package com.cov.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cov.beans.Department;
import com.cov.beans.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	void save(Department department);

}
