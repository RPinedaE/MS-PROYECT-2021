package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service;

import java.util.Date;
import java.util.Optional;

import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.dto.ProgramacionCupoDTO;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.dto.SolicitudCupoDTO;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.exception.ServiceException;

public interface ProgramacionCupoService extends GenericService<ProgramacionCupoDTO>{
	Optional<SolicitudCupoDTO> solicitaCupo(Date fecha, Long idEspecialidad, Long idMedico)  throws ServiceException;
}
