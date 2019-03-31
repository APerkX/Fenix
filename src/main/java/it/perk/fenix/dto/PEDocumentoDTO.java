/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.enums.TipoOperazioneLibroFirmaEnum;

/**
 * DTO per le informazioni su un documento contenute nel PE.
 * 
 * @author Perk
 *
 */
public class PEDocumentoDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2531406312186266919L;

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
	 * 
	 */
	private NotaDTO notaDTO;
	
	/**
	 * Costruttore.
	 * 
	 * @param inIdDocumento					identificativo documento
	 * @param inOperazione					operazione
	 * @param inWobNumber					wob number
	 * @param inQueue						coda
	 * @param inIdUtenteDestinatario		identificativo utente destinatario
	 * @param inIdNodoDestinatario			identificativo nodo destinatario
	 * @param inFlagFirmaDig				flag firma digitale
	 * @param inMotivazioneAssegnazione		motivazione assegnazione
	 * @param inResponses					insieme di response associate
	 * @param inIdFascicolo					identigicativo fascicolo
	 * @param inCodaCorrente				coda corrente
	 * @param inTipoAssegnazioneId			identificativo tipo assegnazione
	 * @param inFlagIterManuale				flag iter manuale
	 * @param inSubject						subject
	 * @param inElencoLibroFirma			elenco libro firma
	 * @param inCount						contatore
	 * @param inDataCreazioneWF				data creazione work flow
	 * @param inFlagRenderizzato			Flag renderizzazione work flow
	 * @param inFirmaCopiaConforme			flag copia conforme
	 * @param inUrgente						flag urgente
	 */
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

		Boolean bIsInSignQueue = (inResponses != null && queue != null && DocumentQueueEnum.isInSignQueue(queue.getName()));
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
	 * Getter.
	 * 
	 * @return	urgenti
	 */
	public Boolean getUrgente() {
		return urgente;
	}
	
	/**
	 * Getter.
	 * 
	 * @return	flag firma copia conforme
	 */
	public final Boolean getFirmaCopiaConforme() {
		return firmaCopiaConforme;
	}

	/**
	 * Getter flag renderizzato.
	 * 
	 * @return	Flag renderizzato.
	 */
	public final Boolean getFlagRenderizzato() {
		if (flagRenderizzato == null) {
			return Boolean.FALSE;
		}
		return flagRenderizzato;
	}

	/**
	 * Getter.
	 * 
	 * @return	coda corrente
	 */
	public final String getCodaCorrente() {
		return codaCorrente;
	}

	/**
	 * Getter.
	 * 
	 * @return	contatore
	 */
	public final int getCount() {
		return count;
	}

	/**
	 * Getter.
	 * 
	 * @return	data creazione workflow
	 */
	public final String getDataCreazioneWF() {
		return dataCreazioneWF;
	}

	/**
	 * Getter.
	 * 
	 * @return	elenco libro firma
	 */
	public final String[] getElencoLibroFirma() {
		return elencoLibroFirma;
	}

	/**
	 * Getter.
	 * 
	 * @return	flag enable firma
	 */
	public final Boolean getFlagEnableFirma() {
		return flagEnableFirma;
	}

	/**
	 * Getter.
	 * 
	 * @return	flag enable firma autografa
	 */
	public final Boolean getFlagEnableFirmaAutografa() {
		return flagEnableFirmaAutografa;
	}

	/**
	 * Getter.
	 * 
	 * @return	flag enable rifiuta
	 */
	public final Boolean getFlagEnableRifiuta() {
		return flagEnableRifiuta;
	}

	/**
	 * Getter.
	 * 
	 * @return	flag enable sigla
	 */
	public final Boolean getFlagEnableSigla() {
		return flagEnableSigla;
	}

	/**
	 * Getter.
	 * 
	 * @return	flag enable vista
	 */
	public final Boolean getFlagEnableVista() {
		return flagEnableVista;
	}

	/**
	 * Getter.
	 * 
	 * @return	flag enable firma digitale
	 */
	public final Boolean getFlagFirmaDig() {
		return flagFirmaDig;
	}

	/**
	 * Getter.
	 * 
	 * @return	flag iter manuale
	 */
	public final Integer getFlagIterManuale() {
		return flagIterManuale;
	}

	/**
	 * Getter.
	 * 
	 * @return	identificativo documento
	 */
	public final String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * Getter.
	 * 
	 * @return	identificativo fascicolo
	 */
	public final Integer getIdFascicolo() {
		return idFascicolo;
	}

	/**
	 * Getter.
	 * 
	 * @return	identificativo nodo destinatario
	 */
	public final Integer getIdNodoDestinatario() {
		return idNodoDestinatario;
	}

	/**
	 * Getter.
	 * 
	 * @return	identificativo utente destinatario
	 */
	public final Integer getIdUtenteDestinatario() {
		return idUtenteDestinatario;
	}

	/**
	 * Getter.
	 * 
	 * @return	motivazione assegnazione
	 */
	public final String getMotivazioneAssegnazione() {
		return motivazioneAssegnazione;
	}

	/**
	 * Getter.
	 * 
	 * @return	tipo operazione
	 */
	public final TipoOperazioneLibroFirmaEnum getOperazione() {
		return operazione;
	}

	/**
	 * Getter.
	 * 
	 * @return	coda
	 */
	public final DocumentQueueEnum getQueue() {
		return queue;
	}

	/**
	 * Getter.
	 * 
	 * @return	subject
	 */
	public final String getSubject() {
		return subject;
	}

	/**
	 * Getter.
	 * 
	 * @return	identificativo tipo assegnazione
	 */
	public final Integer getTipoAssegnazioneId() {
		return tipoAssegnazioneId;
	}

	/**
	 * Getter.
	 * 
	 * @return	wob number
	 */
	public final String getWobNumber() {
		return wobNumber;
	}

	/**
	 * Setter.
	 * 
	 * @param inQueue	coda
	 */
	public final void setQueue(final DocumentQueueEnum inQueue) {
		this.queue = inQueue;
	}

	/**
	 * Gets the flag procedi da corriere.
	 *
	 * @return the flagProcediDaCorriere
	 */
	public Boolean getFlagProcediDaCorriere() {
		return flagProcediDaCorriere;
	}

	/**
	 * Sets the flag procedi da corriere.
	 *
	 * @param inFlagProcediDaCorriere the flagProcediDaCorriere to set
	 */
	public void setFlagProcediDaCorriere(final Boolean inFlagProcediDaCorriere) {
		this.flagProcediDaCorriere = inFlagProcediDaCorriere;
	}

	/**
	 * @return the responses
	 */
	public final String[] getResponses() {
		return responses;
	}

	/**
	 * @param responses the responses to set
	 */
	public final void setResponses(String[] responses) {
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
