package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.especialidad;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;

public interface EspecialidadService {
	EspecialidadDTO findById(Long id) throws ClientException;
}
