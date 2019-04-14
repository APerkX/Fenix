/**
 * 
 */
package it.perk.fenix.service.concrete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filenet.api.collection.DocumentSet;

import filenet.vw.api.VWQueueQuery;
import it.perk.fenix.constants.Constants.BooleanFlag;
import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.dto.MasterDocumentRedDTO;
import it.perk.fenix.dto.PEDocumentoDTO;
import it.perk.fenix.dto.UserForRequestDTO;
import it.perk.fenix.enums.CategoriaDocumentoEnum;
import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.enums.FormatoDocumentoEnum;
import it.perk.fenix.enums.IconaStatoEnum;
import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.enums.QueueGroupEnum;
import it.perk.fenix.enums.SourceTypeEnum;
import it.perk.fenix.enums.TipoAssegnazioneEnum;
import it.perk.fenix.enums.TrasformerCEEnum;
import it.perk.fenix.enums.TrasformerPEEnum;
import it.perk.fenix.helper.filenet.ce.FilenetCEHelper;
import it.perk.fenix.helper.filenet.ce.dao.IMastersFilenetDAO;
import it.perk.fenix.helper.filenet.ce.dao.impl.MastersFilenetDAO;
import it.perk.fenix.helper.filenet.ce.trasform.TrasformCE;
import it.perk.fenix.helper.filenet.pe.FilenetPEHelper;
import it.perk.fenix.helper.filenet.pe.dao.IQueueFilenetDAO;
import it.perk.fenix.helper.filenet.pe.dao.impl.QueueFilenetDAO;
import it.perk.fenix.helper.filenet.pe.trasform.TrasformPE;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.IUtenteDAO;
import it.perk.fenix.provider.PropertiesProvider;
import it.perk.fenix.service.IDocumentiMastersSRV;
import it.perk.fenix.service.IUtenteSRV;

/**
 * Service che gestisce le richieste di Documenti per le Code di Lavoro.
 * 
 * @author Perk
 *
 */
@Service
@Transactional
public class DocumentiMastersSRV implements IDocumentiMastersSRV{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5292787627608969519L;

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(DocumentiMastersSRV.class.getName());
	
	@Autowired
	private IUtenteDAO utenteDao;

	@Autowired
	private IUtenteSRV utenteSRV;

	
	@Override
	public Collection<MasterDocumentRedDTO> getDocumentForMaster(DocumentQueueEnum queue, UserForRequestDTO utente) {
		Collection<MasterDocumentRedDTO> output = new ArrayList<>();
		Set<String> documentTitleSet = new HashSet<>();
		HashMap<String, Collection<PEDocumentoDTO>> tandemRelation = new HashMap<>();
		
		try {
			
			FilenetCredentialsDTO fcDto = utenteSRV.getFilenetCredential(utente.getUfficioRuolo().getUfficio().getIdNodo()); 
			
			if (SourceTypeEnum.FILENET.equals(queue.getType())) {
//				<-- Gestione Code Filenet -->
				
				VWQueueQuery workFlows = getQueueFilenet(queue, utente, fcDto);
				
				Collection<PEDocumentoDTO> workFlowList = TrasformPE.transform(workFlows, TrasformerPEEnum.FROM_WF_TO_DOCUMENTO);
				
				// Viene ciclato il risultato della query sul PE per poter creare una struttura che rispecchi la relazione tra 
				// un Documento e 'N' WorkFlow
				for (PEDocumentoDTO wf : workFlowList) {
					
					Collection<PEDocumentoDTO> wfList = new ArrayList<>();
					wf.setQueue(queue);
					
					// Si prende il documentTitle all'interno del WF e
					// Viene Aggiunto al set di documentTitle che verrà proiettato sul CE 
					if (documentTitleSet.add(wf.getIdDocumento())) {
						// Se non è presente nel set viene creata la prima relazione tra un Document e Workflow
						wfList.add(wf);
						tandemRelation.put(wf.getIdDocumento(), wfList);
					} else {
						// Altrimenti se già presente viene recuperata quella relazione e aggiunto un Workflow
						tandemRelation.get(wf.getIdDocumento()).add(wf);
					}
				} 
				
//				<-- Fine Gestione Code Filenet -->
				
			} else {
//				<-- Gestione Code Applicative -->
				
				Long idUtente = utente.getIdUtente();
				Long idUfficio = utente.getUfficioRuolo().getUfficio().getIdNodo();
				
				// Se la coda richiesta fa parte del Gruppo Ufficio si imposta l'idUtente a 0
				if (QueueGroupEnum.UFFICIO.equals(queue.getGroup())) {
					idUtente = 0L;
				}
				
				documentTitleSet = null;
				
				/**
				 * 
				 * Recupero dei documentTitle dal DB
				 * 
				 * 
				 */
				
//				<-- Fine Gestione Code Applicative -->
			}
			
//			<-- Proiezione sul CE utilizzando i document title provenienti da PE o DB e recupero dei Document -->
			if (documentTitleSet != null && !documentTitleSet.isEmpty()) {
				FilenetCEHelper fceh = new FilenetCEHelper(fcDto);
				IMastersFilenetDAO masterDao = new MastersFilenetDAO();
				DocumentSet documentSetRaw = masterDao.getDocumentsForMasters(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DOCUMENTO_CLASSNAME_FN_METAKEY), documentTitleSet, fceh);
				Collection<MasterDocumentRedDTO> documentList = TrasformCE.transform(documentSetRaw, TrasformerCEEnum.FROM_DOCUMENTO_TO_GENERIC_DOC);
				output = mergePeCeTandem(tandemRelation, documentList, utente, queue);
				
				/**
				 * 
				 * Recupero dei Documenti utilizzando i document title provenienti da PE o DB
				 * 
				 */
				
			}
			
		} catch (Exception e) {
			LOGGER.error("Errore durante il recupero dei Documenti per popolare i Master ( " + queue.getName() + " ): " , e);
		}
		
