package pe.edu.galaxy.training.java.ms.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class AppConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(AppConfigServer.class, args);
	}

}
