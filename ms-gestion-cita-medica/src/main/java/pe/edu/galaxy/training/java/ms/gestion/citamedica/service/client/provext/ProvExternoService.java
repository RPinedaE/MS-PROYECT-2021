package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.provext;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.planilla.PersonalDTO;

public interface ProvExternoService{
	PersonalDTO getPersonalMedico(Long idMedico) throws ClientException;
}
