package com.cg.demojpa.ui;

import java.util.Date;

import com.cg.demojpa.dto.Department;
import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.dto.Project;
import com.cg.demojpa.service.EmployeeService;
import com.cg.demojpa.service.EmployeeServiceImpl;

public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Department dept=new Department();
		dept.setDeptId(10);
		dept.setDeptName("java");
		
		Project proj=new Project();
		proj.setProjId(201);
		proj.setProjName("EMS");
		proj.setProjCost(3000.0);
		
		Project proj2=new Project();
		proj.setProjId(202);
		proj.setProjName("HMS");
		proj.setProjCost(3000.0);
		
		Employee emp=new Employee();
		emp.setEmpId(102);
		emp.setEmpName("hari");
		emp.setDateOfJoining(new Date());
		emp.setEmpSalary(50000.0);
		emp.setProject(proj);
		emp.setDept(dept);
		
		Employee emp2=new Employee();
		emp.setEmpId(103);
		emp.setEmpName("tejaswini");
		emp.setDateOfJoining(new Date());
		emp.setEmpSalary(50000.0);
		emp.setProject(proj2);
		emp.setDept(dept);
		
		EmployeeService es=new EmployeeServiceImpl();
		System.out.println(es.addEmployee(emp));
		System.out.println(es.addEmployee(emp2));
	}

}
