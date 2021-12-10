package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

public interface DisponibilidadCuposService {
	SolicitudCitaDTO validaCupoDisponible(SolicitudCitaDTO solicitudCitaDTO);
}
