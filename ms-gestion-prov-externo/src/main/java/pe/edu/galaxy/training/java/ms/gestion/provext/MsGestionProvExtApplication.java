package pe.edu.galaxy.training.java.ms.gestion.provext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsGestionProvExtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionProvExtApplication.class, args);
	}

}
