/**
 * 
 */
package it.perk.fenix.enums;

/**
 * @author Perk
 * 
 * Enum delle properties salvate su db.
 *
 */
public enum PropertiesNameEnum {

	/**
	 * Id
	 */
	ID_FN_METAKEY("metadato.id"),
	/**
	 * MimeType
	 */
	MIMETYPE_FN_METAKEY("metadato.mimetype"),
	/**
	 * Destinatari mail cc.
	 */
	DESTINATARI_CC_LONG("metadato.destinatariCCLong"),
	/**
	 * Mail message id.
	 */
	MESSAGE_ID("metadato.messageId"),
	
	/**
	 * Tipo Evento.
	 */
	TIPO_EVENTO("metadato.tipoEvento"),
	
	/**
	 * FLAG RIATTIVA.
	 */
	FLAG_RIATTIVA("metadato.flagRiattiva"),
	
	/**
	 * Tipologia procedimento.
	 */
	ID_TIPOLOGIA_PROCEDIMENTO("metadato.idTipologiaProcedimento"),

	/**
	 * Destinatario contributo esterno.
	 */
	DESTINATARIO_CONTRIBUTO_ESTERNO("metadato.destinatarioContributoEsterno"),
	
	/**
	 * Identificativo nodo mittente.
	 */
	ID_NODO_MITTENTE_WF_METAKEY("metadato.idNodoMittente"),

	/**
	 * Contributo esterno.
	 */
	CONTRIBUTO_ESTERNO("metadato.contributoEsterno"),
	
	/**
	 * Mail coordinamento.
	 */
	MAIL_COORDINAMENTO("metadato.mailCoordinamento"),
	
	/**
	 * Metadato firma copia conforme.
	 */
	ID_RUOLO_AMMINISTRATORE_AOO("ruolo.amministratoreAOO.id"),

	
	/**
	 * Metadato firma copia conforme.
	 */
	MAIL_LINK_KEY_ENCRYPTION("metadato.mailLinkKeyEncryption"),
	
	/**
	 * Metadato firma copia conforme.
	 */
	FIRMA_COPIA_CONFORME_METAKEY("metadato.firmaCopiaConforme"),
	
	/**
	 * Metadato versione copia conforme.
	 */
	VERSIONE_COPIA_CONFORME_METAKEY("metadato.versionecopiaconforme"),
	
	/**
	 * Metadato copia conforme.
	 */
	COPIA_CONFORME_METAKEY("metadato.copiaConforme"),
	
	/**
	 * Metadato pe data assegnazione.
	 */
	DATA_ASSEGNAZIONE_WF_METAKEY("metadato.dataAssegnazione"),

	/**
	 * Metadato pe identificativo utente mittente.
	 */
	ID_UTENTE_MITTENTE_WF_METAKEY("metadato.idUtenteMittente"),
	/**
	 * Iter approvativo semaforo.
	 */
	ITER_APPROVATIVO_SEMAFORO_METAKEY("metadato.iterApprovativoSemaforo"),
	
	/**
	 * Livello di security per l'accesso al sistema:
	 *  - high: la pagina di login è bloccata a tutti gli utenti
	 *  - medium: la pagina di login è bloccata a tutti gli utenti che non hanno come ruolo predefinito: Amministratore dell’AOO
	 *  - low: la pagina di login è visibile a tutti gli utenti (utilizzare solo in ambiente di collaudo e manutenzione.
	 */
	ACCESS_SECURITY_LEVEL("access.security.level"),
	
	/**
	 * Intervallo di tempo di refresh delle properties.
	 */
	SUFFISSO_GRUPPOSECURITY_KEY("suffisso.gruppisecurity"),
	
	/**
	 * Data archiviazione.
	 */
	DATA_ARCHIVIAZIONE_METAKEY("metadato.dataArchiviazione"),
	
	/**
	 * Metadato id formato documento.
	 */
	ID_FORMATO_DOCUMENTO("metadato.idFormatoDocumento"),
	
