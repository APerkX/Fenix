/**
 * 
 */
package it.perk.fenix.service;

import filenet.vw.api.VWQueueQuery;
import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.dto.UserForRequestDTO;
import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.service.facade.IDocumentiMastersFacadeSRV;

/**
 * @author Perk
 *
 */
public interface IDocumentiMastersSRV extends IDocumentiMastersFacadeSRV {
	
	/**
	 * resituisce una data coda cercando per DocumentTitle o dataScadenza
	 * 
	 * @param queue
	 * @param utente
	 * @param documentTitle
	 * @param dataScadenza
	 * @param connection
	 * @return
	 */
	VWQueueQuery getQueueFilenet(final DocumentQueueEnum queue, final UserForRequestDTO utente, FilenetCredentialsDTO fcDto);
	

}
