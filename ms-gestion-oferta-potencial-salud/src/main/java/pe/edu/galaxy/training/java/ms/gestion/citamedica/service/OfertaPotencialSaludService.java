package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import java.util.List;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

public interface OfertaPotencialSaludService {
	
	public List<SolicitudCitaDTO> findAll();
	public SolicitudCitaDTO findById(String id);
}
