/**
 * 
 */
package it.perk.fenix.utils;

/**
 * Utility per la gestione delle stringe.
 * 
 * @author Perk
 *
 */
public final class StringUtils {
	
	/**
	 * Costruttore.
	 */
	private StringUtils() {
	}

	/**
	 * Metodo per il test di una stringa (true se la stringa è null o vuota). 
	 * 
	 * @param str	la stringa da testare
	 * @return	true se la stringa è null o vuota
	 */
	public static Boolean isNullOrEmpty(final String str) {
		return str == null || str.trim().length() == 0;
	}
	

}
