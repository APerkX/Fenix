/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.dao.impl;

import java.io.Serializable;

import filenet.vw.api.VWException;
import filenet.vw.api.VWWorkObject;
import it.perk.fenix.exception.FilenetException;
import it.perk.fenix.logger.FenixLogger;

/**
 * Data Access Object che gestisce le Responses dei WorkFlow Filenet.
 * 
 * @author Perk
 *
 */
public class ResponsesFilenetDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428200641346380118L;
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(ResponsesFilenetDAO.class.getName());
	
	/**
	 * Recupera le response di un workflow.
	 * 
	 * @param obj	workflow
	 * @return		insieme delle response
	 */
	public static String[] getResponses(final VWWorkObject obj) {
		String[] output = null;
		try {
			if (obj != null && obj.fetchStepElement() != null) {
				output = obj.fetchStepElement().getStepResponses();
			}
			return output;
		} catch (VWException e) {
			LOGGER.error(e.getMessage());
			throw new FilenetException(e);
		}
	}

}
