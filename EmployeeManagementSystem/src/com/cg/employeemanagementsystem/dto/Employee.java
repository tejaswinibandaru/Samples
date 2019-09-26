package com.cg.employeemanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {
	private Integer empId;
	private String empName;
	private Double empSalary;
	private String designation;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empId, String empName, Double empSalary, String designation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.designation = designation;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", designation="
				+ designation + "]";
	}
	
	
}
