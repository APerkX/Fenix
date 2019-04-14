/**
 * 
 */
package it.perk.fenix.enums;

/**
 * Enum categoria documento.
 * 
 * @author Perk
 *
 */
public enum CategoriaDocumentoEnum {
	/**
	 * Categoria entrata.
	 */
	ENTRATA("E", 1, 7, 8), 

	/**
	 * Categoria uscita.
	 */
	USCITA("U", 2, 3), 

	/**
	 * Categoria altro.
	 */
	ALTRO("A", 4, 5, 6),
	
	/**
	 * Sul DB tabella CATEGORIADOCUMENTO
	 */
	DOCUMENTO_ENTRATA("Documento in entrata",1),
	/**
	 * Sul DB tabella CATEGORIADOCUMENTO
	 */
	DOCUMENTO_USCITA("Documento in uscita",2),
	/**
	 *  Sul DB tabella CATEGORIADOCUMENTO
	 */
	MOZIONE("Mozione",3),
	/**
	 * Sul DB tabella CATEGORIADOCUMENTO
	 */
	ALLEGATO("Allegato",4),
	/**
	 * Sul DB tabella CATEGORIADOCUMENTO
	 */
	ASSET("Asset",5),
	/**
	 * Sul DB tabella CATEGORIADOCUMENTO
	 */
	INTERNO("Interno",6),
	/**
	 * Sul DB tabella CATEGORIADOCUMENTO
	 */
	ASSEGNAZIONE_INTERNA("Assegnazione interna",7),
	/**
	 * Sul DB tabella CATEGORIADOCUMENTO
	 */
	CONTRIBUTO_ESTERNO("Contributo esterno",8);

	/**
	 * Identificativi associati ad una categoria.
	 */
	private Integer[] ids;
	
	/**
	 * Descrizione categoria.
	 */
	private String descrizione;
	
	/**
	 * Costruttore.
	 * 
	 * @param inDescrizione	descrizione
	 * @param inIds			identificativi associati
	 */
	CategoriaDocumentoEnum(final String inDescrizione, final Integer... inIds) {
		this.ids = inIds;
		this.descrizione = inDescrizione;
	}

	/**
	 * Getter identificativi associati.
	 * 
	 * @return	identificativi associati
	 */
	public Integer[] getIds() {
		return ids;
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
	 * Metodo per il recupero di un enum a partire dal suo valore caratteristico.
	 * 
	 * @param value	valore
	 * @return		enum associata al valore
	 */
	public static CategoriaDocumentoEnum get(final Integer value) {
		CategoriaDocumentoEnum output = null;
		for (CategoriaDocumentoEnum cat:CategoriaDocumentoEnum.values()) {
			for (Integer c:cat.getIds()) {
				if (value.equals(c)) {
					output = cat;
					break;
				}
			}
		}
		return output;
	}
}
