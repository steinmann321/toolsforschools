package de.toolsforschools.eventplanner;


import de.toolsforschools.eventplanner.models.School;
import de.toolsforschools.eventplanner.repositories.SchoolRepository;
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

	@Bean
	ApplicationRunner init(SchoolRepository schoolRepository) {
		return args -> {
			School car = new School();
			car.setName("Rudolf-Steiner-Schule");
			schoolRepository.save(car);
			schoolRepository.findAll().forEach(System.out::println);
		};
	}
}
