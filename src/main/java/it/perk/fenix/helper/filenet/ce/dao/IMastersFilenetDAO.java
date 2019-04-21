/**
 * 
 */
package it.perk.fenix.helper.filenet.ce.dao;

import java.io.Serializable;
import java.util.Collection;

import com.filenet.api.collection.DocumentSet;

import it.perk.fenix.helper.filenet.ce.FilenetCEHelper;


/**
 * @author Perk
 *
 */
public interface IMastersFilenetDAO extends Serializable {
	
	/**
	 * Ricerca i Document FN per la visualizzazione del master.
	 * 
	 * @param documentClass - Document class dei documenti da ricercare
	 * @param documentTitles - Collection dei Document Title dei documenti da ricercare.
	 * 
	 * @return Document Set dei documenti ricercati.
	 */
	public DocumentSet getDocumentsForMasters(final String documentClass, final Collection<String> documentTitles, FilenetCEHelper fceh);

}
