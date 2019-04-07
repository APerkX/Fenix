/**
 * 
 */
package it.perk.fenix.model.dao;

import java.io.Serializable;

import it.perk.fenix.model.entity.Nodo;

/**
 * @author Perk
 *
 */
public interface INodoDAO extends Serializable {

	Nodo findById(final Long idUfficio);
	
}
