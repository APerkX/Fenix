/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

/**
 * DTO contenente le informazioni dell'utente necessarie per portare a termine una Request.
 * 
 * @author Perk
 *
 */
public class UserForRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5732720859144564860L;
	
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
	 * Uffici e Ruoli dell'utente.
	 */
	private UfficiRuoliDTO ufficioRuolo;
	
	public UserForRequestDTO() {
		/*
		 * metodo lasciato vuoto volutamente.
		 */
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
	 * @return the ufficioRuolo
	 */
	public UfficiRuoliDTO getUfficioRuolo() {
		return ufficioRuolo;
	}

	/**
	 * @param ufficioRuolo the ufficioRuolo to set
	 */
	public void setUfficioRuolo(UfficiRuoliDTO ufficioRuolo) {
		this.ufficioRuolo = ufficioRuolo;
	}
	
	

}
