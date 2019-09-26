package com.cg.javalabwork.labassigment5;

import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("1.Red");
			System.out.println("2.Yellow");
			System.out.println("3.Green");
			
			System.out.println("Enter your choice: ");
			int choice=scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Stop!!");
				break;
				
			case 2:
				System.out.println("Ready....");
				break;
				
			case 3:
				System.out.println("Go!!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}
