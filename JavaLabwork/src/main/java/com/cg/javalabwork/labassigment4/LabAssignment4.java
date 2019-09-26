package com.cg.javalabwork.labassigment4;

import java.util.Scanner;

public class LabAssignment4 {
	
	public static int calculateCubes(int n) {
		int remainder=0;
		int result=0;
		int sum=0;
		while(n!=0) {
			remainder=n%10;
			result=remainder*remainder*remainder;
			sum+=result;
			n=n/10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number=scanner.nextInt();
		int result=calculateCubes(number);
		System.out.println("Cubes of the digit of the given number="+result);
		scanner.close();
	}
}
