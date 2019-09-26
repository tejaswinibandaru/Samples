package com.cg.javalabwork.labassigment5;

import java.util.Scanner;

import com.cg.eis.exception.NameException;

public class Exercise4 {
	public static String validateFullName(String firstName, String lastName) throws NameException {
		if(firstName.equals("") && lastName.equals("")) {
			throw new NameException("First name and Last name shouldn't be empty");
		}
		return firstName+" "+lastName;
		
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your firstName: ");
		String firstName=scanner.next("\\S");
		System.out.println("Enter your lastName: ");
		String lastName=scanner.next("\\S");
		try {
			System.out.println("Your full name is"+validateFullName(firstName, lastName));
		} catch (NameException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occurred: "+e.getMessage());
		}
	}
}
