/**
 * 
 */
package it.perk.fenix.exception;

/**
 * @author Perk
 * 
 * Eccezione generica dell'applicativo.
 *
 */
public class FenixException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8146679582919220003L;

	/**
	 * Costruttore.
	 * 
	 * @param e	eccezione
	 */
	public FenixException(final Exception e) {
		super(e);
	}

	/**
	 * Costruttore.
	 * 
	 * @param msg	messaggio
	 */
	public FenixException(final String msg) {
		super(msg);
	}
	
	/**
	 * Costruttore.
	 * 
	 * @param msg	messaggio
	 * @param e		eccezione root
	 */
	public FenixException(final String msg, final Exception e) {
		super(msg, e);
	}
	
}
