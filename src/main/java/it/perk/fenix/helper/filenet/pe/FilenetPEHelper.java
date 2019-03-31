/**
 * 
 */
package it.perk.fenix.helper.filenet.pe;

import filenet.vw.api.VWSession;
import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.helper.filenet.common.AbstractFilenetHelper;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.provider.PropertiesProvider;

/**
 * Classe per la gestione del PE di Filenet.
 * 
 * @author Perk
 *
 */
public abstract class FilenetPEHelper extends AbstractFilenetHelper {
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(FilenetPEHelper.class.getName());
	
	/**
	 * Sessione PE.
	 */
	private VWSession session;
	
	/**
	 * Property provider.
	 */
	private PropertiesProvider pp;
	
	
	/**
	 * Costruttore.
	 * 
	 * @param dto	credenziali
	 */
	public FilenetPEHelper(final FilenetCredentialsDTO dto) {
		this(dto.getUserName(), dto.getPassword(), dto.getUri(), dto.getStanzaJAAS(), dto.getConnectionPoint());
	}
	
	/**
	 * Costruttore.
	 * 
	 * @param userName			username
	 * @param password			password
	 * @param urlPE				url PE
	 * @param stanzaJAAS		stanza JASS
	 * @param connectionPoint	connection point PE
	 */
	public FilenetPEHelper(final String userName, final String password, final String urlPE, final String stanzaJAAS, final String connectionPoint) {
		initUserContext(userName, password, urlPE, stanzaJAAS);
		session = connectToPE(userName, password, urlPE, connectionPoint);
		pp = PropertiesProvider.getIstance();
	}
	
	/**
	 * metodo per la chiusura della sessione 
	 */
	public void logoff() {
		session.logoff();
	}

	/**
	 * @return the session
	 */
	public VWSession getSession() {
		return session;
	}

	/**
	 * @return the pp
	 */
	public PropertiesProvider getPp() {
		return pp;
	}

	
}
