package com.spring.professional.exam.tutorial.module04.question42;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.professional.exam.tutorial.module04.question42.controller.EmployeeController;
import com.spring.professional.exam.tutorial.module04.question42.dao.CityDao;
import com.spring.professional.exam.tutorial.module04.question42.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module04.question42.dto.EmployeePutRequest;
import com.spring.professional.exam.tutorial.module04.question42.dto.Employees;
import com.spring.professional.exam.tutorial.module04.question42.entity.City;
import com.spring.professional.exam.tutorial.module04.question42.entity.Employee;

@WebMvcTest(EmployeeController.class)
@AutoConfigureJsonTesters
public class EmployeeControllerIntegrationTest {
	
	public static final City NEW_YORK = new City(1,"New York");
	public static final City LOS_ANGELES = new City(2,"Los Angeles");
	public static final Employee EMPLOYEE_1 = new Employee(1, "John",NEW_YORK);
	public static final Employee EMPLOYEE_2 = new Employee(2,"Dave",LOS_ANGELES);

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeDao employeeDao;
	
	@MockBean
	private CityDao cityDao;
	
	@Autowired
	private JacksonTester<Employees> employeesJson;
	
	@Autowired
	private JacksonTester<EmployeePutRequest> employeePutRequestJson;
	
	
	@Test
	public void shouldSaveEmployeeWithExistingCity() throws Exception {
		when(cityDao.findByName("New York")).thenReturn(Optional.of(NEW_YORK));
		
		mvc.perform(put("/employees").content("{\"name\": \"John\",\"city\":\"New York\"}").contentType(MediaType.APPLICATION_JSON))
									.andExpect(status().isOk());
		
		verify(employeeDao).save(new Employee("John",NEW_YORK));
	}
	
	@Test
	public void shouldNotSaveEmployeeWhenNonExistingCityInRequestFound() throws Exception {
		
		when(cityDao.findByName("New York")).thenReturn(Optional.empty());
		
		String jsonObject= employeePutRequestJson.write(new EmployeePutRequest("John","New York")).getJson();
		System.out.println(jsonObject);
		/*
		mvc.perform(put("/employees").content("{\"name\":\"John\",\"city\":\"New York\"}").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest()); */
		
		mvc.perform(put("/employees").content(jsonObject).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
		
		verify(employeeDao,never()).save(any());
	}
	
	@Test
	public void shouldFetchEmployees() throws UnsupportedEncodingException, Exception {
		when(employeeDao.findAll()).thenReturn(Arrays.asList(EMPLOYEE_1,EMPLOYEE_2));
		
		String jsonResponse =  mvc.perform(get("/employees")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		Iterable<Employee> employeeIterable = Arrays.asList(EMPLOYEE_1,EMPLOYEE_2);
		String jsonToAssert = employeesJson.write(new Employees(employeeIterable)).getJson();
		System.out.println(jsonToAssert);
		
		assertEquals(jsonToAssert,jsonResponse);
	}
}
