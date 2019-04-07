/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.trasform.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import filenet.vw.api.VWException;
import filenet.vw.api.VWQueueQuery;
import filenet.vw.api.VWWorkObject;
import it.perk.fenix.enums.TrasformerPEEnum;
import it.perk.fenix.exception.FilenetException;
import it.perk.fenix.logger.FenixLogger;

/**
 *	Oggetto generico per trasformazione di un elemento del PE.
 * 
 * @author Perk
 * @param <T> Tipo generico che rappresenta l'elemento destinazione della
 *            trasformazione (la sorgente sarà di tipo VWWorkObject).
 */
public abstract class TrasformerPE<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7278625575566250842L;
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(TrasformerPE.class.getName());
	
	/**
	 * Enum che identifica la trasformazione da eseguire.
	 */
	private TrasformerPEEnum enumKey;

	/**
	 * Costruttore.
	 * 
	 * @param inEnumKey	trasformazione da eseguire
	 */
	public TrasformerPE(final TrasformerPEEnum inEnumKey) {
		enumKey = inEnumKey;
	}

	/**
	 * Metodo per la trasformazione di un VWWorkObject in un oggetto target.
	 * 
	 * @param object	VWWorkObject da trasformare
	 * @return			oggetto trasformato
	 */
	public abstract T trasform(VWWorkObject object);
	
	/**
	 * Metodo per la trasformazione di un una collezione di VWWorkObject in una collezione di oggetti destinazione.
	 * 	
	 * @param query	VWQueueQuery che rappresenta l'insieme dei VWWorkObject da trasformare
	 * @return		l'insieme degli oggetti trasformati
	 */
	public final Collection<T> trasform(final VWQueueQuery query) {
		try {
			Collection<T> output = new ArrayList<>();
			while (query.hasNext()) {
				VWWorkObject wo = (VWWorkObject) query.next();
				output.add(trasform(wo));
			}
			return output;
		} catch (Exception e) {
			LOGGER.error("Errore durante la trasformazione del WF: ", e);
			throw new FilenetException(e);
		}
	}

	/**
	 * Metodo per recuperare da un VWWorkObject uno specifico campo sotto forma di stringa.
	 * 
	 * @param object		oggetto sorgente
	 * @param fieldName		campo
	 * @return				valore del campo nell'oggetto
	 * @throws VWException	eccezione generata in fase di estrazione del campo
	 */
	protected final String getDataFieldValue(final VWWorkObject object, final String fieldName) throws VWException {
		return object.getDataField(fieldName).getStringValue();
	}

	/**
	 * Metodo per recuperare da un VWWorkObject uno specifico campo sotto forma
	 * di oggetto.
	 *
	 * @param object
	 *            oggetto sorgente
	 * @param nomeMetadato
	 *            campo
	 * @return valore del campo nell'oggetto
	 */
	public static final Object getMetadato(final VWWorkObject object, final String nomeMetadato) {
		Object output = null;
		try {
			output = object.getFieldValue(nomeMetadato);
		} catch (VWException e) {
			LOGGER.warn("[PE] PROPRIETA' '" + nomeMetadato + "' NON TROVATA", e);
		}
		return output;
	}
	
	/**
	 * Getter.
	 * 
	 * @return	enum
	 */
	public final TrasformerPEEnum getEnumKey() {
		return enumKey;
	}

}
