package com.spring.professional.exam.tutorial.module04.question42.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module04.question42.entity.City;

public interface CityDao extends CrudRepository<City, Integer> {
	Optional<City> findByName(String name);
}
