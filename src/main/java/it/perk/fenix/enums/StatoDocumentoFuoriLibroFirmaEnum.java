/**
 * 
 */
package it.perk.fenix.enums;

import it.perk.fenix.constants.Constants;

/**
 * Enum per mostrare lo stato dei documenti non presenti nel libro firma.
 * 
 * @author Perk
 *
 */
public enum StatoDocumentoFuoriLibroFirmaEnum {

	/**
	 * Assegnazione interna.
	 */
	ASSEGNAZIONE_INTERNA(0),

	/**
	 * Competenza.
	 */
	COMPETENZA(1),

	/**
	 * Conoscenza.
	 */
	CONOSCENZA(2),

	/**
	 * Contributo.
	 */
	CONTRIBUTO(3),

	/**
	 * Rifiuto.
	 */
	RIFIUTO(4),

	/**
	 * Rifiuto firma.
	 */
	RIFIUTO_FIRMA(5),

	/**
	 * Rifiuto sigla.
	 */
	RIFIUTO_SIGLA(6),

	/**
	 * Rifiuto visto.
	 */
	RIFIUTO_VISTO(7),

	/**
	 * Spedizione elettronica.
	 */
	SPEDIZIONE_ELETTRONICA(8),

	/**
	 * Spedizione cartacea.
	 */
	SPEDIZIONE_CARTACEA(9),

	/**
	 * Spedizione mista.
	 */
	SPEDIZIONE_MISTA(10),

	/**
	 * Precensito.
	 */
	PRECENSITO(11),

	/**
	 * Precensito interno.
	 */
	PRECENSITO_INTERNO(12),

	/**
	 * Documento entrata chiuso senza risposta.
	 */
	CHIUSO_ATTI(64),

	/**
	 * Documento entrata o uscita chiuso con risposta.
	 */
	CHIUSO_RISPOSTA(128),

	/**
	 * Documento uscita chiuso senza risposta.
	 */
	CHIUSO_MOZIONE(1024);
	
	/**
	 * Valore associato.
	 */
	private Integer value;

	/**
	 * Costruttore.
	 * 
	 * @param inValue	valore
	 */
	StatoDocumentoFuoriLibroFirmaEnum(final Integer inValue) {
		value = inValue;
	}

	/**
	 * Getter valore.
	 * 
	 * @return	valore
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * Getter valore.
	 * 
	 * @return	valore
	 */
	public Long getLongValue() {
		return value.longValue();
	}

	/**
	 * Metodo per il recupero dell'enum a partire dal tipo assegnazione, categoria, formato e tipo spedizione del documento.
	 * 
	 * @param idTipoAssegnazione	tipo assegnazione documento
	 * @param idCategoriaDocumento	categoria documento
	 * @param idFormatoDocumento	formato documento
	 * @param tipoSpedizione		tipo spedizione documento
	 * @return						enum associata
	 */
	public static StatoDocumentoFuoriLibroFirmaEnum get(final Integer idTipoAssegnazione, final Integer idCategoriaDocumento,
			final Integer idFormatoDocumento, final TipoSpedizioneDocumentoEnum tipoSpedizione) {
		StatoDocumentoFuoriLibroFirmaEnum output = null;
		TipoAssegnazioneEnum tipoAssegnazione = TipoAssegnazioneEnum.get(idTipoAssegnazione);
		if (TipoAssegnazioneEnum.COMPETENZA.equals(tipoAssegnazione)) {
			if (idCategoriaDocumento != null && idCategoriaDocumento == Constants.Varie.CATEGORIA_ASSEGNAZIONE_INTERNA) {
				//assegnazione interna -> img precensito tooltip Documento assegnazione interna
				output = StatoDocumentoFuoriLibroFirmaEnum.ASSEGNAZIONE_INTERNA;
			} else {
				//competenza -> img competenza tooltip Competenza
				output = StatoDocumentoFuoriLibroFirmaEnum.COMPETENZA;
			}
		} else if (TipoAssegnazioneEnum.CONOSCENZA.equals(tipoAssegnazione)) {
			//conoscenza -> img conoscenza tooltip Conoscenza
			output = StatoDocumentoFuoriLibroFirmaEnum.CONOSCENZA;
		} else if (TipoAssegnazioneEnum.CONTRIBUTO.equals(tipoAssegnazione)) {
			//contributo -> img contributo tooltip Contributo
			output = StatoDocumentoFuoriLibroFirmaEnum.CONTRIBUTO;
		} else if (TipoAssegnazioneEnum.RIFIUTO_ASSEGNAZIONE.equals(tipoAssegnazione)) {
			//rifiuto-> img rifiuto tooltip Rifiuto assegnazione
			output = StatoDocumentoFuoriLibroFirmaEnum.RIFIUTO;
		} else if (TipoAssegnazioneEnum.RIFIUTO_FIRMA.equals(tipoAssegnazione)) {
			//rifiuto firma -> img rifiuto tooltip Rifiuto firma
			output = StatoDocumentoFuoriLibroFirmaEnum.RIFIUTO_FIRMA;
		} else if (TipoAssegnazioneEnum.RIFIUTO_SIGLA.equals(tipoAssegnazione)) {
			//rifiuto sigla -> img rifiuto tooltip Rifiuto sigla
			output = StatoDocumentoFuoriLibroFirmaEnum.RIFIUTO_SIGLA;
		} else if (TipoAssegnazioneEnum.RIFIUTO_VISTO.equals(tipoAssegnazione)) {
			//rifiuto visto -> img rifiuto tooltip Rifiuto visto
			output = StatoDocumentoFuoriLibroFirmaEnum.RIFIUTO_VISTO;
		} else if (TipoAssegnazioneEnum.SPEDIZIONE.equals(tipoAssegnazione)) {
			output = StatoDocumentoFuoriLibroFirmaEnum.SPEDIZIONE_ELETTRONICA;
			if (TipoSpedizioneDocumentoEnum.CARTACEO.equals(tipoSpedizione)) {
				output = StatoDocumentoFuoriLibroFirmaEnum.SPEDIZIONE_CARTACEA;
			} else if (TipoSpedizioneDocumentoEnum.MISTO.equals(tipoSpedizione)) {
				output = StatoDocumentoFuoriLibroFirmaEnum.SPEDIZIONE_MISTA;
			}
		} else if (TipoAssegnazioneEnum.FIRMATO_E_SPEDITO.equals(tipoAssegnazione)) {
			if (idFormatoDocumento != null && idFormatoDocumento == FormatoDocumentoEnum.PRECENSITO.getId().intValue()) {
				//precensito -> img precensito.png tooltip Precensito
				output = StatoDocumentoFuoriLibroFirmaEnum.PRECENSITO;
			} else if (idCategoriaDocumento != null && idCategoriaDocumento == Constants.Varie.CATEGORIA_ASSEGNAZIONE_INTERNA) {
				//precensito -> img precensito.png tooltip Documento assegnazione interna
				output = StatoDocumentoFuoriLibroFirmaEnum.PRECENSITO_INTERNO;
			} else {
				//compentenza -> img competenza.png tooltip Competenza
				output = StatoDocumentoFuoriLibroFirmaEnum.COMPETENZA;
			}
		}
		return output;
	}
	
}
