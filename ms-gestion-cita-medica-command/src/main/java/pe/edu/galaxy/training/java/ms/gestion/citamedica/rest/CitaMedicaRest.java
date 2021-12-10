package pe.edu.galaxy.training.java.ms.gestion.citamedica.rest;

import static pe.edu.galaxy.training.java.ms.gestion.citamedica.rest.commons.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.CitaMedicaService;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.exception.ServiceException;

@Slf4j
@RestController
//@RequestMapping("/v1/cita-medica-command")
@RequestMapping(API_CITA_MEDICA_COMMAND)
public class CitaMedicaRest {
	
	@Autowired
	private CitaMedicaService citaMedicaService; 

	
	@PostMapping
	public ResponseEntity<?> send(@RequestBody CitaMedica citaMedica){
		try {
				return ResponseEntity.status(HttpStatus.CREATED).body(citaMedicaService.save(citaMedica));
			 
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
}
