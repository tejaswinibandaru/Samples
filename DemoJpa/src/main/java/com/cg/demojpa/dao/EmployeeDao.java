package com.cg.demojpa.dao;

import java.util.List;

import com.cg.demojpa.dto.Employee;

public interface EmployeeDao {
	public Employee save(Employee emp);
	public Employee findById(Integer empId);
	public List<Employee> findAll();
	public void remove(Integer emp);
	public List<Employee> findBySalary(Double min,Double max);

}
