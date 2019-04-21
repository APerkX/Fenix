/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.trasform.impl;

import java.sql.Connection;
import java.util.Collection;
import java.util.Date;

import com.filenet.api.core.Document;

import it.perk.fenix.constants.Constants;
import it.perk.fenix.dto.MasterDocumentRedDTO;
import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.enums.TipoSpedizioneDocumentoEnum;
import it.perk.fenix.enums.TrasformazionePDFInErroreEnum;
import it.perk.fenix.enums.TrasformerCEEnum;
import it.perk.fenix.helper.filenet.ce.trasform.impl.TrasformerCE;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.utils.StringUtils;

/**
 * Trasformer documento generic Doc.
 * 
 * @author Perk
 *
 */
public class FromDocumentoToGenericDoc extends TrasformerCE<MasterDocumentRedDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6560260717329968121L;
	
	/**
	 * Dimensione massima soggetto.
	 */
	private static final int MAX_ABSTRACT_SIZE = 100;
	
	/**
	 * Posizione tipo destinatari.
	 */
	private static final int TIPO_DEST_POSITION = 3;

//	@Autowired ??? funzionerà nel trasformer non essendo un Service
//	private ILookupDAO lookupDAO;
//	
//	private IContributoDAO contributoDAO;
//	
//	private ITipoProcedimentoDAO tipoPDAO;
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(FromDocumentoToGenericDoc.class.getName());

	public FromDocumentoToGenericDoc() {
		super(TrasformerCEEnum.FROM_DOCUMENTO_TO_GENERIC_DOC);
	}

	@Override
	public MasterDocumentRedDTO trasform(Document document, Connection connection) {
		
		try {
			String guuid = StringUtils.cleanGuidToString(document.get_Id());
			String classeDocumentale = StringUtils.cleanGuidToString(document.getClassName());
			String dt = (String) getMetadato(document, PropertiesNameEnum.DOCUMENT_TITLE_METAKEY);
			Integer numDoc = (Integer) getMetadato(document, PropertiesNameEnum.NUMERO_DOCUMENTO_METAKEY);
			String ogg = StringUtils.getTextAbstract((String) getMetadato(document, PropertiesNameEnum.OGGETTO_METAKEY), MAX_ABSTRACT_SIZE);
			Integer annoDoc = (Integer) getMetadato(document, PropertiesNameEnum.ANNO_DOCUMENTO_METAKEY);

			Date dataCreazione = (Date) getMetadato(document, PropertiesNameEnum.DATA_CREAZIONE_METAKEY);
			Date dataScadenza = (Date) getMetadato(document, PropertiesNameEnum.DATA_SCADENZA_METAKEY);
			Integer urgenza = (Integer) getMetadato(document, PropertiesNameEnum.URGENTE_METAKEY);
			Integer idCategoriaDocumento = (Integer) getMetadato(document, PropertiesNameEnum.IDCATEGORIADOCUMENTO_METAKEY); 
			Integer idFormatoDocumento = (Integer) getMetadato(document, PropertiesNameEnum.ID_FORMATO_DOCUMENTO); 
			Boolean flagFirmaAutografaRM = (Boolean) getMetadato(document, PropertiesNameEnum.FLAG_FIRMA_AUTOGRAFA_RM_METAKEY);
			
			//Pacchetto informazioni riguardanti il protocollo
			Integer numeroProtocollo = (Integer) getMetadato(document, PropertiesNameEnum.NUMERO_PROTOCOLLO_METAKEY);
			Integer annoProtocollo = (Integer) getMetadato(document, PropertiesNameEnum.ANNO_PROTOCOLLO_METAKEY);
			Integer tipoProtocollo = (Integer) getMetadato(document, PropertiesNameEnum.TIPO_PROTOCOLLO_METAKEY);
			Date dataProtocollazione = (Date) getMetadato(document, PropertiesNameEnum.DATA_PROTOCOLLO_METAKEY);
			
//			====================ATTRIBUTI CALCOLATI========================
			//Recupero della tipologia del documento
			Integer idTipologiaDocumento = (Integer) getMetadato(document, PropertiesNameEnum.TIPOLOGIA_DOCUMENTO_ID_METAKEY);
			String tipologiaDocumento = null;
//			if (idTipologiaDocumento != null) {
//				tipologiaDocumento = lookupDAO.getDescTipoDocumento(idTipologiaDocumento.longValue(), connection);
//			}
			
			//Calcolo presenza di Allegati
			Integer attachment = (Integer) document.get_CompoundDocumentState().getValue();
			Boolean bAttachmentPresent = attachment > 0;
			
			//Gestione del flag PDF in errore
			Integer trasfPdfErrore = (Integer) getMetadato(document, PropertiesNameEnum.TRASFORMAZIONE_PDF_ERRORE_METAKEY);
			Boolean bTrasfPdfErrore = false;
			Boolean bTrasfPdfWarning = false;
			if (trasfPdfErrore != null) {
				bTrasfPdfErrore = TrasformazionePDFInErroreEnum.getErrorCodes().contains(trasfPdfErrore);
				bTrasfPdfWarning = TrasformazionePDFInErroreEnum.getWarnCodes().contains(trasfPdfErrore);
			}
			
			//gestione del metadato firmaPDF
			Boolean flagFirmaPDF = (Boolean) getMetadato(document, PropertiesNameEnum.FIRMA_PDF_METAKEY);
			if(flagFirmaPDF == null){
				flagFirmaPDF = true;
			}
			
			//Gestione del Flag riservato
			Integer riservato = (Integer) getMetadato(document, PropertiesNameEnum.RISERVATO_METAKEY);
			Boolean flagRiservato = false;
			if (riservato != null && riservato > 0) {
				flagRiservato = true;
			}
			
			//Recupero del tipo procedimento
			Integer idTipoP = (Integer) getMetadato(document, PropertiesNameEnum.ID_TIPOLOGIA_APPROVAZIONE_FN_METAKEY);
			String tipoProcedimento = null;
//			if (idTipoP != null) {
//				tipoProcedimento = tipoPDAO.getTPbyId(connection, idTipoP).getDescrizione();
//			}
			
			//Recupero del numero dei contributi
			Long numContributi = null;
//			Long numContributi = contributoDAO.countContributi(dt, connection);
			
			//recupero del Tipo Spedizione
			Collection<String> inDestinatari = (Collection<String>) getMetadato(document, PropertiesNameEnum.DESTINATARI_DOCUMENTO_METAKEY);
			TipoSpedizioneDocumentoEnum tipoSpedizione = getTipoSpedizione(inDestinatari);
			
//			====================FINE========================
			
			return new MasterDocumentRedDTO(dt, numDoc, ogg, tipologiaDocumento, numeroProtocollo, annoProtocollo, bAttachmentPresent, bTrasfPdfErrore, bTrasfPdfWarning, 
					dataScadenza, urgenza, dataCreazione, idCategoriaDocumento, flagFirmaAutografaRM, tipoProtocollo, flagRiservato, 
					numContributi, flagFirmaPDF, tipoProcedimento, tipoSpedizione, annoDoc, guuid, idFormatoDocumento, dataProtocollazione, classeDocumentale);

		} catch (Exception e) {
			LOGGER.error("Errore nel recupero di un metadato durante la trasformazione da Document a MasterDocumentRedDTO : ", e);
			return null;
		}
		
	}
	
	private static TipoSpedizioneDocumentoEnum getTipoSpedizione(final Collection<String> inDestinatari) {
		TipoSpedizioneDocumentoEnum output;
		Boolean bElettronico = false;
		Boolean bCartaceo = false;
		Boolean bInterni =  false;
		if (inDestinatari != null) {
			for (String dest : inDestinatari) {
				Integer idTipoSpedizione;
				String[] destSplit = dest.split("\\,");
				String tipoDestinatario = destSplit[TIPO_DEST_POSITION];
				if (Constants.TipoDestinatario.ESTERNO.equalsIgnoreCase(tipoDestinatario)) {
					idTipoSpedizione = Integer.parseInt(destSplit[2]);
					if (Constants.TipoSpedizione.MEZZO_ELETTRONICO.equals(idTipoSpedizione)) {
						bElettronico = true;
					} else {
						bCartaceo = true;
					}
				} else {
					bInterni = true;
				}
				if (bElettronico && bCartaceo) {
					break;
				}
			}
		}
		if (bElettronico) {
			output = TipoSpedizioneDocumentoEnum.ELETTRONICO;
		} else {
			output = TipoSpedizioneDocumentoEnum.CARTACEO;
		}
		return output;
	}

}
