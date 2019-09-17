package com.cg.databaseproj.ems.dao;

import java.util.List;

import com.cg.databaseproj.ems.exception.EmployeeException;
import com.cg.databaseproj.ems.model.Employee;

public interface IEmployeeDao {
	public Employee addEmployee(Employee employee) throws EmployeeException;
	public List<Employee> listAllEmployees() throws EmployeeException;
	
}
