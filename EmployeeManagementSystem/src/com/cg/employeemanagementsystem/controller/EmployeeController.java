package com.cg.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.employeemanagementsystem.dto.Employee;
import com.cg.employeemanagementsystem.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	@RequestMapping(value = "/add_employee",method = RequestMethod.GET)
	public String addEmployee(@ModelAttribute("employee_details") Employee employee) {
		return "addEmployee";
	}
	@RequestMapping(value = "/pagesubmit",method=RequestMethod.POST)
	public String addEmployeeData(@ModelAttribute("employee_details") Employee employee) {
		System.out.println(employeeservice.addEmployee(employee));
		return "home";
	}
	@RequestMapping(value="/view_all",method = RequestMethod.GET)
	public ModelAndView showAllEmployees() {
		List<Employee> employees=employeeservice.viewAllEmployees();
		System.out.println(employees);
		return new ModelAndView("viewAllEmployee", "employeedata", employees);
	}
	
	@RequestMapping(value="/search_employee",method = RequestMethod.GET)
	public String searchEmployee(Integer empId) {
		return "searchEmployee";
	}
	
	@RequestMapping(value="/searchdata", method=RequestMethod.POST)
	public ModelAndView searchData(@RequestParam("empId") Integer empId) {
		Employee employee=employeeservice.searchEmployee(empId);
		System.out.println(employee);
		return new ModelAndView("searchEmployee", "data", employee);
	}
	

}
