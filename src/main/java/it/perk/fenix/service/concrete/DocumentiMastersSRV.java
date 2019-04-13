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
import it.perk.fenix.dto.TandemDTO;
import it.perk.fenix.dto.UserForRequestDTO;
import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.enums.QueueGroupEnum;
import it.perk.fenix.enums.SourceTypeEnum;
import it.perk.fenix.enums.TrasformerPEEnum;
import it.perk.fenix.helper.filenet.ce.FilenetCEHelper;
import it.perk.fenix.helper.filenet.ce.dao.impl.MastersFilenetDAO;
import it.perk.fenix.helper.filenet.pe.FilenetPEHelper;
import it.perk.fenix.helper.filenet.pe.dao.QueueFilenetDAO;
import it.perk.fenix.helper.filenet.pe.trasform.TrasformPE;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.IUtenteDAO;
import it.perk.fenix.provider.PropertiesProvider;
import it.perk.fenix.service.IDocumentiMastersSRV;
import it.perk.fenix.service.IUtenteSRV;

/**
 * Service che gestisce le richieste di Documenti.
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
		HashMap<String, Collection<TandemDTO>> tandemRelation = new HashMap<>();
		
		try {
			
			FilenetCredentialsDTO fcDto = utenteSRV.getFilenetCredential(utente.getUfficioRuolo().getUfficio().getIdNodo()); 
			
			if (SourceTypeEnum.FILENET.equals(queue.getType())) {
//				<-- Gestione Code Filenet -->
				
				VWQueueQuery workFlows = getQueueFilenet(queue, utente, fcDto);
				
				Collection<PEDocumentoDTO> workFlowList = TrasformPE.transform(workFlows, TrasformerPEEnum.FROM_WF_TO_DOCUMENTO);
				
				// Viene ciclato il risultato della query sul PE per poter creare una struttura che rispecchi la relazione tra 
				// un Documento e 'N' WorkFlow
				for (PEDocumentoDTO wf : workFlowList) {
					
					Collection<TandemDTO> tandemList = new ArrayList<>();
					wf.setQueue(queue);
					
					// Si prende il documentTitle all'interno del WF e
					// Viene Aggiunto al set di documentTitle che verrà proiettato sul CE 
					if (documentTitleSet.add(wf.getIdDocumento())) {
						// Se non è presente nel set viene creata la prima relazione tra un Document e Workflow
						TandemDTO t = new TandemDTO(wf);
						tandemList.add(t);
						tandemRelation.put(wf.getIdDocumento(), tandemList);
					} else {
						// Altrimenti se già presente viene recuperata quella relazione e aggiunto un Workflow
						tandemRelation.get(wf.getIdDocumento()).add(new TandemDTO(wf));
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
				MastersFilenetDAO masterDao = new MastersFilenetDAO();
				DocumentSet documentSetRaw = masterDao.getDocumentsForMasters(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DOCUMENTO_CLASSNAME_FN_METAKEY), documentTitleSet, fceh);
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
		QueueFilenetDAO queueDao = new QueueFilenetDAO();
		
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
												   fpeh );					// Helper per connessioni	
	}

}
