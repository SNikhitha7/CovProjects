package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Department;

import com.cov.exception.InvalidDepartmentIdException;
import com.cov.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepo departmentRepo;

	public List<Department> findAll() {
// List<Employee> employee=new ArrayList<Employee>();
		return departmentRepo.findAll();
// return employee;

	}

	public Department findById(int id) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepo.findById(id);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + " not existing in repository");
		}
		return deptOptional.get();

	}

	public Department save(Department department) {

		return departmentRepo.save(department);

	}

	public Department update(Department department) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepo.findById(department.getId());
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException(
					"Department Id" + department.getId() + "not existing in reposiotory");
		}
		return departmentRepo.save(department);
	}

	public Department delete(int id) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepo.findById(id);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + "not existing in repository");
		}
		Department department = deptOptional.get();
		departmentRepo.deleteById(id);
		return department;
	}
}