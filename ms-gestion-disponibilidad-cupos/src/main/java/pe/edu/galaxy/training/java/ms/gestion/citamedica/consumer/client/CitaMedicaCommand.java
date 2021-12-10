package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer.client;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

public interface CitaMedicaCommand {
	void enviar(SolicitudCitaDTO solicitudCitaDTO);
}
