package com.spring.professional.exam.tutorial.module04.question39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.professional.exam.tutorial.module04.question39.ds.Room;

//@SpringBootApplication
public class Runner {
	
	public static void main(String[] args) {
		//SpringApplication.run(Runner.class, args);
		
		
		Room cambridge  =  new Room("Cambridge","Premier Rooom",5,175.0f,true);
		Room manchester  =  new Room("Manchester","Suit",5,250.0f,false);
		Room oxford  =  new Room("Oxford","Suit",5,225.0f,true);
		Room victoria  =  new Room("Victoria","Suit",5,185.0f,false);
		
		Collection<Room> rooms = new ArrayList<>(Arrays.asList(cambridge,manchester,oxford,victoria));
		
		/*
		rooms.stream()
			 .filter(new Predicate<Room>() {

			@Override
			public boolean test(Room room) {
				System.out.format("Testing %s with result %b%n",room.getName(),room.isPetFriendly());
				return room.isPetFriendly();
			}
		}).forEach(new Consumer<Room>() {

			@Override
			public void accept(Room room) {
				
				System.out.println(room.getName());
			}
		}); */
		
		/*
		rooms.stream()
			  .filter(room->room.isPetFriendly())
			  .forEach(room->System.out.println(room.getName())); */
		/*
		rooms.stream()
				.filter(Room::isPetFriendly)
				.forEach(room->System.out.println(room.getName()));*/
		Collection<Room> petFriendlyRooms = rooms.stream().filter(room->room.isPetFriendly()).collect(Collectors.toList());
		
		//rooms.stream().filter(room->room.isPetFriendly()).forEach(room->petFriendlyRooms.add(room));
		
		//petFriendlyRooms.stream().forEach(r->System.out.println(r.getName()));
		//petFriendlyRooms.stream().map(r-> r.getName()).forEach(System.out::println);
		float rent = (float) petFriendlyRooms.stream().mapToDouble(Room::getRent).sum();
		//System.out.println(rent);
		/*
		Iterator<Room> iterator = rooms.iterator();
		while(iterator.hasNext()) {
			Room room = iterator.next();
			if(room.isPetFriendly()) {
				iterator.remove();
			}
		}
		
		rooms.stream().forEach(r-> System.out.println(r.getName()));*/
		
		List<Integer> numbers = Arrays.asList(500,1500,2500,1000,3000,2000);
		
		NavigableSet<Integer> numberTree = new TreeSet<>(numbers);
		
		numberTree.subSet(1750, 2750)//.tailSet(1750)//.descendingSet()//.headSet(1750)
		.stream().forEach(System.out::println);
		
		System.out.println(numberTree.lower(750));
		System.out.println(numberTree.higher(750));
	}

}
