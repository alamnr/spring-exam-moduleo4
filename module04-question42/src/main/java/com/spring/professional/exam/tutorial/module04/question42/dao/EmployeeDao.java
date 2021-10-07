package com.spring.professional.exam.tutorial.module04.question42.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module04.question42.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
