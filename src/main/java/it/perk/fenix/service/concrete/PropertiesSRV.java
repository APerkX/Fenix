/**
 * 
 */
package it.perk.fenix.service.concrete;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.model.dao.IPropertiesDAO;
import it.perk.fenix.model.entity.Property;
import it.perk.fenix.service.IPropertiesSRV;

/**
 * @author Perk
 *
 */
@Service
@Transactional
public class PropertiesSRV implements IPropertiesSRV {

	/**
	 * 
	 */
	private static final long serialVersionUID = -297291413285556658L;
	
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(PropertiesSRV.class.getName());
	
	/**
	 * Dao gestione properties.
	 */
	@Autowired
	private IPropertiesDAO propertiesDAO;


	@Override
	public Map<String, String> getAll() {
		Map<String, String> output = null;

		try {
			
			List<Property> result = propertiesDAO.getAll();
			
			if (result != null && !result.isEmpty()) {
				for (Property p : result) {
					output = new HashMap<>();
					output.put(p.getKey(), p.getValue());
				}
				
			}
			
		} catch (Exception e) {
			LOGGER.info("Errore durante il recupero delle properties dal DB " + e.getMessage());
		}
		
		return output;
	}

	@Override
	public String getByEnum(PropertiesNameEnum param) {
		// TODO Auto-generated method stub
		return null;
	}

}