	/**
	 * Metadato allegato da firmare.
	 */
	DA_FIRMARE_METAKEY("metadato.daFirmare"),
	/**
	 * Chiave della properties 'DocumentTitle'.
	 */
	DOCUMENT_TITLE_METAKEY("metadato.documenttitle"),
	/**
	 * Chiave della properties 'MajorVersionNumber'.
	 */
	MAJOR_VERSION_NUMBER_METAKEY("metadato.majorversionnumber"),
	/**
	 * Chiave della properties 'IDAOO'.
	 */
	ID_AOO_METAKEY("metadato.idaoo"),
	/**
	 * Chiave della properties 'IDAOO' del PE.
	 */
	ID_AOO_WF_METAKEY("pe.metadato.idaoo"),
	/**
	 * Chiave della properties 'Flag Firma autografa RedMobile'.
	 */
	FLAG_FIRMA_AUTOGRAFA_RM_METAKEY("metadato.flagFirmaAutografaRM"),
	/**
	 * Chiave della properties 'Data scadenza'.
	 */
	DATA_SCADENZA_METAKEY("metadato.datascadenza"),
	/**
	 * Chiave della properties 'Data scadenza'.
	 */
	URGENTE_METAKEY("metadato.urgente"),
	/**
	 * Chiave della properties 'Data creazione'.
	 */
	DATA_CREAZIONE_METAKEY("metadato.dataCreazione"),
	/**
	 * Chiave della properties 'Numero documento'.
	 */
	NUMERO_DOCUMENTO_METAKEY("metadato.numeroDocumento"),
	/**
	 * Chiave della properties 'Oggetto'.
	 */
	OGGETTO_METAKEY("metadato.oggetto"),
	/**
	 * Chiave della properties 'ID PROTOCOLLO'.
	 */
	ID_PROTOCOLLO_METAKEY("metadato.idprotocollo"),
	/**
	 * Chiave della properties 'Tipologia documento ID'.
	 */
	TIPOLOGIA_DOCUMENTO_ID_METAKEY("metadato.idtipologiadocumento"),
	/**
	 * Chiave della properties 'Tipologia documento ID'.
	 */
	ATTO_DECRETO_TIPO_DOC_VALUE("metadato.attodecretotipodoc"),
	/**
	 * Chiave della properties 'Tipologia documento ID'.
	 */
	PARERE_TIPO_DOC_METAKEY("metadato.pareretipodoc"),
	/**
	 * Chiave della properties 'Tipologia documento ID'.
	 */
	ATTO_DECRETO_MANUALE_VALUE("metadato.attodecretomanuale"),
	/**
	 * Chiave della properties 'Tipologia documento ID'.
	 */
	ATTO_DECRETO_AUTOMATICO_VALUE("metadato.attodecretoautomatico"),
	/**
	 * Chiave della properties 'Tipologia spedizione ID'.
	 */
	ID_TIPO_SPEDIZIONE_METAKEY("metadato.idtipospedizione"),
	/**
	 * Chiave della properties 'Numero protocollo'.
	 */
	NUMERO_PROTOCOLLO_METAKEY("metadato.numeroprotocollo"),
	/**
	 * Chiave della properties 'Tipologia documento NPS'.
	 */
	DESCRIZIONE_TIPOLOGIA_DOCUMENTO_NPS_METAKEY("metadato.tipologiadocumentonps"),
	/**
	 * Chiave della properties 'Oggetto protocolllo NPS'.
	 */
	OGGETTO_PROTOCOLLO_NPS_METAKEY("metadato.oggettoprotocollonps"),
	/**
	 * Chiave della properties 'Elenco libro firma'.
	 */
	ELENCO_LIBROFIRMA_METAKEY("metadato.elencolibrofirma"),
	/**
	 * Chiave della properties 'Elenco visti'.
	 */
	ELENCO_VISTI_METAKEY("metadato.elencovisti"),
	/**
	 * Chiave della properties 'Elenco conoscenza'.
	 */
	ELENCO_CONOSCENZA_METAKEY("metadato.elencoconoscenza"),
	/**
	 * Chiave della properties 'Elenco conoscenza storico'.
	 */
	ELENCO_CONOSCENZA_STORICO_METAKEY("metadato.elencoconoscenzastorico"),
	/**
	 * Chiave della properties 'Elenco contributi'.
	 */
	ELENCO_CONTRIBUTI_METAKEY("metadato.elencocontributi"),
	/**
	 * Chiave della properties 'Elenco contributi storico'.
	 */
	ELENCO_CONTRIBUTI_STORICO_METAKEY("metadato.elencocontributistorico"),
	/**
	 * Chiave della properties 'Elenco visti uffici'.
	 */
	ELENCO_UFFICI_VISTI_METAKEY("metadato.elencovistiuffici"),
	/**
	 * Chiave della properties 'Elenco visti ispettorati'.
	 */
	ELENCO_VISTI_ISPETTORATI_METAKEY("metadato.elencovistiispettorati"),
	/**
	 * Chiave della properties 'Item assegnatari'.
	 */
	ITEM_ASSEGNATARI_METAKEY("metadato.itemAssegnatari"),
	/**
	 * Chiave della properties 'Item assegnatari'.
	 */
	ELENCO_TRASMISSIONE_LIST_METAKEY("metadato.elencoTrasmissioneList"),
	/**
	 * Chiave della properties 'Count'.
	 */
	COUNT_METAKEY("metadato.count"),
	/**
	 * Chiave della properties 'Anno protocollo'.
	 */
	ANNO_PROTOCOLLO_METAKEY("metadato.annoprotocollo"),
	/**
	 * Chiave della properties 'Data protocollo'.
	 */
	DATA_PROTOCOLLO_METAKEY("metadato.dataprotocollo"),
	/**
	 * Chiave della properties 'Stato fascicolo'.
	 */
	STATO_FASCICOLO_METAKEY("metadato.statofascicolo"),
	/**
	 * Chiave della properties 'Faldonato'.
	 */
	FALDONATO_METAKEY("metadato.faldonato"),
	/**
	 * Chiave della properties 'idFascicoloFEPA'.
	 */
	METADATO_FASCICOLO_IDFASCICOLOFEPA("metadato.fascicolo.idfascicolofepa"),
	/**
	 * Chiave della properties 'idFascicoloFEPA'.
	 */
	METADATO_FASCICOLO_IDFASCICOLO("metadato.fascicolo.idfascicolo"),
	/**
	 * Chiave della properties 'Trasformazione PDF errore'.
	 */
	TRASFORMAZIONE_PDF_ERRORE_METAKEY("metadato.trasformazionepdfinerrore"),
	/**
	 * Chiave della properties 'Firma PDF'.
	 */
	FIRMA_PDF_METAKEY("metadato.firmapdf"),
	/**
	 * Chiave della properties 'Destinatari documento'.
	 */
	DESTINATARI_DOCUMENTO_METAKEY("metadato.destinatari"),
	/**
	 * Chiave della properties 'Ufficio creatore ID'.
	 */
	UFFICIO_CREATORE_ID_METAKEY("metadato.idnodocreatore"),
	/**
	 * Chiave della properties 'Utente creatore ID'.
	 */
	UTENTE_CREATORE_ID_METAKEY("metadato.idutentecreatore"),
	/**
	 * Chiave della properties 'ID utente protocollatore'.
	 */
	ID_UTENTE_PROTOCOLLATORE_METAKEY("metadato.idutenteprotocollatore"),
	/**
	 * Chiave della properties 'ID gruppo protocollatore'.
	 */
	ID_GRUPPO_PROTOCOLLATORE_METAKEY("metadato.idgruppoprotocollatore"),
	/**
	 * Chiave della properties 'Iter approvativo'.
	 */
	ITER_APPROVATIVO_METAKEY("metadato.iterapprovativo"),
	/**
	 * Chiave della properties 'Content element'.
	 */
	CONTENT_ELEMENTS_METAKEY("metadato.contentelements"),
	/**
	 * Chiave della properties 'formato Originale'.
	 */
	IS_FORMATO_ORIGINALE_METAKEY("metadato.isformatooriginale"),
	/**
	 * Chiave della properties 'Nome fascicolo'.
	 */
	NOME_FASCICOLO_METAKEY("metadato.nomefascicolo"),
	/**
	 * Chiave della properties 'Titolario/Indice di classificazione'.
	 */
	TITOLARIO_METAKEY("metadato.indiceclassificazione"),
	/**
	 * Chiave della properties 'Tiplogia assegnazione ID'.
	 */
	ID_TIPO_ASSEGNAZIONE_METAKEY("metadato.idtipoassegnazione"),
	/**
	 * Chiave della properties 'Flag renderizzato'.
	 */
	FLAG_RENDERIZZATO_METAKEY("metadato.flagrenderizzato"),
	/**
	 * Chiave della properties 'Stato richiesta ID'.
	 */
	STATO_RICHIESTA_ID_METAKEY("metadato.assetinformatici.idstatorichiesta"),
	/**
	 * Chiave della properties 'Nome coda'.
	 */
	NOME_CODA_METAKEY("metadato.nomecoda"),
	/**
	 * Chiave della properties 'Parent number del WF'.
	 */
	WF_PARENT_NUMBER_METAKEY("metadato.parentWFNumber"),
	/**
	 * Chiave della properties 'Pronto allo storno'.
	 */
	PRONTO_ALLO_STORNO_METAKEY("metadato.prontoallostorno"),
	/**
	 * Chiave della properties IDCATEGORIADOCUMENTO.
	 */
	IDCATEGORIADOCUMENTO_METAKEY("metadato.idcategoriadocumento"),
	/**
	 * Chiave della properties 'Nome file'.
	 */
	NOME_FILE_METAKEY("metadato.nomefile"),
	/**
	 * Chiave della properties 'Elenco destinatari interni'.
	 */
	ELENCO_DESTINATARI_INTERNI_METAKEY("metadato.elencoDestinatariInterni"),
	/**
	 * Chiave della properties 'Coordinatore flag'.
	 */
	COORDINATORE_FLAG_METAKEY("metadato.coordinatore"),
	/**
	 * Chiave della properties 'Id utente Coordinatore'.
	 */
	ID_UTENTE_COORDINATORE_METAKEY("metadato.idutentecoordinatore"),
	/**
	 * Chiave della properties 'Id ufficio Coordinatore'.
	 */
	ID_UFFICIO_COORDINATORE_METAKEY("metadato.idnodocoordinatore"),
	/**
	 * Chiave della properties 'Id client'.
	 */
	ID_CLIENT_METAKEY("metadato.idclient"),
	/**
	 * Chiave della properties 'Data terminazione'.
	 */
	DATA_TERMINAZIONE_METAKEY("metadato.dataterminazione"),
	/**
	 * Chiave della properties 'Momento protocollazione'.
	 */
	MOMENTO_PROTOCOLLAZIONE_ID_METAKEY("metadato.idmomentoprotocollazione"),
	/**
	 * Chiave della properties 'Formato allegato'.
	 */
	FORMATO_ALLEGATO_ID_METAKEY("metadato.idformatoallegato"),
	/**
	 * Chiave della properties 'Posizione'.
	 */
	POSIZIONE_METAKEY("metadato.posizione"),
	/**
	 * Chiave della properties 'Is copia conforme'.
	 */
	IS_COPIA_CONFORME_METAKEY("metadato.iscopiaconforme"),
	/**
	 * Chiave della properties 'Id ufficio copia conforme'.
	 */
	ID_UFFICIO_COPIA_CONFORME_METAKEY("metadato.idnodocopiaconforme"),
	/**
	 * Chiave della properties 'Id utente copia conforme'.
	 */
	ID_UTENTE_COPIA_CONFORME_METAKEY("metadato.idutentecopiaconforme"),
	/**
	 * Chiave della properties 'Id applicazione key'.
	 */
	ID_APPLICAZIONE_KEY_METAKEY("metadato.idapplicazione.key"),
	/**
	 * Chiave della properties 'Id applicazione value'.
	 */
	ID_APPLICAZIONE_VALUE_METAKEY("metadato.idapplicazione.value"),
	/**
	 * Chiave della properties 'Mittente'.
	 */
	MITTENTE_METAKEY("metadato.mittente"),
	/**
	 * Chiave della properties 'Numero RDP'.
	 */
	NUMERO_RDP_METAKEY("metadato.numerordp"),
	/**
	 * Chiave della properties 'Numero legislatura'.
	 */
	NUMERO_LEGISLATURA_METAKEY("metadato.numerolegislatura"),
	/**
	 * Chiave della properties 'Numero protocollo mittente'.
	 */
	NUMERO_PROTOCOLLO_MITTENTE_METAKEY("metadato.numeroprotocollomittente"),
	/**
	 * Chiave della properties 'Numero protocollo mittente'.
	 */
	ANNO_PROTOCOLLO_MITTENTE_METAKEY("metadato.annoprotocollomittente"),
	/**
	 * Chiave della properties 'Numero protocollo mittente'.
	 */
	DATA_PROTOCOLLO_MITTENTE_METAKEY("metadato.dataprotocollomittente"),
	/**
	 * Chiave della properties 'Assegnatari Competenza'.
	 */
	ASSEGNATARI_COMPETENZA_METAKEY("metadato.assegnataricompetenza"),
	/**
	 * Chiave della properties 'Assegnatari Conoscenza'.
	 */
	ASSEGNATARI_CONOSCENZA_METAKEY("metadato.assegnatariconoscenza"),
	/**
	 * Chiave della properties 'Assegnatari Contributo'.
	 */
	ASSEGNATARI_CONTRIBUTO_METAKEY("metadato.assegnataricontributo"),
	/**
	 * Chiave della properties 'Numero Protocollo Risposta'.
	 */
	NUMERO_PROTOCOLLO_RISPOSTA_METAKEY("metadato.numeroprotocollorisposta"),
	/**
	 * Chiave della properties 'Anno Protocollo Risposta'.
	 */
	ANNO_PROTOCOLLO_RISPOSTA_METAKEY("metadato.annoprotocollorisposta"),
	/**
	 * Chiave della properties 'Numero Raccomandata'.
	 */
	NUMERO_RACCOMANDATA_METAKEY("metadato.numeroraccomandata"),
	/**
	 * Chiave della properties 'Note'.
	 */
	NOTE_METAKEY("metadato.note"),
	/**
	 * Chiave della properties 'Osservazione'.
	 */
	OSSERVAZIONE_METAKEY("metadato.osservazione"),
	/**
	 * Chiave della properties 'Anno Registro Osservazione'.
	 */
	ANNO_REGISTRO_OSSERVAZIONE_METAKEY("metadato.annoRegistroOsservazione"),
	/**
	 * Chiave della properties 'Numero Registro Osservazione'.
	 */
	NUMERO_REGISTRO_OSSERVAZIONE_METAKEY("metadato.numeroRegistroOsservazione"),
	/**
	 * Chiave della properties 'Flag Corte Conti'.
	 */
	FLAG_CORTE_CONTI_METAKEY("metadato.flagcorteconti"),
	/**
	 * Chiave della properties 'Tipo Visto'.
	 */
	TIPO_VISTO_METAKEY("metadato.tipovisto"),
	/**
	 * Chiave della properties 'Anno Registro Visto'.
	 */
	ANNO_REGISTRO_VISTO_METAKEY("metadato.annoRegistroVisto"),
	/**
	 * Chiave della properties 'Numero Registro Visto'.
	 */
	NUMERO_REGISTRO_VISTO_METAKEY("metadato.numeroRegistroVisto"),
	/**
	 * Chiave della properties 'Num Doc Dest Int Uscita'.
	 */
	NUM_DOC_DEST_INT_USCITA_METAKEY("metadato.numDocDestIntUscita"),
	//#################################################################
	
