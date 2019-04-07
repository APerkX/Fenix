/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entità che mappa la tabella AOO_FILENET.
 * 
 * @author Perk
 *
 */
@Entity
@Table(name = "Aoo_Filenet")
public class AooFilenet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3309367734439032895L;
	
	/**
	 * Pk AOO Filenet.
	 */	
	// TODO: verificare che questa sia effettivamente la Primarykey
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PK_AOO_FILENET")
	private Long idAooFilenet;

	/**
	 * Connection point.
	 */	
	@Column(name = "CONNECTION_POINT")
	private  String connectionPoint;

	/**
	 * Identificativo Client AOO.
	 */	
	@Column(name = "ID_CLIENT_AOO")
	private  String idClientAoo;

	/**
	 * Object store.
	 */	
	@Column(name = "OBJECT_STORE")
	private String objectStore;

	/**
	 * Password.
	 */	
	@Column(name = "PASSWORD")
	private String password;


	/**
	 * Stanza Jaas.
	 */	
	@Column(name = "STANZA_JAAS")
	private String stanzaJaas;

	/**
	 * Uri.
	 */	
	@Column(name = "URI")
	private String uri;

	/**
	 * Username.
	 */	
	@Column(name = "USERNAME")
	private String username;

	/**
	 * Aoo.
	 */	
	@OneToOne(mappedBy = "aooFilenet")
	private Aoo aoo;

	public AooFilenet() {
		super();
	}
	
	/**
	 * @return the idAooFilenet
	 */
	public Long getIdAooFilenet() {
		return idAooFilenet;
	}

	/**
	 * @param idAooFilenet the idAooFilenet to set
	 */
	public void setIdAooFilenet(Long idAooFilenet) {
		this.idAooFilenet = idAooFilenet;
	}

	/**
	 * @return the connectionPoint
	 */
	public String getConnectionPoint() {
		return connectionPoint;
	}

	/**
	 * @param connectionPoint the connectionPoint to set
	 */
	public void setConnectionPoint(String connectionPoint) {
		this.connectionPoint = connectionPoint;
	}

	/**
	 * @return the idClientAoo
	 */
	public String getIdClientAoo() {
		return idClientAoo;
	}

	/**
	 * @param idClientAoo the idClientAoo to set
	 */
	public void setIdClientAoo(String idClientAoo) {
		this.idClientAoo = idClientAoo;
	}

	/**
	 * @return the objectStore
	 */
	public String getObjectStore() {
		return objectStore;
	}

	/**
	 * @param objectStore the objectStore to set
	 */
	public void setObjectStore(String objectStore) {
		this.objectStore = objectStore;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the stanzaJaas
	 */
	public String getStanzaJaas() {
		return stanzaJaas;
	}

	/**
	 * @param stanzaJaas the stanzaJaas to set
	 */
	public void setStanzaJaas(String stanzaJaas) {
		this.stanzaJaas = stanzaJaas;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the aoo
	 */
	public Aoo getAoo() {
		return aoo;
	}

	/**
	 * @param aoo the aoo to set
	 */
	public void setAoo(Aoo aoo) {
		this.aoo = aoo;
	}
	
	
	
}
