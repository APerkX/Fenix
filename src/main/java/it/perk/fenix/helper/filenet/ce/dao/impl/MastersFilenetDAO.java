/**
 * 
 */
package it.perk.fenix.helper.filenet.ce.dao.impl;

import java.util.Collection;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.constants.PropertyNames;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;

import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.helper.filenet.ce.FilenetCEHelper;
import it.perk.fenix.helper.filenet.ce.dao.IMastersFilenetDAO;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.provider.PropertiesProvider;
import it.perk.fenix.utils.StringUtils;

/**
 * @author Perk
 *
 */
public class MastersFilenetDAO implements IMastersFilenetDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5858452792395639132L;
	
	/**
	 * Dimensione della massima dimensione della pagine di un content. 
	 */
	private static final int PAGE_SIZE = 1500;
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(MastersFilenetDAO.class.getName());

	@Override
	public DocumentSet getDocumentsForMasters(String documentClass, Collection<String> documentTitles, FilenetCEHelper fceh) {
		Boolean continuable = true;
		StringBuilder select = new StringBuilder();
		StringBuilder sql = new StringBuilder();
		
		select.append("d.").append(PropertyNames.ID).append(", ");
		select.append("d.").append(PropertyNames.DATE_CREATED).append(", ");
		select.append("d.").append(PropertyNames.COMPOUND_DOCUMENT_STATE).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DOCUMENT_TITLE_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.NUMERO_DOCUMENTO_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.OGGETTO_METAKEY)).append(", ");

		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.URGENTE_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.TIPOLOGIA_DOCUMENTO_ID_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.RISERVATO_METAKEY)).append(", ");
		
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ANNO_DOCUMENTO_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.NUMERO_PROTOCOLLO_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ANNO_PROTOCOLLO_METAKEY)).append(", ");

		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DATA_CREAZIONE_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DATA_PROTOCOLLO_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DATA_SCADENZA_METAKEY)).append(", ");

		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.FIRMA_PDF_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.TRASFORMAZIONE_PDF_ERRORE_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.FLAG_FIRMA_AUTOGRAFA_RM_METAKEY)).append(", ");
		
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.IDCATEGORIADOCUMENTO_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.TIPO_PROTOCOLLO_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_TIPOLOGIA_PROCEDIMENTO)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DESTINATARI_DOCUMENTO_METAKEY)).append(", ");
		select.append("d.").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_FORMATO_DOCUMENTO)).append(" ");

		sql.append("SELECT ").append(select).
			append("FROM ").append(documentClass).append(" d ").
			append("WHERE ").append("d.").append(PropertyNames.IS_CURRENT_VERSION).append(" = ").append("true ").
			append("AND ").append("(").append(StringUtils.createInCondition("d.DocumentTitle", documentTitles.iterator(), true)).append(") ").
			append("ORDER BY ").append(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.DATA_CREAZIONE_METAKEY)).append(" DESC");
		
		LOGGER.info(sql.toString());
		SearchSQL searchSQL = new SearchSQL(sql.toString());
		SearchScope scope = new SearchScope(fceh.getOs());
		return (DocumentSet) scope.fetchObjects(searchSQL, PAGE_SIZE, null, continuable);
	}

}
