/**
 * 
 */
package it.perk.fenix.helper.filenet.ce.trasform.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.core.Document;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.property.Property;

import filenet.vw.api.VWException;
import filenet.vw.api.VWWorkObject;
import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.enums.TrasformerCEEnum;
import it.perk.fenix.exception.FilenetException;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.provider.PropertiesProvider;

/**
 * Oggetto per la trasformazione di un documento presente nel CE.
 * 
 * @param <T> the generic type
 * 
 * @author Perk
 *
 */
public abstract class TrasformerCE<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1632026587241914333L;

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(TrasformerCE.class.getName());
	
	/**
	 * Denum che rappresenta la trasformazione CE.
	 */
	private TrasformerCEEnum enumKey;
	
	/**
	 * Costruttore.
	 * 
	 * @param inEnumKey	enum
	 */
	public TrasformerCE(final TrasformerCEEnum inEnumKey) {
		enumKey = inEnumKey;
	}

	/**
	 * Metodo per il recupero di un metadato sottoforma di oggetto.
	 * 
	 * @param document		documento sorgente
	 * @param propertyEnum	enum della proprietà da estrapolare
	 * @return				prorpietà sottoforma di oggetto
	 */
	public static final Object getMetadato(final Document document, final PropertiesNameEnum propertyEnum) {
		return getMetadato(document, PropertiesProvider.getIstance().getParameterByKey(propertyEnum));
	}
	
	/**
	 * Metodo per il recupero di un metadato sottoforma di oggetto.
	 * 
	 * @param document		documento sorgente
	 * @param prop			nome della proprietà da estrapolare
	 * @return				proprietà sottoforma di oggetto
	 */
	public static final Object getMetadato(final Document document, final String prop) {
		Object output = null;
		try {
			Property metadato = document.getProperties().get(prop);
			output = metadato.getObjectValue();
		} catch (EngineRuntimeException e) {
			LOGGER.info("[CE]" + e);
			LOGGER.info("[CE] PROPRIETA' '" + prop + "' NON TROVATA");
		}
		return output;
	}
	
	/**
	 * Metodo per il recupero di una proprietà di un oggetto sotto forma di stringa.
	 * 
	 * @param object		oggetto sorgente
	 * @param fieldName		nome del campo
	 * @return				stringa che rappresenta il campo
	 * @throws VWException	eccezione generata in fase di estrazione del valore
	 */
	protected final String getDataFieldValue(final VWWorkObject object, final String fieldName) throws VWException {
		return object.getDataField(fieldName).getStringValue();
	}
	
	/**
	 * Metodo per il recupero dell'enum caratteristica della trasformazione.
	 * 	
	 * @return	enum
	 */
	public final TrasformerCEEnum getEnumKey() {
		return enumKey;
	}
	
	/**
	 * Metodo per la trasformazione di un documento sorgente in un tipo destinazione.
	 * 
	 * @param document	documento sorgente
	 * @param connection - Connessione al DB
	 * @return			oggetto di destinazione
	 */
	public abstract T trasform(Document document, Connection connection);
	
	/**
	 * Metodo per la trasformazione di un insieme di documenti in una collezione di oggetti.
	 * 
	 * @param documentSet	insieme di documenti da trasformare
	 * @param connection - Connessione al DB
	 * @return				insieme di oggetti trasformati
	 */
	public final Collection<T> trasform(final DocumentSet documentSet, final Connection connection) {
		try {
			Collection<T> output = new ArrayList<>();
			Iterator it = documentSet.iterator();
			while (it.hasNext()) {
				Document document = (Document) it.next();
				output.add(trasform(document, connection));
			}
			return output;
		} catch (Exception e) {
			LOGGER.error("Errore durante il recupero delle informazioni del documento da FileNet (CE). ", e);
			throw new FilenetException(e);
		}
	}
	
	protected void setEnumKey(TrasformerCEEnum enumKey) {
		this.enumKey = enumKey;
	}
}
