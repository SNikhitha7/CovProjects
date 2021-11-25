package com.cov.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/department")
@Api(value = "API to perform operations on department",
     description = "This API provides capability to perform different CRUD operations on department Repository")
public class DepartmentController {
	static Logger logger = Logger.getLogger(DepartmentController.class);
	@Autowired
	DepartmentService departmentService;
	
	@ApiOperation(value = "Search a single department based on the Id given",response = Department.class)
	@GetMapping("/{id}")
	public Department find(@PathVariable int id) throws InvalidDepartmentIdException {
		logger.info("finding a employee with id " + id);
		Department department = departmentService.findById(id);
		logger.info("employee found with id " + id + " is" + department.getName());
		return department;
	}
	
	
	

	@ApiOperation(value = "Read all department details from repository ", produces = "application/xml")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully retrieved list of employees"),
    @ApiResponse(code = 401,message = "You are not authorized to view the repository"),
    @ApiResponse(code = 403,message = "Accessing the resources you are trying to reach is forbidden"),
    @ApiResponse(code = 404,message = "The resources you were trying to reach is not found") })

	@GetMapping()
	public List<Department> findAll() {
		logger.info("finding all departments");
		return departmentService.findAll();
	}

	
	
	@ApiOperation(value = "Save the department details",produces = "application/xml")
	@PostMapping()
	public Department insert(@RequestBody Department department) {
		logger.info("inserting a department with " + department.getName());
		return departmentService.save(department);
	}
    
	@ApiOperation(value = "Edit the department details",produces = "applicatoon/xml")
	@PutMapping()
	public Department edit(@RequestBody Department department) throws InvalidDepartmentIdException {
		logger.info("editing a department with " + department.getName());
		return departmentService.update(department);
	}
    @ApiOperation(value = "Delete the single department based on the ID given",produces= "application/xml")
	@DeleteMapping("/{id}")
	public Department delete(@PathVariable int id) throws InvalidDepartmentIdException {
		logger.info("deleting a department with id " + id);
		return departmentService.delete(id);
	}
}
