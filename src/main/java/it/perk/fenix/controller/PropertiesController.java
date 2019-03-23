/**
 * 
 */
package it.perk.fenix.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.perk.fenix.dto.PropDTO;
import it.perk.fenix.provider.PropertiesProvider;
import it.perk.fenix.service.facade.IPropertiesFacadeSRV;

/**
 * @author Perk
 * 
 *  Controller che permette la gestione delle Properties.
 *
 */
@RestController
@RequestMapping("/properties")
public class PropertiesController {
	
	/**
	 * SRV Properties.
	 */
	@Autowired
	private IPropertiesFacadeSRV propertiesSRV;

	@GetMapping(path = "/refresh") 
	public PropDTO refreshProperties(){
		PropertiesProvider pp = new PropertiesProvider();
		return pp.toJson();
	}
	
	@GetMapping(path = "/findAll") 
	public Map<String, String> findAll(){
		return propertiesSRV.getAll();
	}
	
}
