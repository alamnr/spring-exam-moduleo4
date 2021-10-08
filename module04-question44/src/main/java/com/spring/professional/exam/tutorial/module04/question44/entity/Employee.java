package com.spring.professional.exam.tutorial.module04.question44.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee() {
	
	}
}
