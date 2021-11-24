package com.cov.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cov.beans.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	Optional<Department> findById(int id);

}
