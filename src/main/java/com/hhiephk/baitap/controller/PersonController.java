package com.hhiephk.baitap.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhiephk.baitap.exception.UserNotFoundException;
import com.hhiephk.baitap.model.entity.Person;
import com.hhiephk.baitap.model.payload.request.PersonRequest;
import com.hhiephk.baitap.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/allPerson")
	public List<Person> getAllPerson(){
		return personService.findAll();
	}
	
	@GetMapping("/getInfo/{id}")
	public ResponseEntity<Person> getInfoPerson(@PathVariable int id) throws UserNotFoundException{
//		return personService.findById(id).get();
		return new ResponseEntity<>(personService.findById(id).get(), HttpStatus.OK);
	}
	
//	@PostMapping("/addNewPerson")
//	public Person addNewPerson(@RequestBody PersonRequest personRequest) {
//		Person person = new Person();
//		BeanUtils.copyProperties(personRequest, person);
//		
//		personService.save(person);
//		return person;
//	}
	
	@PutMapping("/editPerson")
	public Person editPerson(@RequestBody PersonRequest personRequest) {
		Person person = new Person();
		BeanUtils.copyProperties(personRequest, person);
		
		personService.save(person);
		return person;
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public String deletePerson(@PathVariable int id) {
		personService.deleteById(id);
		return "Delete Success";
	}
	
}
