/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Perk
 * 
 * Classe necessaria per definire la chiave composta della tabella di Join NodoUtenteRuolo.
 *
 */
@Embeddable
public class NodoUtenteRuoloKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 49044917175555117L;
	
	@Column(name = "IDNODO")
	private Long idNodo;

	@Column(name = "IDUTENTE")
	private Long idUtente;
	
	@Column(name = "IDRUOLO")
	private long idRuolo;

	public NodoUtenteRuoloKey() {
		super();
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
	 * @return the idUtente
	 */
	public Long getIdUtente() {
		return idUtente;
	}

	/**
	 * @param idUtente the idUtente to set
	 */
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	/**
	 * @return the idRuolo
	 */
	public long getIdRuolo() {
		return idRuolo;
	}

	/**
	 * @param idRuolo the idRuolo to set
	 */
	public void setIdRuolo(long idRuolo) {
		this.idRuolo = idRuolo;
	}

	/**
	 * Implementazione necessaria dallo standard Jpa
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNodo == null) ? 0 : idNodo.hashCode());
		result = prime * result + (int) (idRuolo ^ (idRuolo >>> 32));
		result = prime * result + ((idUtente == null) ? 0 : idUtente.hashCode());
		return result;
	}

	/**
	 * Implementazione necessaria dallo standard Jpa
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodoUtenteRuoloKey other = (NodoUtenteRuoloKey) obj;
		if (idNodo == null) {
			if (other.idNodo != null)
				return false;
		} else if (!idNodo.equals(other.idNodo))
			return false;
		if (idRuolo != other.idRuolo)
			return false;
		if (idUtente == null) {
			if (other.idUtente != null)
				return false;
		} else if (!idUtente.equals(other.idUtente))
			return false;
		return true;
	}
	
	
	
}
