package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.especialidad;

import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.ClientException;

public interface EspecialidadService {
	EspecialidadDTO findById(Long id) throws ClientException;
}
