/**
 * 
 */
package it.perk.fenix.enums;


/**
 * Enum per la tipologia di assegnazione.
 * 
 * @author Perk
 *
 */
public enum TipoAssegnazioneEnum {

	/**
	 * Copia conforme.
	 */
	COPIA_CONFORME(15, "Copia Conforme"),
	
	/**
	 * Storico.
	 */
	STORICO(0, "Storico"),

	/**
	 * Competenza.
	 */
	COMPETENZA(1, "Competenza"),

	/**
	 * Conoscenza.
	 */
	CONOSCENZA(2, "Conoscenza"),

	/**
	 * Contributo.
	 */
	CONTRIBUTO(3, "Contributo"),

	/**
	 * Firma.
	 */
	FIRMA(4, "Firma"),

	/**
	 * Sigla.
	 */
	SIGLA(5, "Sigla"),

	/**
	 * Visto.
	 */
	VISTO(6, "Visto"),

	/**
	 * Rifiuto assegnazione.
	 */
	RIFIUTO_ASSEGNAZIONE(7, "Rifiuto Assegnazione"),

	/**
	 * Rifiuto firma.
	 */
	RIFIUTO_FIRMA(8, "Rifiuto Firma"),

	/**
	 * Rifiuto sigla.
	 */
	RIFIUTO_SIGLA(9, "Rifiuto Sigla"),

	/**
	 * Rifiuto visto.
	 */
	RIFIUTO_VISTO(10, "Rifiuto Visto"),

	/**
	 * Spedizione.
	 */
	SPEDIZIONE(11, "Spedizione"),

	/**
	 * Visto manuale.
	 */
	VISTO_MANUALE(12, "Visto Manuale"),

	/**
	 * Firmato.
	 */
	FIRMATO(13, "Firmato"),

	/**
	 * Firmato e spedito.
	 */
	FIRMATO_E_SPEDITO(14, "Firmato e Spedito"),
	
	/**
	 * Destinatario interno.
	 */
	DESTINATARIO_INTERNO(55, "Destinatario Interno");
	

	/**
	 * Identificativo associato.
	 */
	private int tipoAssegnazioneId;
	
	private String descrizione;


	/**
	 * Costruttore.
	 * 
	 * @param id	identificativo associato
	 */
	TipoAssegnazioneEnum(final int inId, final String inDescrizione) {
		tipoAssegnazioneId = inId;
		descrizione = inDescrizione;
	}

	/**
	 * Getter identificativo associato.
	 * 
	 * @return	identificativo associato
	 */
	public int getId() {
		return tipoAssegnazioneId;
	}
	
	/**
	 * @return the descrizione
	 */
	public final String getDescrizione() {
		return descrizione;
	}

	/**
	 * Metodo per il recupero dell'enum a partire dall'identificativo associato.
	 * 
	 * @param idTipoAssegnazione	identificativo associato
	 * @return						enum associato all'identificativo
	 */
	public static TipoAssegnazioneEnum get(final Integer idTipoAssegnazione) {
		TipoAssegnazioneEnum output = null;
		if (idTipoAssegnazione != null) {
			for (TipoAssegnazioneEnum t:TipoAssegnazioneEnum.values()) {
				if (t.getId() == idTipoAssegnazione) {
					output = t;
				}
			}
		}
		return output;
	}

	/**
	 * Metodo per testare se un tipo di assegnazione è presente all'interno di una sequenza di tipi assegnazione.
	 * 
	 * @param valore	tipo di cui verificare la presenza
	 * @param tipi		sequenza
	 * @return			esito del test
	 */
	public static Boolean isIn(final TipoAssegnazioneEnum valore, final TipoAssegnazioneEnum... tipi) {
		Boolean output = false;
		for (TipoAssegnazioneEnum tipo : tipi) {
			if (tipo.equals(valore)) {
				output = true;
				break;
			}
		}
		return output;
	}

}
