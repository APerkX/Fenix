/**
 * 
 */
package it.perk.fenix.model.dao.impl;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import it.perk.fenix.dto.RuoloDTO;
import it.perk.fenix.dto.UfficiRuoliDTO;
import it.perk.fenix.dto.UfficioDTO;
import it.perk.fenix.dto.UtenteDTO;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.AbstractJpaDAO;
import it.perk.fenix.model.dao.IUtenteDAO;
import it.perk.fenix.model.entity.NodoUtenteRuolo;
import it.perk.fenix.model.entity.Utente;

/**
 * @author Perk
 *
 */
@Repository
public class UtenteDAO extends AbstractJpaDAO<Utente> implements IUtenteDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6267126845956203257L;

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(UtenteDAO.class.getName());
	
	/**
	 * Predefinito.
	 */
	private static final Long PREDEFINITO = 1L;
	
	
	@Override
	public UtenteDTO getByUsername(String username) {
		UtenteDTO output = new UtenteDTO();
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);
			
			Root<Utente> utente = cq.from(Utente.class);
			
			// viene fatto l'upper del username e confrontato con quello dato in input 
			Expression<String> upperUsername = cb.upper(utente.get("username"));
			Predicate userNamePredicate = cb.equal(upperUsername, username.toUpperCase());

			cq.where(userNamePredicate);
			
			TypedQuery<Utente> query = em.createQuery(cq);
			Utente u = query.getSingleResult();
			
			output = new UtenteDTO(u);
			
			if (!u.getNodiRuoli().isEmpty()) {
				for (NodoUtenteRuolo nur : u.getNodiRuoli()) {
					UfficioDTO uff = new UfficioDTO(nur.getNodo());
					RuoloDTO r = new RuoloDTO(nur.getRuolo());
					
					Boolean isPredifinito = PREDEFINITO.equals(nur.getPredefinito());
					
					UfficiRuoliDTO uffRuolo = new UfficiRuoliDTO(uff, r, isPredifinito);
					output.getUfficiRuoli().add(uffRuolo);
				}
				
			}
			
		} catch (Exception e) {
			LOGGER.error("Errore durante la ricerca dell'utente : " + username, e);
		}
		return output;
	}

	@Override
	public void createEntity(Utente entity) {

		try {
			if (entity != null) {
				create(entity);
			}
		} catch (EntityExistsException e) {
			LOGGER.warn("Attenzione Entità gia presente nella Tabella Utente", e);
		} catch (Exception e) {
			LOGGER.error("Errore durante l'inserimento utente Livello Dao : ", e);
		} 
		
	}
	
	
	
	

}
