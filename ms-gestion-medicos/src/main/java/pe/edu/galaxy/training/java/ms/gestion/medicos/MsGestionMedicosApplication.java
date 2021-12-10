package pe.edu.galaxy.training.java.ms.gestion.medicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsGestionMedicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionMedicosApplication.class, args);
	}

}
