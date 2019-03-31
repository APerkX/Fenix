/**
 * 
 */
package it.perk.fenix.enums;


/**
 * @author Perk
 *
 */
public enum StatoLavorazioneEnum {
	
	LAVORATE(1L, "LAVORATE"),
	IN_ACQUISIZIONE(2L, "IN ACQUISIZIONE"),
	ASSEGNATE(4L, "ASSEGNATE"),
	IN_SOSPESO(8L, "IN SOSPESO"),
	PRECENSITI(32L, "PRECENSITI"),
	ATTI(64L, "ATTI"),
	RISPOSTA(128L, "RISPOSTA"),
	RICHIESTE_CHIUSE(256L, "RICHIESTE CHIUSE"),
	OSSERVAZIONE(512L, "OSSERVAZIONE"),
	MOZIONE(1024L, "MOZIONE"),
	LAVORATE_TEMP(2048L, "LAVORATE_TEMP");
	
	/**
	 * Identificativo.
	 */
	private Long id; 

	/**
	 * Descrizione.
	 */
	private String descrizione;
	
	private StatoLavorazioneEnum(Long inId, String inDescrizione) {
		id = inId; 
		descrizione = inDescrizione;
	}

	public Long getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public static StatoLavorazioneEnum get(Long idStatoLav) {
		StatoLavorazioneEnum output = null;
		for (StatoLavorazioneEnum sle:StatoLavorazioneEnum.values()) {
			if (sle.getId().equals(idStatoLav)) {
				output = sle;
				break;
			}
		}
		return output;
	}

	public static boolean isOneOf(StatoLavorazioneEnum sle, StatoLavorazioneEnum... sles) {
		Boolean output = false;
		for (StatoLavorazioneEnum s:sles) {
			if (sle.equals(s)) {
				output = true;
			}
		}
		return output;
	}
}
