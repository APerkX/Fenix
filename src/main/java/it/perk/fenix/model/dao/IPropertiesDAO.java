/**
 * 
 */
package it.perk.fenix.model.dao;

import java.io.Serializable;
import java.util.List;

import it.perk.fenix.model.entity.Property;


/**
 * @author Perk
 * 
 *  Interfaccia del DAO per la gestione delle properties.
 *
 */
public interface IPropertiesDAO extends Serializable {

	/**
	 * Metodo per il recupero di tutte properties.
	 * 
	 * @param connection	connessione al db
	 * @return				collezione di properties recuperate
	 */
	List<Property> getAll();

	/**
	 * Recupero di una property da db.
	 * 
	 * @param key			chiave della property
	 * @param connection	connessione al db
	 * @return				valore della property
	 */
	String getByEnum(String key);

}
