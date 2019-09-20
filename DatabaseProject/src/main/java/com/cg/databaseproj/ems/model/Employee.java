package com.cg.databaseproj.ems.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Employee {
	
	private BigInteger empId;
	private String empName;
	private BigDecimal empSalary;
	
	
	public Employee() {
		
	}


	public Employee(BigInteger empId, String empName, BigDecimal empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}


	public BigInteger getEmpId() {
		return empId;
	}


	public void setEmpId(BigInteger empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public BigDecimal getEmpSalary() {
		return empSalary;
	}


	public void setEmpSalary(BigDecimal empSalary) {
		this.empSalary = empSalary;
	}


	@Override
	public int hashCode() {
		return this.empId.intValue();
	}


	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==obj.hashCode();
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
	

}
