package com.cg.eis.pl;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class MainApplication {
	public static void main(String[] args) {
		EmployeeService employeeService=new EmployeeServiceImpl();
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Haribabu");
		employee.setSalary(60000);
		employee.setDesignation();
		
		employee=employeeService.getEmployeeDetails(employee);
		employee.setInsuranceScheme(employeeService.getEmployeeInsuranceScheme(employee));
		employeeService.printEmployeeDetails(employee);
	}
}
