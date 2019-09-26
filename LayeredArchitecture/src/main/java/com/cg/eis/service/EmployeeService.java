package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public interface EmployeeService {
	
	public Employee getEmployeeDetails(Employee employee);
	public String getEmployeeInsuranceScheme(Employee employee);
	public void printEmployeeDetails(Employee employee);

}
