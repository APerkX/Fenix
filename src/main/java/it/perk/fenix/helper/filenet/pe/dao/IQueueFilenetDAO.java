/**
 * 
 */
package it.perk.fenix.helper.filenet.pe.dao;

import java.io.Serializable;
import java.util.List;

import filenet.vw.api.VWQueueQuery;
import it.perk.fenix.helper.filenet.pe.FilenetPEHelper;

/**
 * @author Perk
 *
 */
public interface IQueueFilenetDAO extends Serializable {

	/**
	 * Metodo per effettuare una query sul PE e che restituisce i workflow di una determinata Coda Filenet.
	 * 
	 * @param nomeQueue
	 * @param indexName
	 * @param idNodoDestinatario
	 * @param idUtenteDestinatari
	 * @param idClientAoo
	 * @param idsTipoAssegnazione
	 * @param flagRenderizzato
	 * @param registroRiservato
	 * @param fpeh
	 * @return
	 */
	public VWQueueQuery getWorkFlowsForQueueFilent(final String nomeQueue, final String indexName, final Long idNodoDestinatario, final List<Long> idUtenteDestinatari,
			final String idClientAoo, final List<Long> idsTipoAssegnazione, final Integer flagRenderizzato, final Boolean registroRiservato, final FilenetPEHelper fpeh);

}
