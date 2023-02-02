package com.hhiephk.baitap.service;

import java.util.List;
import java.util.Optional;

import com.hhiephk.baitap.exception.UserNotFoundException;
import com.hhiephk.baitap.model.entity.Person;

public interface PersonService {

	<S extends Person> S save(S entity);

	void deleteById(Integer id);

	Optional<Person> findById(Integer id) throws UserNotFoundException;

	List<Person> findAll();

	Optional<Person> findByUsername(String username);
	
}
