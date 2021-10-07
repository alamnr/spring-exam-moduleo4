package com.spring.professional.exam.tutorial.module04.question42;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.professional.exam.tutorial.module04.question42.dao.CityDao;
import com.spring.professional.exam.tutorial.module04.question42.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module04.question42.dto.EmployeePutRequest;
import com.spring.professional.exam.tutorial.module04.question42.entity.City;
import com.spring.professional.exam.tutorial.module04.question42.entity.Employee;

@WebMvcTest
@AutoConfigureJsonTesters
public class CityAndEmployeeFlowIntegrationTest {

	private static final String NEW_YORK_NAME = "New York";
	private static final String LOS_ANGELES_NAME = "Los Angeles";
	private static final City NEW_YORK = new City(1,NEW_YORK_NAME);
	private static final City LOS_ANGELES = new City(2, LOS_ANGELES_NAME);
		
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CityDao cityDao;
	
	@MockBean
	private EmployeeDao employeeDao;
	
	@Autowired
	private JacksonTester<City> cityJson;
	
	@Autowired
	private JacksonTester<EmployeePutRequest> employeePutRequestJson;
	
	@Test
	public void shouldSaveCitiesAndEmployees() throws Exception {
		String cityJsonToSend_1 = cityJson.write(City.builder().name(NEW_YORK_NAME).build()).getJson();
		String cityJsonToSend_2 = cityJson.write(City.builder().name(LOS_ANGELES_NAME).build()).getJson();
		
		mockMvc.perform(put("/cities").content(cityJsonToSend_1).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(put("/cities").content(cityJsonToSend_2).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		verify(cityDao).save(City.builder().name(NEW_YORK_NAME).build());
		verify(cityDao).save(City.builder().name(LOS_ANGELES_NAME).build());
		
		when(cityDao.findByName(NEW_YORK_NAME)).thenReturn(Optional.of(NEW_YORK));
		when(cityDao.findByName(LOS_ANGELES_NAME)).thenReturn(Optional.of(LOS_ANGELES));
		
		String employeePutRequestJsonToSend_1 = employeePutRequestJson.write(new EmployeePutRequest("John", NEW_YORK_NAME)).getJson();
		String employeePutRequestJsonToSend_2 = employeePutRequestJson.write(new EmployeePutRequest("Jane", LOS_ANGELES_NAME)).getJson();
		
		mockMvc.perform(put("/employees").content(employeePutRequestJsonToSend_1).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		mockMvc.perform(put("/employees").content(employeePutRequestJsonToSend_2).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		verify(employeeDao).save(new Employee("John", NEW_YORK));
		verify(employeeDao).save(new Employee("Jane", LOS_ANGELES));
		
		
	}
	
}
