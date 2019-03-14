/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

import it.perk.fenix.model.entity.Nodo;

/**
 * @author Perk
 *
 */
public class UfficioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2139166655296313514L;
	
	/**
	 * Identifcativo nodo.
	 */
	private Long idNodo;

	/**
	 * Descrizione.
	 */
	private String descrizione;
	
	public UfficioDTO(Nodo n) {
		idNodo = n.getIdNodo();
		descrizione = n.getDescrizione();
	}

	/**
	 * @return the idNodo
	 */
	public Long getIdNodo() {
		return idNodo;
	}

	/**
	 * @param idNodo the idNodo to set
	 */
	public void setIdNodo(Long idNodo) {
		this.idNodo = idNodo;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	

}
