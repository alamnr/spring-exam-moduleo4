package com.spring.professional.exam.tutorial.module04.question38.service;

public class Calculator {
	
	private CalculatorService calculatorService;
	
	public Calculator(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	public int perform(int i, int j) {
		return calculatorService.add(2, 3)*2;
	}

}
