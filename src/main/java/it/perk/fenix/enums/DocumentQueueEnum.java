/**
 * 
 */
package it.perk.fenix.enums;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.perk.fenix.constants.Constants;


/**
 * Enum per elencare le tipologia di coda gestite.
 * 
 * @author Perk
 * 
 *
 */
public enum DocumentQueueEnum {
	
	/**
	 * Coda RED.
	 */
	NSD(1, "NSD_LibroFirma", "LIBRO FIRMA", SourceTypeEnum.FILENET, QueueGroupEnum.UTENTE, null, AccessoFunzionalitaEnum.LIBROFIRMA, true), 
	
	/**
	 * Coda FEPA.
	 */
	FEPA(2, "FEPA_LibroFirma", "FEPA - LIBRO FIRMA", SourceTypeEnum.FILENET, QueueGroupEnum.UTENTE, null, null, true),
	/**
	 * Coda Corriere.
	 */
	CORRIERE(3, "NSD_CORRIERE", "CORRIERE", SourceTypeEnum.FILENET, QueueGroupEnum.UFFICIO, Constants.QueueConstant.INDEX_NAME_DESTINATARIO, AccessoFunzionalitaEnum.CORRIERE, true),
	/**
	 * Coda Corriere.
	 */
	DA_LAVORARE(4, "NSD_DaLavorare", "DA LAVORARE", SourceTypeEnum.FILENET, QueueGroupEnum.UTENTE, Constants.QueueConstant.INDEX_NAME_DESTINATARIO, AccessoFunzionalitaEnum.DALAVORARE, true),
	/**
	 * Cosa sospesi.
	 */
	SOSPESO(5, "NSD_InSospeso", "IN SOSPESO", SourceTypeEnum.FILENET, QueueGroupEnum.UTENTE, null, AccessoFunzionalitaEnum.INSOSPESO, true),
	/**
	 * Coda Spedizione
	 */
	SPEDIZIONE(6, "NSD_CORRIERE_IN_SPEDIZIONE", "SPEDIZIONE", SourceTypeEnum.FILENET, QueueGroupEnum.UFFICIO, Constants.QueueConstant.INDEX_NAME_DESTINATARIO, AccessoFunzionalitaEnum.SPEDIZIONE, true ),
	/**
	 * Coda Giro Visti
	 */
	GIRO_VISTI(7, "NSD_CORRIERE_AlGiroVisti", "GIRO VISTI", SourceTypeEnum.FILENET, QueueGroupEnum.UFFICIO, null, AccessoFunzionalitaEnum.GIROVISTI, true),
	/**
	 * Coda Stornati
	 */
	STORNATI(8, "NSD_Stornati", "STORNATI", SourceTypeEnum.APP, QueueGroupEnum.UTENTE, null, null, false, StatoLavorazioneEnum.ASSEGNATE),
	/**
	 * Coda Procedimenti
	 */
	PROCEDIMENTI(9, "NSD_Procedimenti", "PROCEDIMENTI", SourceTypeEnum.APP, QueueGroupEnum.UTENTE, null, null, false, StatoLavorazioneEnum.LAVORATE),
	/**
	 * Coda Assegnate
	 */
	ASSEGNATE(10, "NSD_Assegnate", "ASSEGNATE", SourceTypeEnum.APP, QueueGroupEnum.UFFICIO, null, AccessoFunzionalitaEnum.ASSEGNATE, false, StatoLavorazioneEnum.LAVORATE),
	/**
	 * Coda Chiuse
	 */
	CHIUSE(11, "NSD_Chiuse", "CHIUSE", SourceTypeEnum.APP, QueueGroupEnum.UFFICIO, null, null, false, StatoLavorazioneEnum.ATTI, StatoLavorazioneEnum.RISPOSTA, StatoLavorazioneEnum.OSSERVAZIONE, StatoLavorazioneEnum.MOZIONE),
	/**
	 * Coda Atti
	 */
	ATTI(12, "NSD_Atti", "ATTI", SourceTypeEnum.APP, QueueGroupEnum.ARCHIVIO, null, null, true, StatoLavorazioneEnum.ATTI),
	/**
	 * Coda Risposta
	 */
	RISPOSTA(13, "NSD_Risposta", "RISPOSTA", SourceTypeEnum.APP, QueueGroupEnum.ARCHIVIO, null, null, false, StatoLavorazioneEnum.RISPOSTA),
	/**
	 * Coda Mozione
	 */
	MOZIONE(14, "NSD_Mozione", "MOZIONE", SourceTypeEnum.APP, QueueGroupEnum.ARCHIVIO, null, AccessoFunzionalitaEnum.MOZIONE, false, StatoLavorazioneEnum.MOZIONE),
	/**
	 * Coda Fepa da Lavorare
	 */
	FEPA_DA_LAVORARE(15, "FEPA_DaLavorare", "FEPA - DA LAVORARE", SourceTypeEnum.FILENET, QueueGroupEnum.UTENTE, null, null, true),
	/**
	 * Coda di servizio se il documento non viene trovato in nessuna coda
	 */
	NESSUNA_CODA(16, "In_Nessuna_Coda_Sevizio", "In Nessuna Coda", SourceTypeEnum.APP, QueueGroupEnum.SERVIZIO, null, null, false),
	/**
	 * Coda di servizio se non vengono trovate ne code filenet ne applicative
	 */
	NON_CENSITO(17, "Non_Censito_Servizio", "NON CENSITO", SourceTypeEnum.APP, QueueGroupEnum.SERVIZIO, null, null, false);

	
	/**
	 * Identificativo.
	 */
	private Integer id; 

