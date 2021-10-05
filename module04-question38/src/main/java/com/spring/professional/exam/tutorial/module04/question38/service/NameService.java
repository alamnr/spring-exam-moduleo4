package com.spring.professional.exam.tutorial.module04.question38.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NameService {
	
	private String[] names = {"John","Dave","Tom"};
	private Random random = new Random();
	
	public String getName() {
		return names[random.nextInt(names.length)];
	}

}
