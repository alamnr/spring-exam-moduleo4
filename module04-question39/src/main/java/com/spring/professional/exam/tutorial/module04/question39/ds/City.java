package com.spring.professional.exam.tutorial.module04.question39.ds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@Builder

public class City {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	public City() {
	
	}

}
