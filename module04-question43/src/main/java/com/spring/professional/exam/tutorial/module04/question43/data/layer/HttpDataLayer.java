package com.spring.professional.exam.tutorial.module04.question43.data.layer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module04.question43.ds.Person;

@Service
public class HttpDataLayer {

	public void saveData(List<Person> persons) {
		System.out.println("Saving data to http ....");
		
		persons.forEach(System.out::println);
		
		System.out.println("Done");
	}
}
