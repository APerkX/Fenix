/**
 * 
 */
package it.perk.fenix.enums;

import it.perk.fenix.dto.NotaDTO;
import it.perk.fenix.utils.StringUtils;

/**
 * @author Perk
 *
 */
public enum ColoreNotaEnum {

	ROSSO(1, "red"),
	
	GIALLO(2, "yellow"),
	
	VERDE(3, "green"),
	
	ARANCIONE(4, "orange"),
	
	BLU(5, "blue");
	
	ColoreNotaEnum(Integer inId, String inColor) {
		id = inId;
		color = inColor;
	}
	
	private Integer id;
	
	private String color;
	
	/**
	  * Metodo per il recupero di un'enum dato il valore caratteristico.
	  * 
	  * @param value	valore
	  * @return		enum
	  */
	 public static ColoreNotaEnum get(final Integer color) {
		 ColoreNotaEnum output = null;
		 for (ColoreNotaEnum c : ColoreNotaEnum.values()) {
			 if (c.getId().equals(color)) {
				 output = c;
				 break;
			 }
		 }
		 return output;
	 }
	 
	 public static NotaDTO getNotaDTO(final String notaRaw) {
		 NotaDTO output = new NotaDTO();
		 if (!StringUtils.isNullOrEmpty(notaRaw)) {
			 String[] assArr = notaRaw.split("_");
			 output.setColore(ColoreNotaEnum.get(Integer.parseInt(assArr[0].substring(1))));
			 if(assArr.length > 1){
				 output.setContentNota(assArr[1]);
			 }
		 }
		 return output;
	 }

	/**
	 * @return the id
	 */
	public final Integer getId() {
		return id;
	}

	/**
	 * @return the color
	 */
	public final String getColor() {
		return color;
	}
	
	
}
