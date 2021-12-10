package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.dto.ProgramacionCupoDTO;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.dto.SolicitudCupoDTO;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.entity.ProgramacionCupoEntity;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.repository.ProgramacionCupoRepository;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.especialidad.EspecialidadService;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.medico.MedicoService;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.exception.ServiceException;

@Service
public class ProgramacionCupoServiceImpl implements ProgramacionCupoService{

	@Autowired
	private JsonMapper jsonMapper;
	
	@Autowired
	private ProgramacionCupoRepository programacionCupoRepository;
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@Autowired
	private MedicoService medicoService;
	
	@Override
	public List<ProgramacionCupoDTO> findLike(ProgramacionCupoDTO programacionCupoDTO) throws ServiceException {
		try {
			
			//List<ProgramacionCupoEntity> listaProgramacionCupoEntity = this.programacionCupoRepository.getAllActivos();
			
			return this.programacionCupoRepository.getAllActivos().stream().map(e -> this.getProgramacionCupoDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public Optional<ProgramacionCupoDTO> findById(ProgramacionCupoDTO programacionCupoDTO) throws ServiceException {
		try {
			Optional<ProgramacionCupoEntity> programacionCupoEntity= this.programacionCupoRepository.findById(programacionCupoDTO.getId());
				if (programacionCupoEntity.isPresent()) {
	
					ProgramacionCupoDTO progCupoDTO =this.getProgramacionCupoDTO(programacionCupoEntity.get()); 
					
					if (!Objects.isNull(progCupoDTO)) {
						progCupoDTO.setEspecialidadDTO(especialidadService.findById(progCupoDTO.getIdEspecialidad()));						
						progCupoDTO.setMedicoDTO(medicoService.findById(progCupoDTO.getIdMedico()));
					}
					
					return Optional.of(progCupoDTO);
				}
				
			return Optional.empty();
				
			} catch (Exception e) {
				throw new ServiceException(e);
			}
	}

	@Override
	public ProgramacionCupoDTO save(ProgramacionCupoDTO programacionCupoDTO) throws ServiceException {
		return null;
	}
	
	
	@Override
	public Optional<SolicitudCupoDTO> solicitaCupo(Date fecha, Long idEspecialidad, Long idMedico) throws ServiceException{
       try {
    	    SolicitudCupoDTO solCupoDTO= new SolicitudCupoDTO();
			List<ProgramacionCupoEntity> listaProgramacionCupoEntity = this.programacionCupoRepository.buscarProgramacionCupo(fecha, idEspecialidad, idMedico);
			
			if(listaProgramacionCupoEntity.isEmpty()) {
				solCupoDTO.setCodResultado("0");
				solCupoDTO.setDesResultado("No se encontró Programación disponible para el Médico en la Especialidad y Fecha solicitada.");
			}else{								
				ProgramacionCupoEntity progCupoEntity= listaProgramacionCupoEntity.get(0);
				
				if(progCupoEntity.getCupDisp()==0) { // Valida Cupos Dosponibles
					solCupoDTO.setCodResultado("0");
					solCupoDTO.setDesResultado("No se encontró Cupos disponibles para la Especialidad y Fecha solicitada.");
				}else {
					solCupoDTO.setIdEspecialidad(progCupoEntity.getIdEspecialidad());
					solCupoDTO.setIdMedico(progCupoEntity.getIdMedico()); 
					solCupoDTO.setFecha(progCupoEntity.getFecha());
					solCupoDTO.setHora("10:00");
					solCupoDTO.setCodResultado("1");
					solCupoDTO.setDesResultado("Cupo asignado para ser atendido por el Médico, Especialidad y Fecha solicitada.");
				}					
			}
			
			return Optional.of(solCupoDTO);
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}	
	}	
	
	
	// Mappers
	private ProgramacionCupoDTO getProgramacionCupoDTO(ProgramacionCupoEntity programacionCupoEntity) {
		return jsonMapper.convertValue(programacionCupoEntity, ProgramacionCupoDTO.class);
	}

}
