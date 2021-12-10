package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.medico;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.planilla.PersonalDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.planilla.PlanillaService;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.provext.ProvExternoService;

@Slf4j
@Component
public class MedicoServiceImpl implements MedicoService{
	
    private DiscoveryClient discoveryClient;
	private RestTemplate 	restTemplate;
	private CircuitBreaker  circuitBreaker;
	
	@Autowired
	private PlanillaService planillaService;
	
	@Autowired
	private ProvExternoService provExternoService;
	
	//Nombre de la API segun Eureka:
	private String url="ms-gestion-medicos";
	
	public MedicoServiceImpl(DiscoveryClient discoveryClient, RestTemplate restTemplate, CircuitBreakerFactory<?,?> circuitBreakerFactory) {
		this.discoveryClient = discoveryClient;
		this.restTemplate = restTemplate;
		this.circuitBreaker = circuitBreakerFactory.create("ms-gestion-medicos");
	}

	@Override
	public MedicoDTO findById(Long id) throws ClientException { // --> Plan A
		
		return circuitBreaker.run(() -> { 
			log.info("--> Ejecutando Plan A");
			ResponseEntity<MedicoDTO> respEntMedicoDTO=restTemplate.getForEntity(this.getURI()+"/v1/medicos/"+id, MedicoDTO.class);
			if (!Objects.isNull(respEntMedicoDTO)) {
				return respEntMedicoDTO.getBody();
			}
			return null;
		
		},
			throwable -> getMedicoDTOPlanB(id)
	    );
	}
	
	public MedicoDTO getMedicoDTOPlanB(Long id) { // --> Plan B
		return circuitBreaker.run(() -> {
			log.info("--> Ejecutando Plan B");
			try {
				return getMedicoDTO(planillaService.getPersonalMedico(id));
			} catch (ClientException e) {
				e.printStackTrace();
			}
			return null;		
		},
			throwable -> getMedicoDTOPlanC(id)
	    );
	}
	
	public MedicoDTO getMedicoDTOPlanC(Long id) { // --> Plan C
		return circuitBreaker.run(() -> {
			log.info("--> Ejecutando Plan C");
			try { 
				return getMedicoDTO(provExternoService.getPersonalMedico(id));
			} catch (ClientException e) {
				e.printStackTrace();
			}
			return null;		
		},
			throwable -> getMedicoDTODefault(id)
	    );
	}
	
	public MedicoDTO getMedicoDTODefault(Long id) {
		log.info("--> Ejecutando Default...");
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
	
	// Mappers
		private MedicoDTO getMedicoDTO(PersonalDTO personalDto) {		
			MedicoDTO medicoDTO= new MedicoDTO();
			medicoDTO.setId(personalDto.getIdMedico());
			medicoDTO.setNombres(personalDto.getNombres());
			medicoDTO.setApellidos(personalDto.getApellidos());			
			return medicoDTO;
		}
}
