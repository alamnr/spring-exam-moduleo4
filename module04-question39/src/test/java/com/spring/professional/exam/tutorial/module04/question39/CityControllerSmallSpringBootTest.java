package com.spring.professional.exam.tutorial.module04.question39;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.professional.exam.tutorial.module04.question39.controller.CityController;
import com.spring.professional.exam.tutorial.module04.question39.dao.CityDao;
import com.spring.professional.exam.tutorial.module04.question39.ds.Cities;
import com.spring.professional.exam.tutorial.module04.question39.ds.City;

@SpringBootTest(classes = CityController.class)
public class CityControllerSmallSpringBootTest {

	@Autowired
	private CityController cityController;
	
	@MockBean
	private CityDao cityDao;
	
	@Test
	public void shouldSaveFewCities() {
		cityController.putCity(City.builder().name("Los Angeles").build());
		cityController.putCity(City.builder().name("New York").build());
		cityController.putCity(City.builder().name("San Francisco").build());
		
		verify(cityDao,times(1)).save(new City(null,"Los Angeles") );
		verify(cityDao,times(1)).save(new City(null,"New York"));
		verify(cityDao,times(1)).save(new City(null, "San Francisco"));
	}
	
	@Test
	public void shouldFetchCities() {
		when(cityDao.findAll()).thenReturn(Arrays.asList(new City(1, "New York"),new City(2, "Los Angeles")));
		
		Cities fetchedCities = cityController.getCities();
		
		assertThat(fetchedCities.getCities()).containsOnly(new City(1,"New York"),new City(2,"Los Angeles"));
	}
	
}
