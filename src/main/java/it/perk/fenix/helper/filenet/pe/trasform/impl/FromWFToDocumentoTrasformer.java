/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.trasform.impl;

import java.util.Date;

import filenet.vw.api.VWException;
import filenet.vw.api.VWWorkObject;
import it.perk.fenix.constants.Constants;
import it.perk.fenix.dto.PEDocumentoDTO;
import it.perk.fenix.enums.ColoreNotaEnum;
import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.enums.TipoOperazioneLibroFirmaEnum;
import it.perk.fenix.enums.TrasformerPEEnum;
import it.perk.fenix.helper.filenet.pe.dao.impl.ResponsesFilenetDAO;
import it.perk.fenix.helper.filenet.pe.trasform.TrasformPE;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.provider.PropertiesProvider;
import it.perk.fenix.utils.DateUtils;

/**
 * @author Perk
 *
 */
public class FromWFToDocumentoTrasformer extends TrasformerPE<PEDocumentoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4178839160380492727L;
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(TrasformPE.class.getName());

	/**
	 * Costruttore
	 */
	public FromWFToDocumentoTrasformer() {
		super(TrasformerPEEnum.FROM_WF_TO_DOCUMENTO);
	}

	/**
	 * Trasform.
	 *
	 * @param object
	 *            the object
	 * @return the PE documento DTO
	 */
	@Override
	public PEDocumentoDTO trasform(VWWorkObject object) {
		
		String[] responses = ResponsesFilenetDAO.getResponses(object);
		String stepName = object.fetchStepElement().getStepName();
		PropertiesProvider pp = PropertiesProvider.getIstance();
		String fClass = (String) getMetadato(object, Constants.PEProperty.VW_CLASS);
		String dataCreazioneWF = DateUtils.dateToString((Date) getMetadato(object, Constants.PEProperty.IW_LAUNCHDATE), null);
		String subject = (String) getMetadato(object, Constants.PEProperty.F_SUBJECT);
		Boolean bFirmaFig = false;
		if ("RED_FirmaRagGenDelloStato".equalsIgnoreCase(fClass)) {
			Integer firmaDigRGS = (Integer) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.FIRMA_DIG_RGS_WF_METAKEY));
			if (firmaDigRGS != null && firmaDigRGS > 0) {
				bFirmaFig = true;
			}
		}

		Boolean urgente = false;
		Integer flagUrgente = (Integer) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.URGENTE_METAKEY));
		if (flagUrgente != null && flagUrgente == 1) {
			urgente = true;
		}
		
		Integer flagIterManuale = (Integer) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.FLAG_ITER_MANUALE_WF_METAKEY));
		Integer idFascicolo = (Integer) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.ID_FASCICOLO_WF_METAKEY));
		String motivazioneAssegnazione = (String) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.MOTIVAZIONE_ASSEGNAZIONE_WF_METAKEY));
	
		String [] metadatiName = object.getFieldNames();
		boolean isElencoLibroFirma = false;
		for (int i = 0; i < metadatiName.length; i++) {
			if (metadatiName[i].equals(pp.getParameterByKey(PropertiesNameEnum.ELENCO_LIBROFIRMA_METAKEY))) {
				isElencoLibroFirma = true;
				break;
			}
		}
	
		String idDocumento = getMetadato(object,pp.getParameterByKey(PropertiesNameEnum.ID_DOCUMENTO_WF_METAKEY)).toString();
		String wobNumber = null;
		String queueName = null;
		try {
			wobNumber = object.getWorkObjectNumber();
			queueName = object.getCurrentQueueName();
		} catch (VWException e) {
			LOGGER.error(" Errore nel recupero di wobNumber o Nome Coda ", e);
		}
		
		String[] elencoLibroFirma = null;
		if (isElencoLibroFirma) {
			elencoLibroFirma = (String[]) getMetadato(object,pp.getParameterByKey(PropertiesNameEnum.ELENCO_LIBROFIRMA_METAKEY));
		}
		Integer count = (Integer)  getMetadato(object,pp.getParameterByKey(PropertiesNameEnum.COUNT_METAKEY));
		Integer idUtenteDestinatario = (Integer) getMetadato(object,pp.getParameterByKey(PropertiesNameEnum.ID_UTENTE_DESTINATARIO_WF_METAKEY));
		Integer idNodoDestinatario = (Integer) getMetadato(object,pp.getParameterByKey(PropertiesNameEnum.ID_NODO_DESTINATARIO_WF_METAKEY));
		Integer tipoAssegnazioneId = (Integer) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.ID_TIPO_ASSEGNAZIONE_METAKEY));
		TipoOperazioneLibroFirmaEnum tolf = TipoOperazioneLibroFirmaEnum.get("" + tipoAssegnazioneId);
		String codaCorrente = (String) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.NOME_CODA_METAKEY));
		Integer flagRenderizzato = (Integer) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.FLAG_RENDERIZZATO_METAKEY));
		Boolean flagRenderizzatoBool = Boolean.FALSE;
		if (flagRenderizzato != null) {
			flagRenderizzatoBool = (flagRenderizzato.intValue() == 1);
		}
		Boolean firmaCopiaConforme = (Boolean) getMetadato(object, pp.getParameterByKey(PropertiesNameEnum.FIRMA_COPIA_CONFORME_METAKEY));
		String nota = (String) getMetadato(object, "F_Comment");

		return new PEDocumentoDTO(idDocumento, tolf, wobNumber, DocumentQueueEnum.get(queueName), idUtenteDestinatario, 
				idNodoDestinatario, bFirmaFig, motivazioneAssegnazione, responses, idFascicolo, codaCorrente, tipoAssegnazioneId, 
				flagIterManuale, subject, elencoLibroFirma, count, dataCreazioneWF, flagRenderizzatoBool, firmaCopiaConforme, urgente, stepName, ColoreNotaEnum.getNotaDTO(nota));


	}

}
