package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.rest;

import static pe.edu.galaxy.training.java.ms.gestion.programacioncupos.rest.commons.Constants.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.dto.ProgramacionCupoDTO;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.dto.SolicitudCupoDTO;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.ProgramacionCupoService;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.exception.ServiceException;

@Slf4j
@RestController
//@RequestMapping("/v1/programacion_cupos")
@RequestMapping(API_PROGRAMACION_CUPOS)
public class ProgramacionCupoRest {
	
	@Autowired
	private ProgramacionCupoService programacionCupoService; 

	@GetMapping
	public ResponseEntity<?> findLike(@RequestParam(name = "nombre", defaultValue = "") String nombre){		
		try {
			return ResponseEntity.ok(programacionCupoService.findLike(null));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		try {
			
			Optional<ProgramacionCupoDTO> optProgramacionCupoDTO = programacionCupoService.findById(ProgramacionCupoDTO.builder().id(id).build());
			
			if(optProgramacionCupoDTO.isPresent()) {
				return ResponseEntity.ok(optProgramacionCupoDTO.get());
			}else {
				return ResponseEntity.noContent().build();
			}
			
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	
	@GetMapping("/solicita-cupo/{fecha}/{idEspecialidad}/{idMedico}")
	public ResponseEntity<?> solicitaCupo(@PathVariable("fecha") String fecha, @PathVariable("idEspecialidad") Long idEspecialidad, @PathVariable("idMedico") Long idMedico){
		try {
			log.info("-> solicitaCupo::: fecha: "+fecha+" / idEspecialidad: "+idEspecialidad+" / idMedico: "+idMedico);						
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    Date fechaSolicitada = new Date();
			try {
				fechaSolicitada = sdf.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Optional<SolicitudCupoDTO> cupoSolicitado = programacionCupoService.solicitaCupo(fechaSolicitada, idEspecialidad, idMedico);
			
			if(cupoSolicitado.isPresent()) {
				return ResponseEntity.ok(cupoSolicitado.get());
			}else {
				return ResponseEntity.noContent().build();
			}
			
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated ProgramacionCupoDTO programacionCupoDTO){
		
		return null;
	};
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated ProgramacionCupoDTO programacionCupoDTO){
		
		return null;
	};
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		return null;
	};
}
