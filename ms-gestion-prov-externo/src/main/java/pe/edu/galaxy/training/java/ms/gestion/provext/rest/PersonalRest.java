package pe.edu.galaxy.training.java.ms.gestion.provext.rest;

import static pe.edu.galaxy.training.java.ms.gestion.provext.rest.commons.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.provext.dto.PersonalDTO;
import pe.edu.galaxy.training.java.ms.gestion.provext.service.PersonalService;
import pe.edu.galaxy.training.java.ms.gestion.provext.service.exception.ServiceException;

@Slf4j
@RestController
//@RequestMapping("/v1/personal")
@RequestMapping(API_PROV_EXTERNO)
public class PersonalRest {
	
	@Autowired
	private PersonalService personalService; 

	@GetMapping
	public ResponseEntity<?> findLike(@RequestParam(name = "nombre", defaultValue = "") String nombre){		
		try {
			return ResponseEntity.ok(personalService.findLike(null));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build(); //Tiene mucho detalle tecnico, cuidado!
		}
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(personalService.findById(PersonalDTO.builder().id(id).build()).get());
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@GetMapping("/medico/{idMedico}")
	public ResponseEntity<?> findByIdMedico(@PathVariable("idMedico") Long idMedico){
		try {
			return ResponseEntity.ok(personalService.getPersonalMedico(PersonalDTO.builder().idMedico(idMedico).build()).get());
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated PersonalDTO personalDTO){
		
		return null;
	};
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated PersonalDTO personalDTO){
		
		return null;
	};
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		return null;
	};
}
