package com.cg.jpaproject.ui;

import java.math.BigInteger;
import java.util.Scanner;

import com.cg.jpaproject.service.UserService;
import com.cg.jpaproject.service.UserServiceImpl;

public class BusReservationSystem {
	
	UserService userService=new UserServiceImpl();
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id");
		BigInteger id=scanner.nextBigInteger();
		System.out.println("Enter bus name");
		String name=scanner.next();
		System.out.println("Enter bus type");
		String busType=scanner.next();
		System.out.println("Enter bus class");
		String busClass=scanner.next();
		System.out.println("Enter bus source:");
		String source=scanner.next();
		System.out.println("Enter bus destination:");
		String destination=scanner.next();
		
		
	}

}
