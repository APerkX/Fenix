/**
 * 
 */
package it.perk.fenix.service.concrete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filenet.vw.api.VWQueueQuery;
import it.perk.fenix.constants.Constants.BooleanFlag;
import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.dto.MasterDocumentRedDTO;
import it.perk.fenix.dto.UserForRequestDTO;
import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.enums.QueueGroupEnum;
import it.perk.fenix.enums.SourceTypeEnum;
import it.perk.fenix.helper.filenet.pe.FilenetPEHelper;
import it.perk.fenix.helper.filenet.pe.dao.QueueFilenetDAO;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.IUtenteDAO;
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
		
		try {
			
			FilenetCredentialsDTO fcDto = utenteSRV.getFilenetCredential(utente.getUfficioRuolo().getUfficio().getIdNodo()); 
			
			if (SourceTypeEnum.FILENET.equals(queue.getType())) {
//				<-- Gestione Code Filenet -->
				
				VWQueueQuery workFlows = getQueueFilenet(queue, utente, fcDto);
				
				/**
				 * 
				 * Recupero dei documentTitle dal PE 
				 * e delle informazioni relative ai WF. 
				 * 
				 * 
				 */
				
//				<-- Fine Gestione Code Filenet -->
				
			} else {
//				<-- Gestione Code Applicative -->
				
				/**
				 * 
				 * Recupero dei documentTitle dal DB
				 * 
				 * 
				 */
				
//				<-- Fine Gestione Code Applicative -->
			}
			
//			<-- Reupero dati da CE utilizzando i document title provenienti da PE o DB -->
			if (documentTitleSet != null && !documentTitleSet.isEmpty()) {
				
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
