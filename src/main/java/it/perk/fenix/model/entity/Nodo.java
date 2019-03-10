/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;
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
 * Entità che mappa la tabella NODO
 *
 */
@Entity
@Table(name = "NODO")
public class Nodo implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -202953509719514372L;
	
	/**
	 * Identifcativo nodo.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNODO")
	private Long idNodo;

	/**
	 * Descrizione.
	 */
	@Column(name = "DESCRIZIONE")
	private String descrizione;
	
	/**
	 * Identifcativo nodo padre.
	 */
	@Column(name = "IDNODOPADRE")
	private Long idNodoPadre;

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

	/**
	 * Flag Segreteria.
	 */
	@Column(name = "FLAGSEGRETERIA")
	private Integer flagSegreteria;

	/**
	 * Aoo.
	 */
//	private Aoo aoo;
	
	// andrebbe prevista una relazione @OneToOne con l'entità utente.
	@Column(name = "IDUTENTEDIRIGENTE")
	private Long idUtenteDirigente;

	@OneToMany(mappedBy = "nodo")
	private Collection<NodoUtenteRuolo> utentiRuoli;

	public Nodo() {
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

	/**
	 * @return the idNodoPadre
	 */
	public Long getIdNodoPadre() {
		return idNodoPadre;
	}

	/**
	 * @param idNodoPadre the idNodoPadre to set
	 */
	public void setIdNodoPadre(Long idNodoPadre) {
		this.idNodoPadre = idNodoPadre;
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

	/**
	 * @return the flagSegreteria
	 */
	public Integer getFlagSegreteria() {
		return flagSegreteria;
	}

	/**
	 * @param flagSegreteria the flagSegreteria to set
	 */
	public void setFlagSegreteria(Integer flagSegreteria) {
		this.flagSegreteria = flagSegreteria;
	}

	/**
	 * @return the idUtenteDirigente
	 */
	public Long getIdUtenteDirigente() {
		return idUtenteDirigente;
	}

	/**
	 * @param idUtenteDirigente the idUtenteDirigente to set
	 */
	public void setIdUtenteDirigente(Long idUtenteDirigente) {
		this.idUtenteDirigente = idUtenteDirigente;
	}

	/**
	 * @return the utentiRuoli
	 */
	public Collection<NodoUtenteRuolo> getUtentiRuoli() {
		return utentiRuoli;
	}

	/**
	 * @param utentiRuoli the utentiRuoli to set
	 */
	public void setUtentiRuoli(Collection<NodoUtenteRuolo> utentiRuoli) {
		this.utentiRuoli = utentiRuoli;
	}
	
	

}
