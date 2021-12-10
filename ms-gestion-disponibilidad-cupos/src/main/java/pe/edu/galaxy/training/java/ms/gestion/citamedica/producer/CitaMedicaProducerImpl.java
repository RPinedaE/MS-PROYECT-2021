package pe.edu.galaxy.training.java.ms.gestion.citamedica.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

@Slf4j
@Service
public class CitaMedicaProducerImpl implements CitaMedicaProducer{
	
	//Usa otro topic para la respuesta: topic-cita-medica-result-solicitud
	@Value("${custom.kafka.topic-name-rs}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, SolicitudCitaDTO> citaKafkaTemplate;
 
	@Override
	public void sendMessage(SolicitudCitaDTO solicitudCitaDTO) {
		log.info("-> send cita : "+ solicitudCitaDTO);
		log.info("-> topicName : "+ topicName);
		
		log.info("--> enviando mensaje...");
		citaKafkaTemplate.send(topicName, solicitudCitaDTO);
	}

}
