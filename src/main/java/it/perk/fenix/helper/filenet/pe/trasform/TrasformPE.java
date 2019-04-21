/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.trasform;

import java.util.ArrayList;
import java.util.Collection;

import filenet.vw.api.VWException;
import filenet.vw.api.VWQueueQuery;
import filenet.vw.api.VWRosterQuery;
import filenet.vw.api.VWWorkObject;
import it.perk.fenix.enums.TrasformerPEEnum;
import it.perk.fenix.exception.FenixException;
import it.perk.fenix.exception.FilenetException;
import it.perk.fenix.helper.filenet.pe.trasform.impl.TrasformerPE;
import it.perk.fenix.logger.FenixLogger;

/**
 * Classe per la trasformazione degli oggetti PE.
 * 
 * @author Perk
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class TrasformPE {

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(TrasformPE.class.getName());
	
	/**
	 * Costruttore.
	 */
	private TrasformPE() {
	}
	
	/**
	 * Metodo per la trasformazione dei risultato provenienti da una query sul PE.
	 * 
	 * @param <T>	tipologia degli oggetti trasformati
	 * @param query	query eseguita sul PE
	 * @param te	tipologia di trasformazione da adottare
	 * @return		collezione degli oggetti trasformati
	 */
	public static <T> Collection<T> transform(final VWQueueQuery query, final TrasformerPEEnum te) {
		TrasformerPE trasformer = TrasformerPEFactory.getInstance().getTrasformer(te);
		return trasformer.trasform(query);
	}
	
	/**
	 * Metodo per trasformazione di un WorkObject in un una entità.
	 * 
	 * @param <T>	tipologia degli oggetti trasformati
	 * @param wob	workobject da trasformare
	 * @param te	tipologia di trasformazione da eseguire
	 * @return		oggetto trasformato
	 */
	public static <T> T transform(final VWWorkObject wob, final TrasformerPEEnum te) {
		TrasformerPE trasformer = TrasformerPEFactory.getInstance().getTrasformer(te);
		try {
			return (T) trasformer.trasform(wob);
		} catch (Exception e) {
			LOGGER.error("Errore durante il recupero delle informazioni dal workflow. ", e);
			throw new FilenetException(e);
		}
	}
	
	/**
	 * Metodo per la trasformazione dei risultato provenienti da una query sul roster del PE.
	 * 
	 * @param <T>	tipologia degli oggetti trasformati
	 * @param query	query eseguita sul roster del PE
	 * @param te	tipologia di trasformazione da adottare
	 * @return		collezione degli oggetti trasformati
	 */
	public static <T> Collection<T> transform(final VWRosterQuery query, final TrasformerPEEnum te) {
		Collection<T> collection = null;
		if (query != null) {
			collection = new ArrayList<>();
			try {
				while (query.hasNext()) {
					VWWorkObject obj = (VWWorkObject) query.next();
					collection.add((T) transform(obj, te));
				}
			} catch (VWException e) {
				LOGGER.error("Errore durante il recupero delle informazioni dal worfkflow: " + e.getMessage(), e);
				throw new FenixException("Errore durante il recupero delle informazioni dal worfkflow. ", e);
			}
		}
		return collection;
	}
}
