package com.cg.employeemanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.employeemanagementsystem.dto.Employee;
@Repository("employeedao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	List<Employee> employees=new ArrayList<Employee>();

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employees.add(employee);
		return employee;
	}

	@Override
	public List<Employee> viewAllEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee searchEmployee(Integer empId) {
		// TODO Auto-generated method stub
		for(Employee employee:employees) {
			if(employee.getEmpId()==empId) {
				return employee;
			}
		}
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
