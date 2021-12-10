package pe.edu.galaxy.training.java.ms.gestion.especialidades.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.edu.galaxy.training.java.ms.gestion.especialidades.dto.EspecialidadDTO;
import pe.edu.galaxy.training.java.ms.gestion.especialidades.entity.EspecialidadEntity;
import pe.edu.galaxy.training.java.ms.gestion.especialidades.repository.EspecialidadRepository;
import pe.edu.galaxy.training.java.ms.gestion.especialidades.service.exception.ServiceException;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired
	private JsonMapper jsonMapper;
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public List<EspecialidadDTO> findLike(EspecialidadDTO especialidadDTO) throws ServiceException {
		try {
			
			//List<EspecialidadEntity> listaEspecialidadEntity = this.especialidadRepository.getAllActivos();
			
			return this.especialidadRepository.getAllActivos().stream().map(e -> this.getEspecialidadDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public Optional<EspecialidadDTO> findById(EspecialidadDTO especialidadDTO) throws ServiceException {
		try {
			Optional<EspecialidadEntity> especialidadEntity= this.especialidadRepository.findById(especialidadDTO.getId());
			if (especialidadEntity.isPresent()) {

				EspecialidadDTO espDTO =this.getEspecialidadDTO(especialidadEntity.get()); 
				return Optional.of(espDTO);
			}
			
		return Optional.empty();
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public EspecialidadDTO save(EspecialidadDTO especialidadDTO) throws ServiceException {

		return null;
	}

	
	// Mappers
	private EspecialidadDTO getEspecialidadDTO(EspecialidadEntity especialidadEntity) {
		return jsonMapper.convertValue(especialidadEntity, EspecialidadDTO.class);
	}

}
