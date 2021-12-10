package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.provext;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.planilla.PersonalDTO;

@Slf4j
@Component
public class ProvExternoServiceImpl implements ProvExternoService{
	
    private DiscoveryClient discoveryClient;
	private RestTemplate 	restTemplate;
	
	//Nombre de la API segun Eureka:
	private String url="ms-gestion-prov-externo";
	
	public ProvExternoServiceImpl(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
		this.discoveryClient = discoveryClient;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public PersonalDTO getPersonalMedico(Long idMedico) throws ClientException {
        ResponseEntity<PersonalDTO> respEntPersonalDTO=restTemplate.getForEntity(this.getURI()+"/v1/provext/medico/"+idMedico, PersonalDTO.class);
		
		if (!Objects.isNull(respEntPersonalDTO)) {
			return respEntPersonalDTO.getBody();
		}
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
