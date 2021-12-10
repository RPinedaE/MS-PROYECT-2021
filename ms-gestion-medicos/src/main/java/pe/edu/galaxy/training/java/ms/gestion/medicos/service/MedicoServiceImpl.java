package pe.edu.galaxy.training.java.ms.gestion.medicos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.edu.galaxy.training.java.ms.gestion.medicos.dto.MedicoDTO;
import pe.edu.galaxy.training.java.ms.gestion.medicos.entity.MedicoEntity;
import pe.edu.galaxy.training.java.ms.gestion.medicos.repository.MedicoRepository;
import pe.edu.galaxy.training.java.ms.gestion.medicos.service.exception.ServiceException;

@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private JsonMapper jsonMapper;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public List<MedicoDTO> findLike(MedicoDTO medicoDTO) throws ServiceException {
		try {
			
			//List<MedicoEntity> listaMedicoEntity = this.medicoRepository.getAllActivos();
			
			return this.medicoRepository.getAllActivos().stream().map(e -> this.getMedicoDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public Optional<MedicoDTO> findById(MedicoDTO medicoDTO) throws ServiceException {
		try {
			Optional<MedicoEntity> medicoEntity= this.medicoRepository.findById(medicoDTO.getId());
			if (medicoEntity.isPresent()) {

				MedicoDTO espDTO =this.getMedicoDTO(medicoEntity.get()); 
				return Optional.of(espDTO);
			}
			
		return Optional.empty();
		
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public MedicoDTO save(MedicoDTO medicoDTO) throws ServiceException {

		return null;
	}

	
	// Mappers
	private MedicoDTO getMedicoDTO(MedicoEntity medicoEntity) {
		return jsonMapper.convertValue(medicoEntity, MedicoDTO.class);
	}

}
