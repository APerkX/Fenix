/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author Perk
 * 
 * Entità che mappa la Tabella di Join - NodoUtenteRuolo.
 *
 */
@Entity
@Table(name = "NODOUTENTERUOLO")
public class NodoUtenteRuolo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -221766930172995054L;
	
	/**
	 * Chiave composita per la Tabella di Join.
	 */
	@EmbeddedId
	private NodoUtenteRuoloKey id;
	
	@ManyToOne
	@MapsId("IDNODO")
	@JoinColumn(name = "IDNODO")
	private Nodo nodo;
	
	@ManyToOne
	@MapsId("IDUTENTE")
	@JoinColumn(name = "IDUTENTE")
	private Utente utente;

	@ManyToOne
	@MapsId("IDRUOLO")
	@JoinColumn(name = "IDRUOLO")
	private Ruolo ruolo;
	
	/**
	 * Flag che indica se la coppia ufficio/ruolo è la predefinita per l'utente.
	 */
	@Column(name = "PREDEFINITO")
	private Long predefinito;
	
	/**
	 * Active user.
	 */
	@Column(name = "ACTIVEUSER")
	private Long activeUser;
	
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
	 * Costruttore.
	 */
	public NodoUtenteRuolo() {
		super();
	}

	/**
	 * @return the id
	 */
	public NodoUtenteRuoloKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(NodoUtenteRuoloKey id) {
		this.id = id;
	}

	/**
	 * @return the nodo
	 */
	public Nodo getNodo() {
		return nodo;
	}

	/**
	 * @param nodo the nodo to set
	 */
	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}

	/**
	 * @param utente the utente to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	/**
	 * @return the ruolo
	 */
	public Ruolo getRuolo() {
		return ruolo;
	}

	/**
	 * @param ruolo the ruolo to set
	 */
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	/**
	 * @return the predefinito
	 */
	public Long getPredefinito() {
		return predefinito;
	}

	/**
	 * @param predefinito the predefinito to set
	 */
	public void setPredefinito(Long predefinito) {
		this.predefinito = predefinito;
	}

	/**
	 * @return the activeUser
	 */
	public Long getActiveUser() {
		return activeUser;
	}

	/**
	 * @param activeUser the activeUser to set
	 */
	public void setActiveUser(Long activeUser) {
		this.activeUser = activeUser;
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
