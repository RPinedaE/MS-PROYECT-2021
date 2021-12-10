package pe.edu.galaxy.training.java.ms.gestion.pacientes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import pe.edu.galaxy.training.java.ms.gestion.pacientes.dto.PacienteDTO;
import pe.edu.galaxy.training.java.ms.gestion.pacientes.entity.PacienteEntity;
import pe.edu.galaxy.training.java.ms.gestion.pacientes.repository.PacienteRepository;
import pe.edu.galaxy.training.java.ms.gestion.pacientes.service.exception.ServiceException;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private JsonMapper jsonMapper;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public List<PacienteDTO> findLike(PacienteDTO pacienteDTO) throws ServiceException {
		try {
			
			//List<ProductoEntity> listaProductoEntity = this.productoRepository.getAllActivos();
			
			return this.pacienteRepository.getAllActivos().stream().map(e -> this.getPacienteDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public Optional<PacienteDTO> findById(PacienteDTO pacienteDTO) throws ServiceException {
		try {
			Optional<PacienteEntity> pacienteEntity= this.pacienteRepository.findById(pacienteDTO.getId());
			if (pacienteEntity.isPresent()) {
 
				PacienteDTO pacDTO =this.getPacienteDTO(pacienteEntity.get()); 
				return Optional.of(pacDTO);
			}
			
		return Optional.empty();
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public PacienteDTO save(PacienteDTO productoDTO) throws ServiceException {

		return null;
	}

	
	// Mappers
	private PacienteDTO getPacienteDTO(PacienteEntity pacienteEntity) {
		return jsonMapper.convertValue(pacienteEntity, PacienteDTO.class);
	}

}
