/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import filenet.vw.api.VWQueueQuery;
import it.perk.fenix.constants.Constants;
import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.enums.PropertiesNameEnum;
import it.perk.fenix.helper.filenet.pe.FilenetPEHelper;
import it.perk.fenix.helper.filenet.pe.FilenetPEQueryBuilder;
import it.perk.fenix.helper.filenet.pe.FilenetPEQueryBuilder.Proposition;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.provider.PropertiesProvider;

/**
 * Data Access Object che gestisce le Queue Filenet.
 * 
 * @author Perk
 *
 */
public class QueueFilenetDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5702263495648759301L;
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(QueueFilenetDAO.class.getName());
	
	
//	public QueueFilenetDAO(FilenetCredentialsDTO dto) {
//		super(dto);
//	}

	/**
	 * Metodo per effettuare una query sul PE e che restituisce i workflow di una determinata Coda Filenet.
	 * 
	 * @param wobNumber
	 * @param nomeQueue
	 * @param indexName
	 * @param idNodoDestinatario
	 * @param idUtenteDestinatari
	 * @param idClientAoo
	 * @param idsTipoAssegnazione
	 * @param flagRenderizzato
	 * @param registroRiservato
	 * @return VWQueueQuery
	 */
	public VWQueueQuery getWorkFlowsForQueueFilent(final String nomeQueue, final String indexName, final Long idNodoDestinatario, final List<Long> idUtenteDestinatari,
													final String idClientAoo, final List<Long> idsTipoAssegnazione, final Integer flagRenderizzato, final Boolean registroRiservato, final FilenetPEHelper fpeh) {
		
		FilenetPEQueryBuilder fqb = new FilenetPEQueryBuilder(fpeh.getSession(), nomeQueue);
		
		// IdNodoDestinatario
		fqb.and(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_NODO_DESTINATARIO_WF_METAKEY), idNodoDestinatario.intValue());
		
		// idUtentiDestinatari
		if (idUtenteDestinatari != null && !idUtenteDestinatari.isEmpty()) {
			if (idUtenteDestinatari.size() == 1) {
				fqb.and(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_UTENTE_DESTINATARIO_WF_METAKEY), idUtenteDestinatari.get(0).intValue());
			} else {
				List<Proposition> propositions = new ArrayList<>();
				for (Long idUtenteDestinatario : idUtenteDestinatari) {
					propositions.add(fqb.createProposition(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_UTENTE_DESTINATARIO_WF_METAKEY), idUtenteDestinatario.intValue()));
				}
				Proposition[] longPropositions = propositions.toArray(new Proposition[propositions.size()]);
				fqb.or(longPropositions);
			}
		}
		
		// IdClientAoo
		if (idClientAoo != null) {
			fqb.and(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_CLIENT_METAKEY), idClientAoo);
		}
		
		// IdsTipoAssegnazione
		if (idsTipoAssegnazione != null && !idsTipoAssegnazione.isEmpty()) {
			if (idsTipoAssegnazione.size() > 1) {
				Long[] idst = idsTipoAssegnazione.toArray(new Long[0]);
				fqb.in(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_TIPO_ASSEGNAZIONE_METAKEY), idst);
			} else {
				fqb.and(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.ID_TIPO_ASSEGNAZIONE_METAKEY), idsTipoAssegnazione.get(0).intValue());
			}
		}
		
		// IdsTipoAssegnazione
		if (flagRenderizzato != null) {
			fqb.and(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.FLAG_RENDERIZZATO_METAKEY), flagRenderizzato);
		}
		
		// IdsTipoAssegnazione
		if (registroRiservato != null) {
			fqb.and(PropertiesProvider.getIstance().getParameterByKey(PropertiesNameEnum.REGISTRO_RISERVATO_METAKEY), registroRiservato);
		}
		
		// IndexName
		if (indexName != null) {
			return fqb.createQuery(true, indexName);
		}
		
		// Create Query
		return fqb.createQuery(true);

	}
	
	
}
