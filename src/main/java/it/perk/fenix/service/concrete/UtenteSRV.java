/**
 * 
 */
package it.perk.fenix.service.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.perk.fenix.dto.FilenetCredentialsDTO;
import it.perk.fenix.dto.UtenteDTO;
import it.perk.fenix.exception.FenixException;
import it.perk.fenix.exception.ResourceNotFoundException;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.INodoDAO;
import it.perk.fenix.model.dao.IUtenteDAO;
import it.perk.fenix.model.entity.Aoo;
import it.perk.fenix.model.entity.AooFilenet;
import it.perk.fenix.model.entity.Nodo;
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
	
	@Autowired
	private INodoDAO nodoDao;
	
	@Override
	public UtenteDTO getByUsername(String username) {
		UtenteDTO utente = null;
		
		try {
			utente = utenteDao.getByUsername(username);
		} catch (ResourceNotFoundException e) {
			LOGGER.warn("L'utente richiesto non è censito dall'applicazione --> " + username, e);
			throw new FenixException("L'utente richiesto non è censito dall'applicativo", e);
		} catch (Exception e) {
			LOGGER.error("Errore durante la ricerca dell'utente : " + username , e);
			throw new FenixException("Errore durante la ricerca dell'utente : " + username, e);
		}
		
		return utente;
	}

	@Override
	public FilenetCredentialsDTO getFilenetCredential(Long idUfficio) {
		FilenetCredentialsDTO output = null;
		
		try {
			Nodo nodo = nodoDao.findById(idUfficio);
			Aoo aoo = nodo.getAoo();
			AooFilenet aooFn = aoo.getAooFilenet();
			output = new FilenetCredentialsDTO(aooFn.getUsername(), aooFn.getPassword(), aooFn.getUri(), aooFn.getStanzaJaas(), aooFn.getConnectionPoint(), aooFn.getObjectStore(), aooFn.getIdClientAoo());
		} catch (Exception e) {
			LOGGER.error("Errore durante il recupero delle credenziali Filenet partendo dall'idUfficio : " + idUfficio , e);
			throw new FenixException("Errore durante il recupero delle credenziali Filenet partendo dall'idUfficio : " + idUfficio , e);
		}
		
		return output;
	}

}
