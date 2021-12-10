package pe.edu.galaxy.training.java.ms.gestion.planilla.service;

import java.util.Optional;

import pe.edu.galaxy.training.java.ms.gestion.planilla.dto.PersonalDTO;
import pe.edu.galaxy.training.java.ms.gestion.planilla.service.exception.ServiceException;

public interface PersonalService extends GenericService<PersonalDTO>{
	Optional<PersonalDTO> getPersonalMedico(PersonalDTO personalDTO) throws ServiceException;
}
