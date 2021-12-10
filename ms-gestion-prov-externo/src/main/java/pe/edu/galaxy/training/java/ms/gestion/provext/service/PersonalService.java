package pe.edu.galaxy.training.java.ms.gestion.provext.service;

import java.util.Optional;

import pe.edu.galaxy.training.java.ms.gestion.provext.dto.PersonalDTO;
import pe.edu.galaxy.training.java.ms.gestion.provext.service.exception.ServiceException;

public interface PersonalService extends GenericService<PersonalDTO>{
	Optional<PersonalDTO> getPersonalMedico(PersonalDTO personalDTO) throws ServiceException;
}
