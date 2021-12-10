package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.repository.CitaMedicaRepository;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.exception.ServiceException;
import reactor.core.publisher.Mono;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{

	@Autowired
	private CitaMedicaRepository citaMedicaRepository;

	@Override
	public Mono<CitaMedica> save(CitaMedica citaMedica) throws ServiceException {
		try {
			  return this.citaMedicaRepository.save(citaMedica);

		} catch (Exception e) {
				throw new ServiceException(e);
		}
	}
}
