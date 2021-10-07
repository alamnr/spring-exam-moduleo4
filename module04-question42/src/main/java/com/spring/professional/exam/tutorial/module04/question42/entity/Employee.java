package com.spring.professional.exam.tutorial.module04.question42.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	public Employee(String name,City city) {
		this.name=name;
		this.city=city;
	}
	public Employee() {
	
	}
	
}
