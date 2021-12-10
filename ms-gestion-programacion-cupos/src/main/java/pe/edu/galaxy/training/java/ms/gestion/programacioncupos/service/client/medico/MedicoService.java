package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.medico;

import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.ClientException;

public interface MedicoService {
	MedicoDTO findById(Long id) throws ClientException;
}
