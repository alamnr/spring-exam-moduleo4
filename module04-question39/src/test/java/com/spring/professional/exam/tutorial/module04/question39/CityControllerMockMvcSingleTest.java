package com.spring.professional.exam.tutorial.module04.question39;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.professional.exam.tutorial.module04.question39.controller.CityController;
import com.spring.professional.exam.tutorial.module04.question39.dao.CityDao;
import com.spring.professional.exam.tutorial.module04.question39.ds.City;

//@SpringBootTest  // don't use it , shows error
@ExtendWith(SpringExtension.class)
@WebMvcTest(CityController.class)
public class CityControllerMockMvcSingleTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CityDao cityDao;
	
	@Test
	public void shouldSaveCity() throws Exception {
		mockMvc.perform(put("/cities").content("{\"name\":\"New York\"}").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		verify(cityDao,times(1)).save(new City(null,"New York"));
		
	}
	
	@Test
	public void shouldFetchCities() throws UnsupportedEncodingException, Exception {
		when(cityDao.findAll()).thenReturn(Arrays.asList(new City(1, "New York"),new City(2, "Los Angeles")));
		
		String jsonResponse = mockMvc.perform(get("/cities"))
										.andExpect(status().isOk())
										.andReturn()
										.getResponse()
										.getContentAsString();
		
		assertThat(jsonResponse)
					.contains("\"id\":1,\"name\":\"New York\"")
					.contains("\"id\":2,\"name\":\"Los Angeles\"");
	}	
	
}
