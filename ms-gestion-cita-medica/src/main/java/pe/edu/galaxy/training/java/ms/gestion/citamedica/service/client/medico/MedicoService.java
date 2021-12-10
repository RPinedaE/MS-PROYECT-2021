package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.medico;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;

public interface MedicoService {
	MedicoDTO findById(Long id) throws ClientException;
}
