package com.spring.professional.exam.tutorial.module04.question42;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.professional.exam.tutorial.module04.question42.controller.CityController;
import com.spring.professional.exam.tutorial.module04.question42.dao.CityDao;
import com.spring.professional.exam.tutorial.module04.question42.entity.City;

@WebMvcTest(CityController.class)
public class CityDaoControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CityDao cityDao;
	
	@Test
	public void shouldSaveCities() throws Exception {
		mvc.perform(put("/cities").content("{\"name\":\"New York\"}").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		mvc.perform(put("/cities").content("{\"name\":\"Los Angeles\"}").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		verify(cityDao).save(City.builder().name("New York").build());
		verify(cityDao).save(City.builder().name("Los Angeles").build());
		
	}
	
	@Test
	public void shouldFetchCities() throws Exception, Exception {
		when(cityDao.findAll()).thenReturn(
					Arrays.asList(new City(1, "New York"),new City(2,"Los Angeles"))
				);
		String jsonString = mvc.perform(get("/cities")).andExpect(status().isOk())
								.andReturn().getResponse().getContentAsString();
		
		assertThat(jsonString ).contains("{\"id\":1,\"name\":\"New York\"}").contains("{\"id\":2,\"name\":\"Los Angeles\"}");
	}
	

}
