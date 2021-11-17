
	package com.cov.service;

	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.repo.EmployeeRepo;

	@Service
	public class EmployeeService {

		@Autowired
		EmployeeRepo employeeRepo;

		public List<Employee> findAll() {
//			List<Employee> employee=new ArrayList<Employee>();
			return employeeRepo.findAll();
//			return employee;

		}

		public Employee findById(int id) throws InvalidEmployeeIdException{
			Optional<Employee> empOptional=employeeRepo.findById(id);
			if(!empOptional.isPresent()) {
			throw new InvalidEmployeeIdException("Employee Id "+id+" not existing in repository");
			}
			return empOptional.get();

			}
		public Employee save(Employee employee) throws InvalidEmployeeIdException{

			return employeeRepo.save(employee);

			}
		public Employee update(Employee employee) throws InvalidEmployeeIdException{
			Optional<Employee> empOptional=employeeRepo.findById(employee.getId());
			if(!empOptional.isPresent()) {
			throw new InvalidEmployeeIdException("Employee Id"+employee.getId()+"not existing in reposiotory");
			}
			return employeeRepo.save(employee);
			}
		public Employee delete(int id) throws InvalidEmployeeIdException {
			Optional<Employee> empOptional = employeeRepo.findById(id);
			if (!empOptional.isPresent()) {
				throw new InvalidEmployeeIdException("Employee Id" + id+ "not existing in repository");
			}
			Employee employee = empOptional.get();
			employeeRepo.deleteById(id);
			return employee;
		}


	}



