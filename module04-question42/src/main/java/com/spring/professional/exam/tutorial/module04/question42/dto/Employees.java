package com.spring.professional.exam.tutorial.module04.question42.dto;

import com.spring.professional.exam.tutorial.module04.question42.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employees {

	private Iterable<Employee> employees;
	
	public Employees() {
	
	}
}