	//### MAIL METAKEY ###############################################
	/**
	 * Chiave della properties 'Stato Mail'.
	 */
	STATO_MAIL_METAKEY("metadato.statomail"),
	
	/**
	 * Chiave della properties 'From Mail'.
	 */
	FROM_MAIL_METAKEY("metadato.from"),
	/**
	 * Chiave della properties 'Destinatari eMail'.
	 */
	DESTINATARI_EMAIL_METAKEY("metadato.destinatarimail"),
	/**
	 * Chiave della properties "Data ricezione Mail".
	 * @author AndreaP
	 */
	DATA_RICEZIONE_MAIL_METAKEY("metadato.dataricezionemail"),
	/**
	 * Chiave della properties 'Destinatari CC eMail'.
	 */
	DESTINATARI_CC_EMAIL_METAKEY("metadato.destinataricc"),
	/**
	 * Chiave della properties 'Oggetto eMail'.
	 */
	OGGETTO_EMAIL_METAKEY("metadato.oggettomail"),
	/**
	 * Chiave della properties 'Casella postale'.
	 */
	CASELLA_POSTALE_METAKEY("metadato.casellapostale"),
	/**
	 * Chiave della properties 'Mittente mail'.
	 */
	MITTENTE_MAIL_METAKEY("metadato.mittentemail"),
	/**
	 * Chiave della properties 'Tipologia invio'.
	 */
	TIPOLOGIA_INVIO_METAKEY("metadato.tipologiainvio"),
	/**
	 * Chiave della properties 'SentOn'.
	 */
	DATA_INVIO_MAIL_METAKEY("metadato.datainviomail"),
	/**
	 * Chiave della properties 'ID utente destinatario'.
	 */
	ID_UTENTE_DESTINATARIO_WF_METAKEY("metadato.idutentedestinatario"),
	/**
	 * Chiave della properties 'ID nodo destinatario'.
	 */
	ID_NODO_DESTINATARIO_WF_METAKEY("metadato.idnododestinatario"),
	/**
	 * Chiave della properties 'Id documento WF'.
	 */
	ID_DOCUMENTO_WF_METAKEY("metadato.iddocumento"),
	/**
	 * Chiave della property 'Id utente temporaneo WF'
	 */
	ID_UTENTE_TMP_WF_METAKEY("metadato.idutentetmp"),
	/**
	 * Chiave della properties 'Firma DIG RGS'.
	 */
	FIRMA_DIG_RGS_WF_METAKEY("metadato.firmadigrgs"),
	/**
	 * Chiave della properties 'Flag Iter Manaule'.
	 */
	FLAG_ITER_MANUALE_WF_METAKEY("metadato.flagIterManuale"),
	/**
	 * Chiave della properties 'ID fascicolo'.
	 */
	ID_FASCICOLO_WF_METAKEY("metadato.idfascicolo"),
	/**
	 * Chiave della properties 'Motivazione assegnazione'.
	 */
	MOTIVAZIONE_ASSEGNAZIONE_WF_METAKEY("metadato.motivazioneassegnazione"),
	/**
	 * Chiave della properties Workflow processo step'.
	 */
	ID_NODO_START_WF_METAKEY("metadato.idNodoStart"),
	/**
	 * Chiave della properties 'Is Assegnazione Interna'.
	 */
	IS_ASSEGNAZIONE_INTERNA_WF_METAKEY("metadato.isassegnazioneinterna"),
	/**
	 * Chiave della properties 'ID Documento Old'.
	 */
	ID_DOCUMENTO_OLD_WF_METAKEY("metadato.iddocumentoold"),
	/**
	 * Chiave della properties 'Nota email'.
	 */
	NOTA_EMAIL_METAKEY("metadato.notaemail"),
	/**
	 * Chiave della properties 'Motivo eliminazione email'.
	 */
	MOTIVO_ELIMINAZIONE_EMAIL_METAKEY("metadato.motivazioneEliminazioneMail"),
	/**
	 * Chiave della properties 'Data Cambio Stato'.
	 */
	DATA_CAMBIO_STATO_EMAIL_METAKEY("metadato.datacambiostato"),
	/**
	 * 
	 */
	ID_RACCOLTA_FAD_METAKEY("metadato.idraccoltafad"),
	/**
	 * 
	 */
	AMMINISTRAZIONE_FAD_METAKEY("metadato.amministrazioneFad"),
	/**
	 * 
	 */
	RAGIONERIA_FAD_METAKEY("metadato.ragioneriaFad"),
	/**
	 * 
	 */
	ID_RACCOLTA_PROVVISORIA_METAKEY("metadato.idraccoltaprovvisoria"),
	/**
	 * 
	 */
	DOC_OLD_ALLEGATO_WF_METAKEY("metadato.allegatoWorkflow.documentoOld"),
	/**
	 * 
	 */
	DOC_NEW_ALLEGATO_WF_METAKEY("metadato.allegatoWorkflow.documentoNew"),
	//#################################################################
	
