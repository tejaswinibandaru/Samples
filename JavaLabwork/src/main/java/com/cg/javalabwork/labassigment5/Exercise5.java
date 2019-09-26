package com.cg.javalabwork.labassigment5;

import java.util.Scanner;

class InvalidAgeException extends Exception{

	public InvalidAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
public class Exercise5 {
	
	public static int validateAge(int age) throws InvalidAgeException {
		if(age<=15) {
			throw new InvalidAgeException("Age should be above 15!!");
		}else {
			System.out.println("You are eligible");
		}
		return age;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your age: ");
		int age=scanner.nextInt();
		try {
			System.out.println(validateAge(age));
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occurred: "+e.getMessage());
		}
	}

}
