/**
 * 
 */
package it.perk.fenix.model.dao.impl;

import java.util.logging.Logger;

import javax.persistence.EntityExistsException;

import org.springframework.stereotype.Repository;

import it.perk.fenix.model.dao.AbstractJpaDAO;
import it.perk.fenix.model.dao.IUtenteDAO;
import it.perk.fenix.model.entity.Utente;

/**
 * @author Perk
 *
 */
@Repository
public class UtenteDAO extends AbstractJpaDAO<Utente> implements IUtenteDAO {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(UtenteDAO.class.getName());
	
	@Override
	public Utente getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEntity(Utente entity) {

		try {
			if (entity != null) {
				create(entity);
			}
		} catch (EntityExistsException e) {
			LOGGER.warning("Attenzione Entità gia presente nella Tabella Utente" + e.getMessage());
		} catch (Exception e) {
			LOGGER.info("Errore durante l'inserimento utente Livello Dao : " + e.getMessage());
		} 
		
	}

}