	//### CASELLA POSTA METAKEY #######################################
	/**
	 * Chiave della properties 'tipologia casella postale'.
	 */
	TIPOLOGIA_CASELLA_POSTA_METAKEY("metadato.tipologia"),
	//#################################################################
	
	//### FILENET #####################################################

	/**
	 * Metadato indirizzo mailbox.
	 */
	MAILBOX_INDIRIZZO_FN_METAKEY("metadato.mailboxName"),
	/**
	 * Chiave della properties 'hostinvio'.
	 */
	MAILBOX_HOSTINVIO_MAIL_METAKEY("metadato.hostinvio"),
	/**
	 * Chiave della properties 'hostricezione'.
	 */
	MAILBOX_HOSTRICEZIONE_METAKEY("metadato.hostricezione"),
	/**
	 * Chiave della properties 'passwordinvio'.
	 */
	MAILBOX_PASSWORDINVIO_METAKEY("metadato.passwordinvio"),
	/**
	 * Chiave della properties 'passwordricezione'.
	 */
	MAILBOX_PASSWORDRICEZIONE_METAKEY("metadato.passwordricezione"),
	/**
	 * Chiave della properties 'portinvio'.
	 */
	MAILBOX_PORTINVIO_METAKEY("metadato.portinvio"),
	/**
	 * Chiave della properties 'portricezione'.
	 */
	MAILBOX_PORTRICEZIONE_METAKEY("metadato.portricezione"),
	/**
	 * Chiave della properties 'proxyhost'.
	 */
	MAILBOX_PROXYHOST_METAKEY("metadato.proxyhost"),
	/**
	 * Chiave della properties 'proxyport'.
	 */
	MAILBOX_PROXYPORT_METAKEY("metadato.proxyport"),
	/**
	 * Chiave della properties 'usernameinvio'.
	 */
	MAILBOX_USERNAMEINVIO_METAKEY("metadato.usernameinvio"),
	/**
	 * Chiave della properties 'usernamericezione'.
	 */
	MAILBOX_USERNAMERICEZIONE_METAKEY("metadato.usernamericezione"),
	/**
	 * Chiave della properties 'serverintype'.
	 */
	MAILBOX_SERVERINTYPE_METAKEY("metadato.serverintype"),
	/**
	 * Chiave della properties 'serveroutautenticazione'.
	 */
	MAILBOX_SERVEROUTAUTENTICAZIONE_METAKEY("metadato.serveroutautenticazione"),
	/**
	 * Chiave della properties 'gestionewhitelist'.
	 */
	MAILBOX_GESTIONEWHITELIST_METAKEY("metadato.gestionewhitelist"),
	/**
	 * Chiave della properties 'Mailbox className'.
	 */
	MAILBOX_CLASSNAME_FN_METAKEY("filenet.classemailbox"),
	/**
	 * Chiave della properties 'DOCUMENTO className'.
	 */
	DOCUMENTO_CLASSNAME_FN_METAKEY("filenet.classedocumento"),
	/**
	 * Chiave della properties 'CONTRIBUTO className'.
	 */
	CONTRIBUTO_CLASSNAME_FN_METAKEY("filenet.classecontributo"),
	/**
	 * Chiave della properties 'Fascicolo className'.
	 */
	FASCICOLO_CLASSNAME_FN_METAKEY("filenet.classefascicolo"),
	/**
	 * Chiave della properties 'Faldone className'.
	 */
	FALDONE_CLASSNAME_FN_METAKEY("filenet.classefaldone"),
	/**
	 * Chiave della properties 'Allegato className'.
	 */
	ALLEGATO_CLASSNAME_FN_METAKEY("filenet.classeallegato"),
	/**
	 * Chiave della properties 'DSR className'.
	 */
	DSR_CLASSNAME_FN_METAKEY("filenet.classedocumentodichiarazioneserviziresi"),
	/**
	 * Chiave della properties 'Fattura FEPA className'.
	 */
	FATTURA_FEPA_CLASSNAME_FN_METAKEY("filenet.classedocumentofatturafepa"),
	/**
	 * Chiave della properties 'Mailbox className'.
	 */
	DECRETO_DIRIGENZIALE_FEPA_CLASSNAME_FN_METAKEY("filenet.classedocumentodescretodirigenzialefepa"),
	/**
	 * Chiave della properties 'Atto decreto className'.
	 */
	ATTO_DECRETO_CLASSNAME_FN_METAKEY("filenet.classedocumentoattodecreto"),
	/**
	 * Chiave della properties 'Atto decreto className'.
	 */
	DOCUMENTO_GENERICO_CLASSNAME_FN_METAKEY("filenet.classedocumentogenerico"),
	/**
	 * Chiave della properties 'Titolario className'.
	 */
	TITOLARIO_CLASSNAME_FN_METAKEY("filenet.classetitolario"),
	/**
	 * Chiave della properties 'Mail className'.
	 */
	MAIL_CLASSNAME_FN_METAKEY("filenet.classemail"),
	/**
	 * Chiave della properties 'BARCODE'.
	 */
	BARCODE_METAKEY("metadato.barcode"),
	/**
	 * Chiave della properties 'Tipo protocollo'.
	 */
	TIPO_PROTOCOLLO_METAKEY("metadato.tipoprotocollo"),
	/**
	 * Chiave della properties 'Riservato'.
	 */
	RISERVATO_METAKEY("metadato.riservato"),
	/**
	 * Chiave della properties 'Registro riservato'.
	 */
	REGISTRO_RISERVATO_METAKEY("metadato.registroriservato"),
	/**
	 * Chiave della properties 'Anno documento'.
	 */
	ANNO_DOCUMENTO_METAKEY("metadato.annoDocumento"), //annoDocumento
	/**
	 * Chiave della properties 'Folder elettronici'.
	 */
	FOLDER_ELETTRONICI_FN_METAKEY("folder.elettronici"),
	/**
	 * Chiave della properties 'Folder fascicolo'.
	 */
	FOLDER_FASCICOLI_FN_METAKEY("folder.fascicoli"),
	/**
	 * Chiave della properties 'Folder fascicolo'.
	 */
	FOLDER_CASELLA_POSTALE_FN_METAKEY("folder.casellapostale"),
	/**
	 * Chiave della properties 'Folder inviata'.
	 */
	FOLDER_MAIL_INVIATA_FN_METAKEY("folder.mail.fws.inviata"),
	/**
	 * Chiave della properties 'Folder inbox'.
	 */
	FOLDER_MAIL_INBOX_FN_METAKEY("folder.mail.fws.inbox"),
	
