package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.especialidad;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.ClientException;

@Slf4j
@Component
public class EspecialidadServiceImpl implements EspecialidadService{
	
    private DiscoveryClient discoveryClient;
	private RestTemplate 	restTemplate;
	private CircuitBreaker  circuitBreaker;
	
	//Nombre de la API segun Eureka:
	private String url="ms-gestion-especialidades";
	
	public EspecialidadServiceImpl(DiscoveryClient discoveryClient, RestTemplate restTemplate, CircuitBreakerFactory<?,?> circuitBreakerFactory) {
		this.discoveryClient = discoveryClient;
		this.restTemplate = restTemplate;
		this.circuitBreaker = circuitBreakerFactory.create("ms-gestion-especialidades");
	}

	@Override
	public EspecialidadDTO findById(Long id) throws ClientException { // --> Plan A
		
		return circuitBreaker.run(() -> { 
		log.info("--> EspecialidadDTO : Ejecutando Plan A");
		
		ResponseEntity<EspecialidadDTO> respEntEspecialidadDTO=restTemplate.getForEntity(this.getURI()+"/v1/especialidades/"+id, EspecialidadDTO.class);		
		if (!Objects.isNull(respEntEspecialidadDTO)) {
			return respEntEspecialidadDTO.getBody();
		}
		return null;
		},
			throwable -> getServicioDTODefault(id)
		);
	}
	
	public EspecialidadDTO getServicioDTODefault(Long id) {
		log.info("--> EspecialidadDTO : Ejecutando Default...");
		return null;
	}
	
	
	private String getURI() {
		if (Objects.isNull(discoveryClient)) {
			return "";
		}
		List<ServiceInstance> instances = discoveryClient.getInstances(url);

		if (Objects.isNull(instances) || instances.isEmpty()) return "not found";
		log.info("*Host: "+instances.get(0).getHost());
		String uri=instances.get(0).getUri().toString();		
		log.info("*Uri: " +uri);
		return uri;
	}
}
