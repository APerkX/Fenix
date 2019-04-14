/**
 * 
 */
package it.perk.fenix.exception;

import it.perk.fenix.enums.TrasformerCEEnum;
import it.perk.fenix.enums.TrasformerPEEnum;

/**
 * Eccezione per l'assenza del trasformer.
 * 
 * @author Perk
 *
 */
public class NoTrasformerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3157305846290852546L;
	
	/**
	 * Costruttore.
	 * 
	 * @param enumKey	enum PE
	 */
	public NoTrasformerException(final TrasformerPEEnum enumKey) {
		super("Trasformer non trovato per la chiave: " + enumKey);
	}

	/**
	 * Costruttore.
	 * 
	 * @param enumKey enum CE
	 */
	public NoTrasformerException(final TrasformerCEEnum enumKey) {
		super("Trasformer non trovato per la chiave: " + enumKey);
	}

}
