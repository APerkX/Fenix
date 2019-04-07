/**
 * 
 */
package it.perk.fenix.model.dao.impl;

import org.springframework.stereotype.Repository;

import it.perk.fenix.exception.FenixException;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.AbstractJpaDAO;
import it.perk.fenix.model.dao.INodoDAO;
import it.perk.fenix.model.entity.Nodo;

/**
 * @author Perk
 *
 */
@Repository
public class NodoDAO extends AbstractJpaDAO<Nodo> implements INodoDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 457611254762513911L;

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(NodoDAO.class.getName());
	
	/**
	 * Cotruttore che definisce l'entità con cui si 
	 * andrà ad operare con i metodi generici.
	 * 
	 */
	public NodoDAO(){
	      setClazz(Nodo.class);
	}
	
	@Override
	public Nodo findById(Long idUfficio) {
		Nodo nodo = null;
		
		try {
			nodo = findById(idUfficio);
		} catch (Exception e) {
			LOGGER.error("Errore durante il recupero del Nodo con id : " + idUfficio, e);
			throw new FenixException("Errore durante il recupero del Nodo con id : " + idUfficio, e);
		}
		
		return nodo;
	}

}
