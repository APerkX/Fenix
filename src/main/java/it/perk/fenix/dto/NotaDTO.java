/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

import it.perk.fenix.enums.ColoreNotaEnum;

/**
 * @author Perk
 *
 */
public class NotaDTO implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7630148537609651517L;

	/**
	 * Il colore della nota.
	 */
	private ColoreNotaEnum colore;
	
	/**
	 * Il testo della nota.
	 */
	private String contentNota;
	
	/**
	 * Costruttore.
	 */
	public NotaDTO() {
		super();
		contentNota = "";
	}

	/**
	 * Getter colore.
	 * 
	 * @return	colore
	 */
	public ColoreNotaEnum getColore() {
		return colore;
	}

	/**
	 *
	 * tags:
	 * @param i the colore to set
	 */
	public void setColore(ColoreNotaEnum i) {
		this.colore = i;
	}

	/**
	 * Getter content della nota.
	 * 
	 * @return	content della nota
	 */
	public String getContentNota() {
		return contentNota;
	}

	/**
	 *
	 * tags:
	 * @param contentNota the contentNota to set
	 */
	public void setContentNota(String contentNota) {
		this.contentNota = contentNota;
	}
}
