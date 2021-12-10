package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.producer.CitaMedicaProducer;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.DisponibilidadCuposService;

@Slf4j
@Service
public class CitaMedicaConsumerImpl implements CitaMedicaConsumer{
	
	private DisponibilidadCuposService dispCuposService;
	private CitaMedicaProducer citaMedicaProducer;
	
	public CitaMedicaConsumerImpl(DisponibilidadCuposService dispCuposService, CitaMedicaProducer citaMedicaProducer) {
		this.dispCuposService  = dispCuposService;
		this.citaMedicaProducer= citaMedicaProducer;
	}
	
	
	@KafkaListener(
			topics = "${custom.kafka.topic-name}",
			groupId = "${custom.kafka.group-id}",
			containerFactory = "citaMedicaKafkaListenerContainerFactory")
	@Override
	public void consumeMessage(SolicitudCitaDTO solicitudCitaDTO) {
		log.info("-> Consumiendo mensaje de la cola [{}]", solicitudCitaDTO);
		
		//-> Evalua las reglas de negocio:
		SolicitudCitaDTO citaMedicaResult = dispCuposService.validaCupoDisponible(solicitudCitaDTO);
        
		//-> Produce Resultado en nuevo Topic Result:
		citaMedicaProducer.sendMessage(citaMedicaResult);
	}

}
