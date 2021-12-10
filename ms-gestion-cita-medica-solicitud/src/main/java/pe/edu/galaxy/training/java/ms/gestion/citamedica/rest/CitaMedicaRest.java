package pe.edu.galaxy.training.java.ms.gestion.citamedica.rest;

import static pe.edu.galaxy.training.java.ms.gestion.citamedica.rest.commons.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.producer.CitaMedicaProducer;

@Slf4j
@RestController
//@RequestMapping("/v1/cita-medica-solicitud")
@RequestMapping(API_CITA_MEDICA_SOLICITUD)
public class CitaMedicaRest {
	
	@Autowired
	private CitaMedicaProducer citaMedicaProducer;

	@PostMapping
	public ResponseEntity<?> send(@RequestBody SolicitudCitaDTO solicitudCitaDTO){
		try {
			citaMedicaProducer.sendMessage(solicitudCitaDTO);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	};
}
