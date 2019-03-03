/**
 * 
 */
package it.perk.fenix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.perk.fenix.model.entity.Utente;

/**
 * @author Perk
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
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
}
