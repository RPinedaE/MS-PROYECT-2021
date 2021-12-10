package pe.edu.galaxy.training.java.ms.gestion.citamedica.repository;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

public interface CitaMedicaRepositoryRedis {
	public void save(SolicitudCitaDTO solicitudCitaDTO);
}
