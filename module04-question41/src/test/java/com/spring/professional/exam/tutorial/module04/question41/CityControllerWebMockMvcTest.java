package com.spring.professional.exam.tutorial.module04.question41;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerWebMockMvcTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldSaveCities() throws Exception {
		mockMvc.perform(put("/cities").content("{\"name\":\"New York\"}").contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk());
	
		mockMvc.perform(put("/cities").content("{\"name\":\"Los Angeles\"}").contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk());
		
		String jsonResponse = mockMvc.perform(get("/cities"))
										.andExpect(status().isOk())
										.andReturn().getResponse().getContentAsString();
		
		assertThat(jsonResponse).contains("{\"id\":1,\"name\":\"New York\"}")
								.contains("{\"id\":2,\"name\":\"Los Angeles\"}");
	}
	
}
