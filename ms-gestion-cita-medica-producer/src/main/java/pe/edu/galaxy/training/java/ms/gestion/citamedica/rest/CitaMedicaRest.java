package pe.edu.galaxy.training.java.ms.gestion.citamedica.rest;

import static pe.edu.galaxy.training.java.ms.gestion.citamedica.rest.commons.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.producer.CitaMedicaProducer;

@Slf4j
@RestController
//@RequestMapping("/v1/cita-medica-producer")
@RequestMapping(API_CITA_MEDICA_PRODUCER)
public class CitaMedicaRest {
	
	@Autowired
	private CitaMedicaProducer citaMedicaProducer;

	@PostMapping
	public ResponseEntity<?> send(@RequestBody CitaMedica citaMedica){
		try {
			citaMedicaProducer.sendMessage(citaMedica);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	};
}
