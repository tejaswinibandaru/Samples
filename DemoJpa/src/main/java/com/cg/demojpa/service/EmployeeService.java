package com.cg.demojpa.service;

import java.util.List;

import com.cg.demojpa.dto.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);
	public List<Employee> showAll();
	public void removeEmployee(Integer empId);
	public Employee getEmployeeById(Integer empId);
	public List<Employee> getEmployeesBySalary(Double minimum, Double maximum);
}
