package com.assessment.weatherspring;

import com.assessment.weatherspring.repository.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WeatherspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		WeatherRepository weatherRepository;
	}
}
