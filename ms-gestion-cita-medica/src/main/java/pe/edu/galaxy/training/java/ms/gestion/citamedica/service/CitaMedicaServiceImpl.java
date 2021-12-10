package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.CitaMedicaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.entity.CitaMedicaEntity;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.repository.CitaMedicaRepository;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.especialidad.EspecialidadService;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.medico.MedicoService;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.paciente.PacienteService;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.exception.ServiceException;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{

	@Autowired
	private JsonMapper jsonMapper;
	
	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private EspecialidadService especialidadService;

	
	@Override
	public List<CitaMedicaDTO> findLike(CitaMedicaDTO citaMedicaDTO) throws ServiceException {
		try {
			
			//List<CitaMedicaEntity> listaCitaMedicaEntity = this.citaMedicaRepository.getAllActivos();
			
			return this.citaMedicaRepository.getAllActivos().stream().map(e -> this.getCitaMedicaDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public Optional<CitaMedicaDTO> findById(CitaMedicaDTO citaMedicaDTO) throws ServiceException {
		try {
				Optional<CitaMedicaEntity> citaMedicaEntity= this.citaMedicaRepository.findById(citaMedicaDTO.getId());
				if (citaMedicaEntity.isPresent()) {
	
					CitaMedicaDTO miCitaMedicaDTO =this.getCitaMedicaDTO(citaMedicaEntity.get());  
					
					if (!Objects.isNull(miCitaMedicaDTO)) {
						miCitaMedicaDTO.setPacienteDTO(pacienteService.findById(miCitaMedicaDTO.getIdPaciente()));
						miCitaMedicaDTO.setMedicoDTO(medicoService.findById(miCitaMedicaDTO.getIdMedico()));
						miCitaMedicaDTO.setEspecialidadDTO(especialidadService.findById(miCitaMedicaDTO.getIdEspecialidad()));												
					}
					
					return Optional.of(miCitaMedicaDTO);
				}
				
			return Optional.empty();
				
			} catch (Exception e) {
				throw new ServiceException(e);
			}
	}

	@Override
	public CitaMedicaDTO save(CitaMedicaDTO citaMedicaDTO) throws ServiceException {

		return null;
	}

	
	// Mappers
	private CitaMedicaDTO getCitaMedicaDTO(CitaMedicaEntity citaMedicaEntity) {
		return jsonMapper.convertValue(citaMedicaEntity, CitaMedicaDTO.class);
	}

}
