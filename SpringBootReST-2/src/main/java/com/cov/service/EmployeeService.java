
package com.cov.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.repo.EmployeeRepo;

@Service
public class EmployeeService {
	Logger logger = Logger.getLogger(EmployeeService.class);

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> findAll() {
		List<Employee> employee = new ArrayList<Employee>();
		return employeeRepo.findAll();

	}

	public Employee findById(int id) throws InvalidEmployeeIdException {
		logger.info("Finding employee with ID :" + id);
		Optional<Employee> empOptional = employeeRepo.findById(id);
		if (!empOptional.isPresent()) {
			logger.debug("Employee not found with id :" + id);
			InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
					"Employee not found");
			logger.warn(invalidEmployeeIdException);
			throw new InvalidEmployeeIdException("Employee Id "+id+" not existing in repository");
		}
		return empOptional.get();

	}

	public Employee save(Employee employee) {
		logger.info("Saving employee with ID :"+employee);
		logger.debug("Employee not found with id :" + employee);
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
				"Employee not found");
		logger.warn(invalidEmployeeIdException);
		
		return employeeRepo.save(employee);

	}

	public Employee update(Employee employee) throws InvalidEmployeeIdException {
		logger.info("Update employee with ID : " + employee);
		Optional<Employee> empOptional = employeeRepo.findById(employee.getId());
		if (!empOptional.isPresent()) {
			logger.debug("Employee not found with ID" + employee);
			InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
					"Employee not found");
			logger.warn(invalidEmployeeIdException);
			throw new InvalidEmployeeIdException("Employee Id"+employee.getId()+"not existing in reposiotory");
		}
		return employeeRepo.save(employee);
	}

	public Employee delete(int id) throws InvalidEmployeeIdException {
		logger.info("Delete employee with ID :" + id);
		Optional<Employee> empOptional = employeeRepo.findById(id);
		if (!empOptional.isPresent()) {
			logger.debug("Employee not found with ID :" + id);
			InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
					"Employee not found");
			logger.warn(invalidEmployeeIdException);
			throw new InvalidEmployeeIdException("Employee Id" + id+ "not existing in repository");
		}
		Employee employee = empOptional.get();
		System.out.println("delete id in service : " + id);
		System.out.println("delete employee in service : " + employee);
		employeeRepo.deleteById(id);
		return employee;
	}

	public List<Employee> findAllByDeptno(int deptno) throws InvalidDepartmentIdException {
		logger.info("Finding Department number :" +deptno);
		List<Employee> employee = employeeRepo.findAllEmployeeDeptno(deptno);
		if (employee.isEmpty()) {
			throw new InvalidDepartmentIdException("Department Id " + deptno + "not existing in repository");
		}

		return employee;

	}

}
