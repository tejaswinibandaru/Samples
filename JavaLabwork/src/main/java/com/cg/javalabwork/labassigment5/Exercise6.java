package com.cg.javalabwork.labassigment5;

import java.util.Scanner;

import com.cg.eis.exception.EmployeeException;

public class Exercise6 {
	public static double validateSalary(double salary) throws EmployeeException {
		if(salary<3000) {
			throw new EmployeeException("Salary should not be less than 3000");
		}else {
			System.out.println("Your salary need not to be incremented!!");
		}
		return salary;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your salary: ");
		double empSalary=scanner.nextDouble();
		try {
			validateSalary(empSalary);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occurred: "+e.getMessage());
		}
	}
}
