package com.cg.demojpa.ui;

import java.util.Scanner;

import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.service.EmployeeService;
import com.cg.demojpa.service.EmployeeServiceImpl;

public class EmployeeMain {
	
	public static void printMenu() {
		System.out.println("--------------------------------------------------");
		System.out.println("1.Add Employee");
		System.out.println("2.Delete Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("4.View all employees");
		System.out.println("5.Find employees by salary");
		System.out.println("---------------------------------------------------");
		System.out.println("Enter your choice");
		
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		EmployeeService es=new EmployeeServiceImpl();
		int runLoop=1;
		while(runLoop != 0) {
			printMenu();
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("------------------------------------------");
				Employee emp=new Employee();
				
				System.out.println("Enter emp Id: "); 
				int id=scanner.nextInt();
				
				System.out.println("Enter emp name: "); 
				String name=scanner.next();
				
				System.out.println("Enter emp salary: "); 
				double salary=scanner.nextDouble();
				
				emp.setEmpId(id); 
				emp.setEmpName(name); 
				emp.setEmpSalary(salary);
				
				System.out.println(es.addEmployee(emp));
				System.out.println("----------------------------------------------");
				break;
			case 2:
				System.out.println("----------------------------------------------");
				System.out.println("Enter the id to remove: ");
				id=scanner.nextInt();
				es.removeEmployee(id);
				System.out.println("----------------------------------------------");
				break;
			case 3:
				System.out.println("----------------------------------------------");
				System.out.println("Enter the id to search: ");
				id=scanner.nextInt();
				System.out.println(es.getEmployeeById(id));
				System.out.println("----------------------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------------------");
				System.out.println("List of employees: ");
				for(Employee e:es.showAll()) {
					System.out.println(e);
				}
				System.out.println("----------------------------------------------");
				break;
			case 5:
				System.out.println("----------------------------------------------");
				System.out.println("Enter the range: ");
				double min=scanner.nextDouble();
				double max=scanner.nextDouble();
				for(Employee e: es.getEmployeesBySalary(min, max)) {
					System.out.println(e);
				}
				System.out.println("----------------------------------------------");
				break;
			}
			System.out.println("Press 1 to continue, 0 to exit");
			runLoop=scanner.nextInt();
			
		}
		
		
	}
}
