package pe.edu.galaxy.training.java.ms.gestion.especialidades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsGestionEspecialidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionEspecialidadesApplication.class, args);
	}
}
