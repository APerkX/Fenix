/**
 * 
 */
package it.perk.fenix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Perk
 * 
 * Eccezione generica per le risorse non trovate.
 * HTTP STATUS CODE: {@code 404 Not Found}.
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1623379911647562332L;
	
	/**
	 * Costruttore.
	 * 
	 * @param e	eccezione
	 */
	public ResourceNotFoundException(final Exception e) {
		super(e);
	}

	/**
	 * Costruttore.
	 * 
	 * @param msg	messaggio
	 */
	public ResourceNotFoundException(final String msg) {
		super(msg);
	}
	
	/**
	 * Costruttore.
	 * 
	 * @param msg	messaggio
	 * @param e		eccezione root
	 */
	public ResourceNotFoundException(final String msg, final Exception e) {
		super(msg, e);
	}
	

}
