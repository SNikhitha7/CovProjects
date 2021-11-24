
package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cov.beans.Person;
import com.cov.exception.InvalidPersonIdException;
import com.cov.repo.PersonRepo;

@Service
public class PersonService {
	Logger logger = Logger.getLogger(PersonService.class);
	@Autowired
	PersonRepo personRepo;

	public List<Person> findAll() {
		return personRepo.findAll();
	}

	public Person findById(int id) throws InvalidPersonIdException {
		logger.info("Finding person with ID :" +id);
		Optional<Person> personOptional = personRepo.findById(id);
		if (!personOptional.isPresent()) {
			logger.debug("Person not found with id" +id);
			InvalidPersonIdException invalidPersonIdException = new InvalidPersonIdException("Person ID not found ");
			logger.warn(invalidPersonIdException);
			throw new InvalidPersonIdException();
		}
		return personOptional.get();
	}

	public Person insert(Person person) {
		return personRepo.save(person);
	}

	public Person update(Person person) throws InvalidPersonIdException {
		logger.info("Update person with ID :" + person);
		Optional<Person> personOptional = personRepo.findById(person.getId());
		if (!personOptional.isPresent()) {
			logger.debug("Person not found with id" +person);
			InvalidPersonIdException invalidPersonIdException = new InvalidPersonIdException("Person  not found ");
			logger.warn(invalidPersonIdException);
			throw new InvalidPersonIdException();
		}
		return personRepo.save(person);
	}

	public Person delete(int id) throws InvalidPersonIdException {
		logger.info("Delete person with ID :" + id);
		Optional<Person> personOptional = personRepo.findById(id);
		if (!personOptional.isPresent()) {
			logger.debug("Person not found with id" +id);
			InvalidPersonIdException invalidPersonIdException = new InvalidPersonIdException("Person ID not found ");
			logger.warn(invalidPersonIdException);
			throw new InvalidPersonIdException();
		}
		Person person = personOptional.get();
		personRepo.deleteById(id);
		return person;
	}
}
