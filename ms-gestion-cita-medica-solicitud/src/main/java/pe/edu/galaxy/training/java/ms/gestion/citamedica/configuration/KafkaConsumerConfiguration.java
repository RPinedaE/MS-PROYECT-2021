package pe.edu.galaxy.training.java.ms.gestion.citamedica.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

@Configuration
public class KafkaConsumerConfiguration {

	@Value("${custom.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${custom.kafka.group-id-rs}")
	private String groupId;

	
	//Conexion del Consumer al Kafka
	public ConsumerFactory<String, SolicitudCitaDTO> citaMedicaConsumerFactory() {	
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),new JsonDeserializer<>(SolicitudCitaDTO.class));
	}

	
	//Instancia del Consumer Listener
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, SolicitudCitaDTO> citaMedicaKafkaListenerContainerFactory() {
		
		ConcurrentKafkaListenerContainerFactory<String, SolicitudCitaDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(citaMedicaConsumerFactory());
		
		return factory;
	}
	
}