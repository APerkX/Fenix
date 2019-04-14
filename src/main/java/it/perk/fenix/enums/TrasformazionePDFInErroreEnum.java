/**
 * 
 */
package it.perk.fenix.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum per modellare i valori del metadato CE trasformazionePDFInErrore.
 * 
 * @author Perk
 *
 */
public enum TrasformazionePDFInErroreEnum {
	
	/**
	 * Errore nella trasformazione in PDF.
	 */
	KO_CONVERSIONE(1, "Errore nella trasformazione in PDF"),
	
	/**
	 * Servizio di conversione pdf non disponibile.
	 */
	KO_ADOBE(2, "Servizio di conversione pdf non disponibile"),
	
	/**
	 * Servizio di firma digitale non disponibile.
	 */
	KO_PKBOX(3, "Servizio di firma digitale non disponibile"),
	
	/**
	 * Servizio di protocollazione non disponibile.
	 */
	KO_PROTO(4, "Servizio di protocollazione non disponibile"),

	/**
	 * Errore nel completamento del processo di firma
	 */
	KO_GENERICO(5, "Errore nel completamento del processo di firma"),
	
	/**
	 * Servizio di conversione pdf non disponibile.
	 */
	WARN_ADOBE(12, "Servizio di conversione pdf non disponibile"),
	
	/**
	 * Servizio di firma digitale non disponibile.
	 */
	WARN_PKBOX(13, "Servizio di firma digitale non disponibile"),
	
	/**
	 * Servizio di protocollazione non disponibile.
	 */
	WARN_PROTO(14, "Servizio di protocollazione non disponibile"),

	/**
	 * Errore nel completamento del processo di firma
	 */
	WARN_GENERICO(15, "Errore nel completamento del processo di firma"),;
	

	/**
	 * Valore.
	 */
	private Integer value;
	
	/**
	 * Descrizione.
	 */
	private String description;
	
	/**
	 * Costruttore.
	 * 
	 * @param inValue		valore
	 * @param inDescription	descrizione
	 */
	TrasformazionePDFInErroreEnum(final Integer inValue, final String inDescription) {
		value = inValue;
		description = inDescription;
	}

	/**
	 * Getter.
	 * 
	 * @return	value
	 */
	public Integer getValue() {
		return value;
	}
	
	/**
	 * Getter.
	 * 
	 * @return	descrizione
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Metodo per il recupero di un enum a partire dal valore.
	 * 
	 * @param value	valore
	 * @return		enum
	 */
	public static TrasformazionePDFInErroreEnum get(final Integer value) {
		TrasformazionePDFInErroreEnum output = null;
		
		if(value != null) {
			return output;
		}
			
		for (TrasformazionePDFInErroreEnum q:TrasformazionePDFInErroreEnum.values()) {
			if (q.getValue().equals(value)) {
				output = q;
				break;
			}
		}
		
		return output;
	}
	
	public static List<Integer> getErrorCodes() {
		
		List<Integer> codes = new ArrayList<>();
		
		codes.add(KO_CONVERSIONE.getValue());
		codes.add(KO_ADOBE.getValue());
		codes.add(KO_PKBOX.getValue());
		codes.add(KO_PROTO.getValue());
		codes.add(KO_GENERICO.getValue());
		
		return codes;
		
	}

	public static List<Integer> getWarnCodes() {
		
		List<Integer> codes = new ArrayList<>();
		
		codes.add(WARN_ADOBE.getValue());
		codes.add(WARN_PKBOX.getValue());
		codes.add(WARN_PROTO.getValue());
		codes.add(WARN_GENERICO.getValue());
		
		return codes;
		
	}
	
	public static TrasformazionePDFInErroreEnum getRelativeKoCode(Integer val) {
		
		if(val.equals(WARN_ADOBE.value)) {
			return KO_ADOBE;
		}
		
		if(val.equals(WARN_GENERICO.value)) {
			return KO_GENERICO;
		}
		
		if(val.equals(WARN_PKBOX.value)) {
			return KO_PKBOX;
		}
		
		if(val.equals(WARN_PROTO.value)) {
			return KO_PROTO;
		}
		
		return get(val);
		
	}
}
