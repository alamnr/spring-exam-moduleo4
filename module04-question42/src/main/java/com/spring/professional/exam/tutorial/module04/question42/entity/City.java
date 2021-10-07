package com.spring.professional.exam.tutorial.module04.question42.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class City {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	public City() {
	
	}

}
