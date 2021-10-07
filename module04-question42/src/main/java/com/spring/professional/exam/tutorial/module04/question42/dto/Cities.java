package com.spring.professional.exam.tutorial.module04.question42.dto;

import com.spring.professional.exam.tutorial.module04.question42.entity.City;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cities {

	private Iterable<City> cities;
	
	public Cities() {
	
	}
}
