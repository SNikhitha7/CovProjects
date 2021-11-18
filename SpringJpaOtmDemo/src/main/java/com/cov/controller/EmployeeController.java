package com.cov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.DepartmentService;
import com.cov.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "regEmp", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView modelAndView = new ModelAndView("regEmp", "employee", new Employee());
		modelAndView.addObject("departmentService", departmentService);
		return modelAndView;

	}

	@RequestMapping(value = "regEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) throws InvalidEmployeeIdException {
		ModelAndView modelAndView = new ModelAndView("savedEmployee");
		modelAndView.addObject("employee", employeeService.save(employee));
		return modelAndView;
	}

	@RequestMapping("getEmp")
	public ModelAndView findEmployee() {

		ModelAndView modelAndView = new ModelAndView("showEmployee", "emps", employeeService.findAll());

		return modelAndView;
	}

	@RequestMapping(value = "editEmp", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam int id) throws InvalidEmployeeIdException {
		Employee empToEdit = employeeService.findById(id);
		ModelAndView modelAndView = new ModelAndView("editEmp", "empToEdit", empToEdit);
		return modelAndView;
	}

	@RequestMapping(value = "updateEmp", method = RequestMethod.POST)
	public ModelAndView updateEmpe(@ModelAttribute("empToEdit") Employee employee)
			throws InvalidEmployeeIdException {
		employeeService.update(employee);
		ModelAndView modelAndView = new ModelAndView("redirect:getEmp");

		return modelAndView;

	}

	@RequestMapping(value = "deleteEmp")
	public ModelAndView deleteEmp(@RequestParam int id) throws InvalidEmployeeIdException {
		employeeService.delete(id);
		ModelAndView modelandview = new ModelAndView("redirect:getEmp");
		return modelandview;
	}
}
