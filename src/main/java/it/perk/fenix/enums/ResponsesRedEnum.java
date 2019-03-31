/**
 * 
 */
package it.perk.fenix.enums;

import java.util.Collection;

import it.perk.fenix.dto.ResponsesDTO;
import it.perk.fenix.utils.StringUtils;


/**
 * Enum per la gestione delle response Applicative e Filenet.
 * 
 * @author Perk
 *
 */
public enum ResponsesRedEnum {
	
	INSERISCI_NOTA(1, ExecutionTypeEnum.SINGLE, SourceTypeEnum.APP, null, TaskTypeEnum.HUMAN_TASK, "pnlInserisciNota", "Inserisci Nota"), 
	
	TRACCIA_PROCEDIMENTO(2, ExecutionTypeEnum.MULTI, SourceTypeEnum.APP, null, TaskTypeEnum.HUMAN_TASK, "dlgTracciaProcedimento", "Traccia Procedimento"), 
	
	NO_TRACCIA_PROCEDIMENTO(3, ExecutionTypeEnum.MULTI, SourceTypeEnum.APP, null, TaskTypeEnum.HUMAN_TASK, "dlgNonTracciaProcedimento", "Non Tracciare Procedimento"), 
	
	SPEDISCI_MAIL(4, ExecutionTypeEnum.MULTI, SourceTypeEnum.APP, null, TaskTypeEnum.HUMAN_TASK, "dlgSpedisciMail", "Spedisci Mail"), 
	
	VISTO(5,"Visto", TaskTypeEnum.HUMAN_TASK, "dlgVisto", "Visto"), //possibile RIuso mobile OperationDocumentSRV.vista
	
	VERIFICATO(6, "Verificato", TaskTypeEnum.SERVICE_TASK, "verificato", "Verificato"),
	
	SIGLA(7,"Sigla", TaskTypeEnum.HUMAN_TASK, "", "Sigla"), //possibile RIuso mobile OperationDocumentSRV.sigla
	
	SIGLA_E_INVIA(8,"Sigla e invia", TaskTypeEnum.HUMAN_TASK, "", "Sigla e Invia"), //possibile RIuso mobile OperationDocumentSRV.sigla
	
	RIFIUTA(9,"Rifiuta", TaskTypeEnum.HUMAN_TASK, "dlgRifiuta", "Rifiuta"), //possibile RIuso mobile OperationDocumentSRV.rifiuta
	
	MODIFICA(10,"Modifica", TaskTypeEnum.BEAN_TASK, "modificaApplet", "Modifica"), 
	
	ASSEGNA_UFFICIO_UCP(11,"Assegna a Ufficio UCP", TaskTypeEnum.SERVICE_TASK, "assegnaUfficioUCP", "Assegna a Uffico UCP"), 
	
	ASSOCIA_DECRETI(12,"Associa decreti", TaskTypeEnum.HUMAN_TASK, "dlgAssociazioni", "Associa Decreti"), 
	
	MODIFICA_ASSOCIAZIONI(13,"Modifica associazioni", TaskTypeEnum.HUMAN_TASK, "dlgAssociazioni", "Modifica Associazioni"), 
	
	ATTI(14,"Atti", TaskTypeEnum.HUMAN_TASK, "dlgAtti", "Atti"), 
	
	CHIUDI(15,"Chiudi", TaskTypeEnum.SERVICE_TASK, "chiudi", "Chiudi"), //    ChiudiSRV.public EsitoOperazioneDTO chiudi(UtenteDTO utente, String wobNumber)
	
	DA_PROTOCOLLARE(16,"Da protocollare", TaskTypeEnum.BEAN_TASK, "daProtocollare", "Da Protocollare"), 
	
	FIRMA_AUTOGRAFA(17, ExecutionTypeEnum.MULTI, SourceTypeEnum.APP, "firma autografa", TaskTypeEnum.BEAN_TASK, "firmaAutografa", "Firma Autografa"),
	
	FIRMA_REMOTA(18, ExecutionTypeEnum.MULTI, SourceTypeEnum.APP, "firma remota", TaskTypeEnum.BEAN_TASK, "firmaRemota", "Firma Remota"), 
	
