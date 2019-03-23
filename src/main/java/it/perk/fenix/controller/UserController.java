/**
 * 
 */
package it.perk.fenix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import it.perk.fenix.dto.UtenteDTO;
import it.perk.fenix.model.entity.Utente;
import it.perk.fenix.service.facade.IUtenteFacadeSRV;

/**
 * @author Perk
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUtenteFacadeSRV utenteSRV;
	
	@GetMapping(path = "/all") 
	public List<Utente> findAll(){
		List<Utente> utenti = new ArrayList<>();
		
		utenti.add(new Utente(1L, "Andrea", "Perquoti"));
		utenti.add(new Utente(2L, "Claudio", "Claudioni"));
		utenti.add(new Utente(3L, "David", "Copperfield"));
		utenti.add(new Utente(4L, "Mago", "Silvan"));
		utenti.add(new Utente(5L, "Mago", "Forest"));
		utenti.add(new Utente(6L, "Harry", "Houdini"));
		
		return utenti;
	}

	@GetMapping(path = "/user/{username}") 
	public UtenteDTO findUserForLogin(@PathVariable("username") String username){
		UtenteDTO utente = utenteSRV.getByUsername("biagio.mazzotta");
		return Preconditions.checkNotNull(utente);
	}
	
	
}
