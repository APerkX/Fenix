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
public class WorkFlowDTO implements Serializable{

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
	 * 
	 */
	private NotaDTO notaDTO;
}
