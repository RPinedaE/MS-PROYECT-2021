package pe.edu.galaxy.training.java.ms.gestion.citamedica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.OfertaPotencialSaludService;

@RestController
@RequestMapping("/oferta-potencial-salud")
public class OfertaSaludController {

	private OfertaPotencialSaludService ofertaPotencialSaludService;
	
	public OfertaSaludController(OfertaPotencialSaludService ofertaPotencialSaludService) {
		this.ofertaPotencialSaludService= ofertaPotencialSaludService;
	}

	@GetMapping
	public ResponseEntity<List<SolicitudCitaDTO>> getAll(){
		return ResponseEntity.ok(this.ofertaPotencialSaludService.findAll());
	}
}
