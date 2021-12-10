package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.cupos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.ClientException;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class SolicitudCupoServiceImpl implements SolicitudCupoService{
	
    private DiscoveryClient discoveryClient;
    
    // Client
 	private WebClient rest;
	
	//Nombre de la API segun Eureka:
	private String url ="ms-gestion-programacion-cupos";
	
	public SolicitudCupoServiceImpl(WebClient.Builder builder, DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
		this.rest = builder.baseUrl(this.getURI() + "/v1/programacion-cupos/").build();
	}
	

	@Override
	public SolicitudCupoDTO solicitaCupo(Date fecha, Long idEspecialidad, Long idMedico) throws ClientException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String fechaSolicitada= sdf.format(fecha);
		
		log.info("-> Solicitando cupo para la fecha: "+fechaSolicitada+" / Especialidad ID: "+idEspecialidad+" / Medico ID: "+idMedico);

		Mono<SolicitudCupoDTO> monoSolicitudCupoDTO = rest.get().uri("/solicita-cupo/"+fechaSolicitada+"/"+idEspecialidad+"/"+idMedico).retrieve().bodyToMono(SolicitudCupoDTO.class);
		
		if (!Objects.isNull(monoSolicitudCupoDTO)) {
			return monoSolicitudCupoDTO.block();
		}
				
		return null;
	}	
	
	private String getURI() {
		log.info("-> getURI()::: discoveryClient:" +discoveryClient);
		String uri="";
		
		if (Objects.isNull(discoveryClient)) {
			return "";
		}
		List<ServiceInstance> instances = discoveryClient.getInstances(url);

		if (Objects.isNull(instances) || instances.isEmpty()) {
			return "-> not found";
			
		}else {
			log.info("*Host: "+instances.get(0).getHost());
			uri= instances.get(0).getUri().toString();		
			log.info("*Uri: " +uri);
		}
			
		return uri;
	}

}
