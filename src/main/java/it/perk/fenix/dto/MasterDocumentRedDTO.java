/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.enums.IconaStatoEnum;
import it.perk.fenix.enums.StatoDocumentoFuoriLibroFirmaEnum;
import it.perk.fenix.enums.TipoAssegnazioneEnum;
import it.perk.fenix.enums.TipoOperazioneLibroFirmaEnum;
import it.perk.fenix.enums.TipoSpedizioneDocumentoEnum;


/**
 * @author Perk
 *
 */
public class MasterDocumentRedDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5320385267748688002L;

	/**
	 * 
	 */
	private String guuid;
	
	/**
	 * 
	 */
	private String classeDocumentale;
	
	/**
	 * id auto generato all'occorrenza per rendere univoco un elemento in tabella
	 */
	private String idTable;
	
	/**
	 * Flag urgente.
	 */
	private Boolean urgente;

	/**
	 * Icona che rappresenta lo stato del documento.
	 */
	private IconaStatoEnum iconaStato;
	
	/**
	 * Anno protocollo.
	 */
	private Integer annoProtocollo;

	/**
	 * Flag allegati presenti.
	 */
	private Boolean bAttachmentPresent;

	/**
	 * Flag trasformazione in errore.
	 */
	private Boolean bTrasfPdfErrore;
	
	/**
	 * Flag trasformazione pdf in warning (errore che permette un nuovo tentativo senza passare dalla GA).
	 */
	private Boolean bTrasfPdfWarning;

	/**
	 * Document title.
	 */
	private String documentTitle;

	/**
	 * Flag abilita firma.
	 */
	private Boolean flagEnableFirma;

	/**
	 * Flag abilita firma autografa.
	 */
	private Boolean flagEnableFirmaAutografa;

	/**
	 * Flag abilita rifiuto.
	 */
	private Boolean flagEnableRifiuta;

	/**
	 * Flag abilita sigla.
	 */
	private Boolean flagEnableSigla;

	/**
	 * Flag abilita visto.
	 */
	private Boolean flagEnableVista;
	
	/**
	 * Flag Procedi da Corriere.
	 */
	private Boolean flagEnableProcediCorriere;

	/**
	 * Flag firma digitale.
	 */
	private Boolean flagFirmaDig;

	/**
	 * Identificativo utente destinatario.
	 */
	private Integer idUtenteDestinatario;

	/**
	 * Motivazione assegnazione.
	 */
	private String motivazioneAssegnazione;

	/**
	 * Numero documento.
	 */
	private Integer numeroDocumento;

	/**
	 * Numero protocollo.
	 */
	private Integer numeroProtocollo;

	/**
	 * Oggetto.
	 */
	private String oggetto;

	/**
	 * Operazione.
	 */
	private TipoOperazioneLibroFirmaEnum operazione;

	/**
	 * Coda.
	 */
	private DocumentQueueEnum queue;

	/**
	 * Tipologia documento.
	 */
	private String tipologiaDocumento;

	/**
	 * Wob number.
	 */
	private String wobNumber;

	/**
	 * Flag firma autografa Red.
	 */
	private Boolean flagFirmaAutografaRM;

	/**
	 * Data protocollazione.
	 */
	private final Date dataProtocollazione;

	/**
	 * Data creazione.
	 */
	private Date dataCreazione;

	/**
	 * Data scadenza.
	 */
	private Date dataScadenza;

	/**
	 * Urgenza.
	 */
	private Integer urgenza;

	/**
	 * Stato.
	 */
	private StatoDocumentoFuoriLibroFirmaEnum stato;

	/**
	 * Tipo spedizione.
	 */
	private TipoSpedizioneDocumentoEnum tipoSpedizione;
	
	/**
	 * Tipo Procedimento
	 */
	private String tipoProcedimento;

	/**
	 * Identificativo categoria documento.
	 */
	private Integer idCategoriaDocumento;

	/**
	 * Identificativo formato documento.
	 */
	private Integer idFormatoDocumento;
	
	/**
	 * Flag renderizzato.
	 */
	private Boolean flagRenderizzato;

	/**
	 * Identificativo momento protocollazione.
	 */
	private Integer idMomentoProtocollazione;

	/**
	 * Tipologia protocollo.
	 */
	private Integer tipoProtocollo;

	/**
	 * Flag riservato.
	 */
	private Boolean flagRiservato;

	/**
	 * Numero contributi.
	 */
	private Long numContributi;

	/**
	 * Flag firma copia conforme.
	 */
	private Boolean firmaCopiaConforme;

	/**
	 * Tipologia assegnazione.
	 */
	private TipoAssegnazioneEnum tipoAssegnazione;
	
	/**
	 * Flag firma PDF.
	 */
	private Boolean flagFirmaPDF;
	
	/**
	 * 
	 */
	private Integer annoDocumento;
	
	/**
	 * 
	 */
	private ResponsesDTO responses;
	
	/**
	 * 
	 */
	private String[] responsesRaw;
	
	/**
	 * 
	 */
	private String stepName;
	
	/**
	 * 
	 */
	private NotaDTO nota;
		
	public MasterDocumentRedDTO() {
		tipoSpedizione = null;
		idCategoriaDocumento = null;
		idFormatoDocumento = null;
		dataCreazione = null;
		documentTitle = null;
		numeroDocumento = null;
		oggetto = null;
		tipologiaDocumento = null;
		operazione = null;
		numeroProtocollo = null;
		annoProtocollo = null;
		wobNumber = null;
		bAttachmentPresent = null;
		bTrasfPdfErrore = null;
		bTrasfPdfWarning = null;
		flagEnableFirma = false;
		flagEnableFirmaAutografa = false;
		flagEnableRifiuta = false;
		flagEnableVista = false;
		flagEnableSigla = false;
		flagEnableProcediCorriere = false;
		dataScadenza = null;
		urgenza = null;
		flagFirmaAutografaRM = null;
		iconaStato = null;
		idMomentoProtocollazione = null;
		tipoProtocollo = null;
		flagRiservato = null;
		numContributi = null;
		dataProtocollazione = null;
	}
	
	public MasterDocumentRedDTO(final String inDocumentTitle, final Integer inNumeroDocumento, final String inOggetto,
							final String inTipologiaDocumento, final Integer inNumeroProtocollo, final Integer inAnnoProtocollo, final Boolean inAttachmentPresent,
							final Boolean inTrasfPdfErrore, final Boolean inTrasfPdfWarning, final Date inDataScadenza, final Integer inUrgenza, 
							final Date inDataCreazione, final Integer inIdCategoriaDocumento, 
							final Boolean inFlagFirmaAutografaRM, final Integer inTipoProtocollo, final Boolean inFlagRiservato,
							final Long inNumContributi, final Boolean inFlagFirmaPDF, final String inTipoProcedimento, 
							final TipoSpedizioneDocumentoEnum inTipoSpedizione, final Integer inAnnoDocumento, final String inGuuid,
							final Integer inIdFormatoDocumento, final Date inDataProtocollazione, final String inClasseDocumentale) {
		super();
		idTable = UUID.randomUUID().toString();
		idCategoriaDocumento = inIdCategoriaDocumento;
		idFormatoDocumento = inIdFormatoDocumento;
		dataCreazione = inDataCreazione;
		documentTitle = inDocumentTitle;
		numeroDocumento = inNumeroDocumento;
		oggetto = inOggetto;
		tipologiaDocumento = inTipologiaDocumento;
		numeroProtocollo = inNumeroProtocollo;
		annoProtocollo = inAnnoProtocollo;
		bAttachmentPresent = inAttachmentPresent;
		bTrasfPdfErrore = inTrasfPdfErrore;
		bTrasfPdfWarning = inTrasfPdfWarning;
		dataScadenza = inDataScadenza;
		urgenza = inUrgenza;//TODO: viene recuperato anche dal PE. quale mantenere
		flagFirmaAutografaRM = inFlagFirmaAutografaRM;
		tipoProtocollo = inTipoProtocollo;
		flagRiservato = inFlagRiservato;
		numContributi = inNumContributi;
		flagFirmaPDF = inFlagFirmaPDF;
		tipoProcedimento = inTipoProcedimento;
		tipoSpedizione = inTipoSpedizione;
		annoDocumento = inAnnoDocumento;
		guuid = inGuuid;
		classeDocumentale = inClasseDocumentale;
		
		dataProtocollazione = inDataProtocollazione;
		
//		Flag che verranno abilitati più avanti
		flagEnableFirma = false;
		flagEnableFirmaAutografa = false;
		flagEnableRifiuta = false;
		flagEnableVista = false;
		flagEnableSigla = false;
		flagEnableProcediCorriere = false;
	}
	
	/**
	 * Costruttore utilizzatoper il clone del master
	 */
	public MasterDocumentRedDTO(final MasterDocumentRedDTO m ) {
		super();
		this.urgente = m.getUrgente();
		this.iconaStato = m.getIconaStato();
		this.annoProtocollo = m.getAnnoProtocollo();
		this.bAttachmentPresent = m.getbAttachmentPresent();
		this.bTrasfPdfErrore = m.getbTrasfPdfErrore();
		this.bTrasfPdfWarning = m.getbTrasfPdfWarning();
		this.documentTitle = m.getDocumentTitle();
		this.flagEnableFirma = m.getFlagEnableFirma();
		this.flagEnableFirmaAutografa = m.getFlagEnableFirmaAutografa();
		this.flagEnableRifiuta = m.getFlagEnableRifiuta();
		this.flagEnableSigla = m.getFlagEnableSigla();
		this.flagEnableVista = m.getFlagEnableVista();
		this.flagEnableProcediCorriere = m.getFlagEnableProcediCorriere();
		this.flagFirmaDig = m.getFlagFirmaDig();
		this.idUtenteDestinatario = m.getIdUtenteDestinatario();
		this.motivazioneAssegnazione = m.getMotivazioneAssegnazione();
		this.numeroDocumento = m.getNumeroDocumento();
		this.numeroProtocollo = m.getNumeroProtocollo();
		this.oggetto = m.getOggetto();
		this.operazione = m.getOperazione();
		this.queue = m.getQueue();
		this.tipologiaDocumento = m.getTipologiaDocumento();
		this.wobNumber = m.getWobNumber();
		this.flagFirmaAutografaRM = m.getFlagFirmaAutografaRM();
		this.dataProtocollazione = m.getDataProtocollazione();
		this.dataCreazione = m.getDataCreazione();
		this.dataScadenza = m.getDataScadenza();
		this.urgenza = m.getUrgenza();
		this.stato = m.getStato();
		this.tipoSpedizione = m.getTipoSpedizione();
		this.tipoProcedimento = m.getTipoProcedimento();
		this.idCategoriaDocumento = m.getIdCategoriaDocumento();
		this.idFormatoDocumento = m.getIdFormatoDocumento();
		this.flagRenderizzato = m.getFlagRenderizzato();
		this.idMomentoProtocollazione = m.getIdMomentoProtocollazione();
		this.tipoProtocollo = m.getTipoProtocollo();
		this.flagRiservato = m.getFlagRiservato();
		this.numContributi = m.getNumContributi();
		this.firmaCopiaConforme = m.getFirmaCopiaConforme();
		this.tipoAssegnazione = m.getTipoAssegnazione();
		this.flagFirmaPDF = m.getFlagFirmaPDF();
		this.annoDocumento = m.getAnnoDocumento();
		this.guuid = m.getGuuid();
		this.classeDocumentale = m.getClasseDocumentale();
		
	}
	
	public final void fill(PEDocumentoDTO wf) {
		this.setUrgente(wf.getUrgente());
		this.setOperazione(wf.getOperazione());
		this.setWobNumber(wf.getWobNumber());
		this.setResponsesRaw(wf.getResponses());
		this.setStepName(wf.getStepName());
		this.setNota(wf.getNotaDTO());
		
		this.setQueue(wf.getQueue());
		this.setIdUtenteDestinatario(wf.getIdUtenteDestinatario());
		this.setFlagFirmaDig(wf.getFlagFirmaDig());
		this.setMotivazioneAssegnazione(wf.getMotivazioneAssegnazione());
		this.setTipoAssegnazione(TipoAssegnazioneEnum.get(wf.getTipoAssegnazioneId()));
		if (!this.getbTrasfPdfErrore()) {
			this.setFlagEnableFirma(wf.getFlagEnableFirma());
			this.setFlagEnableFirmaAutografa(wf.getFlagEnableFirmaAutografa());
			this.setFlagEnableRifiuta(wf.getFlagEnableRifiuta());
			this.setFlagEnableSigla(wf.getFlagEnableSigla());
			this.setFlagEnableVista(wf.getFlagEnableVista());
		}
	}
	
	/**
	 * @return the urgente
	 */
	public final Boolean getUrgente() {
		return urgente;
	}


	/**
	 * @param urgente the urgente to set
	 */
	public final void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}


	/**
	 * @return the iconaStato
	 */
	public final IconaStatoEnum getIconaStato() {
		return iconaStato;
	}


	/**
	 * @param iconaStato the iconaStato to set
	 */
	public final void setIconaStato(IconaStatoEnum iconaStato) {
		this.iconaStato = iconaStato;
	}


	/**
	 * @return the annoProtocollo
	 */
	public final Integer getAnnoProtocollo() {
		return annoProtocollo;
	}


	/**
	 * @param annoProtocollo the annoProtocollo to set
	 */
	public final void setAnnoProtocollo(Integer annoProtocollo) {
		this.annoProtocollo = annoProtocollo;
	}


	/**
	 * @return the bAttachmentPresent
	 */
	public final Boolean getbAttachmentPresent() {
		return bAttachmentPresent;
	}


	/**
	 * @param bAttachmentPresent the bAttachmentPresent to set
	 */
	public final void setbAttachmentPresent(Boolean bAttachmentPresent) {
		this.bAttachmentPresent = bAttachmentPresent;
	}


	/**
	 * @return the bTrasfPdfErrore
	 */
	public final Boolean getbTrasfPdfErrore() {
		return bTrasfPdfErrore;
	}
	
	/**
	 * @return the bTrasfPdfWarning
	 */
	public final Boolean getbTrasfPdfWarning() {
		return bTrasfPdfWarning;
	}


	/**
	 * @param bTrasfPdfErrore the bTrasfPdfErrore to set
	 */
	public final void setbTrasfPdfErrore(Boolean bTrasfPdfErrore) {
		this.bTrasfPdfErrore = bTrasfPdfErrore;
	}
	
	/**
	 * @param bTrasfPdfWarning the bTrasfPdfWarning to set
	 */
	public final void setbTrasfPdfWarning(Boolean bTrasfPdfWarning) {
		this.bTrasfPdfWarning = bTrasfPdfWarning;
	}


	/**
	 * @return the documentTitle
	 */
	public final String getDocumentTitle() {
		return documentTitle;
	}


	/**
	 * @param documentTitle the documentTitle to set
	 */
	public final void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}


	/**
	 * @return the flagEnableFirma
	 */
	public final Boolean getFlagEnableFirma() {
		return flagEnableFirma;
	}


	/**
	 * @param flagEnableFirma the flagEnableFirma to set
	 */
	public final void setFlagEnableFirma(Boolean flagEnableFirma) {
		this.flagEnableFirma = flagEnableFirma;
	}


	/**
	 * @return the flagEnableFirmaAutografa
	 */
	public final Boolean getFlagEnableFirmaAutografa() {
		return flagEnableFirmaAutografa;
	}


	/**
	 * @param flagEnableFirmaAutografa the flagEnableFirmaAutografa to set
	 */
	public final void setFlagEnableFirmaAutografa(Boolean flagEnableFirmaAutografa) {
		this.flagEnableFirmaAutografa = flagEnableFirmaAutografa;
	}


	/**
	 * @return the flagEnableRifiuta
	 */
	public final Boolean getFlagEnableRifiuta() {
		return flagEnableRifiuta;
	}


	/**
	 * @param flagEnableRifiuta the flagEnableRifiuta to set
	 */
	public final void setFlagEnableRifiuta(Boolean flagEnableRifiuta) {
		this.flagEnableRifiuta = flagEnableRifiuta;
	}


	/**
	 * @return the flagEnableSigla
	 */
	public final Boolean getFlagEnableSigla() {
		return flagEnableSigla;
	}


	/**
	 * @param flagEnableSigla the flagEnableSigla to set
	 */
	public final void setFlagEnableSigla(Boolean flagEnableSigla) {
		this.flagEnableSigla = flagEnableSigla;
	}


	/**
	 * @return the flagEnableVista
	 */
	public final Boolean getFlagEnableVista() {
		return flagEnableVista;
	}


	/**
	 * @param flagEnableVista the flagEnableVista to set
	 */
	public final void setFlagEnableVista(Boolean flagEnableVista) {
		this.flagEnableVista = flagEnableVista;
	}


	/**
	 * @return the flagEnableProcediCorriere
	 */
	public final Boolean getFlagEnableProcediCorriere() {
		return flagEnableProcediCorriere;
	}


	/**
	 * @param flagEnableProcediCorriere the flagEnableProcediCorriere to set
	 */
	public final void setFlagEnableProcediCorriere(Boolean flagEnableProcediCorriere) {
		this.flagEnableProcediCorriere = flagEnableProcediCorriere;
	}


	/**
	 * @return the flagFirmaDig
	 */
	public final Boolean getFlagFirmaDig() {
		return flagFirmaDig;
	}


	/**
	 * @param flagFirmaDig the flagFirmaDig to set
	 */
	public final void setFlagFirmaDig(Boolean flagFirmaDig) {
		this.flagFirmaDig = flagFirmaDig;
	}


	/**
	 * @return the idUtenteDestinatario
	 */
	public final Integer getIdUtenteDestinatario() {
		return idUtenteDestinatario;
	}


	/**
	 * @param idUtenteDestinatario the idUtenteDestinatario to set
	 */
	public final void setIdUtenteDestinatario(Integer idUtenteDestinatario) {
		this.idUtenteDestinatario = idUtenteDestinatario;
	}


	/**
	 * @return the motivazioneAssegnazione
	 */
	public final String getMotivazioneAssegnazione() {
		return motivazioneAssegnazione;
	}


	/**
	 * @param motivazioneAssegnazione the motivazioneAssegnazione to set
	 */
	public final void setMotivazioneAssegnazione(String motivazioneAssegnazione) {
		this.motivazioneAssegnazione = motivazioneAssegnazione;
	}


	/**
	 * @return the numeroDocumento
	 */
	public final Integer getNumeroDocumento() {
		return numeroDocumento;
	}


	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public final void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	/**
	 * @return the numeroProtocollo
	 */
	public final Integer getNumeroProtocollo() {
		return numeroProtocollo;
	}


	/**
	 * @param numeroProtocollo the numeroProtocollo to set
	 */
	public final void setNumeroProtocollo(Integer numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}


	/**
	 * @return the oggetto
	 */
	public final String getOggetto() {
		return oggetto;
	}


	/**
	 * @param oggetto the oggetto to set
	 */
	public final void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}


	/**
	 * @return the operazione
	 */
	public final TipoOperazioneLibroFirmaEnum getOperazione() {
		return operazione;
	}


	/**
	 * @param operazione the operazione to set
	 */
	public final void setOperazione(TipoOperazioneLibroFirmaEnum operazione) {
		this.operazione = operazione;
	}


	/**
	 * @return the queue
	 */
	public final DocumentQueueEnum getQueue() {
		return queue;
	}


	/**
	 * @param queue the queue to set
	 */
	public final void setQueue(DocumentQueueEnum queue) {
		this.queue = queue;
	}


	/**
	 * @return the tipologiaDocumento
	 */
	public final String getTipologiaDocumento() {
		return tipologiaDocumento;
	}


	/**
	 * @param tipologiaDocumento the tipologiaDocumento to set
	 */
	public final void setTipologiaDocumento(String tipologiaDocumento) {
		this.tipologiaDocumento = tipologiaDocumento;
	}


	/**
	 * @return the wobNumber
	 */
	public final String getWobNumber() {
		return wobNumber;
	}


	/**
	 * @param wobNumber the wobNumber to set
	 */
	public final void setWobNumber(String wobNumber) {
		this.wobNumber = wobNumber;
	}

	/**
	 * @return the flagFirmaAutografaRM
	 */
	public final Boolean getFlagFirmaAutografaRM() {
		return flagFirmaAutografaRM;
	}


	/**
	 * @param flagFirmaAutografaRM the flagFirmaAutografaRM to set
	 */
	public final void setFlagFirmaAutografaRM(Boolean flagFirmaAutografaRM) {
		this.flagFirmaAutografaRM = flagFirmaAutografaRM;
	}


	/**
	 * @return the dataCreazione
	 */
	public final Date getDataCreazione() {
		return dataCreazione;
	}


	/**
	 * @param dataCreazione the dataCreazione to set
	 */
	public final void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}


	/**
	 * @return the dataScadenza
	 */
	public final Date getDataScadenza() {
		return dataScadenza;
	}


	/**
	 * @param dataScadenza the dataScadenza to set
	 */
	public final void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}


	/**
	 * @return the urgenza
	 */
	public final Integer getUrgenza() {
		return urgenza;
	}


	/**
	 * @param urgenza the urgenza to set
	 */
	public final void setUrgenza(Integer urgenza) {
		this.urgenza = urgenza;
	}


	/**
	 * @return the stato
	 */
	public final StatoDocumentoFuoriLibroFirmaEnum getStato() {
		return stato;
	}


	/**
	 * @param stato the stato to set
	 */
	public final void setStato(StatoDocumentoFuoriLibroFirmaEnum stato) {
		this.stato = stato;
	}


	/**
	 * @return the tipoSpedizione
	 */
	public final TipoSpedizioneDocumentoEnum getTipoSpedizione() {
		return tipoSpedizione;
	}


	/**
	 * @param tipoSpedizione the tipoSpedizione to set
	 */
	public final void setTipoSpedizione(TipoSpedizioneDocumentoEnum tipoSpedizione) {
		this.tipoSpedizione = tipoSpedizione;
	}


	/**
	 * @return the idCategoriaDocumento
	 */
	public final Integer getIdCategoriaDocumento() {
		return idCategoriaDocumento;
	}


	/**
	 * @param idCategoriaDocumento the idCategoriaDocumento to set
	 */
	public final void setIdCategoriaDocumento(Integer idCategoriaDocumento) {
		this.idCategoriaDocumento = idCategoriaDocumento;
	}


	/**
	 * @return the idFormatoDocumento
	 */
	public final Integer getIdFormatoDocumento() {
		return idFormatoDocumento;
	}


	/**
	 * @param idFormatoDocumento the idFormatoDocumento to set
	 */
	public final void setIdFormatoDocumento(Integer idFormatoDocumento) {
		this.idFormatoDocumento = idFormatoDocumento;
	}


	/**
	 * @return the flagRenderizzato
	 */
	public final Boolean getFlagRenderizzato() {
		return flagRenderizzato;
	}


	/**
	 * @param flagRenderizzato the flagRenderizzato to set
	 */
	public final void setFlagRenderizzato(Boolean flagRenderizzato) {
		this.flagRenderizzato = flagRenderizzato;
	}


	/**
	 * @return the idMomentoProtocollazione
	 */
	public final Integer getIdMomentoProtocollazione() {
		return idMomentoProtocollazione;
	}


	/**
	 * @param idMomentoProtocollazione the idMomentoProtocollazione to set
	 */
	public final void setIdMomentoProtocollazione(Integer idMomentoProtocollazione) {
		this.idMomentoProtocollazione = idMomentoProtocollazione;
	}


	/**
	 * @return the tipoProtocollo
	 */
	public final Integer getTipoProtocollo() {
		return tipoProtocollo;
	}


	/**
	 * @param tipoProtocollo the tipoProtocollo to set
	 */
	public final void setTipoProtocollo(Integer tipoProtocollo) {
		this.tipoProtocollo = tipoProtocollo;
	}


	/**
	 * @return the flagRiservato
	 */
	public final Boolean getFlagRiservato() {
		return flagRiservato;
	}


	/**
	 * @param flagRiservato the flagRiservato to set
	 */
	public final void setFlagRiservato(Boolean flagRiservato) {
		this.flagRiservato = flagRiservato;
	}


	/**
	 * @return the numContributi
	 */
	public final Long getNumContributi() {
		return numContributi;
	}


	/**
	 * Getter.
	 * 
	 * @return	test presenza contributi
	 */
	public final Boolean getHasContributi() {
		return numContributi > 0;
	}


	/**
	 * @return the firmaCopiaConforme
	 */
	public final Boolean getFirmaCopiaConforme() {
		return firmaCopiaConforme;
	}


	/**
	 * @param firmaCopiaConforme the firmaCopiaConforme to set
	 */
	public final void setFirmaCopiaConforme(Boolean firmaCopiaConforme) {
		this.firmaCopiaConforme = firmaCopiaConforme;
	}


	/**
	 * @return the tipoAssegnazione
	 */
	public final TipoAssegnazioneEnum getTipoAssegnazione() {
		return tipoAssegnazione;
	}


	/**
	 * @param tipoAssegnazione the tipoAssegnazione to set
	 */
	public final void setTipoAssegnazione(TipoAssegnazioneEnum tipoAssegnazione) {
		this.tipoAssegnazione = tipoAssegnazione;
	}


	/**
	 * @return the flagFirmaPDF
	 */
	public final Boolean getFlagFirmaPDF() {
		return flagFirmaPDF;
	}


	/**
	 * @param flagFirmaPDF the flagFirmaPDF to set
	 */
	public final void setFlagFirmaPDF(Boolean flagFirmaPDF) {
		this.flagFirmaPDF = flagFirmaPDF;
	}


	/**
	 * @return the dataProtocollazione
	 */
	public final Date getDataProtocollazione() {
		return dataProtocollazione;
	}

	/**
	 * @return the tipoProcedimento
	 */
	public String getTipoProcedimento() {
		return tipoProcedimento;
	}

	/**
	 * @param tipoProcedimento the tipoProcedimento to set
	 */
	public void setTipoProcedimento(String tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	/**
	 * @return the idTable
	 */
	public String getIdTable() {
		return idTable;
	}

	/**
	 * @param idTable the idTable to set
	 */
	public void setIdTable(String idTable) {
		this.idTable = idTable;
	}

	/**
	 * @return the responses
	 */
	public ResponsesDTO getResponses() {
		return responses;
	}

	/**
	 * @param responses the responses to set
	 */
	public void setResponses(ResponsesDTO responses) {
		this.responses = responses;
	}

	/**
	 * @return the annoDocumento
	 */
	public Integer getAnnoDocumento() {
		return annoDocumento;
	}

	/**
	 * @param annoDocumento the annoDocumento to set
	 */
	public void setAnnoDocumento(Integer annoDocumento) {
		this.annoDocumento = annoDocumento;
	}

	/**
	 * @return the guuid
	 */
	public String getGuuid() {
		return guuid;
	}
	
	/**
	 * @return the classeDocumentale
	 */
	public String getClasseDocumentale() {
		return classeDocumentale;
	}

	/**
	 * @param guuid the guuid to set
	 */
	public void setGuuid(String guuid) {
		this.guuid = guuid;
	}
	
	/**
	 * @param classeDocumentale the classeDocumentale to set
	 */
	public void setClasseDocumentale(String classeDocumentale) {
		this.classeDocumentale = classeDocumentale;
	}

	/**
	 * @return the stepName
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * @param stepName the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	/**
	 * @return the responsesRaw
	 */
	public String[] getResponsesRaw() {
		return responsesRaw;
	}

	/**
	 * @param responsesRaw the responsesRaw to set
	 */
	public void setResponsesRaw(String[] responsesRaw) {
		this.responsesRaw = responsesRaw;
	}

	/**
	 * @return the nota
	 */
	public NotaDTO getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(NotaDTO nota) {
		this.nota = nota;
	}
	

}
