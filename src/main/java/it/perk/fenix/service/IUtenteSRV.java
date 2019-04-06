/**
 * 
 */
package it.perk.fenix.service;

import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.service.facade.IUtenteFacadeSRV;

/**
 * @author Perk
 *
 */
public interface IUtenteSRV extends IUtenteFacadeSRV {

	/**
	 * Servizio che restituisce le credenziali per l'accesso a filenet.
	 * 
	 * @param idUfficio - id Ufficio dell'utente al momento della Request
	 * @return
	 */
	FilenetCredentialsDTO getFilenetCredential(final Long idUfficio);
}