	FOLDER_MAIL_FWS_NOTIFICHE("folder.mail.fws.notifiche"),
	/**
	 * Chiave della properties 'PE ROSTER NAME'.
	 */
	PE_ROSTERNAME_FN_METAKEY("pe.rostername"),
	/**
	 * Chiave della properties 'Tipo approvazione ID' del PE.
	 */
	ID_TIPO_APPROVAZIONE_FN_METAKEY("metadato.idtipoapprovazione"),
	/**
	 * Chiave della properties 'Tipo approvazione ID' del CE.
	 */
	ID_TIPOLOGIA_APPROVAZIONE_FN_METAKEY("metadato.idTipologiaProcedimento"),
	/**
	 * Chiave della properties 'Note visto'.
	 */
	NOTE_VISTO_FN_METAKEY("metadato.notevisto"),
	/**
	 * Chiave della properties 'ID coda lavorazione'.
	 */
	ID_CODA_LAVORAZIONE_FN_METAKEY("metadato.idcodalavorazione"),
	/**
	 * Chiave della properties 'ID tipo firma'.
	 */
	ID_TIPO_FIRMA_FN_METAKEY("metadato.idtipofirma"),
	/**
	 * Chiave della properties 'WS client'.
	 */
	WS_IDCLIENT("ws.idclient"),
	//#################################################################
	
