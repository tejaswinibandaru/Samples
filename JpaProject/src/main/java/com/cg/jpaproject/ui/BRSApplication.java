package com.cg.jpaproject.ui;

import java.util.Scanner;

import com.cg.jpaproject.service.UserService;

public class BRSApplication {
	static UserService userService;
	static int counter = 0;
	static int day_counter=600;
	static int passenger_counter=500;
	static int booking_counter=200;
	static int transaction_counter=100;
	
	static void printMainMenu() {
		System.out.println("----------------------------Welcome To Bus Reservation System----------------------------");
		Scanner scanner=new Scanner(System.in);
		int runLoop=1;
		while(runLoop!=0) {
			int choice;
			while (true) {
				System.out.println("---------------------------------------------------------------");
				System.out.println("Select 1 for Admin");
				System.out.println("Select 2 for Customer");
				System.out.println("Select 3 to Exit");
				System.out.println("---------------------------------------------------------------");
				System.out.println("Enter your choice:");
				System.out.println("---------------------------------------------------------------");
				choice=scanner.nextInt();
			}
		}
	}
}
