package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer.client;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

@Slf4j
@Component
public class CitaMedicaCommandImpl implements CitaMedicaCommand{

	private DiscoveryClient discoveryClient;

	// Client
	private WebClient rest;

	private String uri = "ms-gestion-cita-medica-command";


	public CitaMedicaCommandImpl(WebClient.Builder builder, DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
		this.rest = builder.baseUrl(this.getURI() + "/v1/cita-medica-command").build();
	}

	@Override
	public void enviar(SolicitudCitaDTO solicitudCitaDTO) {
		try {
			log.info("Objeto a enviar para command [{}]",solicitudCitaDTO);
			
			rest.post()
	        .uri("")
	        .body(BodyInserters.fromValue(solicitudCitaDTO))
	        .retrieve()
	        .bodyToMono(SolicitudCitaDTO.class)
	        .subscribe(System.out::println);
			
			 /*rest.get()
			.uri("")
	        .retrieve()
	        .bodyToMono(CitaMedica.class)
	        .subscribe(System.out::println);*/
			
			log.info("Post enviado -> command");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//https://howtodoinjava.com/spring-webflux/webclient-get-post-example/
	//https://www.baeldung.com/webflux-webclient-parameters
	//https://stackoverflow.com/questions/59915794/add-query-parameter-in-webclient-request

	private String getURI() {
		List<ServiceInstance> instances = discoveryClient.getInstances(uri);

		if (Objects.isNull(instances) || instances.isEmpty()) {
			return null;
		}
		String uri = instances.get(0).getUri().toString();
		log.info("uri: " + uri);
		return uri;
	}

}
