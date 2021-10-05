package com.spring.professional.exam.tutorial.module04.question38.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.professional.exam.tutorial.module04.question38.service.NameService;

@Controller
public class HelloController {

	@Autowired
	private NameService nameService;
	
	@GetMapping
	@ResponseBody
	public String hello() {
		return "Hello " + nameService.getName();
	}
}
