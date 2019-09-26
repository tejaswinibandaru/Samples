package com.cg.employeemanagementsystem.dao;

import java.util.List;

import com.cg.employeemanagementsystem.dto.Employee;

public interface EmployeeDao {
	public Employee addEmployee(Employee employee);
	public List<Employee> viewAllEmployees();
	public Employee searchEmployee(Integer empId);
	public Employee updateEmployee(Integer empId);
	public Employee removeEmployee(Integer empId);
}
