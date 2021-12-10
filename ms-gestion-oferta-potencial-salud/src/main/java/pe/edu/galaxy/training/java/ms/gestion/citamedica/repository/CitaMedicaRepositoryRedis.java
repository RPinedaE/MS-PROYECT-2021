package pe.edu.galaxy.training.java.ms.gestion.citamedica.repository;

import java.util.List;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

public interface CitaMedicaRepositoryRedis {
	
	public List<SolicitudCitaDTO> findAll();
	public SolicitudCitaDTO findById(String id);
}
