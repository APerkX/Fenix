/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

/**
 * Data Transfer Object per i dati di connessione a Filenet.
 * 
 * @author Perk
 *
 */
public class FilenetCredentialsDTO implements Serializable {

	/**
	 * Serializzable.
	 */
	private static final long serialVersionUID = 7781804693011785238L;

	/**
	 * Connection point.
	 */
	private String connectionPoint;

	/**
	 * Identificativo client aoo.
	 */
	private String idClientAoo;

	/**
	 * Object store.
	 */
	private String objectStore;

	/**
	 * Password.
	 */
	private String password;

	/**
	 * Stanza jaas.
	 */
	private String stanzaJAAS;

	/**
	 * Uri.
	 */
	private String uri;

	/**
	 * Username.
	 */
	private String userName;

	/**
	 * Costruttore.
	 * 
	 * @param inUserName		username
	 * @param inPassword		password
	 * @param inUri				uri
	 * @param inStanzaJAAS		stanza jass
	 * @param inConnectionPoint	connection point
	 * @param inObjectStore		object store
	 * @param inIdClientAoo		identificativo client aoo
	 */
	public FilenetCredentialsDTO(final String inUserName, final String inPassword, final String inUri, final String inStanzaJAAS, 
			final String inConnectionPoint, final String inObjectStore, final String inIdClientAoo) {
		super();
		userName = inUserName;
		password = inPassword;
		uri = inUri;
		stanzaJAAS = inStanzaJAAS;
		connectionPoint = inConnectionPoint;
		objectStore = inObjectStore;
		idClientAoo = inIdClientAoo;
	}
	
	/**
	 * Getter.
	 * 
	 * @return	connection point
	 */
	public final String getConnectionPoint() {
		return connectionPoint;
	}

	/**
	 * Getter.
	 * 
	 * @return	identificativo client aoo
	 */
	public final String getIdClientAoo() {
		return idClientAoo;
	}

	/**
	 * Getter.
	 * 
	 * @return	object store
	 */
	public final String getObjectStore() {
		return objectStore;
	}

	/**
	 * Getter.
	 * 
	 * @return	password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * Getter.
	 * 
	 * @return	stanza jaas
	 */
	public final String getStanzaJAAS() {
		return stanzaJAAS;
	}

	/**
	 * Getter.
	 * 
	 * @return	uri
	 */
	public final String getUri() {
		return uri;
	}

	/**
	 * Getter.
	 * 
	 * @return	username
	 */
	public final String getUserName() {
		return userName;
	}
	
}
