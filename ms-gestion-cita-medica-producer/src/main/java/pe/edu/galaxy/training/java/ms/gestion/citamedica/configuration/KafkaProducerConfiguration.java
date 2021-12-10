package pe.edu.galaxy.training.java.ms.gestion.citamedica.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.serializer.JsonSerializer;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

@Slf4j
@Configuration
public class KafkaProducerConfiguration {

	
	@Value("${custom.kafka.bootstrap-servers}")
	private String bootstrapServers;

	// Conexion al Servidor Kafka
	@Bean
	public ProducerFactory<String, CitaMedica> citaProducerFactory() { 
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);          //Server Kafka
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); //Llave de los mensajes enviados
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); //Formato de los mensajes enviados
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	//Platilla del Mensaje a Publicar
	@Bean
	public KafkaTemplate<String, CitaMedica> citaKafkaTemplate() {
	
		KafkaTemplate<String, CitaMedica> kafkaTemplate = new KafkaTemplate<>(citaProducerFactory());

		//Mas que listener es un Command
		kafkaTemplate.setProducerListener(new ProducerListener<String, CitaMedica>() {

			@Override
			public void onSuccess(ProducerRecord<String, CitaMedica> producerRecord, RecordMetadata recordMetadata) {

				log.info("Mensaje publicado con exito: {}  offset:  {}", producerRecord.value(), recordMetadata.offset());
				
			}

			@Override
			public void onError(ProducerRecord<String, CitaMedica> producerRecord, RecordMetadata recordMetadata,
					Exception exception) {
				log.warn("Error al publicar el mensaje [{}] exception: {}", producerRecord.value(), exception.getMessage());
			}
		});
		return kafkaTemplate;
	}
	
}