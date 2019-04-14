/**
 * 
 */
package it.perk.fenix.constants;

/**
 * Classe delle costanti.
 * 
 * @author Perk
 *
 */
public class Constants {
	
	public static final String EMPTY_STRING = "";
	
	/**
	 * 	Constanti booleane Integer.
	 *
	 * @author Perk
	 * 
	 */
	public static final class BooleanFlag {

		/**
		 * FLAG FALSE.
		 */
		public static final int FALSE = 0;
		/**
		 * FLAG TRUE.
		 */
		public static final int TRUE = 1;

		/**
		 * Costruttore.
		 */
		protected BooleanFlag() {
		}
	}
	
	/**
	 * The Class TipoDestinatario.
	 *
	 * @author Perk
	 * 
	 * 	Tipologia destinatario (interno/esterno).
	 */
	public static final class TipoDestinatario {
		
		/**
		 * Destinatario interno.
		 */
		public static final String INTERNO = "I";

		/**
		 * Destinatario esterno.
		 */
		public static final String ESTERNO = "E";

		/**
		 * Costruttore.
		 */
		protected TipoDestinatario() {
		}
	}
	
	/**
	 * The Class TipoSpedizione.
	 *
	 * @author CPIERASC
	 * 
	 * 	Tipo spedizione.
	 */
	public static final class TipoSpedizione {
		
		/**
		 * Identificativo mezzo non specificato.
		 */
		public static final Integer MEZZO_NON_SPECIFICATO = 0;

		/**
		 * Identificativo mezzo cartaceo.
		 */
		public static final Integer MEZZO_CARTACEO = 1;

		/**
		 * Identificativo mezzo elettronico.
		 */
		public static final Integer MEZZO_ELETTRONICO = 2;
		
		/**
		 * Costruttore.
		 */
		protected TipoSpedizione() {
		}
	}
	
	/**
	 * 	Proprietà del PE.
	 *
	 * @author Perk
	 * 
	 */
	public static final class PEProperty {
				
		/**
		 * F_WorkObjectName.
		 */
		public static final String VW_WORK_OBJECTNAME = "F_WorkObjectName";

		/**
		 * F_Tag.
		 */
		public static final String VW_TAG = "F_Tag";

		/**
		 * F_WorkObjectNumber.
		 */
		public static final String VW_WOB_NUM = "F_WorkObjectNumber";

		/**
		 * F_WorkClass.
		 */
		public static final String VW_WORK_CLASS_NAME = "F_WorkClass";

		/**
		 * F_WPClassName.
		 */
		public static final String VW_WORK_PERFORMER_CLASS_NAME = "F_WPClassName";

		/**
		 * F_Operation.
		 */
		public static final String VW_OPERATION_NAME = "F_Operation";

		/**
		 * F_ISheetName.
		 */
		public static final String VW_INSTRUCTION_SHEET_NAME = "F_ISheetName";

		/**
		 * F_LockedUserName.
		 */
		public static final String VW_LOCKED_USER_NAME = "F_LockedUserName";

		/**
		 * F_WorkOrderId.
		 */
		public static final String VW_WORK_ORDER_ID = "F_WorkOrderId";

		/**
		 * F_CurrentQueue.
		 */
		public static final String VW_CURRENT_QUEUE = "F_CurrentQueue";

		/**
		 * F_WorkSpaceId.
		 */
		public static final String VW_WORK_SPACE_ID = "F_WorkSpaceId";

		/**
		 * F_WorkClassId.
		 */
		public static final String VW_WORK_CLASS_ID = "F_WorkClassId";

		/**
		 * F_WobNum.
		 */
		public static final String F_WOB_NUM = "F_WobNum";

		/**
		 * F_Locked.
		 */
		public static final String F_LOCKED = "F_Locked";

		/**
		 * F_ServerId.
		 */
		public static final String F_SERVER_ID = "F_ServerId";

		/**
		 * F_LockMachine.
		 */
		public static final String F_LOCKED_MACHINE_ID = "F_LockMachine";

