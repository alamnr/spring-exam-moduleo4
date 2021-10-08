package com.spring.professional.exam.tutorial.module04.question43;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.professional.exam.tutorial.module04.question43.data.transfer.DataTransferAction;

@SpringBootApplication
public class Runner implements CommandLineRunner {
	
	@Autowired private DataTransferAction dataTransferAction;
	
	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataTransferAction.transfer();
	}

}
