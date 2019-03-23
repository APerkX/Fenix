/**
 * 
 */
package it.perk.fenix.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

import it.perk.fenix.model.dao.AbstractJpaDAO;
import it.perk.fenix.model.dao.IPropertiesDAO;
import it.perk.fenix.model.entity.Property;

/**
 * @author Perk
 *
 */
@Repository
public class PropertiesDAO extends AbstractJpaDAO<Property> implements IPropertiesDAO  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4023800281167515822L;
	
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(PropertiesDAO.class.getName());
	
	/**
	 * Cotruttore che definisce l'entità con cui si 
	 * andarà ad operare con i metodi generici.
	 * 
	 */
	public PropertiesDAO(){
	      setClazz(Property.class );
	}

	@Override
	public List<Property> getAll() {
		List<Property> output = new ArrayList<>();
		try {
			output = findAll();
		} catch (Exception e) {
			LOGGER.info("Errore durante il recupero delle properties dal DB " + e.getMessage());
		}
		return output;
	}

	@Override
	public String getByEnum(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
