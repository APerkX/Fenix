/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import it.perk.fenix.model.entity.Ruolo;

/**
 * @author Perk
 *
 */
public class RuoloDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6282555880655111510L;
	
	/**
	 * Identificativo ruolo.
	 */
	private long idRuolo;

	/**
	 * Nome ruolo.
	 */
	private String nomeRuolo;
	
	/**
	 * Permessi.
	 */
	private BigDecimal permessi;

	public RuoloDTO(Ruolo r) {
		idRuolo = r.getIdRuolo();
		nomeRuolo = r.getNomeRuolo();
		permessi = r.getPermessi();
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
	 * @return the nomeRuolo
	 */
	public String getNomeRuolo() {
		return nomeRuolo;
	}

	/**
	 * @param nomeRuolo the nomeRuolo to set
	 */
	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	/**
	 * @return the permessi
	 */
	public BigDecimal getPermessi() {
		return permessi;
	}

	/**
	 * @param permessi the permessi to set
	 */
	public void setPermessi(BigDecimal permessi) {
		this.permessi = permessi;
	}
	
	
	
}
