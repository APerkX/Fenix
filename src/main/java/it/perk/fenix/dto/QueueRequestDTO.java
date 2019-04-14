/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

import it.perk.fenix.enums.DocumentQueueEnum;

/**
 * Dto utilizzato per mappare le richieste delle Code di Lavoro.
 * 
 * @author Perk
 *
 */
public class QueueRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7207482553900976057L;
	
	/**
	 * Coda di lavoro Richiesta
	 */
	private DocumentQueueEnum queueEnum;
	
	/**
	 * Informazioni utente necessarie per le request. 
	 */
	private UserForRequestDTO utente;

	/**
	 * @return the queueEnum
	 */
	public DocumentQueueEnum getQueueEnum() {
		return queueEnum;
	}

	/**
	 * @return the utente
	 */
	public UserForRequestDTO getUtente() {
		return utente;
	}

	/**
	 * @param queueEnum the queueEnum to set
	 */
	public void setQueueEnum(DocumentQueueEnum queueEnum) {
		this.queueEnum = queueEnum;
	}

	/**
	 * @param utente the utente to set
	 */
	public void setUtente(UserForRequestDTO utente) {
		this.utente = utente;
	}

}
