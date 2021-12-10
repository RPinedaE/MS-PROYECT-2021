package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.cupos;

import java.util.Date;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;

public interface SolicitudCupoService {
	SolicitudCupoDTO solicitaCupo(Date fecha, Long idEspecialidad, Long idMedico) throws ClientException;
}