	PREDISPONI_DOCUMENTO(19,"Predisponi documento", TaskTypeEnum.BEAN_TASK, "predisponiDocumento", "Predisponi Documento"), 
	
	PREDISPONI_DICHIARAZIONE(20,"Predisponi dichiarazione", TaskTypeEnum.HUMAN_TASK, "dlgPredisponiDocumentoDichiarazione", "Predisponi Dichiarazione"), 
	
	SPEDITO(21, "Spedito", TaskTypeEnum.HUMAN_TASK, "dlgSpedito", "Spedito"), 
	
	STAMPA_PROTOCOLLO(22,"Stampa Protocollo", TaskTypeEnum.BEAN_TASK, "stampaProtocolloApplet", "Stampa Protocollo"), 
	
	INVIA_UFFICIO_PROPONENTE(23, ExecutionTypeEnum.SINGLE, SourceTypeEnum.FILENET, "Invia a Ufficio proponente", TaskTypeEnum.HUMAN_TASK, "pnlUfficioProponente", "Invia a Ufficio Proponente"), 
	
	FIRMATO_E_SPEDITO(24,"Firmato e spedito", TaskTypeEnum.SERVICE_TASK, "firmatoESpedito", "Firmato e Spedito"), 
	
	FIRMATO(25,"Firmato", TaskTypeEnum.SERVICE_TASK, "firmato", "Firmato"), 
	
	INVIA_UCP(26,"Invia a UCP", TaskTypeEnum.SERVICE_TASK, "inviaUCP", "Invia a UCP"), 
	
	PRERDISPOSIZIONE_FIRMA_AUTOGRAFA(27,"Predisposizione per firma autografa", TaskTypeEnum.HUMAN_TASK, "", "Predisposizione per Firma Autografa"), 
	
	REINVIA(28,"Reinvia", TaskTypeEnum.SERVICE_TASK, "reinvia", "Reinvia"), 
	
