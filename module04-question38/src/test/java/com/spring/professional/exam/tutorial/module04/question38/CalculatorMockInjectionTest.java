package com.spring.professional.exam.tutorial.module04.question38;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.professional.exam.tutorial.module04.question38.service.Calculator;
import com.spring.professional.exam.tutorial.module04.question38.service.CalculatorService;

public class CalculatorMockInjectionTest {
	
	@Mock
	private CalculatorService calculatorService;
	private AutoCloseable autoCloseable;
	@InjectMocks
	private Calculator calculator;
	
	
	@BeforeEach
	void init() {
		autoCloseable = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void close() throws Exception {
		autoCloseable.close();
	}
	
	@Test
	public void testPerform() {
		when(calculatorService.add(2, 3)).thenReturn(5);
		assertEquals(10, calculator.perform(2, 3));
	}
	
	
	

}
