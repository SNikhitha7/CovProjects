package com.cov.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cov.beans.Department;
import com.cov.beans.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	//@Query("SELECT  e FROM Employee e where e.department.id =?1")
	List<Employee> findByDepartment(Department department);
}
