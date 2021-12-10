package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.paciente;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;

public interface PacienteService {
	PacienteDTO findById(Long id) throws ClientException;
}
