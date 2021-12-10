package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer.client.CitaMedicaCommand;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

@Slf4j
@Service
public class CitaMedicaConsumerImpl implements CitaMedicaConsumer{
	
	
	private CitaMedicaCommand citaMedicaCommand;
	
	public CitaMedicaConsumerImpl(CitaMedicaCommand citaMedicaCommand) {
		this.citaMedicaCommand = citaMedicaCommand;
	}
	
	
	@KafkaListener(
			topics = "${custom.kafka.topic-name}",
			groupId = "${custom.kafka.group-id}",
			containerFactory = "citaMedicaKafkaListenerContainerFactory")
	@Override
	public void consumeMessage(CitaMedica citaMedica) {
		log.info("-> Consumiendo mensaje de la cola [{}]", citaMedica);
				
		log.info("-> Enviando mensaje leido para hacer command...");
		citaMedicaCommand.enviar(citaMedica);
	}

}
