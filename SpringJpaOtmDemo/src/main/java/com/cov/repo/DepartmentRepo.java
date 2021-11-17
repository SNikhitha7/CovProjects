package com.cov.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cov.beans.Department;


public interface DepartmentRepo extends JpaRepository<Department, Long> {
	


	}


