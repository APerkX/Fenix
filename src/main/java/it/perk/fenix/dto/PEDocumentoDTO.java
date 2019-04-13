/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.enums.TipoOperazioneLibroFirmaEnum;

/**
 * @author Perk
 *
 */
public class PEDocumentoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3733018307054356048L;

	/**
	 * Coda corrente.
	 */
	private String codaCorrente;

	/**
	 * Contatore.
	 */
	private int count;

	/**
	 * Data creazione work flow.
	 */
	private String dataCreazioneWF;

	/**
	 * Elenco libro firma.
	 */
	private String[] elencoLibroFirma;

	/**
	 * Flag firma abilitata.
	 */
	private Boolean flagEnableFirma;
	
	/**
	 * Flag firma copia conforme.
	 */
	private Boolean firmaCopiaConforme;

	/**
	 * Flag firma autografa abilitata.
	 */
	private Boolean flagEnableFirmaAutografa;

	/**
	 * Flag rifiuto abilitato.
	 */
	private Boolean flagEnableRifiuta;

	/**
	 * Flag sigla abilitata.
	 */
	private Boolean flagEnableSigla;

	/**
	 * Flag visto abilitato.
	 */
	private Boolean flagEnableVista;

	/**
	 * Flag firma digitale.
	 */
	private Boolean flagFirmaDig;

	/**
	 * Flag iter manuale.
	 */
	private Integer flagIterManuale;

	/**
	 * Identificativo documento.
	 */
	private String idDocumento;

	/**
	 * Identificativo fascicolo.
	 */
	private Integer idFascicolo;
	
	/**
	 * Identificativo nodo destinatario.
	 */
	private Integer idNodoDestinatario;

	/**
	 * Identificativo utente destinatario.
	 */
	private Integer idUtenteDestinatario;

	/**
	 * Motivo assegnazione.
	 */
	private String motivazioneAssegnazione;

	/**
	 * Operazione da eseguire sul documento.
	 */
	private TipoOperazioneLibroFirmaEnum operazione;

	/**
	 * Coda.
	 */
	private DocumentQueueEnum queue;

	/**
	 * Soggetto.
	 */
	private String subject;

	/**
	 * Identificativo tipo assegnazione.
	 */
	private Integer tipoAssegnazioneId;

	/**
	 * Wob number.
	 */
	private String wobNumber;
	
	/**
	 * Flag renderizzato.
	 */
	private Boolean flagRenderizzato;

	/**
	 * Flag urgenti.
	 */
	private Boolean urgente;

	/**
	 * Flag procedi da corriere.
	 */
	private Boolean flagProcediDaCorriere;
	
	/**
	 * Lista di response grezza restituita dal wf
	 */
	private String[] responses;
	
	/**
	 * 
	 */
	private String stepName;
	
	/**
	 * Informazioni Nota
	 */
	private NotaDTO notaDTO;
	
	public PEDocumentoDTO() {
		
	}
	
	public PEDocumentoDTO(final String inIdDocumento, final TipoOperazioneLibroFirmaEnum inOperazione, final String inWobNumber, 
			final DocumentQueueEnum inQueue, final Integer inIdUtenteDestinatario, final Integer inIdNodoDestinatario, final Boolean inFlagFirmaDig, 
			final String inMotivazioneAssegnazione, final String[] inResponses, final Integer inIdFascicolo, final String inCodaCorrente, 
			final Integer inTipoAssegnazioneId, final Integer inFlagIterManuale, final String inSubject, final String[] inElencoLibroFirma,
			final Integer inCount, final String inDataCreazioneWF, final Boolean inFlagRenderizzato, final Boolean inFirmaCopiaConforme, final Boolean inUrgente, 
			final String inStepName, final NotaDTO inNotaDTO) {
		super();
		urgente = inUrgente;
		idDocumento = inIdDocumento;
		operazione = inOperazione;
		wobNumber = inWobNumber;
		queue = inQueue;
		idUtenteDestinatario = inIdUtenteDestinatario;
		idNodoDestinatario = inIdNodoDestinatario;
		flagFirmaDig = inFlagFirmaDig;
		motivazioneAssegnazione = inMotivazioneAssegnazione;
		idFascicolo = inIdFascicolo;
		flagIterManuale = inFlagIterManuale;
		subject = inSubject;
		tipoAssegnazioneId = inTipoAssegnazioneId;

		flagEnableFirma = false;
		flagEnableFirmaAutografa = false;
		flagEnableRifiuta = false;
		flagEnableVista = false;
		flagEnableSigla = false;
		flagProcediDaCorriere = false;

		codaCorrente = inCodaCorrente;
		elencoLibroFirma = inElencoLibroFirma;
		if (inCount != null) {
			count = inCount;
		}
		dataCreazioneWF = inDataCreazioneWF;
		flagRenderizzato = inFlagRenderizzato;
		firmaCopiaConforme = inFirmaCopiaConforme;
		
		responses = inResponses;
		stepName = inStepName;
		notaDTO = inNotaDTO;

//		Boolean bIsInSignQueue = (inResponses != null && queue != null && DocumentQueueEnum.isInSignQueue(queue.getName()));
//		if (inResponses != null) {
//			for (String response:inResponses) {
//				if (bIsInSignQueue) {
//					if (LibroFirmaPerFirmaResponseEnum.FIRMA_DIGITALE.firstIn(response) != null) {
//						flagEnableFirma = true;
//					} else if (LibroFirmaPerFirmaResponseEnum.FIRMA_AUTOGRAFA.firstIn(response) != null) {
//						flagEnableFirmaAutografa = true;
//					} else if (LibroFirmaPerFirmaResponseEnum.RIFIUTA.firstIn(response) != null) {
//						flagEnableRifiuta = true;
//					} else if (LibroFirmaPerFirmaResponseEnum.VISTA.firstIn(response) != null) {
//						flagEnableVista = true;
//					} else if (LibroFirmaPerFirmaResponseEnum.SIGLA.firstIn(response) != null) {
//						flagEnableSigla = true;
//					}
//				} else {
//					if (LibroFirmaPerFirmaResponseEnum.PROCEDI_DA_CORRIERE.firstIn(response) != null) {
//						 flagProcediDaCorriere = true;
//					}
//				}
//			}
//		}
	}

	/**
	 * @return the codaCorrente
	 */
	public String getCodaCorrente() {
		return codaCorrente;
	}

	/**
	 * @param codaCorrente the codaCorrente to set
	 */
	public void setCodaCorrente(String codaCorrente) {
		this.codaCorrente = codaCorrente;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the dataCreazioneWF
	 */
	public String getDataCreazioneWF() {
		return dataCreazioneWF;
	}

	/**
	 * @param dataCreazioneWF the dataCreazioneWF to set
	 */
	public void setDataCreazioneWF(String dataCreazioneWF) {
		this.dataCreazioneWF = dataCreazioneWF;
	}

	/**
	 * @return the elencoLibroFirma
	 */
	public String[] getElencoLibroFirma() {
		return elencoLibroFirma;
	}

	/**
	 * @param elencoLibroFirma the elencoLibroFirma to set
	 */
	public void setElencoLibroFirma(String[] elencoLibroFirma) {
		this.elencoLibroFirma = elencoLibroFirma;
	}

	/**
	 * @return the flagEnableFirma
	 */
	public Boolean getFlagEnableFirma() {
		return flagEnableFirma;
	}

	/**
	 * @param flagEnableFirma the flagEnableFirma to set
	 */
	public void setFlagEnableFirma(Boolean flagEnableFirma) {
		this.flagEnableFirma = flagEnableFirma;
	}

	/**
	 * @return the firmaCopiaConforme
	 */
	public Boolean getFirmaCopiaConforme() {
		return firmaCopiaConforme;
	}

	/**
	 * @param firmaCopiaConforme the firmaCopiaConforme to set
	 */
	public void setFirmaCopiaConforme(Boolean firmaCopiaConforme) {
		this.firmaCopiaConforme = firmaCopiaConforme;
	}

	/**
	 * @return the flagEnableFirmaAutografa
	 */
	public Boolean getFlagEnableFirmaAutografa() {
		return flagEnableFirmaAutografa;
	}

	/**
	 * @param flagEnableFirmaAutografa the flagEnableFirmaAutografa to set
	 */
	public void setFlagEnableFirmaAutografa(Boolean flagEnableFirmaAutografa) {
		this.flagEnableFirmaAutografa = flagEnableFirmaAutografa;
	}

	/**
	 * @return the flagEnableRifiuta
	 */
	public Boolean getFlagEnableRifiuta() {
		return flagEnableRifiuta;
	}

	/**
	 * @param flagEnableRifiuta the flagEnableRifiuta to set
	 */
	public void setFlagEnableRifiuta(Boolean flagEnableRifiuta) {
		this.flagEnableRifiuta = flagEnableRifiuta;
	}

	/**
	 * @return the flagEnableSigla
	 */
	public Boolean getFlagEnableSigla() {
		return flagEnableSigla;
	}

	/**
	 * @param flagEnableSigla the flagEnableSigla to set
	 */
	public void setFlagEnableSigla(Boolean flagEnableSigla) {
		this.flagEnableSigla = flagEnableSigla;
	}

	/**
	 * @return the flagEnableVista
	 */
	public Boolean getFlagEnableVista() {
		return flagEnableVista;
	}

	/**
	 * @param flagEnableVista the flagEnableVista to set
	 */
	public void setFlagEnableVista(Boolean flagEnableVista) {
		this.flagEnableVista = flagEnableVista;
	}

	/**
	 * @return the flagFirmaDig
	 */
	public Boolean getFlagFirmaDig() {
		return flagFirmaDig;
	}

	/**
	 * @param flagFirmaDig the flagFirmaDig to set
	 */
	public void setFlagFirmaDig(Boolean flagFirmaDig) {
		this.flagFirmaDig = flagFirmaDig;
	}

	/**
	 * @return the flagIterManuale
	 */
	public Integer getFlagIterManuale() {
		return flagIterManuale;
	}

	/**
	 * @param flagIterManuale the flagIterManuale to set
	 */
	public void setFlagIterManuale(Integer flagIterManuale) {
		this.flagIterManuale = flagIterManuale;
	}

	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	/**
	 * @return the idFascicolo
	 */
	public Integer getIdFascicolo() {
		return idFascicolo;
	}

	/**
	 * @param idFascicolo the idFascicolo to set
	 */
	public void setIdFascicolo(Integer idFascicolo) {
		this.idFascicolo = idFascicolo;
	}

	/**
	 * @return the idNodoDestinatario
	 */
	public Integer getIdNodoDestinatario() {
		return idNodoDestinatario;
	}

	/**
	 * @param idNodoDestinatario the idNodoDestinatario to set
	 */
	public void setIdNodoDestinatario(Integer idNodoDestinatario) {
		this.idNodoDestinatario = idNodoDestinatario;
	}

	/**
	 * @return the idUtenteDestinatario
	 */
	public Integer getIdUtenteDestinatario() {
		return idUtenteDestinatario;
	}

	/**
	 * @param idUtenteDestinatario the idUtenteDestinatario to set
	 */
	public void setIdUtenteDestinatario(Integer idUtenteDestinatario) {
		this.idUtenteDestinatario = idUtenteDestinatario;
	}

	/**
	 * @return the motivazioneAssegnazione
	 */
	public String getMotivazioneAssegnazione() {
		return motivazioneAssegnazione;
	}

	/**
	 * @param motivazioneAssegnazione the motivazioneAssegnazione to set
	 */
	public void setMotivazioneAssegnazione(String motivazioneAssegnazione) {
		this.motivazioneAssegnazione = motivazioneAssegnazione;
	}

	/**
	 * @return the operazione
	 */
	public TipoOperazioneLibroFirmaEnum getOperazione() {
		return operazione;
	}

	/**
	 * @param operazione the operazione to set
	 */
	public void setOperazione(TipoOperazioneLibroFirmaEnum operazione) {
		this.operazione = operazione;
	}

	/**
	 * @return the queue
	 */
	public DocumentQueueEnum getQueue() {
		return queue;
	}

	/**
	 * @param queue the queue to set
	 */
	public void setQueue(DocumentQueueEnum queue) {
		this.queue = queue;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the tipoAssegnazioneId
	 */
	public Integer getTipoAssegnazioneId() {
		return tipoAssegnazioneId;
	}

	/**
	 * @param tipoAssegnazioneId the tipoAssegnazioneId to set
	 */
	public void setTipoAssegnazioneId(Integer tipoAssegnazioneId) {
		this.tipoAssegnazioneId = tipoAssegnazioneId;
	}

	/**
	 * @return the wobNumber
	 */
	public String getWobNumber() {
		return wobNumber;
	}

	/**
	 * @param wobNumber the wobNumber to set
	 */
	public void setWobNumber(String wobNumber) {
		this.wobNumber = wobNumber;
	}

	/**
	 * @return the flagRenderizzato
	 */
	public Boolean getFlagRenderizzato() {
		return flagRenderizzato;
	}

	/**
	 * @param flagRenderizzato the flagRenderizzato to set
	 */
	public void setFlagRenderizzato(Boolean flagRenderizzato) {
		this.flagRenderizzato = flagRenderizzato;
	}

	/**
	 * @return the urgente
	 */
	public Boolean getUrgente() {
		return urgente;
	}

	/**
	 * @param urgente the urgente to set
	 */
	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}

	/**
	 * @return the flagProcediDaCorriere
	 */
	public Boolean getFlagProcediDaCorriere() {
		return flagProcediDaCorriere;
	}

	/**
	 * @param flagProcediDaCorriere the flagProcediDaCorriere to set
	 */
	public void setFlagProcediDaCorriere(Boolean flagProcediDaCorriere) {
		this.flagProcediDaCorriere = flagProcediDaCorriere;
	}

	/**
	 * @return the responses
	 */
	public String[] getResponses() {
		return responses;
	}

	/**
	 * @param responses the responses to set
	 */
	public void setResponses(String[] responses) {
		this.responses = responses;
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
	 * @return the notaDTO
	 */
	public NotaDTO getNotaDTO() {
		return notaDTO;
	}

	/**
	 * @param notaDTO the notaDTO to set
	 */
	public void setNotaDTO(NotaDTO notaDTO) {
		this.notaDTO = notaDTO;
	}

	
}
