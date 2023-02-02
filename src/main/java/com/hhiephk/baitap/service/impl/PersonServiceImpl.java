package com.hhiephk.baitap.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhiephk.baitap.exception.UserNotFoundException;
import com.hhiephk.baitap.model.entity.Person;
import com.hhiephk.baitap.repository.PersonRepository;
import com.hhiephk.baitap.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonRepository personRepository;

	@Override
	public <S extends Person> S save(S entity) {
		return personRepository.save(entity);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Optional<Person> findById(Integer id) throws UserNotFoundException {
		Optional<Person> optionalPerson = personRepository.findById(id);
		System.out.println(optionalPerson);
		if(optionalPerson.isEmpty()) {
			throw new UserNotFoundException("User not found with id: " + id);
		}else {
			return optionalPerson;
		}
	}

	@Override
	public void deleteById(Integer id) {
		personRepository.deleteById(id);
	}

	@Override
	public Optional<Person> findByUsername(String username) {
		return personRepository.findByUsername(username);
	}
	
	
}
