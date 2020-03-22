package pl.example.spring.punkty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class PunktyApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PunktyApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "5005"));
		app.run(args);
	}

}
