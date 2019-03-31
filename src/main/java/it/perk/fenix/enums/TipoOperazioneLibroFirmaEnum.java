/**
 * 
 */
package it.perk.fenix.enums;


/**
 * Enumerato utilizzato per definire le operazioni eseguibili sul libro firma.
 * 
 * @author Perk
 *
 */
public enum TipoOperazioneLibroFirmaEnum {
	
	/**
	 * STORICO.
	 */
	COMPETENZA(1L, "ASSEGNATO PER COMPETENZA"),
	/**
	 * STORICO.
	 */
	CONOSCENZA(2L, "ASSEGNATO PER CONOSCENZA"),
	/**
	 * CONTRIBUTO.
	 */
	CONTRIBUTO(3L, "IN RICHIESTA CONTRIBUTO"),
	/**
	 * Firma.
	 */
	FIRMA(4L, "DA FIRMARE"),
	/**
	 * VISTO.
	 */
	FIRMATO(13L, "FIRMATO"),
	/**
	 * VISTO.
	 */
	FIRMATO_E_SPEDITO(14L, "FIRMATO E SPEDITO"),
	/**
	 * RIFIUTO ASSEGNAZIONE.
	 */
	RIFIUTO_ASSEGNAZIONE(7L, "RIFIUTATO [ASSEGNAZIONE]"),
	/**
	 * RIFIUTO FIRMA.
	 */
	RIFIUTO_FIRMA(8L, "RIFIUTATO [FIRMA]"),
	/**
	 * RIFIUTO SIGLA.
	 */
	RIFIUTO_SIGLA(9L, "RIFIUTATO [SIGLA]"),
	/**
	 * RIFIUTO VISTO.
	 */
	RIFIUTO_VISTO(10L, "RIFIUTO [VISTO]"),
	/**
	 * Sigla.
	 */
	SIGLA(5L, "DA SIGLARE"),
	/**
	 * SPEDIZIONE.
	 */
	SPEDIZIONE(11L, "IN SPEDIZIONE"),
	/**
	 * STORICO.
	 */
	STORICO(0L, "[STORICO]"),
	/**
	 * Visto.
	 */
	VISTA(6L, "DA VISTARE"),
	/**
	 * VISTO.
	 */
	VISTO(12L, "VISTATO"),
	
	/**
	 * LIBRO FIRMA.
	 */
	LIBRO_FIRMA(1000L, "LIBRO FIRMA"),
	/**
	 * RICERCA.
	 */
	RICERCA(1001L, "RICERCA"),
	/**
	 * CORRIERE.
	 */
	CORRIERE(1002L, "CORRIERE"),
	/**
	 * DA LAVORARE.
	 */
	DA_LAVORARE(1003L, "DA LAVORARE");

	/**
	 * Descrizione azione.
	 */
	private String descrizione;
	
	/**
	 * Identificativo azione.
	 */
	private Long idFilenet;

	/**
	 * Costruttore.
	 * 
	 * @param inIdFilenet			identificativo
	 * @param inDescrizione	descrizione
	 */
	TipoOperazioneLibroFirmaEnum(final Long inIdFilenet, final String inDescrizione) {
		this.idFilenet = inIdFilenet;
		this.descrizione = inDescrizione;
	}

	/**
	 * Getter descrizione.
	 * 
	 * @return	descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Getter identificativo.
	 * 
	 * @return	identificativo
	 */
	public Long getIdFilenet() {
		return idFilenet;
	}

	/**
	 * Recupero di un enum a partire dal suo id.
	 * 
	 * @param metadatoFilenet	id
	 * @return					enum associata
	 */
	public static TipoOperazioneLibroFirmaEnum get(final String metadatoFilenet) {
		TipoOperazioneLibroFirmaEnum output = null;
		for (TipoOperazioneLibroFirmaEnum tolf:TipoOperazioneLibroFirmaEnum.values()) {
			if (tolf.getIdFilenet().equals(Long.valueOf(metadatoFilenet))) {
				output = tolf;
				break;
			}
		}
		return output;
	}

}