	//### CE KEY ######################################################
	/**
	 * Chiave della properties 'Folder documenti'.
	 */
	FOLDER_DOCUMENTI_CEKEY("folder.documenti"),
	/**
	 * Chiave della properties 'Folder bozze'.
	 */
	FOLDER_BOZZE_CEKEY("folder.bozze"),
	/**
	 * Chiave della properties 'Folder bozze mail'.
	 */
	FOLDER_BOZZE_MAIL_CEKEY("folder.bozzemail"),
	//#################################################################
	
	//### WF KEY ######################################################
	/**
	 * Chiave della properties 'Workflow processo giro visto ufficio'.
	 */
	WF_PROCESSO_GIROVISTOUFFICIO_MAPPING_WFKEY("workflow.processogirovistoufficio.mapping"),
	/**
	 * Chiave della properties 'Workflow processo giro visto ispettorato'.
	 */
	WF_PROCESSO_GIROVISTOISPETTORATO_MAPPING_WFKEY("workflow.processogirovistoispettorato.mapping"),
	/**
	 * Chiave della properties 'Workflow processo giro visto ispettore competente'.
	 */
	WF_PROCESSO_GIROVISTOISPCOMPETENTE_MAPPING_WFKEY("workflow.processogirovistoispcompetente.mapping"),
	/**
	 * Chiave della properties 'Mapping Step In Sospeso'.
	 */
	STEP_IN_SOSPESO_MAPPING_WFKEY("stepname.insospeso.mapping"),
	/**
	 * Chiave della properties 'Workflow processso contributo'.
	 */
	WF_PROCESSO_CONTRIBUTO_WFKEY("workflow.processocontributo.mapping"),
	/**
	 * Chiave della properties 'Workflow processo chiusura storico'.
	 */
	WF_PROCESSO_CHIUSURA_STORICO_WFKEY("pe.chiusurastorico"),
	/**
	 * Chiave della properties 'Al giro visti Step Name'.
	 */
	AL_GIROVISTI_STEPNAME_WFKEY("stepname.algirovisti.mapping"),
	/**
	 * Chiave della properties Workflow processo step'.
	 */
	WF_PROCESSO_STEP_MAPPING_WFKEY("workflow.processostep.mapping"),
	/**
	 * Chiave della properties Workflow processo conoscenza'.
	 */
	WF_PROCESSO_CONOSCENZA_MAPPING_WFKEY("workflow.processoconoscenza.mapping"),
	//######################################################################
	
