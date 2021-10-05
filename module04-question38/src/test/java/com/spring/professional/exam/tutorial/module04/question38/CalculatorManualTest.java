package com.spring.professional.exam.tutorial.module04.question38;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.spring.professional.exam.tutorial.module04.question38.service.Calculator;
import com.spring.professional.exam.tutorial.module04.question38.service.CalculatorService;

public class CalculatorManualTest {
	
	
	private CalculatorService calculatorService;	
	
	private Calculator calculator ;
	
	
	@BeforeEach
	public void init() {
		calculatorService = mock(CalculatorService.class);
		calculator = new Calculator(calculatorService);
	} 
	
	@Test
	public void testPerform() {	
		when(calculatorService.add(2, 3)).thenReturn(5);
		assertEquals(10, calculator.perform(2, 3));
		verify(calculatorService,times(1)).add(2, 3);
		
		
	}

}
