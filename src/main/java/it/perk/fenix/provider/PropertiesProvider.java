/**
 * 
 */
package it.perk.fenix.provider;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import it.perk.fenix.dto.PropDTO;
import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.service.facade.IPropertiesFacadeSRV;

/**
 * @author Perk
 * 
 * Oggetto per la gestione dei parametri 
 * (sono salvati su db e aggiornati ogni quanto di tempo).
 *
 */
public class PropertiesProvider implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6280865913888911425L;
	
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(PropertiesProvider.class.getName());
	
	/**
	 * Quanto di tempo in ms in fase di attesa di aggiornamento.
	 */
	private static final int WAITING_TIME = 100;
	
	/**
	 * SRV Properties.
	 */
	private IPropertiesFacadeSRV propertiesSRV;
	
	/**
	 * Istanza (singleton).
	 */
	private static PropertiesProvider provider;

	/**
	 * Parametri.
	 */
	private Map<String, String> parameters;
	
	/**
	 * Flag che indica la fase di aggiornamento in corso.
	 */
	private Boolean isUpdating;
	
	/**
	 * Data ultimo refresh.
	 */
	private Date lastRefreshTime;
	
	/**
	 * Costruttore.
	 */
	public PropertiesProvider() {
		propertiesSRV = (IPropertiesFacadeSRV) ApplicationContextProvider.getApplicationContext().getBean("propertiesSRV");
		refreshProperties();
	}
	
	/**
	 * Getter istanza singleton.
	 * 
	 * @return	istanza
	 */
	public static PropertiesProvider getIstance() {
		if (provider == null) {
			provider = new PropertiesProvider();
		}
		return provider;
	}

	/**
	 * Recupero parametro a partire dalla sua chiave.
	 * 
	 * @param inPar	chiave parametro
	 * @return		valore parametro
	 */
	public String getParameterByKey(final PropertiesNameEnum inPar) {
		waitUpdating();
		return parameters.get(inPar.getKey());
	}
	
	/**
	 * Recupero parametro.
	 * 
	 * @param inParString	chiave parametro
	 * @return		valore parametro
	 */
	public String getParameterByString(final String inParString) {
		waitUpdating();
		return parameters.get(inParString);
	}
	
	/**
	 * Metodo per attendere il termine dell'update.
	 */
	private void waitUpdating() {
		while (isUpdating) {
			try {
				Thread.sleep(WAITING_TIME);
			} catch (InterruptedException e) {
				LOGGER.info(e.getMessage());
				Thread.currentThread().interrupt();
			}
		}
	}

	/**
	 * Aggiornamento parametri.
	 */
	public void refreshProperties() {
		try {
			isUpdating = true;
			lastRefreshTime = new Date();
			LOGGER.info("PROPERTIES PROVIDER refreshProperties(): Caricamento dei parametri di configurazione dal DB in corso...");
			parameters = propertiesSRV.getAll();
			LOGGER.info("PROPERTIES PROVIDER refreshProperties(): Caricamento dei parametri di configurazione dal DB effettuato.");
			if (parameters != null && parameters.size() > 0) {
				LOGGER.info("PROPERTIES PROVIDER refreshProperties(): Caricate i seguenti parametri:");
				for (Entry<String, String> entry: parameters.entrySet()) {
					LOGGER.info("PROPERTIES PROVIDER refreshProperties(): " + entry.getKey() + "=" + entry.getValue());
				}
			} else {
				// warn
				LOGGER.info("PROPERTIES PROVIDER refreshProperties(): Attenzione: non risulta essere stato caricato nessun parametro!");
			}
		} catch (Exception e) {
			// error
			LOGGER.info("PROPERTIES PROVIDER refreshProperties(): Errore durante il refresh delle properties:" + e);
		} finally {
			isUpdating = false;
		}
	}
	
	/**
	 * 
	 * @return PropDTO 
	 */
	public PropDTO toJson() {
		waitUpdating();
		PropDTO output = new PropDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
		InetAddress localhost = null;
		try {
			localhost = InetAddress.getLocalHost();
			output.setIpServer(localhost.toString());
		} catch (UnknownHostException e) {
			// warn
			LOGGER.info("Errore nel recupero dell'indirizzo locale della macchina: ");
			output.setIpServer("Non è stato possibile recuperare l'indirizzo locale della macchina");
		}
		output.setLastRefreshTime(sdf.format(lastRefreshTime));
		
		if (parameters != null && parameters.size() > 0) {
			output.setInfoMsg("I PARAMETRI SONO STATI CARICATI CON SUCCESSO");
			output.setParameters(parameters);
		} else {
			output.setInfoMsg("NESSUN PARAMETRO CARICATO");
		}
		return output;
	}

}
