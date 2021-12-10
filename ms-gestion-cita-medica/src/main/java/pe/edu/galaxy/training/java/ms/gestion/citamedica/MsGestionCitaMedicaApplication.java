package pe.edu.galaxy.training.java.ms.gestion.citamedica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsGestionCitaMedicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionCitaMedicaApplication.class, args);
	}
}
