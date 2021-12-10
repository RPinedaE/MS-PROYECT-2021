package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.planilla;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;

public interface PlanillaService{
	PersonalDTO getPersonalMedico(Long idMedico) throws ClientException;
}
