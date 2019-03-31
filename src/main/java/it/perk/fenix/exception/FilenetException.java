/**
 * 
 */
package it.perk.fenix.exception;

/**
 * Eccezione in fase di gestione Filenets.
 * 
 * @author Perk
 *
 */
public class FilenetException extends RuntimeException {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore.
	 * 
	 * @param e	eccezione
	 */
	public FilenetException(final Exception e) {
		super(e);
	}

	/**
	 * Costruttore.
	 * 
	 * @param msg	messaggio
	 */
	public FilenetException(final String msg) {
		super(msg);
	}
	
	/**
	 * Costruttore.
	 * 
	 * @param msg	messaggio
	 * @param e		eccezione root
	 */
	public FilenetException(final String msg, final Exception e) {
		super(msg, e);
	}
	
}
