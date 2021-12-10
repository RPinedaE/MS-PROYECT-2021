package pe.edu.galaxy.training.java.ms.gestion.programacioncupos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsGestionProgramacionCuposApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionProgramacionCuposApplication.class, args);
	}
}
