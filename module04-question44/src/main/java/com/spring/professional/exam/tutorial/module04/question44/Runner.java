package com.spring.professional.exam.tutorial.module04.question44;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.professional.exam.tutorial.module04.question44.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module04.question44.entity.Employee;

@SpringBootApplication
public class Runner implements CommandLineRunner {

	@Autowired private EmployeeDao employeeDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	
		employeeDao.saveAll(Arrays.asList(
				new Employee(1,"John","Doe","john@repo.com"),new Employee(2, "Jane", "Dina", "jane@repo.com"),
				new Employee(3, "Tom", "Frost", "tom@repo.com")
				));
		employeeDao.findAll().forEach(System.out::println);
	}

}
