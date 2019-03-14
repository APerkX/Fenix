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
 * Entità che mappa la tabella UTENTE
 *
 */
@Entity
@Table(name = "UTENTE")
public class Utente implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -6546985888202380372L;

	/**
	 * Identificativo utente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDUTENTE")
	private Long idUtente;

	/**
	 * Username.
	 */
	@Column(name = "USERNAME")
	private String username;

	/**
	 * Nome.
	 */
	@Column(name = "NOME")
	private String nome;
	
	/**
	 * Cognome.
	 */
	@Column(name = "COGNOME")
	private String cognome;
	
	/**
	 * Codice fiscale.
	 */
	@Column(name = "CODFIS")
	private String codiceFiscale;

	/**
	 * Email.
	 */
	@Column(name = "EMAIL")
	private String email;

	/**
	 * Registro riservato.
	 */
	@Column(name = "REGISTRORISERVATO")
	private Long registroRiservato;
	
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
	
	@OneToMany(mappedBy = "utente")
	private Collection<NodoUtenteRuolo> nodiRuoli;
	
	/**
	 * Default Constructor
	 */
	public Utente() {
		super();
	}
	
	/**
	 * 
	 * @param inIdUtente
	 * @param inNome
	 * @param inCognome
	 */
	public Utente(final Long inIdUtente, final String inNome, final String inCognome) {
		idUtente = inIdUtente;
		nome = inNome;
		cognome = inCognome;
		username = null;
		codiceFiscale = null;
		email = null;
		registroRiservato = null;
		dataAttivazione = null;
		dataDisattivazione = null;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the codiceFiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @param codiceFiscale the codiceFiscale to set
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the registroRiservato
	 */
	public Long getRegistroRiservato() {
		return registroRiservato;
	}

	/**
	 * @param registroRiservato the registroRiservato to set
	 */
	public void setRegistroRiservato(Long registroRiservato) {
		this.registroRiservato = registroRiservato;
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
	 * @return the nodiRuoli
	 */
	public Collection<NodoUtenteRuolo> getNodiRuoli() {
		return nodiRuoli;
	}

	/**
	 * @param nodiRuoli the nodiRuoli to set
	 */
	public void setNodiRuoli(Collection<NodoUtenteRuolo> nodiRuoli) {
		this.nodiRuoli = nodiRuoli;
	}

}
