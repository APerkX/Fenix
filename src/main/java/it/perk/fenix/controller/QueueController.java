/**
 * 
 */
package it.perk.fenix.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.perk.fenix.dto.MasterDocumentRedDTO;
import it.perk.fenix.dto.QueueRequestDTO;
import it.perk.fenix.enums.DocumentQueueEnum;
import it.perk.fenix.service.facade.IDocumentiMastersFacadeSRV;

/**
 * Controller per la gestione delle Code di Lavoro.
 * 
 * @author Perk
 *
 */
@RestController
@RequestMapping("/queues")
public class QueueController {
	
	@Autowired
	private IDocumentiMastersFacadeSRV docMastersSRV;

	@GetMapping("/masters")
	public Collection<MasterDocumentRedDTO> getQueue(@RequestBody QueueRequestDTO queueRequest) {
		Collection<MasterDocumentRedDTO> output = new ArrayList<>();
		
		try {
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Attenzione Bad Request");
		}
		
		return output;
	}
	
	@GetMapping("/enum/{id}")
	public DocumentQueueEnum getQueueEnum(@PathVariable("id") Integer idEnum) {
		DocumentQueueEnum output = null;

		try {
			output = DocumentQueueEnum.get(idEnum);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Attenzione Bad Request");
		}
		
		return output;
	}
	
}
