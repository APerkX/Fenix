/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import it.perk.fenix.model.entity.Utente;

/**
 * @author Perk
 *
 */
public class UtenteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -552295844544021035L;
	
	/**
	 * idUtente.
	 */
	private Long idUtente;

	/**
	 * Username.
	 */
	private String username;

	/**
	 * Nome.
	 */
	private String nome;
	
	/**
	 * Cognome.
	 */
	private String cognome;
	
	/**
	 * Codice fiscale.
	 */
	private String codiceFiscale;

	/**
	 * Email.
	 */
	private String email;

	/**
	 * Registro riservato.
	 */
	private Long registroRiservato;
	
	/**
	 * Uffici e Ruoli dell'utente.
	 */
	private Collection<UfficiRuoliDTO> ufficiRuoli;
	
	
	public UtenteDTO() {
		ufficiRuoli = new ArrayList<>();
	}

	public UtenteDTO(final Utente u) {
		idUtente = u.getIdUtente();
		username = u.getUsername();
		nome = u.getNome();
		cognome = u.getCognome();
		codiceFiscale = u.getCodiceFiscale();
		email = u.getEmail();
		registroRiservato = u.getRegistroRiservato();
		ufficiRuoli = new ArrayList<>();
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
	 * @return the ufficiRuoli
	 */
	public Collection<UfficiRuoliDTO> getUfficiRuoli() {
		return ufficiRuoli;
	}

	/**
	 * @param ufficiRuoli the ufficiRuoli to set
	 */
	public void setUfficiRuoli(Collection<UfficiRuoliDTO> ufficiRuoli) {
		this.ufficiRuoli = ufficiRuoli;
	}

	
}
