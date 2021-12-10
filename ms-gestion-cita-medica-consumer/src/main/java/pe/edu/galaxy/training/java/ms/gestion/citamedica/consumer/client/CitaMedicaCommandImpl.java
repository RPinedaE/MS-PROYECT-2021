package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer.client;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

@Slf4j
@Component
public class CitaMedicaCommandImpl implements CitaMedicaCommand{

	private DiscoveryClient discoveryClient;

	// Client
	private WebClient rest;

	private String uri = "ms-gestion-cita-medica-command";


	public CitaMedicaCommandImpl(WebClient.Builder builder, DiscoveryClient discoveryClient) {
		log.info("---> CitaMedicaCommandImpl()::: discoveryClient:"+discoveryClient);
		this.discoveryClient = discoveryClient;
		this.rest = builder.baseUrl(this.getURI() + "/v1/cita-medica-command").build();
	}

	@Override
	public void enviar(CitaMedica citaMedica) {
		try {
			log.info("Objeto a enviar para command [{}]",citaMedica);
			
			rest.post()
	        .uri("")
	        .body(BodyInserters.fromValue(citaMedica))
	        .retrieve()
	        .bodyToMono(CitaMedica.class)
	        .subscribe(System.out::println);
			
			log.info("Post enviado -> command");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String getURI() {
		log.info("-> getURI()::: ");
		List<ServiceInstance> instances = discoveryClient.getInstances(uri);

		if (Objects.isNull(instances) || instances.isEmpty()) {
			return null;
		}
		String uri = instances.get(0).getUri().toString();
		log.info("----> URI: " + uri);
		return uri;
	}

}