	//### NPS KEY ##########################################################
	/**
	 * Chiave della properties 'Endpoint servizi documentale WS NPS'.
	 */
	NPS_WS_DOCUMENTALE_ENDPOINT_NPSKEY("nps.ws.documentale.endpoint"),
	/**
	 * Chiave della properties 'Endpoint servizi protocollo WS NPS'.
	 */
	NPS_WS_PROTOCOLLO_ENDPOINT_NPSKEY("nps.ws.protocollo.endpoint"),
	/**
	 * Chiave della properties 'Endpoint servizi WS NPS'.
	 */
	NPS_CLIENT_NPSKEY("nps.ws.client"),
	/**
	 * Chiave della properties 'Endpoint servizi WS NPS'.
	 */
	NPS_PWD_NPSKEY("nps.ws.pwd"),
	/**
	 * Chiave della properties 'Endpoint servizi WS NPS'.
	 */
	NPS_SERVICE_NPSKEY("nps.ws.service"),
	/**
	 * Chiave della properties 'Endpoint servizi WS NPS'.
	 */
	NPS_USER_NPSKEY("nps.ws.user"),
	/**
	 * Chiave della properties 'Endpoint servizi WS NPS'.
	 */
	NPS_APPLICATION_NPSKEY("nps.ws.application"),
	/**
	 * Chiave della properties 'Endpoint servizi WS NPS'.
	 */
	NPS_ACTOR_NPSKEY("nps.ws.actor"),
	//######################################################################
	//### PMEF KEY ##########################################################
	
	/**
	 * Protocollo MEF endpoint.
	 */
	TARGET_ENDPOINT_PMEFKEY("protocollomef.targetendpoint"),
	
	/**
	 * Protocollo MEF username.
	 */
	WSUSERNAME_PMEFKEY("protocollomef.wsusername"),
	
	/**
	 * Protocollo MEF password.
	 */
	WSPASSWORD_PMEFKEY("protocollomef.wspassword"),
	
	/**
	 * Protocollo MEF azione.
	 */
	AZIONE_PMEFKEY("protocollomef.azione"),
	
	/**
	 * Protocollo MEF servizio.
	 */
	SERVIZIO_PMEFKEY("protocollomef.servizio"),
	//######################################################################
	
	
	//### ADOBE KEY ########################################################
	/**
	 * Chiave della properties 'Endpoint server Adobe'.
	 */
	DSC_DEFAULT_SOAP_ENDPOINT_ADOBEKEY("DSC_DEFAULT_SOAP_ENDPOINT"),
	/**
	 * Chiave della properties 'MAX_CONVERT_RETRY Adobe'.
	 */
	MAX_CONVERT_RETRY_ADOBEKEY("MAX_CONVERT_RETRY"),
	/**
	 * Chiave della properties 'DSC_SERVER_TYPE Adobe'.
	 */
	DSC_SERVER_TYPE_ADOBEKEY("DSC_SERVER_TYPE"),
	/**
	 * Chiave della properties 'DSC_CREDENTIAL_USERNAME Adobe'.
	 */
	DSC_CREDENTIAL_USERNAME_ADOBEKEY("DSC_CREDENTIAL_USERNAME"),
	/**
	 * Chiave della properties 'DSC_CREDENTIAL_USERNAME Adobe'.
	 */
	DSC_CREDENTIAL_PASSWORD_ADOBEKEY("DSC_CREDENTIAL_PASSWORD"),
	/**
	 * Chiave della properties 'system.admin.username'.
	 */
	SYSTEM_ADMIN_USERNAME_KEY("system.admin.username"),
	/**
	 * Chiave della properties 'sistema.amministratore', da concatenare con la stringa CODICEAOO + ".".
	 */
	AOO_SISTEMA_AMMINISTRATORE("sistema.amministratore"),
	//######################################################################
	
	
	//### DEMBIL_FEPA KEY ##########################################################
	/**
	 * 
	 */
	FAD_DEMBIL_TARGET_ENDPOINT("fad.ws.targetendpoint"),//ok
	/**
	 * 
	 */
	FAD_DEMBIL_APPLICATION("dembil_fad.ws.applicazione"),//ok
	/**
	 * 
	 */
	FAD_DEMBIL_ORG_ID("dembil_fad.ws.orgid"),//ok
	/**
	 * 
	 */
	FAD_DEMBIL_USER_ID("dembil_fad.ws.userid"),//ok
	/**
	 * 
	 */
	FAD_DEMBIL_USER_TYPE("dembil_fad.ws.usertype"),//ok
	/**
	 * 
	 */
	FAD_DEMBIL_CLIENT_ID("dembil_fad.ws.clientid"),//ok
	/**
	 * 
	 */
	FAD_DEMBIL_PASSWORD("dembil_fad.ws.password"),//ok
	/**
	 * 
	 */
	FAD_DEMBIL_SERVICE("dembil_fad.ws.service"),
	//######################################################################
	
