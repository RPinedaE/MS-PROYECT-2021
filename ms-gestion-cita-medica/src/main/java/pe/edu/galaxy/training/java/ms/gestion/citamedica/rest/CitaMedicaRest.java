package pe.edu.galaxy.training.java.ms.gestion.citamedica.rest;

import static pe.edu.galaxy.training.java.ms.gestion.citamedica.rest.commons.Constants.*;

import java.util.Optional;

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
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.CitaMedicaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.CitaMedicaService;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.exception.ServiceException;

@Slf4j
@RestController
//@RequestMapping("/v1/cita_medica")
@RequestMapping(API_CITA_MEDICA)
public class CitaMedicaRest {
	
	@Autowired
	private CitaMedicaService citaMedicaService; 

	@GetMapping
	public ResponseEntity<?> findLike(@RequestParam(name = "nombre", defaultValue = "") String nombre){		
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
			
			Optional<CitaMedicaDTO> optCitaMedicaDTO = citaMedicaService.findById(CitaMedicaDTO.builder().id(id).build());
			
			if(optCitaMedicaDTO.isPresent()) {
				return ResponseEntity.ok(optCitaMedicaDTO.get());
			}else {
				return ResponseEntity.noContent().build();
			}
			
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated CitaMedicaDTO citaMedicaDTO){
		
		return null;
	};
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated CitaMedicaDTO citaMedicaDTO){
		
		return null;
	};
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		return null;
	};
}
