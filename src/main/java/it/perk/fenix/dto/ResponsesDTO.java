/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import it.perk.fenix.enums.ResponsesRedEnum;


/**
 * @author Perk
 *
 */
public class ResponsesDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5985823718410444859L;

	/**
	 * Collection contenente le response applicative e filenet che risultano essere gestite
	 */
	private Collection<ResponsesRedEnum> responsesEnum;
	
	/**
	 * responses che non risultano essere gestite ma che mostreremo a video come riscontro 
	 */
	private Collection<String> responseIssues;
	
	public ResponsesDTO() {
		super();
		responsesEnum = new ArrayList<>();
		responseIssues = new ArrayList<>();
	}

	/**
	 * @return the responsesEnum
	 */
	public final Collection<ResponsesRedEnum> getResponsesEnum() {
		return responsesEnum;
	}

	/**
	 * @param responsesEnum the responsesEnum to set
	 */
	public final void setResponsesEnum(Collection<ResponsesRedEnum> responsesEnum) {
		this.responsesEnum = responsesEnum;
	}

	/**
	 * @return the responseIssues
	 */
	public final Collection<String> getResponseIssues() {
		return responseIssues;
	}

	/**
	 * @param responseIssues the responseIssues to set
	 */
	public final void setResponseIssues(Collection<String> responseIssues) {
		this.responseIssues = responseIssues;
	}
	
	


}
