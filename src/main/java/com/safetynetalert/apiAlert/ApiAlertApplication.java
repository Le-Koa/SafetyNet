package com.safetynetalert.apiAlert;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class ApiAlertApplication{

	public static void main(String[] args) {

		SpringApplication.run(ApiAlertApplication.class, args);
	}
//In memorie
	//In disk

	@Bean
	CommandLineRunner runner(ReadJsonFile readJsonFile) {
		return args -> {
			readJsonFile.saveInDb();
		};
	}
}
