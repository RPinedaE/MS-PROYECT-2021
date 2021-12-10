package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.CitaMedicaService;

@Slf4j
@Service
public class CitaMedicaConsumerImpl implements CitaMedicaConsumer{
	
	private CitaMedicaService citaMedicaService;
	
	public CitaMedicaConsumerImpl(CitaMedicaService citaMedicaService) {
		this.citaMedicaService = citaMedicaService;
	}
	
	@KafkaListener(
			topics = "${custom.kafka.topic-name-rs}",
			groupId = "${custom.kafka.group-id-rs}",
			containerFactory = "citaMedicaKafkaListenerContainerFactory")
	@Override
	public void consumeMessage(SolicitudCitaDTO solicitudCitaDTO) {
		log.info("-> Consumiendo mensaje resultado cita solicitada [{}]", solicitudCitaDTO);
		
		log.info("-> Actualiza Estado en la DB Transaccional con estado: "+solicitudCitaDTO.getEstado()+" = "+solicitudCitaDTO.getEstado().ordinal());
		citaMedicaService.actualizaEstadoSolicitud(solicitudCitaDTO.getCitaId().longValue(), String.valueOf(solicitudCitaDTO.getEstado().ordinal()), solicitudCitaDTO.getHoraCita()); 		
	}

}