		/**
		 * F_EnqueueTime.
		 */
		public static final String F_ENQUEUE_TIME = "F_EnqueueTime";

		/**
		 * F_Responses.
		 */
		public static final String F_RESPONSES = "F_Responses";

		/**
		 * F_LastErrorNumber.
		 */
		public static final String F_LAST_ERROR_NUMBER = "F_LastErrorNumber";

		/**
		 * F_LastErrorText.
		 */
		public static final String F_LAST_ERROR_TEXT = "F_LastErrorText";

		/**
		 * F_WsStatus.
		 */
		public static final String F_WS_STATUS = "F_WsStatus";

		/**
		 * F_Comment.
		 */
		public static final String F_COMMENT = "F_Comment";

		/**
		 * F_Response.
		 */
		public static final String F_RESPONSE = "F_Response";

		/**
		 * F_Subject.
		 */
		public static final String F_SUBJECT = "F_Subject";

		/**
		 * F_WorkflowName.
		 */
		public static final String F_WORKFLOW_NAME = "F_WorkflowName";

		/**
		 * F_RosterName.
		 */
		public static final String IW_ROSTER_NAME = "F_RosterName";

		/**
		 * F_StepReceived.
		 */
		public static final String IW_DATE_RECEIVED = "F_StepReceived";

		/**
		 * F_Originator.
		 */
		public static final String IW_ORIGINATOR = "F_Originator";

		/**
		 * F_Trackers.
		 */
		public static final String IW_TRACKERS = "F_Trackers";

		/**
		 * F_StartTime.
		 */
		public static final String IW_LAUNCHDATE = "F_StartTime";

		/**
		 * F_ParticipantName.
		 */
		public static final String IW_PARTICIPANTNAME = "F_ParticipantName";

		/**
		 * F_Deadline.
		 */
		public static final String IW_DEADLINE = "F_Deadline";

		/**
		 * F_Reminder.
		 */
		public static final String IW_REMINDER = "F_Reminder";

		/**
		 * F_Overdue.
		 */
		public static final String IW_OVERDUE = "F_Overdue";

		/**
		 * F_TrackerStatus.
		 */
		public static final String IW_IS_TRACKER = "F_TrackerStatus";

		/**
		 * F_WorkFlowNumber.
		 */
		public static final String IW_WORKFLOW_NUMBER = "F_WorkFlowNumber";

		/**
		 * F_OperationId.
		 */
		public static final String IW_OPERATION_ID = "F_OperationId";

		/**
		 * F_OperationType.
		 */
		public static final String IW_OPERATION_TYPE = "F_OperationType";

		/**
		 * F_UIFlag.
		 */
		public static final String IW_UI_FLAG = "F_UIFlag";

		/**
		 * F_StepName.
		 */
		public static final String IW_STEP_NAME = "F_StepName";

		/**
		 * F_StepProcId.
		 */
		public static final String IW_STEP_PROC_ID = "F_StepProcId";

		/**
		 * F_SourceDoc.
		 */
		public static final String IW_SOURCE_DOC = "F_SourceDoc";

		/**
		 * F_StepDescription.
		 */
		public static final String IW_STEP_DESCRIPTION = "F_StepDescription";

		/**
		 * F_StepResponses.
		 */
		public static final String IW_STEP_RESPONSES = "F_StepResponses";

		/**
		 * F_Class.
		 */
		public static final String VW_CLASS = "F_Class";
		
		/**
		 * GIRO_VISTI_ISPETTORATO
		 */
		public static final String GIRO_VISTI_ISPETTORATO = "Giro Visti Ispettorato";

		/**
		 * Costruttore.
		 */
		protected PEProperty() {
		}

	}
	
	/**
	 * Costanti per le code.
	 * 
	 * @author Perk
	 *
	 */
	public static final class QueueConstant {
		
		public static final String INDEX_NAME_DESTINATARIO = "Destinatario";
		
		/**
		 * Costruttore
		 */
		protected QueueConstant() {
		}
	}
	
	/**
	 * 	Varie.
	 *
	 * @author Perk
	 * 
	 */
	public static final class Varie {

