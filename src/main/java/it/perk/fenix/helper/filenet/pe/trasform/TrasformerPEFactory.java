/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.trasform;

import java.util.HashMap;
import java.util.Map;

import it.perk.fenix.enums.TrasformerPEEnum;
import it.perk.fenix.exception.NoTrasformerException;
import it.perk.fenix.helper.filenet.pe.trasform.impl.FromWFToDocumentoTrasformer;
import it.perk.fenix.helper.filenet.pe.trasform.impl.TrasformerPE;

/**
 * Factory delle trasformazioni PE.
 * 
 * @author Perk
 *
 */
@SuppressWarnings("rawtypes")
public class TrasformerPEFactory {
	
	/**
	 * Trasformatori.
	 */
	private static Map<TrasformerPEEnum, TrasformerPE> trasformers;
	
	/**
	 * Singleton.
	 */
	private static TrasformerPEFactory instance = new TrasformerPEFactory();
	
	/**
	 * Costruttore.
	 */
	private TrasformerPEFactory() {
		trasformers = new HashMap<>();
		addTrasformer(new FromWFToDocumentoTrasformer());
//		addTrasformer(new ModificaIterTrasformer());
	}

	/**
	 * Metodo per aggiungere una trasformazione.
	 * 
	 * @param t	trasformatore
	 */
	private static void addTrasformer(final TrasformerPE t) {
		trasformers.put(t.getEnumKey(), t);
	}

	/**
	 * Recupero istanza singleton.
	 * 
	 * @return	istanza
	 */
	public static TrasformerPEFactory getInstance() {
		return instance;
	}

	/**
	 * Metodo per il recupero di un trasformatore.
	 * 
	 * @param te	enum caratteristica trasformatore
	 * @return		trasformatore
	 */
	public TrasformerPE getTrasformer(final TrasformerPEEnum te) {
		TrasformerPE tr = trasformers.get(te);
		if (tr == null) {
			throw new NoTrasformerException(te);
		}
		return tr;
	}

}