	//### BILENTI KEY ##########################################################
	/**
	 * 
	 */
	BILENTI_ENDPOINT("bilenti.ws.targetendpoint"),
	/**
	 * 
	 */
	BILENTI_APPLICAZIONE_WS("bilenti.fepa.credenziali.ws.applicazione"),
	/**
	 * 
	 */
	BILENTI_CLIENTID("bilenti.fepa.credenziali.ws.clientid"),
	/**
	 * 
	 */
	BILENTI_PASSWORD("bilenti.fepa.credenziali.ws.password"),
	/**
	 * 
	 */
	BILENTI_SERVICE("bilenti.fepa.credenziali.ws.service"),
	/**
	 * 
	 */
	BILENTI_APPLICAZIONE_UTENTE("bilenti.fepa.credenziali.utente.applicazione"),
	/**
	 * 
	 */
	BILENTI_ORGID("bilenti.fepa.credenziali.utente.orgid"),
	/**
	 * 
	 */
	BILENTI_USERID("bilenti.fepa.credenziali.utente.userid"),
	/**
	 * 
	 */
	BILENTI_USERTYPE("bilenti.fepa.credenziali.utente.usertype"),
	
	//######################################################################
	
	
	/**
	 * mezzoRicezione : contiene l'id del mezzo
	 */
	METADATO_DOCUMENTO_MEZZORICEZIONE("metadato.documento.mezzoricezione"),
	
	/**
	 * dataAnnullamentoDocumento
	 */
	METADATO_DOCUMENTO_DATA_ANNULLAMENTO("metadato.documento.dataAnnullamento"),
	
	/**
	 * mittente : String
	 */
	METADATO_DOCUMENTO_MITTENTE("metadato.documento.mittente"),
	
	/**CAMPI FALDONE START***********************************************************/
	/**
	 * DocumentTitle
	 */
	METADATO_FALDONE_DOCUMENTTITLE("metadato.faldone.documentTitle"),
	/**
	 * nomeFaldone
	 */
	METADATO_FALDONE_NOMEFALDONE("metadato.faldone.nomeFaldone"),
	/**
	 * parentFaldone
	 */
	METADATO_FALDONE_PARENTFALDONE("metadato.faldone.parentFaldone"),
	/**
	 * descrizioneFaldone
	 */
	METADATO_FALDONE_DESCRIZIONEFALDONE("metadato.faldone.descrizioneFaldone"),
	/**
	 * idAOO
	 */
	METADATO_FALDONE_IDAOO("metadato.faldone.idAOO"),
	/**
	 * MigratoProtocolloMEF
	 */
	METADATO_FALDONE_MIGRATOPROTOCOLLOMEF("metadato.faldone.migratoProtocolloMEF"),
	/**
	 * Oggetto
	 */
	METADATO_FALDONE_OGGETTO("metadato.faldone.oggetto"),
	/**
	 * IsReserved
	 */
	METADATO_FALDONE_RESERVED("metadato.faldone.reserved"),
	/**CAMPI FALDONE END*************************************************************/
	
	METADATO_ANNO_MITTENTE_CONTRIBUTO("metadato.annomittentecontributo"),
	METADATO_NUMERO_MITTENTE_CONTRIBUTO("metadato.numeromittentecontributo"),
	MODIFICA_MONTANARO_METAKEY("metadato.modifica_montanaro"),
	
	METADATO_STATO_PRE_ARCHIVIAZIONE("metadato.statomailprearchiviazione"),
	DELTA_GIORNI_ELIMINAZIONE_MAIL("delta.numero.gg"),
	
	VERIFICA_FIRMA_MAX_ITEM("verifica.firma.max.item"),
	METADATO_DOCUMENTO_VALIDITA_FIRMA("metadato.validitaFirma"), 
	PKBOX_SERVERPATH("pkbox.serverpath"),
	GROUP_SECURITY_PREFIX("group.security.prefix"),
	FALDONE_PARENT_FOLDER_PREFIX("faldone.parent.folder.prefix"),
	MAX_FASCICOLI_NON_CLASSIFICATI("max.fascicoli.non_classificati"),
	
	/**
	 * Chiave della properties 'tipologiaFirma'.
	 */
	TIPOLOGIA_FIRMA_WF_METAKEY("metadato.tipologiafirma"),
	
	TIPO_DOC_BILANCIO_ENTI_USCITA("tipologia.documento.bilancio.enti.uscita");
	
	
	/**
	 * Chiave del parametro.
	 */
	private String key;
	
	/**
	 * Costruttore.
	 * 
	 * @param inKey	chiave
	 */
	PropertiesNameEnum(final String inKey) {
		key = inKey;
	}
	
	/**
	 * Getter chiave.
	 * 
	 * @return	chiave del parametro
	 */
	public String getKey() {
		return key;
	}

}
