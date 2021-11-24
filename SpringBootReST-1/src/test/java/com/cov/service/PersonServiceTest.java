package com.cov.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cov.beans.Person;
import com.cov.repo.PersonRepo;
@TestInstance(Lifecycle.PER_CLASS)
class PersonServiceTest {
	
	@InjectMocks
	PersonService personService;
	
	@Mock
	PersonRepo personRepo;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Person> persons = new ArrayList<>();
		persons .add(new Person(1,"Sai","Dharam"));
		persons .add(new Person(2,"Teja","Kumari"));
		persons .add(new Person(3,"Vicky","Kaushal"));
		List<Person> personList = personService.findAll();
		
		when(personRepo.findAll()).thenReturn(persons);
		when(personRepo.findById(2)).thenReturn(Optional.of(persons.get(2)));
		
		
	}

	@Test
	void testFindAll() {
		List<Person> personList = personService.findAll();
		assertNotNull(personList);
		assertEquals(3, personList.size());
		
	}

	@Test
	void testFindById() {
		Person personExisting = new Person(2,"Teja","Kumari");
		when(personRepo.findById(2)).thenReturn(Optional.of(personExisting));
		
		Person person = personRepo.findById(2).get();
		assertNotNull(person);
		assertSame(person.getFirstName(),"Teja");
		assertEquals(person.getId(), 2);
		
	}

	@Test
	void testInsert() {
		
	
		Person person= new Person(4, "Nish","Hanth");
		when(personRepo.save(person)).thenReturn(person);
		Person per = personRepo.save(person);
		assertNotNull(per);
		assertSame(per.getFirstName(), "Nish");
		assertEquals(per.getId(), 4);

		}
		
	
	

	@Test
	void testUpdate() {
		
		Person personUpdate=new Person(4,"Shyam","Sundhar");
		when(( personRepo.findById(personUpdate.getId()))).thenReturn(Optional.of(personUpdate));
		when(personRepo.save(personUpdate)).thenReturn(personUpdate);
		Person per=personRepo.save(personUpdate);
		assertNotNull(per);
		assertSame(per.getFirstName(), "Shyam");
		assertEquals(per.getId(), 4);
		}
		
		
	
	}
//
//	@Test
//	void testDelete() {
//		Person personDeleting = new Person(2,"Teja","Kumari");
//		when(personRepo.deleteById(1)).thenReturn(Optional.of(personDeleting));
//		assertNotNull(personList);
//		
//		
//	}


