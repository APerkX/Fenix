/**
 * 
 */
package it.perk.fenix.helper.filenet.ce.trasform;

import java.util.HashMap;

import it.perk.fenix.enums.TrasformerCEEnum;
import it.perk.fenix.exception.NoTrasformerException;
import it.perk.fenix.helper.filenet.ce.trasform.impl.TrasformerCE;
import it.perk.fenix.helper.filenet.pe.trasform.impl.FromDocumentoToGenericDoc;

/**
 *  Factory per la gestione delle trasformazioni 
 *  dei documenti presenti nel CE.
 * 
 * @author Perk
 *
 */
@SuppressWarnings("rawtypes")
public class TrasformerCEFactory {
	
	/**
	 * Insieme dei trasformer.
	 */
	private static HashMap<TrasformerCEEnum, TrasformerCE> trasformers;
	
	/**
	 * Istanza della factory.
	 */
	private static TrasformerCEFactory instance = new TrasformerCEFactory();
	
	/**
	 * Costruttore.
	 */
	private TrasformerCEFactory() {
		trasformers = new HashMap<TrasformerCEEnum, TrasformerCE>();
		addTrasformer(new FromDocumentoToGenericDoc());
//		addTrasformer(new FromDocumentoToMasterTrasformer());
//		addTrasformer(new FromDocumentoToDetailTrasformer());
//		addTrasformer(new FromDocumentoToDetailRedTrasformer());
//		addTrasformer(new FromDocumentoToLightDetailRedTrasformer());
//		addTrasformer(new FromDocumentoToDocumentoFascicoloTrasformer());
//		addTrasformer(new FromDocumentoToFascicoloTrasformer());
//		addTrasformer(new FromDocumentoToMailDetailTrasformer());
//		addTrasformer(new FromDocumentoToAllegatoMailTrasformer());
//		addTrasformer(new FromDocumentoToMailMasterTrasformer());
//		addTrasformer(new FromDocumentoToMailMasterWithContentTrasformer());
//		addTrasformer(new ModificaIterTrasformer());
//		addTrasformer(new FromDocumentoToAllegatoDtoTransformer());
//		addTrasformer(new FromDocumentToFaldoneDtoTransformer());
//		addTrasformer(new FromDocumentoToAppletContent());
//		addTrasformer(new FromDocumentToFaldoneTreeDtoTransformer());
//		addTrasformer(new FromDocumentToRedVersionTransformer());
//		addTrasformer(new FromDocumentoToAllegatoContentMailTrasformer());
//		addTrasformer(new FromDocumentoToAllegatoDetailTrasformer());
	}

	/**
	 * Metodo per aggiungere un trasformer associato ad una specifica enum.
	 * 
	 * @param t	trasformer
	 */
	private static void addTrasformer(final TrasformerCE t) {
		trasformers.put(t.getEnumKey(), t);
	}

	/**
	 * Metodo per il recupero dell'istanza della factory.
	 * 
	 * @return	istanza della factory
	 */
	public static TrasformerCEFactory getInstance() {
		return instance;
	}

	/**
	 * Recupero di un trasformer a partire dall'enum che identifica una trasformazione.
	 * 
	 * @param te	identificatore trasformazione
	 * @return		trasformer
	 */
	public TrasformerCE getTrasformer(final TrasformerCEEnum te) {
		TrasformerCE tr = trasformers.get(te);
		if (tr == null) {
			throw new NoTrasformerException(te);
		}
		return tr;
	}

}
