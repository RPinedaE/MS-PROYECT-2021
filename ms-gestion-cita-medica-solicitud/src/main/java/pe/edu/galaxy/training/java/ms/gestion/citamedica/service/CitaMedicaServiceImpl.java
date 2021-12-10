package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.repository.CitaMedicaRepository;

@Slf4j
@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{
	
	private CitaMedicaRepository citaMedicaRepository;
	
	public CitaMedicaServiceImpl(CitaMedicaRepository citaMedicaRepository) {
		this.citaMedicaRepository= citaMedicaRepository;
	}

	@Override
	public void actualizaEstadoSolicitud(Long idCita, String estSolicitud, String hraCita) {
		try {
			  this.citaMedicaRepository.actualizaEstadoSolicitud(idCita, estSolicitud, hraCita);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
	}

}
