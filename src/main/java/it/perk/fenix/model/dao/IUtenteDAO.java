/**
 * 
 */
package it.perk.fenix.model.dao;

import java.util.List;

import it.perk.fenix.model.entity.Utente;

/**
 * @author Perk
 *
 */
public interface IUtenteDAO {
	
	Utente getByUsername(final String username);
	
	Utente findById(long id);

    List<Utente> findAll();

    void createEntity(Utente entity);

    Utente update(Utente entity);

    void delete(Utente entity);

    void deleteById(long entityId);

}
