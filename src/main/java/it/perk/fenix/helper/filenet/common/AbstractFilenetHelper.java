/**
 * 
 */
package it.perk.fenix.helper.filenet.common;

import javax.security.auth.Subject;

import com.filenet.api.constants.PropertyNames;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.FilterElement;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.util.UserContext;

import filenet.vw.api.VWSession;
import it.perk.fenix.exception.FilenetException;
import it.perk.fenix.logger.FenixLogger;

/**
 * Classe per la gestione della connessione a Filenet.
 * 
 * @author Perk
 *
 */
public abstract class AbstractFilenetHelper {
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(AbstractFilenetHelper.class.getName());

	
	/**
	 * Metodo per l'inizializzazione del contesto dell'utente.
	 * 
	 * @param userId		identificativo utente
	 * @param password		password utente
	 * @param uri			uri
	 * @param stanzaJAAS	stanza jaas
	 * @return				connessione a Filenet
	 */
	protected final Connection initUserContext(final String userId, final String password, final String uri, final String stanzaJAAS) {
		UserContext uc = UserContext.get();
		Connection con = Factory.Connection.getConnection(uri);
		Subject sub = UserContext.createSubject(con, userId, password, stanzaJAAS);
		uc.pushSubject(sub);
		return con;
	}
	
	/**
	 * Metodo per la connessione al PE.
	 * 
	 * @param userId			identificativo utente
	 * @param password			password
	 * @param uri				uri
	 * @param connectionPoint	connection point
	 * @return					sessione
	 */
	protected final VWSession connectToPE(final String userId, final String password, final String uri, final String connectionPoint) {
		try {
			VWSession pesession = new filenet.vw.api.VWSession();
			pesession.setBootstrapCEURI(uri);
			pesession.logon(userId, password, connectionPoint);
			return pesession;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new FilenetException(e);
		}
	}
	
	/**
	 * Metodo per il recupero dell'objectstore.
	 * 
	 * @param objectStore	nome object store
	 * @param con			connessione
	 * @return				object store
	 */
	protected final ObjectStore getObjectStore(final String objectStore, final Connection con) {
		PropertyFilter pf = new PropertyFilter();
		pf.addIncludeProperty(new FilterElement(0, null, Boolean.TRUE, PropertyNames.NAME, null));
		pf.addIncludeProperty(new FilterElement(0, null, Boolean.TRUE, PropertyNames.DOMAIN, null));
		Domain dom = Factory.Domain.fetchInstance(con, null, pf);
		ObjectStore os = Factory.ObjectStore.getInstance(dom, objectStore);
		os.fetchProperties(pf);
		return os;
	}
	
	
}
