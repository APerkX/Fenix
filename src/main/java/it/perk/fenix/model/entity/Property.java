/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author Perk
 *
 */
@Entity
@Table(name = "PROPERTIES")
public class Property implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2807354195633376155L;
	
	/**
	 * Chiave.
	 */
	@Id
	@Column(name = "KEY")
	private String key;

	/**
	 * Valore.
	 */
	@Column(name = "VALUE")
	private String value;
	
	/**
	 * Gruppo.
	 */
	@Column(name = "GRUPPO")
	private String gruppo;
	
	/**
	 * Blob.
	 */
	@Lob
	@Column(name = "BLOB_VALUE")
	private byte[] blobValue;
	
	public Property() {
		/**
		 * costruttore vuoto
		 */
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the gruppo
	 */
	public String getGruppo() {
		return gruppo;
	}

	/**
	 * @param gruppo the gruppo to set
	 */
	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	/**
	 * @return the blobValue
	 */
	public byte[] getBlobValue() {
		return blobValue;
	}

	/**
	 * @param blobValue the blobValue to set
	 */
	public void setBlobValue(byte[] blobValue) {
		this.blobValue = blobValue;
	}
	
	
	

}
