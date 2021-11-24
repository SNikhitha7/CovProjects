package com.cov.service;

import static org.junit.jupiter.api.Assertions.*;
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

import com.cov.beans.Department;
import com.cov.beans.Employee;

import com.cov.repo.EmployeeRepo;

@TestInstance(Lifecycle.PER_CLASS)
class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepo employeeRepo;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Employee> employees = new ArrayList<>();
		Department department1 = new Department(1, "Integrations");
		Department department2 = new Department(2, "Crm");
		Department department3 = new Department(3, "BDA");

		employees.add(new Employee(1, "Shinchan", department1));
		employees.add(new Employee(2, "Teja", department2));
		employees.add(new Employee(3, "Vicky", department3));
		List<Employee> employeeList = employeeService.findAll();

		when(employeeRepo.findAll()).thenReturn(employees);
		when(employeeRepo.findById(2)).thenReturn(Optional.of(employees.get(2)));

	}

	@Test
	void testFindAll() {
		List<Employee> employeeList = employeeService.findAll();
		assertNotNull(employeeList);
		assertEquals(3, employeeList.size());
	}

	@Test
	void testFindById() {
		Employee employee = employeeRepo.findById(2).get();
		assertNotNull(employee);
		assertSame(employee.getName(), "Teja");

		assertEquals(employee.getId(), 2);

	}

	@Test
	void testSave() {
		Department department = new Department(1, "Crm");
		Employee employee = new Employee(4, "Suma", department);
		when(employeeRepo.save(employee)).thenReturn(employee);
		Employee emp = employeeRepo.save(employee);
		assertNotNull(emp);
		assertSame(emp.getName(), "Suma");
		assertEquals(emp.getId(), 4);
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		Department department = new Department(3, "BDA");
		Employee employee = new Employee(3, "Shinchan", department);
		when((employeeRepo.findById(employee.getId()))).thenReturn(Optional.of(employee));
		when(employeeRepo.save(employee)).thenReturn(employee);
		Employee emp = employeeRepo.save(employee);
		assertNotNull(emp);
		assertSame(emp.getName(), "Shinchan");
		assertEquals(emp.getId(), 3);
		fail("Not yet implemented");
	}

//     @Test
//     void testDelete() {
//    	 Department department = new Department(3,"BDA");
//    	 Employee employee = new Employee(3,"Shinchan", department);
//    	 when(employeeRepo.deleteById(employee.getId())).thenReturn(Optionl.of(employee));
//    	 assertNotNull(employee);
//    	 assertEquals(employee.getId(), 3);
//     }

}
