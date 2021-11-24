package com.cov.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

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
import com.cov.repo.DepartmentRepo;

@TestInstance(Lifecycle.PER_CLASS)
class DepartmentServiceTest {
	@InjectMocks
	DepartmentService departmentService;
	@Mock
	DepartmentRepo departmentRepo;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Department> departments = new ArrayList<>();
		departments.add(new Department(1, "Integrations"));
		departments.add(new Department(2, "Crm"));
		departments.add(new Department(3, "BDA"));
		
		when(departmentRepo.findAll()).thenReturn(departments);
		Department departmentExisting = new Department(2, "Crm");
		when(departmentRepo.findById(2)).thenReturn(Optional.of(departmentExisting));
	}

	@Test
	void testFindAll() {
		List<Department> DeptList = departmentService.findAll();
		assertNotNull(DeptList);
		assertEquals(4, DeptList.size());
	}

	@Test
	void testFindById() {
		Department department = departmentRepo.findById(2).get();
		assertNotNull(department);
		assertSame(department.getName(), "integrations");
		assertEquals(department.getId(), 2);
	}

	@Test
	void testSave() {
		Department department=new Department(4,"Productions");
		when(departmentRepo.save(department)).thenReturn(department);
		Department dept = departmentRepo.save(department);
		assertNotNull(dept);
		assertSame(dept.getName(), "productions");
		assertEquals(dept.getId(), 4);
	}

	@Test
	void testUpdate() {
		Department department=new Department(4,"BRM");
		when(( departmentRepo.findById(department.getId()))).thenReturn(Optional.of(department));
		when(departmentRepo.save(department)).thenReturn(department);
		Department dept=departmentRepo.save(department);
		assertNotNull(dept);
		assertSame(dept.getName(), "BRM");
		assertEquals(dept.getId(), 4);
	}


	
}
