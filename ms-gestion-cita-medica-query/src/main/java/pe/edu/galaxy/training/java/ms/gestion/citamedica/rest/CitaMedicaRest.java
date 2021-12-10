package pe.edu.galaxy.training.java.ms.gestion.citamedica.rest;

import static pe.edu.galaxy.training.java.ms.gestion.citamedica.rest.commons.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.CitaMedicaService;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.exception.ServiceException;

@Slf4j
@RestController
//@RequestMapping("/v1/cita-medica-query")
@RequestMapping(API_CITA_MEDICA_QUERY)
public class CitaMedicaRest {
	
	@Autowired
	private CitaMedicaService citaMedicaService; 

	@GetMapping
	public ResponseEntity<?> findLike(@RequestParam(name = "fecha", defaultValue = "") String fecha){		
		try {
			
			  return ResponseEntity.ok(citaMedicaService.findLike(null));
			  
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		try {
				return ResponseEntity.ok(citaMedicaService.findById(CitaMedica.builder().idCita(id).build()));
			
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
}