		/**
		 * Indice di split per il calcolo del tipo di spedizione su di un destinatario.
		 */
		public static final int INDICE_SPLIT_TIPO_SPEDIZIONE = 3;
		
		/**
		 * Cambio iter MEV CAVALLO.
		 */
		public static final int INDEX_BEFORE_MEV_CAVALLO = 4;		
		/**
		 * Suffisso eccezione OTP non valido.
		 */
		public static final String INVALID_OTP_SUFFIX = "Invalid OTP";
		
		/**
		 * OTO non valido.
		 */
		public static final String OTP_NON_VALIDO = "L'OTP inserito non è valido!";
		
		/**
		 * Comando aggiornaDTViewe.
		 */
		public static final String DT_VIEWER_COMMAND = "#{LibroBean.aggiornaDTViewer}";
		
		/**
		 * Logout.
		 */
		public static final String LOGOUT_TITLE = "Logout";
		
		/**
		 * Identificativo categoria assegnazione interna.
		 */
		public static final int CATEGORIA_ASSEGNAZIONE_INTERNA = 7;
		
		/**
		 * Codice errore per trasformazione PDF.
		 */
		public static final int TRASFORMAZIONE_PDF_IN_ERRORE = 1;
		
		/**
		 * Codice ok per trasformazione PDF.
		 */
		public static final int TRASFORMAZIONE_PDF_OK = 0;
		
		/**
		 * Tipo trasformazione "TRASFORMATA" per la coda trasformazione PDF.
		 */
		public static final int TRASFORMATA = 1;
		
		/**
		 * Tipo trasformazione "TRASFORMATAIMPL" per la coda trasformazione PDF.
		 */
		public static final int TRASFORMATAIMPL = 2;
		
		/**
		 * Prefisso AOO FileNet
		 */
		public static final String AOO_PREFIX = "/AOO_";
		
		/**
		 * ELENCOTRASMISSIONEELETTRONICO
		 */
		public static final String ELENCOTRASMISSIONEELETTRONICO = "elettronico";
		
		/**
		 * Prefisso AOO FileNet
		 */
		public static final int ID_AOO_RL = 24;

		/**
		 * Descrizione Tipo Procedimento PRELEX
		 */
		public static final String TIPO_PROCEDIMENTO_PRELEX = "PRELEX";
		
		/**
		 * Stato del Fascicolo utilizzato da fepa nella crazione della raccolta FAD
		 */
		public static final String STATO_FASCICOLO_FEPA_INSERITO = "INSERITO";
		
		/**
		 * Stato del Fascicolo utilizzato da fepa nella crazione della raccolta FAD
		 */
		public static final String STATO_FASCICOLO_FEPA_APERTO = "APERTO";
		
		/**
		 * Label Tipologia processo manuale 
		 */
		public static final String TIPOLOGIA_PROC_PROCESSO_MANUALE_ATTO_DECRETO_LABEL = "Processo manuale ATTO DECRETO";
		
		/**
		 * Label Tipologia processo automatico 
		 */
		public static final String TIPOLOGIA_PROC_PROCESSO_AUTOMATICO_ATTO_DECRETO_LABEL = "Processo automatico ATTO DECRETO";
		
		/**
		 * Tipologia Documento "Dichiarazione Servizi Resi"
		 */
		public static final String TIPOLOGIA_DOC_DICHIARAZIONE_SERVIZI_RESI = "DICHIARAZIONE SERVIZI RESI";
		
		public static final int MAXLENGTH_SQL_QUERY_IN = 999;
		
		/**
		 * Label Tipologia documento FAD principale 
		 */
		public static final String TIPO_DOCUMENTO_FAD_PRINCIPALE = "RP01";
		
		/**
		 *  Label Tipologia documento FAD allegato 
		 */
		public static final String TIPO_DOCUMENTO_FAD_ALLEGATO = "RP02";
		
		
		/**
		 * Costruttore.
		 */
		protected Varie() {
		}
	}
	
	
	/**
	 * Costruttore.
	 */
	protected Constants() {
		
	}
	

}
