/**
 * 
 */
package it.perk.fenix.service.facade;

import java.io.Serializable;
import java.util.Collection;

import it.perk.fenix.dto.MasterDocumentRedDTO;
import it.perk.fenix.dto.UserForRequestDTO;
import it.perk.fenix.enums.DocumentQueueEnum;

/**
 * @author Perk
 *
 */
public interface IDocumentiMastersFacadeSRV extends Serializable {

	/**
	 * Metodo utilizzato per il recupero dei Documenti appartenenti a una coda di lavoro.
	 * 
	 * @param queue 	- Coda Richiesta
	 * @param utente 	- Utente richiedente
	 * @return Collection di DTO utilizzati per valorizzare il DTH
	 */
	Collection<MasterDocumentRedDTO> getDocumentForMaster(DocumentQueueEnum queue, UserForRequestDTO utente);
	
}
