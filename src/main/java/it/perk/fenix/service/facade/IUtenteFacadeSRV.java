/**
 * 
 */
package it.perk.fenix.service.facade;

import java.io.Serializable;

import it.perk.fenix.dto.UtenteDTO;


/**
 * @author Perk
 *
 */
public interface IUtenteFacadeSRV extends Serializable {
	
	/**
	 * Recupero utente tramite username.
	 * 
	 * @param username	username utente
	 * @return			dati utente
	 */
	UtenteDTO getByUsername(String username);

}
