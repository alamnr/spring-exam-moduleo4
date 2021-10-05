package com.spring.professional.exam.tutorial.module04.question39;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.professional.exam.tutorial.module04.question39.controller.CityController;
import com.spring.professional.exam.tutorial.module04.question39.ds.City;

@SpringBootTest
public class CityControllerSpringBootTest {

	@Autowired
	private CityController cityController;
	
	@Test
	public void shouldSaveFewCities() {
		cityController.putCity(City.builder().name("New York").build());
		cityController.putCity(City.builder().name("Los Angeles").build());
		cityController.putCity(City.builder().name("San Francisco").build());
		
		assertThat(cityController.getCities().getCities()).containsOnly(
				new City(1, "New York"),new City(2,"Los Angeles"),new City(3,"San Francisco"));
		
		
	}
}
