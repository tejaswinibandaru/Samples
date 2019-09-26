package com.cg.employeemanagementsystem.service;

import java.util.List;

import com.cg.employeemanagementsystem.dto.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public List<Employee> viewAllEmployees();
	public Employee searchEmployee(Integer empId);
	public Employee updateEmployee(Integer empId);
	public Employee removeEmployee(Integer empId);

}
