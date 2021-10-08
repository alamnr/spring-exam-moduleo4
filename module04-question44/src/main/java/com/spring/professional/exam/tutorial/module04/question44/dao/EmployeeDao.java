package com.spring.professional.exam.tutorial.module04.question44.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module04.question44.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	Employee findByEmail(String email);
}
