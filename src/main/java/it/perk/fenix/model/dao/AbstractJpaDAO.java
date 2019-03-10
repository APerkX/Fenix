/**
 * 
 */
package it.perk.fenix.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.common.base.Preconditions;

/**
 * 
 * @author Perk
 *
 * @param <T>
 */
public abstract class AbstractJpaDAO<T extends Serializable> {
	
	private Class<T> clazz;
	
	@PersistenceContext
	protected EntityManager em;
	
	public final void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
	}
	
	public T findById(final long id) {
		return em.find(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("FROM " + clazz.getName()).getResultList();
	}
	
	public void create(final T entity) {
		em.persist(entity);
	}
	
	public T update(final T entity) {
		return em.merge(entity);
	}
	
	public void delete(final T entity) {
		em.remove(entity);
	}
	
	public void deleteById(final long entityId) {
		final T entity = findById(entityId);
		delete(entity);
	}

}