	RICHIEDI_VERIFICA(29,"Richiedi verifica", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Verifica"), 
	
	RICHIEDI_VISTO(30,"Richiedi visto", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Visto"), 
	
	RICHIEDI_VISTO_ISPETTORE(31,"Richiedi visto ispettore", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Visto Ispettore"), 
	
	RICHIEDI_VISTO_UFFICIO(32,"Richiedi visto ufficio", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Visto Ufficio"),//
	
	RICHIEDI_VISTO_INTERNO(33,"Richiedi visto interno", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Visto Interno"), 
	
	RICHIESTA_VISTI(34,"Richiesta Visti", TaskTypeEnum.HUMAN_TASK, "", "Richiesta Visti"), 
	
	SIGLA_RICHIEDI_VISTI(35,"Rigla e richiedi visti", TaskTypeEnum.HUMAN_TASK, "", "Sigla e Richiedi Visti"), 
	
	RIFIUTA_SPEDIZIONE(36,"Rifiuta Spedizione", TaskTypeEnum.HUMAN_TASK, "", "Rifiuta Spedizione"), 
	
	INSERISCI_CONTRIBUTO(37,"Rnserisci contributo", TaskTypeEnum.HUMAN_TASK, "", "Inserisci Contributo"),
	
	VALIDA_CONTRIBUTI(38,"Valida contributi", TaskTypeEnum.HUMAN_TASK, "", "Valida Contributi"), 
	
	CHIUDI_SENZA_ASSOCIAZIONE(39,"Chiudi senza associazione", TaskTypeEnum.HUMAN_TASK, "", "Chiudi Senza Associazione"), 
	
	INVIO_IN_FIRMA(40,"Invio in firma", TaskTypeEnum.HUMAN_TASK, "", "Invio in Firma"), 
	
	INVIO_IN_SIGLA(41,"Invio in sigla", TaskTypeEnum.HUMAN_TASK, "", "Invio in Sigla"), 
	
	METTI_IN_CONOSCENZA(42,"Metti in conoscenza", TaskTypeEnum.HUMAN_TASK, "", "Metti in Conoscenza"), 
	
	MODIFICA_ITER(43,"Modifica iter", TaskTypeEnum.HUMAN_TASK, "", "Modifica Iter"), 
	
	STORNA(44,"Storna", TaskTypeEnum.HUMAN_TASK, "", "Storna"), 
	
	STORNA_UTENTE(45,"Storna a utente", TaskTypeEnum.HUMAN_TASK, "", "Storna a Utente"), 
	
	ASSEGNA(46, "Assegna", TaskTypeEnum.HUMAN_TASK, "", "Assegna"), 
	
	RICHIEDI_CONTRIBUTO(47,"Richiedi contributo", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Contributo"), 
	
	RICHIEDI_CONTRIBUTO_INTERNO(48,"Richiedi contributo interno", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Contributo Interno"), 
	
	RICHIEDI_CONTRIBUTO_UTENTE(49,"Richiedi contributo a utente", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Contributo a Utente"), 
	
	RICHIESTA_CONTRIBUTO(50,"Richiesta contributo", TaskTypeEnum.HUMAN_TASK, "", "Richiesta Contributo"), 
	
	ELIMINA(51,"Elimina", TaskTypeEnum.SERVICE_TASK, "eliminaPrecensiti", "Elimina"), 
	
	FALDONA(52,"Faldona", TaskTypeEnum.HUMAN_TASK, "", "Faldona"), 
	
	INVIO_DECRETO_FIRMA(53,"Invio decreto in firma", TaskTypeEnum.HUMAN_TASK, "", "Invio Decreto in Firma"), 
	
	FIRMA_DIGITALE(54,"Firma digitale", TaskTypeEnum.BEAN_TASK, "firmaDigitale", "Firma Digitale"), 
	
	PRESA_VISIONE(55,"Presa visione", TaskTypeEnum.SERVICE_TASK, "presaVisione", "Presa Visione"), 
	
	PROCEDI(56,"Procedi", TaskTypeEnum.SERVICE_TASK, "procedi", "Procedi"), 
	
	PROSEGUI(57,"Prosegui", TaskTypeEnum.SERVICE_TASK, "prosegui", "Prosegui"), 
	
	INVIA_AL_DIRETTORE(58,"Invia al direttore", TaskTypeEnum.HUMAN_TASK, "", "Invia al Direttore"), 
	
	INVIA_ISPETTORE(59,"Invia all'ispettore", TaskTypeEnum.SERVICE_TASK, "inviaIspettore", "Invia all'Ispettore"), 
	
	STORNA_AL_CORRIERE(60,"Storna al corriere", TaskTypeEnum.SERVICE_TASK, "stornaAlCorriere", "Storna al Corriere"), 
	
	METTI_IN_SOSPESO(61,"Metti in sospeso", TaskTypeEnum.SERVICE_TASK, "mettiInSospeso", "Metti in Sospeso"), 
	
	METTI_ATTI(62,"Metti agli atti", TaskTypeEnum.HUMAN_TASK, "", "Metti agli Aatti"), 
	
	INVIA_UFFICIO_COORDINAMENTO(63,"Invia a ufficio di coordinamento", TaskTypeEnum.SERVICE_TASK, "inviaUffCoordinamento", "Invia a Ufficio di Coordinamento"), 
	
	INVIA_FIRMA_DIGITALE(64,"Invia in firma digitale", TaskTypeEnum.SERVICE_TASK, "inviaFirmaDigitale", "Invia in Firma Digitale"), 
	
	SPOSTA_IN_LAVORAZIONE(65,"Sposta in lavorazione", TaskTypeEnum.SERVICE_TASK, "spostaInLavorazione", "Sposta in Lavorazione"), 
	
	INOLTRA(66,"Inoltra", TaskTypeEnum.HUMAN_TASK, "", "Inoltra"), 
	
	NON_VERIFICATO(67,"Non verificato", TaskTypeEnum.HUMAN_TASK, "", "Non Verificato"), 
	
	VALIDAZIONE_CONTRIBUTO(68,"Validazione contributo", TaskTypeEnum.HUMAN_TASK, "", "Validazione Contributo"), 
	
	ATTESTA_COPIA_CONFORME(69,"Attesta copia conforme", TaskTypeEnum.HUMAN_TASK, "", "Attesta Copia Conforme"), 
	
	RICHIEDI_SOLLECITO(70,"Richiedi sollecito", TaskTypeEnum.HUMAN_TASK, "", "Richiedi Sollecito"), 
	
	COLLEGA_CONTRIBUTO(71,"Collega contributo", TaskTypeEnum.HUMAN_TASK, "", "Collega Conrtibuto"), 
	
	RICHIEDI_FIRMA_COPIA_CONFORME(72,"Richiedi firma Copia Conforme", TaskTypeEnum.HUMAN_TASK, "", "Firma Copia Conforme"),
	
	RIATTIVA_PROCEDIMENTO(73,  ExecutionTypeEnum.SINGLE, SourceTypeEnum.APP, "riattiva procedimento", TaskTypeEnum.HUMAN_TASK, null, "Riattiva Procedimento"),
	
	INVIO_IN_VISTO(74,"Invio in visto", TaskTypeEnum.HUMAN_TASK, "", "Invio in Visto"),
	
	RIASSEGNA(75,  ExecutionTypeEnum.SINGLE, SourceTypeEnum.FILENET, "Riassegna", TaskTypeEnum.HUMAN_TASK, null, "Riassegna");
	
	/**
	 * Response name 
	 */
	private String response;
	
	private String target;
	private Integer id;
	
	/**
	 * @return the id
	 */
	public final Integer getId() {
		return id;
	}

	/**
	 * Nome visualizzato front end
	 */
	private String displayName;

	private TaskTypeEnum taskType;

	private SourceTypeEnum responseType;
	private ExecutionTypeEnum et;
	
	public ExecutionTypeEnum getEt() {
		return et;
	}
	public SourceTypeEnum getResponseType() {
		return responseType;
	}
	/**
	 * Costruttore
	 * 
	 * @param id
	 * @param responseFilenet
	 * @param fullyQualifiedName
	 * @param displayName
	 */
	 ResponsesRedEnum(Integer inId, ExecutionTypeEnum inEt, SourceTypeEnum inResponseType, String inResponse, TaskTypeEnum inTaskType, String inTarget, String inDisplayName) {
		 id = inId;
		 responseType = inResponseType;
		 response = inResponse;
		 target = inTarget;
		 displayName = inDisplayName;
		 taskType = inTaskType;
		 et = inEt;
	 }

	 ResponsesRedEnum(Integer inId, String inResponse, TaskTypeEnum inTaskType, String inTarget, String inDisplayName) {
		 id = inId;
		 responseType = SourceTypeEnum.FILENET;
		 response = inResponse;
		 target = inTarget;
		 displayName = inDisplayName;
		 taskType = inTaskType;
		 et = ExecutionTypeEnum.MULTI;
	 }
	 /**
	  * Metodo per il recupero di un'enum dato il valore caratteristico.
	  * 
	  * @param value	valore
	  * @return		enum
	  */
	 public static ResponsesRedEnum get(final String response) {
		 ResponsesRedEnum output = null;
		 for (ResponsesRedEnum r:ResponsesRedEnum.values()) {
			 if (!StringUtils.isNullOrEmpty(r.getResponse()) && r.getResponse().equalsIgnoreCase(response)) {
				 output = r;
				 break;
			 }
		 }
		 return output;
	 }

		public TaskTypeEnum getTaskType() {
			return taskType;
		}
		

	/**
	 * @return the response
	 */
	public final String getResponse() {
		return response;
	}

	public final String getTarget() {
		return target;
	}

	/**
	 * @return the displayName
	 */
	public final String getDisplayName() {
		return displayName;
	}
	
	 public static ResponsesDTO getStructuredDTO(final Collection<String> response) {
		 ResponsesDTO output = new ResponsesDTO();
		 if (response != null && !response.isEmpty()) {
			 for (String s : response) {
				 ResponsesRedEnum rre = get(s);
				 if (rre != null) {
					 output.getResponsesEnum().add(rre);
				} else {
					output.getResponseIssues().add(s);			
				}
			}			 
		 }
		 return output;
	 }	 
	
}
