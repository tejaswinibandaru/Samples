package com.cg.eis.service;


import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	public Employee getEmployeeDetails(Employee employee) {
		return employee;

	}

	public String getEmployeeInsuranceScheme(Employee employee) {
		if(employee.getSalary() > 5000 && employee.getSalary() < 20000 && employee.getDesignation().equalsIgnoreCase("System Associate")) {
			return "Scheme C";
		}
		else if(employee.getSalary() >= 20000 && employee.getSalary() < 40000 && employee.getDesignation().equalsIgnoreCase("Programmer")) {
			return "Scheme B";
		}
		else if(employee.getSalary() >= 40000 && employee.getDesignation().equalsIgnoreCase("Manager")) {
			return "Scheme A";
		}
		else {
			return "No scheme";
		}
	}

	public void printEmployeeDetails(Employee employee) {
		System.out.println("Employee Id: "+employee.getId());
		System.out.println("Employee Name: "+employee.getName());
		System.out.println("Employee Salary: "+employee.getSalary());
		System.out.println("Employee Designation: "+employee.getDesignation());
		System.out.println("Employee Insurance Scheme:"+employee.getInsuranceScheme());
	}

}
