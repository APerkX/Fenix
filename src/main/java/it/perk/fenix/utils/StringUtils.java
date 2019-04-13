/**
 * 
 */
package it.perk.fenix.utils;

import java.util.Iterator;

/**
 * Utility per la gestione delle stringe.
 * 
 * @author Perk
 *
 */
public final class StringUtils {
	
	/**
	 * MAX_COUNT_IN_CONDITON.
	 */
	private static final int MAX_COUNT_IN_CONDITON = 999;
	
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

	/**
	 * Crea la 'IN' condition per la query per più di 1000 elementi.
	 * 
	 * @param attribute - attributo da inserire in IN condition
	 * @param iterator			lista di oggetti
	 * @param flagStringify	flag che indica se gli oggetti devono essere inseriti tra apici 
	 * @return				flusso CSV
	 */
	public static String createInCondition(final String attribute, final Iterator iterator, final Boolean flagStringify) {
		StringBuilder buffer = new StringBuilder(attribute + " IN (");
		int count = 0;
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			String tmp = obj.toString();
			if (flagStringify != null && flagStringify) {
				tmp = stringify(obj);
			}
			buffer.append(tmp);
			buffer.append(",");
			count++;
			if (count == MAX_COUNT_IN_CONDITON && iterator.hasNext()) {
				String output = buffer.toString();
				if (output.endsWith(",")) {
					output = output.substring(0, output.length() - 1);
			    	output = output + ") OR " + createInCondition(attribute, iterator, flagStringify);
			    	buffer = new StringBuilder(output);
				}
				break;
			}
		}
	    String output = buffer.toString();
	    if (output.endsWith(",")) {
	    	output = output.substring(0, output.length() - 1);
	    	output = output + ") ";
	    }
	    return output;
	}
	
	/**
	 * Dato un oggetto lo trasforma in stringa ed inserisce il risultato tra apici.
	 * 	
	 * @param obj	oggetto
	 * @return		oggetto in forma di stringa
	 */
	private static String stringify(final Object obj) {
		return "'" + obj.toString() + "'";
	}

}
