package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.repo.DepartmentRepo;

@Service
public class DepartmentService {
	Logger logger = Logger.getLogger(DepartmentService.class);
	@Autowired
	DepartmentRepo departmentRepo;

	public List<Department> findAll() {
		return departmentRepo.findAll();
	}

	public Department findById(int id) throws InvalidDepartmentIdException {
		logger.info("Finding Department with Id :" + id);
		Optional<Department> deptOptional = departmentRepo.findById(id);
		if (!deptOptional.isPresent()) {
			logger.debug("Department not found with ID :" + id);
			InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
					"Department not found");
			logger.warn(invalidDepartmentIdException);
			throw new InvalidDepartmentIdException("Department Id " + id + " not existing in repository");
		}
		return deptOptional.get();

	}

	public Department save(Department department) {

		return departmentRepo.save(department);

	}

	public Department update(Department department) throws InvalidDepartmentIdException {
		logger.info("Update Department with ID :" + department);
		Optional<Department> deptOptional = departmentRepo.findById(department.getId());
		if (!deptOptional.isPresent()) {
			logger.debug("Department not Found with id :" + department);
			InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
					"Department not found");
			logger.warn(invalidDepartmentIdException);
			throw new InvalidDepartmentIdException(
					"Department Id" + department.getId() + "not existing in reposiotory");
		}
		return departmentRepo.save(department);
	}

	public Department delete(int id) throws InvalidDepartmentIdException {
		logger.info("Delete Department with ID :" + id);
		Optional<Department> deptOptional = departmentRepo.findById(id);
		if (!deptOptional.isPresent()) {
			logger.debug("Department not found with ID :" + id);
			InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
					"Department not found");
			logger.warn(invalidDepartmentIdException);
			throw new InvalidDepartmentIdException("Department Id " + id + "not existing in repository");
		}
		Department department = deptOptional.get();
		departmentRepo.deleteById(id);
		return department;
	}

}