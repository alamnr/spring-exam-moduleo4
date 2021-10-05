package com.spring.professional.exam.tutorial.module04.question39;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import com.spring.professional.exam.tutorial.module04.question39.ds.City;


@JsonTest
public class CityJsonTest {

	@Autowired
	private JacksonTester<City> json;
	
	@Test
	public void shouldSerialize() throws IOException {
		City city = new City(1,"New York");
		String json = this.json.write(city).getJson();
		assertEquals(json, "{\"id\":1,\"name\":\"New York\"}");
	}
	
	@Test
	public void shouldDeSerialize() throws IOException {
		City city = this.json.parse("{\"id\":1,\"name\":\"New York\"}").getObject();
		
		assertEquals(1, city.getId());
		assertEquals("New York", city.getName());
		
	}
	
}
