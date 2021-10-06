package com.spring.professional.exam.tutorial.module04.question39.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {
	
	private String name;
	private String type;
	private int count;
	private float rent;
	private boolean isPetFriendly;

}
