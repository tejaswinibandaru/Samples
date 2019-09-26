package com.cg.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeemanagementsystem.dao.EmployeeDao;
import com.cg.employeemanagementsystem.dto.Employee;

@Service("employeeservice")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeedao;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeedao.addEmployee(employee);
	}

	@Override
	public List<Employee> viewAllEmployees() {
		// TODO Auto-generated method stub
		return employeedao.viewAllEmployees();
	}

	@Override
	public Employee searchEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee removeEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
