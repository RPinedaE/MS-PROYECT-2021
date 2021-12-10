package pe.edu.galaxy.training.java.ms.registryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsAdminRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminRegistryServerApplication.class, args);
	}
}
