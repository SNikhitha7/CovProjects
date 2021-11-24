package com.cov.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cov.beans.Person;
import com.cov.exception.InvalidPersonIdException;
import com.cov.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	static Logger logger = Logger.getLogger(PersonController.class); 
	@Autowired
	PersonService personService;

	
	@GetMapping("/{id}")
	public Person find(@PathVariable int id) throws InvalidPersonIdException {
		logger.info("Finding a person with id :" +id);
		Person person =  personService.findById(id);
		logger.debug("Found person is" + person.getFirstName()+ " " + person.getLastName());
		return personService.findById(id);
	}

	
	@GetMapping()
	public List<Person> findAll() {
		return personService.findAll();
	}

	
	@PostMapping()
	public Person insertPerson(@RequestBody Person person) {
		logger.info("Insering  person with id:" + person);
		logger.debug("Inserted person is" + person.getFirstName() + " " + person.getLastName());
		return personService.insert(person);
	}

	
	@PutMapping()
	public Person edit(@RequestBody Person person) throws InvalidPersonIdException {
		logger.info("Update  person with id:" + person);
		logger.debug("Updated person is" + person.getFirstName() + " " + person.getLastName());
		return personService.update(person);
	}

	
	@DeleteMapping("/{id}")
	public Person delete(@PathVariable int id) throws InvalidPersonIdException {
		logger.info("Deleting  person with id:" + id);
		
		return personService.delete(id);
	}
}