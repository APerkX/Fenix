/**
 * 
 */
package it.perk.fenix.service.facade;

import java.io.Serializable;
import java.util.Map;

import it.perk.fenix.enums.PropertiesNameEnum;

/**
 * @author Perk
 * 
 *  Facade del servizio di gestione delle properties.
 *
 */
public interface IPropertiesFacadeSRV extends Serializable {
	
	/**
	 * Metodo per il recupero di tutte le properties.
	 * 
	 * @return	properties recuperate
	 */
	Map<String, String> getAll();
	
	/**
	 * Metodo per il recupero di una property.
	 * 
	 * @param param	enum della property
	 * @return		valore della property
	 */
	String getByEnum(PropertiesNameEnum param);

}
