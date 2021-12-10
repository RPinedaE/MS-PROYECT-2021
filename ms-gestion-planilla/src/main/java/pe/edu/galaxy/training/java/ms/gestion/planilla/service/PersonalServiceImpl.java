package pe.edu.galaxy.training.java.ms.gestion.planilla.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.edu.galaxy.training.java.ms.gestion.planilla.dto.PersonalDTO;
import pe.edu.galaxy.training.java.ms.gestion.planilla.entity.PersonalEntity;
import pe.edu.galaxy.training.java.ms.gestion.planilla.repository.PersonalRepository;
import pe.edu.galaxy.training.java.ms.gestion.planilla.service.exception.ServiceException;

@Service
public class PersonalServiceImpl implements PersonalService{

	@Autowired
	private JsonMapper jsonMapper;
	
	@Autowired
	private PersonalRepository personalRepository;
	
	@Override
	public List<PersonalDTO> findLike(PersonalDTO personalDTO) throws ServiceException {
		try {
			
			//List<PersonalEntity> listaPersonalEntity = this.personalRepository.getAllActivos();
			
			return this.personalRepository.getAllActivos().stream().map(e -> this.getPersonalDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public Optional<PersonalDTO> findById(PersonalDTO personalDTO) throws ServiceException {
		try {
			Optional<PersonalEntity> personalEntity= this.personalRepository.findById(personalDTO.getId());
			if (personalEntity.isPresent()) {

				PersonalDTO espDTO =this.getPersonalDTO(personalEntity.get()); 
				return Optional.of(espDTO);
			}
			
		return Optional.empty();
		
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public Optional<PersonalDTO> getPersonalMedico(PersonalDTO personalDTO) throws ServiceException {
		try {
			Optional<PersonalEntity> personalEntity= Optional.of(this.personalRepository.getPersonalMedico(personalDTO.getIdMedico()));
			if (personalEntity.isPresent()) {

				PersonalDTO espDTO =this.getPersonalDTO(personalEntity.get()); 
				return Optional.of(espDTO);
			}
			
		return Optional.empty();
		
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public PersonalDTO save(PersonalDTO personalDTO) throws ServiceException {

		return null;
	}

	
	// Mappers
	private PersonalDTO getPersonalDTO(PersonalEntity personalEntity) {
		return jsonMapper.convertValue(personalEntity, PersonalDTO.class);
	}

}
