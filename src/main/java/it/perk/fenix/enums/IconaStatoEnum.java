/**
 * 
 */
package it.perk.fenix.enums;

/**
 * Icona stato.
 * 
 * @author Perk
 *
 */
public enum IconaStatoEnum {
	
	/**
	 * Icona visto.
	 */
	VISTO(1, "visto.png", "Visto", "Visto"),
	
	/**
	 * Icona firma.
	 */
	FIRMA(2, "firma.png", "Firma", "Firma"),
	
	/**
	 * Icona firma autografa su red.
	 */
	FIRMA_AUTOGRAFA_SU_RED(3, "no_firma.png", "Firma autografa su Red", "Firma autografa su Red"),
	
	/**
	 * Icona sigla.
	 */
	SIGLA(4, "sigla.png", "Sigla", "Sigla"),
	
	/**
	 * Icona documento assegnazione interna.
	 */
	DOCUMENTO_ASSEGNAZIONE_INTERNA(5, "precensito.png", "Documento assegnazione interna", "Documento assegnazione interna"),
	
	/**
	 * Icona competenza.
	 */
	COMPETENZA(6, "competenza.png", "Competenza", "Competenza"),
	
	/**
	 * Icona conoscenza.
	 */
	CONOSCENZA(7, "conoscenza.png", "Conoscenza", "Conoscenza"),
	
	/**
	 * Icona contributo.
	 */
	CONTRIBUTO(8, "contributo.png", "Contributo", "Contributo"),
	
	/**
	 * Icona rifiuto assegnazione.
	 */
	RIFIUTO_ASSEGNAZIONE(9, "rifiuto.png", "Rifiuto assegnazione", "Rifiuto assegnazione"),
	
	/**
	 * Icona sigla.
	 */
	RIFIUTO_SIGLA(10, "rifiuto.png", "Rifiuto sigla", "Rifiuto sigla"),
	
	/**
	 * Icona visto.
	 */
	RIFIUTO_VISTO(11, "rifiuto.png", "Rifiuto visto", "Rifiuto visto"),
	
	/**
	 * Icona firma.
	 */
	RIFIUTO_FIRMA(12, "rifiuto.png", "Rifiuto firma", "Rifiuto firma"),
	
	/**
	 * Icona spedizione elettronica.
	 */
	SPEDIZIONE_ELETTRONICA(13, "sent_elettronici.png", "Spedizione elettronica", "Spedizione elettronica"),
	
	/**
	 * Icona spedizione cartacea.
	 */
	SPEDIZIONE_CARTACEA(14, "sent.png", "Spedizione cartacea", "Spedizione cartacea"),
	
	/**
	 * Icona spedizione mista.
	 */
	SPEDIZIONE_MISTA(15, "sent_misti.png", "Spedizione mista", "Spedizione mista"),
	
	/**
	 * Icona precensito.
	 */
	PRECENSITO(16, "precensito.png", "Precensito", "Precensito"),
	
	/**
	 * Icona documento in entrata chiuso senza risposta.
	 */
	DOCUMENTO_IN_ENTRATA_CHIUSO_SENZA_RISPOSTA(17, "envelope-icon.png", "Documento in entrata chiuso messo agli atti", "Documento in entrata chiuso chiuso messo agli atti"),
	
	/**
	 * Icona documento in entrata o uscita chiuso con risposta.
	 */
	DOCUMENTO_IN_ENTRATA_O_USCITA_CHIUSO_CON_RISPOSTA(18, "envelope-icon.png", "Documento in entrata o uscita chiuso con risposta", 
			"Documento in entrata o uscita chiuso con risposta"),
	
	/**
	 * Icona documento in uscita chiuso senza risposta.
	 */
	DOCUMENTO_IN_USCITA_CHIUSO_SENZA_RISPOSTA(19, "envelope-icon.png", "Documento in uscita chiuso in mozione", "Documento in uscita chiuso in mozione"),
	
	/**
	 * Icona sigla con alt e title "Visto".
	 */
	SIGLA_TITLE_VISTO(20, "sigla.png", "Visto", "Visto"),
	
	/**
	 * Icona spedizione elettronica in errore.
	 */
	SPEDIZIONE_ELETTRONICA_ERRORE(21, "sent_elettronici_errore.png", "Spedizione elettronica", "Spedizione elettronica"),
	
	/**
	 * Icona spedizione mista in errore.
	 */
	SPEDIZIONE_MISTA_ERRORE(15, "sent_misti_errore.png", "Spedizione mista", "Spedizione mista"),
	
	/**
	 * Icona documento in attesa.
	 */
	DOCUMENTO_IN_ATTESA(100, "time.png", "Documento in attesa", "Documento in attesa"), 

	/**
	 * Icona doumento copia conforme.
	 */
	DOCUMENTO_IN_FIRMA_PER_COPIA_CONFORME(101, "copiaConforme.png", "Documento in firma per copia conforme", "Documento in firma per copia conforme"),
	
	/**
	 * Icona doumento copia conforme.
	 */
	COPIA_CONFORME(102, "copiaConforme.png", "Copia Conforme", "Copia Conforme");

	/**
	 * Valore.
	 */
	private Integer value;
	
	/**
	 * Nome file.
	 */
	private String filename;
	
	/**
	 * Testo alternativo.
	 */
	private String altText;
	
	/**
	 * Title.
	 */
	private String title;
	
	/**
	 * Costruttore.
	 * 
	 * @param inValue		valore
	 * @param inFilename	nome file
	 * @param inAltText		testo alternativo
	 * @param inTitle		title
	 */
	IconaStatoEnum(final Integer inValue, final String inFilename, final String inAltText, final String inTitle) {
		value = inValue;
		filename = inFilename;
		altText = inAltText;
		title = inTitle;
	}

	/**
	 * Getter.
	 * 
	 * @return	nome file
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Getter.
	 * 
	 * @return	testo alternativo
	 */
	public String getAltText() {
		return altText;
	}

	/**
	 * Getter.
	 * 
	 * @return	title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Getter valore.
	 * 
	 * @return	valore
	 */
	public Integer getValue() {
		return value;
	}
}