		return output;
	}



	@Override
	public VWQueueQuery getQueueFilenet(DocumentQueueEnum queue, UserForRequestDTO utente, FilenetCredentialsDTO fcDto) {
		List<Long> idsUtenteDestinatario = new ArrayList<>();
		List<Long> idsTipoAssegnazione = new ArrayList<>();

		// Init del PE helper che contiene le connessioni che verrà passato ai DaoFilenet
		FilenetPEHelper fpeh = new FilenetPEHelper(null); 
		
		// Creazione instanza per interrogazione Filenet Pe
		IQueueFilenetDAO queueDao = new QueueFilenetDAO();
		
		//Informazioni Comuni a tutte le code
		String queueName = queue.getName();
		String indexName = queue.getIndexName();
		Boolean registroRiservato = false;
		Long idNodoDestinatario = utente.getUfficioRuolo().getUfficio().getIdNodo();
		idsUtenteDestinatario.add(utente.getIdUtente());
		String idClient = fcDto.getIdClientAoo();
		Integer flagRenderizzato = null;
		
		//Prendo informazioni Specifiche nel caso la coda lo richieda
		if (DocumentQueueEnum.NSD.equals(queue)) {
			//imposto i tipi Assegnazione di riferimento Firma, Sigla, Visto
			idsTipoAssegnazione.add(4L);
			idsTipoAssegnazione.add(5L);
			idsTipoAssegnazione.add(6L);
			//Setto il flag Renderizzato
			flagRenderizzato = BooleanFlag.TRUE;
			//nel caso l'utente abbia tra i suoi permessi la delega aggiungo ai destinatari anche il Dirigente
//			if (utenteDAO.isDelegato(utente.getIdRuolo(), connection)) {
//				Utente dirigente = nodoDAO.getNodo(utente.getIdUfficio(), connection).getDirigente();
//				if(dirigente != null) {
//					idsUtenteDestinatario.add(dirigente.getIdUtente());
//				}
//			}
		} 
		
		//elimino il destinatario nel caso la coda faccia parte del gruppo UFFICIO perchè non richiesto
		if (queue.getGroup().equals(QueueGroupEnum.UFFICIO)) {
			idsUtenteDestinatario.clear();
		}
		
		
		//Eseguo query generica per il recupero dei workflow delle code FileNet
		return queueDao.getWorkFlowsForQueueFilent(queueName, 				// Nome Coda
												   indexName, 				// Index Name
												   idNodoDestinatario, 		// ID Nodo Destinatario
												   idsUtenteDestinatario, 	// ID Utente/i destinatari/io
												   idClient, 				// ID ClientAoo
												   idsTipoAssegnazione, 	// IdTipoAssegnazione 
												   flagRenderizzato, 		// Flag Renderizzato
												   registroRiservato,		// Registro Riservato
												   fpeh);					// Helper per connessioni	
	}
	
	/**
	 * Merge tra gli oggetti ottenuti dal PE e dal CE.
	 * 
	 * @param tandemRelation
	 * @param documentList
	 * @param utente
	 * @param queue
	 * @return
	 */
	private Collection<MasterDocumentRedDTO> mergePeCeTandem(final HashMap<String, Collection<PEDocumentoDTO>> tandemRelation, final Collection<MasterDocumentRedDTO> documentList, final UserForRequestDTO utente, final DocumentQueueEnum queue) {
		Collection<MasterDocumentRedDTO> output = new ArrayList<>();
		
		// Si Verifica l'esistenza di una relazione tra un Document e almeno un Workflow
		if (!tandemRelation.isEmpty()) {
			// Viene fatto un merge tra le informazioni da Pe e CE
			for (MasterDocumentRedDTO m : documentList) {
				// Si ciclano i risultati provenienti dal CE
				// e per ognuno di essi si verifica se esiste una relazione nella struttura creata in precedenza
				Collection<PEDocumentoDTO> wfList = tandemRelation.get(m.getDocumentTitle());
				if (wfList != null && !wfList.isEmpty()) {
					// Si ciclano le 'N' relazione dell Document sul PE
					for (PEDocumentoDTO wf : wfList) {
						// Per ognuna di esse viene creato un 'clone' del Document 
						// e viene fatto il merge con le informazioni del WF
						MasterDocumentRedDTO dolly = new MasterDocumentRedDTO(m);
						dolly.fill(wf);
						// Viene assegnata un'icona stato
						updateIconaStato(dolly, utente);
						output.add(dolly);
					}
				} else {
					LOGGER.error("Attenzione per il Documento ( " + m.getDocumentTitle() + " ) non esiste più una relazione con un Workflow nella coda -> " + queue.getName() );
				}
				
			}
			
			
		} else {
			// Se non c'è almeno un a relazione significa che è stata richiesta una coda Applicatica
			// e quindi si procede direttamente all'assegnazione delle icone stato
			for (MasterDocumentRedDTO m : documentList) {
				m.setQueue(queue);
				updateIconaStato(m, utente);
				output.add(m);
			}

		}
		
		return output;
	}
	
	
	public void updateIconaStato(final MasterDocumentRedDTO master, final UserForRequestDTO utente) {
		
		IconaStatoEnum iconaStato = null;
		TipoAssegnazioneEnum tipoAssegnazioneMaster = master.getTipoAssegnazione();
		if(tipoAssegnazioneMaster != null) {
			
			switch (tipoAssegnazioneMaster) {
			case COMPETENZA:
			case FIRMATO:
			case FIRMATO_E_SPEDITO:
				if (master.getIdFormatoDocumento() == FormatoDocumentoEnum.PRECENSITO.getId().intValue()) {
					iconaStato = IconaStatoEnum.PRECENSITO;
				} else {
					
					CategoriaDocumentoEnum categoriaMaster = CategoriaDocumentoEnum.get(master.getIdCategoriaDocumento());
					
					if(CategoriaDocumentoEnum.ASSEGNAZIONE_INTERNA.equals(categoriaMaster)){
						iconaStato = IconaStatoEnum.DOCUMENTO_ASSEGNAZIONE_INTERNA;
					} else {
						iconaStato = IconaStatoEnum.COMPETENZA;
					}
				}
				break;
			
			case CONOSCENZA:
				iconaStato = IconaStatoEnum.CONOSCENZA;
				break;
				
			case CONTRIBUTO:
				iconaStato = IconaStatoEnum.CONTRIBUTO;
				break;
				
			case FIRMA:
				iconaStato = IconaStatoEnum.FIRMA;
				break;
				
			case SIGLA:
				iconaStato = IconaStatoEnum.SIGLA;
				break;
				
			case VISTO:
				
//				Aoo aoo = aooSRV.recuperaAoo(utente.getIdAoo().intValue());
//				
//				if(aoo.getCodiceAoo() != null && aoo.getCodiceAoo().equals(AooInfoEnum.DSII.getCodiceAoo())){
//					iconaStato = IconaStatoEnum.SIGLA_TITLE_VISTO;
//				} else {
//					iconaStato = IconaStatoEnum.VISTO;
//				}
				break;

			case RIFIUTO_ASSEGNAZIONE:
				iconaStato = IconaStatoEnum.RIFIUTO_ASSEGNAZIONE;
				break;
			
			case RIFIUTO_FIRMA:
				iconaStato = IconaStatoEnum.RIFIUTO_FIRMA;
				break;
			
			case RIFIUTO_SIGLA:
				iconaStato = IconaStatoEnum.RIFIUTO_SIGLA;
				break;
			
			case RIFIUTO_VISTO:
				iconaStato = IconaStatoEnum.RIFIUTO_VISTO;
				break;
			
			case COPIA_CONFORME:
				iconaStato = IconaStatoEnum.COPIA_CONFORME;
				break;
				
			case SPEDIZIONE:
				
//				FilenetCEHelper fceh = new FilenetCEHelper(utente.getFcDTO());
//				Document d = fceh.getDocumentByIdGestionale(master.getDocumentTitle(), null, null, utente.getIdAoo().intValue(), null, null);
//				Property metadato = d.getProperties().get(pp.getParameterByKey(PropertiesNameEnum.DESTINATARI_DOCUMENTO_METAKEY));
//				Collection<String> inDestinatari = (Collection<String>) metadato.getObjectValue();
//				if(inDestinatari != null && inDestinatari.size() > 0) {
//					int totaleDestinatari = inDestinatari.size();
//					int totCartacei = 0;
//					int totElettronici = 0;
//					for (String dest : inDestinatari) {
//						String[] destSplit = dest.split("\\,");
//						if(destSplit.length >= 5) {
//							TipologiaDestinatarioEnum tde = TipologiaDestinatarioEnum.getByTipologia(destSplit[3]);
//							if(TipologiaDestinatarioEnum.ESTERNO.equals(tde)) {
//								MezzoSpedizioneEnum mezzo = MezzoSpedizioneEnum.getById(Integer.valueOf(destSplit[2]));
//								if(MezzoSpedizioneEnum.ELETTRONICO.equals(mezzo)) {
//									totElettronici++;
//								} else if(MezzoSpedizioneEnum.CARTACEO.equals(mezzo)) {
//									totCartacei++;
//								}
//							}
//							
//							if(totCartacei == totaleDestinatari) {
//								
//								iconaStato = IconaStatoEnum.SPEDIZIONE_CARTACEA;
//								
//							} else {
//								
//								//conta errori in fase di spedizione
//								int numErroriSpedizione = gestioneNotificheMailDAO.getNumErroriSpedizione(master.getDocumentTitle(), connection);
//								
//								if(totElettronici == totaleDestinatari){
//									if (numErroriSpedizione > 0) {
//										iconaStato = IconaStatoEnum.SPEDIZIONE_ELETTRONICA_ERRORE;
//									} else {
//										iconaStato = IconaStatoEnum.SPEDIZIONE_ELETTRONICA;
//									}
//								} else {
//									if (numErroriSpedizione > 0) {
//										iconaStato = IconaStatoEnum.SPEDIZIONE_MISTA_ERRORE;
//									} else {
//										iconaStato = IconaStatoEnum.SPEDIZIONE_MISTA;
//									}
//								}
//								
//							}
//							
//						}
//					}
//					
//				}
//					
				break;
				
			default:
				LOGGER.warn("Tipo Assegnazione " + master.getTipoAssegnazione() + " non previsto");
				break;
			}
			
		}
		
		master.setIconaStato(iconaStato);

	} 

}
