package de.toolsforschools.eventplanner;


import de.toolsforschools.eventplanner.services.H2DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories
public class EventplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventplannerApplication.class, args);
	}

	@Autowired
	private H2DBService service;
	@Bean
	ApplicationRunner init() {
		return args -> {
				service.initDefaultData();
		};
	}
}
