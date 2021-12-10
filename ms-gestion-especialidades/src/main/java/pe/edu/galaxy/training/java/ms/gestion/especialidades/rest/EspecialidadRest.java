package pe.edu.galaxy.training.java.ms.gestion.especialidades.rest;

import static pe.edu.galaxy.training.java.ms.gestion.especialidades.rest.commons.Constants.*;


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
import pe.edu.galaxy.training.java.ms.gestion.especialidades.dto.EspecialidadDTO;
import pe.edu.galaxy.training.java.ms.gestion.especialidades.service.EspecialidadService;
import pe.edu.galaxy.training.java.ms.gestion.especialidades.service.exception.ServiceException;

@Slf4j
@RestController
//@RequestMapping("/v1/especialidades")
@RequestMapping(API_ESPECIALIDADES)
public class EspecialidadRest {
	
	@Autowired
	private EspecialidadService especialidadService; 

	@GetMapping
	public ResponseEntity<?> findLike(@RequestParam(name = "nombre", defaultValue = "") String nombre){		
		try {
			return ResponseEntity.ok(especialidadService.findLike(null));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build(); //Tiene mucho detalle tecnico, cuidado!
		}
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(especialidadService.findById(EspecialidadDTO.builder().id(id).build()).get());
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated EspecialidadDTO especialidadDTO){
		
		return null;
	};
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated EspecialidadDTO especialidadDTO){
		
		return null;
	};
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		return null;
	};
}
