/**
 * 
 */
package it.perk.fenix.service.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.perk.fenix.dto.UtenteDTO;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.IUtenteDAO;
import it.perk.fenix.service.IUtenteSRV;

/**
 * @author Perk
 *
 */
@Service
@Transactional
public class UtenteSRV implements IUtenteSRV {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4081291389384892944L;

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(UtenteSRV.class.getName());
	
	@Autowired
	private IUtenteDAO utenteDao;
	
	@Override
	public UtenteDTO getByUsername(String username) {
		UtenteDTO utente = null;
		
		try {
			utente = utenteDao.getByUsername(username);
		} catch (Exception e) {
			LOGGER.error("Errore durante la ricerca dell'utente : " + username , e);
		}
		
		return utente;
	}

}
