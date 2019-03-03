/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Perk
 * 
 * Entità che mappa la tabella UTENTE
 *
 */
public class Utente implements Serializable{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -6546985888202380372L;

	/**
	 * Identificativo utente.
	 */
	private final Long idUtente;

	/**
	 * Username.
	 */
	private final String username;

	/**
	 * Nome.
	 */
	private final String nome;
	
	/**
	 * Cognome.
	 */
	private final String cognome;
	
	/**
	 * Codice fiscale.
	 */
	private final String codiceFiscale;

	/**
	 * Email.
	 */
	private final String email;

	/**
	 * Registro riservato.
	 */
	private final Long registroRiservato;
	
	/**
	 * Data attivazione.
	 */
	private final Date dataAttivazione;

	/**
	 * Data disattivazione.
	 */
	private final Date dataDisattivazione;
	
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @return the codiceFiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the registroRiservato
	 */
	public Long getRegistroRiservato() {
		return registroRiservato;
	}

	/**
	 * @return the dataAttivazione
	 */
	public Date getDataAttivazione() {
		return dataAttivazione;
	}

	/**
	 * @return the dataDisattivazione
	 */
	public Date getDataDisattivazione() {
		return dataDisattivazione;
	}

}
