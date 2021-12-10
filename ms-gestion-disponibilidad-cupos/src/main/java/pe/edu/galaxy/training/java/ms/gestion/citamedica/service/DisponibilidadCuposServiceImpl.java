package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.EstadoCitaEnum;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.repository.CitaMedicaRepositoryRedis;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.cupos.SolicitudCupoDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.cupos.SolicitudCupoService;

@Slf4j
@Service
public class DisponibilidadCuposServiceImpl implements DisponibilidadCuposService{

	private SolicitudCupoService solicitudCupoService;
	private CitaMedicaRepositoryRedis citaMedicaRepositoryRedis;
	
	public DisponibilidadCuposServiceImpl(SolicitudCupoService solicitudCupoService, CitaMedicaRepositoryRedis citaMedicaRepositoryRedis) {
		this.solicitudCupoService= solicitudCupoService;
		this.citaMedicaRepositoryRedis = citaMedicaRepositoryRedis;
	}
		
	@Override
	public SolicitudCitaDTO validaCupoDisponible(SolicitudCitaDTO solicitudCitaDTO) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaSolicitada = new Date();

		try {
			fechaSolicitada = sdf.parse(solicitudCitaDTO.getFechaCita());
			SolicitudCupoDTO solicitudCupoDTO = solicitudCupoService.solicitaCupo(fechaSolicitada, solicitudCitaDTO.getEspecialidadId().longValue(), solicitudCitaDTO.getMedicoId().longValue());
			
			if(solicitudCupoDTO.getCodResultado().equals("0")) {
				log.info("*Resultado: "+solicitudCupoDTO.getDesResultado()); 
				solicitudCitaDTO.setEstado(EstadoCitaEnum.RECHAZADA);
				
				log.info("*Resguardando información en REDIS...");
				citaMedicaRepositoryRedis.save(solicitudCitaDTO);
				
			}else {
				log.info("*Resultado: "+solicitudCupoDTO.getDesResultado()); 
				solicitudCitaDTO.setEstado(EstadoCitaEnum.APROBADA);
				solicitudCitaDTO.setHoraCita(solicitudCupoDTO.getHora());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return solicitudCitaDTO;
	}
}
