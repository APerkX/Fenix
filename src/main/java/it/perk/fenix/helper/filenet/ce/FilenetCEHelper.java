/**
 * 
 */
package it.perk.fenix.helper.filenet.ce;

import com.filenet.api.core.Connection;
import com.filenet.api.core.ObjectStore;

import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.helper.filenet.common.AbstractFilenetHelper;
import it.perk.fenix.logger.FenixLogger;

/**
 * Classe per la gestione del CE di Filenet.
 * 
 * @author Perk
 *
 */
public class FilenetCEHelper extends AbstractFilenetHelper {

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(FilenetCEHelper.class.getName());
	
	/**
	 * ObjectStore FileNet.
	 */
	private ObjectStore os;

	/**
	 * Costruttore a partire dal DTO delle credenziali FileNet.
	 * @param dto - DTO delle credenziali FileNet
	 */
	public FilenetCEHelper(final FilenetCredentialsDTO dto) {
		this(dto.getUserName(), dto.getPassword(), dto.getUri(), dto.getStanzaJAAS(), dto.getObjectStore());
	}
	
	/**
	 * Costruttore a partire dalle credenziali FileNet.
	 * @param userName - Username per la connessione a FN.
	 * @param password - Pwd per la connessione a FN.
	 * @param urlCE - URL dell'infrastruttura CE di FileNet.
	 * @param stanzaJAAS - Stanza JAAS
	 * @param objectStore - Object store di FN.
	 */
	public FilenetCEHelper(final String userName, final String password, final String urlCE, final String stanzaJAAS, final String objectStore) {
		Connection con = initUserContext(userName, password, urlCE, stanzaJAAS);
		os = getObjectStore(objectStore, con);
	}

	/**
	 * @return the os
	 */
	public ObjectStore getOs() {
		return os;
	}
	
	
}
