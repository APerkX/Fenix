/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Perk
 *
 */
public class PropDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2274554598129880029L;

	/**
	 * Time Stamp dell'ultimo Refresh.
	 */
	private String lastRefreshTime;
	/**
	 * Indirizzo locale macchina. 
	 */
	private String ipServer;
	
	/**
	 * Messagio info. 
	 */
	private String infoMsg;
	
	/**
	 * Parametri.
	 */
	private Map<String, String> parameters;

	/**
	 * @return the lastRefreshTime
	 */
	public String getLastRefreshTime() {
		return lastRefreshTime;
	}

	/**
	 * @param lastRefreshTime the lastRefreshTime to set
	 */
	public void setLastRefreshTime(String lastRefreshTime) {
		this.lastRefreshTime = lastRefreshTime;
	}

	/**
	 * @return the ipServer
	 */
	public String getIpServer() {
		return ipServer;
	}

	/**
	 * @param ipServer the ipServer to set
	 */
	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}

	/**
	 * @return the parameters
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the infoMsg
	 */
	public String getInfoMsg() {
		return infoMsg;
	}

	/**
	 * @param infoMsg the infoMsg to set
	 */
	public void setInfoMsg(String infoMsg) {
		this.infoMsg = infoMsg;
	}
	
	
}