	/**
	 * Descrizione.
	 */
	private String name;
	
	/**
	 * Nome visualizzato front end
	 */
	private String displayName;
	
	/**
	 * Tipo coda (Filenet/Applicativa)
	 */
	private SourceTypeEnum type;
	
	/**
	 * Gruppo di riferimento
	 */
	private QueueGroupEnum group;
	
	/**
	 * Index Name utile per la query al PE
	 */
	private String indexName;

	/**
	 * enum utilizzato per gestire i permessi delle code
	 */
	private AccessoFunzionalitaEnum accessFun;

	/**
	 * flag che identifica se la coda è operativa
	 */
	private boolean codaOperativa;
	
	/**
	 * Lista di ID che rappresentato lo stato lavorazione di una coda
	 */
	private StatoLavorazioneEnum[] idsStatoLavorazione;

	/**
	 * Costruttore.
	 * 
	 * @param inId			identificativo
	 * @param inDescrizione	descrizione
	 */
	DocumentQueueEnum(final Integer inId, final String inName, final String inDisplayName, SourceTypeEnum inType, QueueGroupEnum inGroup, 
						final String inIndexName, final AccessoFunzionalitaEnum inAccessFun, final boolean inCodaOperativa, final StatoLavorazioneEnum... inIdsStatoLavorazione) {
		id = inId;
		name = inName;
		displayName = inDisplayName;
		type = inType;
		group = inGroup;
		indexName = inIndexName;
		accessFun = inAccessFun;
		codaOperativa = inCodaOperativa;
		idsStatoLavorazione = inIdsStatoLavorazione;
		
	}
	
	/**
	 * Getter identifcativo.
	 * 
	 * @return	identificativo
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Getter descrizione.
	 * @return	descrizione
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the displayName
	 */
	public final String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the group
	 */
	public final QueueGroupEnum getGroup() {
		return group;
	}

	/**
	 * @return the indexName
	 */
	public final String getIndexName() {
		return indexName;
	}
	
	/**
	 * @return the accessFun
	 */
	public final AccessoFunzionalitaEnum getAccessFun() {
		return accessFun;
	}
	
	/**
	 * @return the codaOperativa
	 */
	public final boolean isCodaOperativa() {
		return codaOperativa;
	}

	/**
	 * @return the idsStatoLavorazione
	 */
	public final StatoLavorazioneEnum[] getIdsStatoLavorazione() {
		return idsStatoLavorazione;
	}
	
	/**
	 * Metodo per il recupero di un'enum dato il valore caratteristico.
	 * 
	 * @param value	valore
	 * @return		enum
	 */
	public static DocumentQueueEnum get(final String value) {
		DocumentQueueEnum output = DocumentQueueEnum.NON_CENSITO;
		for (DocumentQueueEnum q:DocumentQueueEnum.values()) {
			if (q.getName().equals(value)) {
				output = q;
				break;
			}
		}
		return output;
	}

	/**
	 * Metodo per verificare se la descrizione fornita in input appartiene ad una della code fornite.
	 * 	
	 * @param queue	descrizione coda
	 * @return		true se la coda è gestita, false altrimenti
	 */
	public static boolean isInSignQueue(final String queue) {
		boolean output = false;
		for (DocumentQueueEnum q:DocumentQueueEnum.values()) {
			if (q.getId() <= DocumentQueueEnum.FEPA.getId() && queue.equals(q.getName())) {
				output = true;
				break;
			}
		}
		return output;
	}
	
	/**
	 * 
	 * @param idStatoLav
	 * @param idUtente
	 * @return
	 */
	public static DocumentQueueEnum getQueue(final StatoLavorazioneEnum statoLav, final QueueGroupEnum group) {
		DocumentQueueEnum output = null;
		Collection<DocumentQueueEnum> queues = getQueueByGroup(group);
		for (DocumentQueueEnum q:queues) {
			if (canHandle(q, statoLav)) {
				output = q;
				break;
			}
		}
		return output;
	}
	
	private static Collection<DocumentQueueEnum> getQueueByGroup(QueueGroupEnum group) {
		Collection<DocumentQueueEnum> output = new ArrayList<>();
		for (DocumentQueueEnum q:DocumentQueueEnum.values()) {
			if (group.equals(q.getGroup())) {
				output.add(q);
			}
		}
		return output;
	}

	private static Boolean canHandle(DocumentQueueEnum queue, StatoLavorazioneEnum statoLav) {
		Boolean output = false;
		for (StatoLavorazioneEnum sl:queue.getIdsStatoLavorazione()) {
			if (sl.equals(statoLav)) {
				output = true;
				break;
			}
		}
		return output;
	}
	
	public SourceTypeEnum getType() {
		return type;
	}
	
	public List<Long> getIdStatiLavorazione() {
		List<Long> output = new ArrayList<>();
		for (StatoLavorazioneEnum sle:idsStatoLavorazione) {
			output.add(sle.getId());
		}
		return output;
	}

}
