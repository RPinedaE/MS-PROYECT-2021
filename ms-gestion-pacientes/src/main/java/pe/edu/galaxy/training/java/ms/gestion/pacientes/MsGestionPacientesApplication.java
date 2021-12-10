package pe.edu.galaxy.training.java.ms.gestion.pacientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsGestionPacientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionPacientesApplication.class, args);
	}

}
