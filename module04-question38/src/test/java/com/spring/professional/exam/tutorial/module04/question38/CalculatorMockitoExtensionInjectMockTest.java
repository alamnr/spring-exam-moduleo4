package com.spring.professional.exam.tutorial.module04.question38;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.professional.exam.tutorial.module04.question38.service.Calculator;
import com.spring.professional.exam.tutorial.module04.question38.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
public class CalculatorMockitoExtensionInjectMockTest {
	
	@Mock
	private CalculatorService calculatorService;
	@InjectMocks
	private Calculator calculator;
	
	@Test
	public void testPerform() {
		when(calculatorService.add(2, 3)).thenReturn(5);
		assertEquals(10, calculator.perform(2, 3));
		verify(calculatorService,times(1)).add(2, 3);
		
	}

	
}
