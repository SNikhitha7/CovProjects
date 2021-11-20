package com.cov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "regdept", method = RequestMethod.GET)
	public ModelAndView newDepartment() {
		ModelAndView modelAndView = new ModelAndView("regDepartment", "department", new Department());
		return modelAndView;
	}

	@RequestMapping(value = "regdept", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute("department") Department department) {
		System.out.println("XXXXXXXXX Department in DepartmentController - saveDepartment : "+department);
		departmentService.save(department);
		ModelAndView modelAndView = new ModelAndView("redirect:getDept");
		return modelAndView;
	}

	@RequestMapping("getDept")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("showDept", "depts", departmentService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "editDept", method = RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws InvalidDepartmentIdException {
		Department deptToEdit = departmentService.findById(id);
		ModelAndView modelAndView = new ModelAndView("editDept", "deptToEdit", deptToEdit);
		return modelAndView;
	}

	@RequestMapping(value = "updateDept", method = RequestMethod.POST)
	public ModelAndView updateEditDept(@ModelAttribute("deptToEdit") Department department)
			throws InvalidDepartmentIdException {
		departmentService.update(department);
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getDept");
		System.out.println("Employee Updated successfully with id : " + department.getId());
		return modelAndView;
	}

	@RequestMapping(value = "deleteDept")
	public ModelAndView deleteEmp(@RequestParam int id) throws InvalidDepartmentIdException {
		departmentService.delete(id);
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getDept");
		return modelAndView;
	}
}
