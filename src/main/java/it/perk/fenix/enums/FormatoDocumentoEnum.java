/**
 * 
 */
package it.perk.fenix.enums;


/**
 * Enumerato utilizzato per definire il formato di un documento.
 * 
 * @author Perk
 *
 */
public enum FormatoDocumentoEnum {
	
	/**
	 * Cartaceo.
	 */
	CARTACEO(1L, "Cartaceo"),
	/**
	 * Elettronico.
	 */
	ELETTRONICO(2L, "Elettronico"),
	/**
	 * Precensito.
	 */
	PRECENSITO(3L, "Precensito");

	/**
	 * Identificativo formato.
	 */
	private Long id;
	/**
	 * Descrizione formato.
	 */
	private String descrizione;
	
	/**
	 * Costruttore.
	 * 
	 * @param inId			identificativo
	 * @param inDescrizione	descrizione
	 */
	FormatoDocumentoEnum(final Long inId, final String inDescrizione) {
		this.id = inId;
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
	public Long getId() {
		return id;
	}
	
	/**
	 * Ritorna l'enum selezionato  
	 * @param id
	 * @return
	 */
	public static FormatoDocumentoEnum getEnumById(Long id) {
		FormatoDocumentoEnum output = null;
		for (FormatoDocumentoEnum item : FormatoDocumentoEnum.values()) {
			if(item.getId().equals(id) ) {
				output = item;
				break;
			}
		}
		
		return output;
	}

}
