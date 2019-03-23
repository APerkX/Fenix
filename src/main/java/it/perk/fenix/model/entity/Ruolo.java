/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Perk
 *
 */
@Entity
@Table(name = "RUOLO")
public class Ruolo implements Serializable  {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 6933047123432515071L;

	/**
	 * Identificativo ruolo.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDRUOLO")
	private Long idRuolo;

	/**
	 * Nome ruolo.
	 */
	@Column(name = "NOMERUOLO")
	private String nomeRuolo;
	
	/**
	 * Permessi.
	 */
	@Column(name = "PERMESSI")
	private BigDecimal permessi;

	/**
	 * Data attivazione.
	 */
	@Column(name = "DATAATTIVAZIONE")
	private Date dataAttivazione;

	/**
	 * Data disattivazione.
	 */
	@Column(name = "DATADISATTIVAZIONE")
	private Date dataDisattivazione;
	
	@OneToMany(mappedBy = "ruolo")
	private Collection<NodoUtenteRuolo> utentiNodi;
	
	/**
	 * Aoo.
	 */
//	private Aoo aoo;

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

	/**
	 * @return the dataAttivazione
	 */
	public Date getDataAttivazione() {
		return dataAttivazione;
	}

	/**
	 * @param dataAttivazione the dataAttivazione to set
	 */
	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}

	/**
	 * @return the dataDisattivazione
	 */
	public Date getDataDisattivazione() {
		return dataDisattivazione;
	}

	/**
	 * @param dataDisattivazione the dataDisattivazione to set
	 */
	public void setDataDisattivazione(Date dataDisattivazione) {
		this.dataDisattivazione = dataDisattivazione;
	}

}
