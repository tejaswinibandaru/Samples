package com.cg.javalabwork.labassigment13;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
		String user="admin";
		String pass="adm@123";
		
		Verification verification=(username,password)->{
			if(username.equals(user) && password.equals(pass)) {
				return true;
			}
			return false;
		};
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the username: ");
		String username=scanner.next();
		System.out.println("Enter the password:");
		String password=scanner.next();
		boolean validate=verification.validate(username, password);
		if(validate) {
			System.out.println("Valid username and password");
		}
		else {
			System.out.println("Username and password are incorrect");
		}
	}
}
