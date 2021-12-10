package pe.edu.galaxy.training.java.ms.gestion.citamedica.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

@Slf4j
@Service
public class CitaMedicaProducerImpl implements CitaMedicaProducer{
	
	@Value("${custom.kafka.topic-name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, CitaMedica> citaKafkaTemplate;
 
	@Override
	public void sendMessage(CitaMedica citaMedica) {
		log.info("-> send cita : "+ citaMedica);
		log.info("-> topicName : "+ topicName);
		
		log.info("--> enviando mensaje...");
		citaKafkaTemplate.send(topicName, citaMedica);
	}

}
