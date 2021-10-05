package com.spring.professional.exam.tutorial.module04.question38;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.professional.exam.tutorial.module04.question38.service.NameService;

//@RunWith(SpringRunner.class)  // JUnit-4
//@ExtendWith(SpringExtension.class) // JUnit-5 , already present in @SpringBootTest
@SpringBootTest
@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {

	@Autowired	
	private MockMvc mockMvc; 
	
	@MockBean
	private NameService nameService;	
	
	/*
	@Mock
	private NameService nameService;
	private AutoCloseable autoClosable;
	
	@BeforeEach
	void init() {
		autoClosable = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void close() throws Exception {
		autoClosable.close();
	} */
	
	/*
	 // Mockito Manual Test 
	private NameService nameService;
	@BeforeEach
    void init() {
		nameService = mock(NameService.class);
    } */
	
	/*
	// Mockito annotation test
	@Mock	
	private NameService nameService;
	private AutoCloseable closeable;
	
	@BeforeEach
    void init() {
		closeable = MockitoAnnotations.openMocks(this);
    } 
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    } */ 
	
	@Test
	public void shouldSayHello() throws Exception {
		when(nameService.getName()).thenReturn("Test");
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn();
		
		assertEquals("Hello Test", mvcResult.getResponse().getContentAsString());
		
		verify(nameService,times(1)).getName();
	}
	
}
