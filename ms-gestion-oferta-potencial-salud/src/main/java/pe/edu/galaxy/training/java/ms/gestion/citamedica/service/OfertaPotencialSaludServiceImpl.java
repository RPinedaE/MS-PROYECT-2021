package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.repository.CitaMedicaRepositoryRedis;

@Service
public class OfertaPotencialSaludServiceImpl implements OfertaPotencialSaludService{

	private CitaMedicaRepositoryRedis citaMedicaRepositoryRedis;
	
	public OfertaPotencialSaludServiceImpl( CitaMedicaRepositoryRedis citaMedicaRepositoryRedis) {
		this.citaMedicaRepositoryRedis = citaMedicaRepositoryRedis;
	}

	@Override
	public List<SolicitudCitaDTO> findAll() {

		return citaMedicaRepositoryRedis.findAll();
	}

	@Override
	public SolicitudCitaDTO findById(String id) {

		return citaMedicaRepositoryRedis.findById(id);
	}
		
}
