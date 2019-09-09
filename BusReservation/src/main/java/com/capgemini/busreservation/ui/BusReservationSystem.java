package com.capgemini.busreservation.ui;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.busreservation.dto.Booking;
import com.capgemini.busreservation.dto.Bus;
import com.capgemini.busreservation.exception.BusException;
import com.capgemini.busreservation.service.AdminService;
import com.capgemini.busreservation.service.AdminServiceImpl;
import com.capgemini.busreservation.service.CustomerService;
import com.capgemini.busreservation.service.CustomerServiceImpl;

public class BusReservationSystem {
	
	public static void printAdminMenu() {
		System.out.println("1. Add bus");
		System.out.println("2. Remove bus");
		System.out.println("3. Update bus");
		System.out.println("4. Search bus");
		System.out.println("5. View buses");
		System.out.println("6. Get transactions by date");
	}
	
	public static void printCustomerMenu() {
		System.out.println("1.Book ticket");
		System.out.println("2.Cancel ticket");
		System.out.println("3.View Tickets");
		System.out.println("4.View Ticket By Date");
	}
	
	public static void main(String[] args) {
		
		AdminService adminService=new AdminServiceImpl();
		CustomerService customerService=new CustomerServiceImpl();
		//Assuming that we have one admin
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Login as: ");
		System.out.println("1. Admin");
		System.out.println("2.Customer");
		int choice = scanner.nextInt();
		
		int n=1;
		if(choice == 1) {
			while(n!=0) {
				printAdminMenu();
				System.out.println("Enter your choice: ");
				int admin_choice=scanner.nextInt();
				switch(admin_choice) {
				case 1:
					Bus bus=new Bus();
					System.out.println("Enter bus id: ");
					BigInteger busId=scanner.nextBigInteger();
					bus.setBusId(busId);
					System.out.println("Enter bus name");
					String busName=scanner.next();
					bus.setBusName(busName);
					System.out.println("Enter the bus type");
					String busType=scanner.next();
					try {
						if(!busType.equalsIgnoreCase("sleeper")||!busType.equalsIgnoreCase("semi-sleeper")) {
							throw new BusException("The type should be sleeper or semi-Sleeper");
						}
						else {
							bus.setBusType(busType);
						}
						
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception occurred: "+e.getMessage());
					}
					
					System.out.println("Enter the bus class");
					String busClass=scanner.next();
					try {
						if(busClass.equalsIgnoreCase("AC")||busClass.equalsIgnoreCase("Non-AC")) {
							throw new BusException("Class should be AC or Non-AC");
						}
						else {
							bus.setBusClass(busClass);
						}
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception occurred: "+e.getMessage());
					}
					
					System.out.println("Enter the no of seats in the bus: ");
					int noOfSeats=scanner.nextInt();
					
					bus.setNoOfSeats(noOfSeats);
					
					System.out.println("Enter the no of days of the week on which day the bus will run");
					int noOfDays=scanner.nextInt();
					Set<DayOfWeek> days=new HashSet<DayOfWeek>();
					for(int i=0;i<noOfDays;i++) {
						System.out.println("Enter the day number starting from 1(Monday) to 7(Sunday): ");
						int day=scanner.nextInt();
						try {
							if(day<1 && day>7) {
								throw new BusException("Invalid day");
							}
							else {
								days.add(DayOfWeek.of(day));
							}
							
						}catch (Exception e) {
							// TODO: handle exception
							System.out.println("Exception occurred: "+e.getMessage());
						}
					}
					bus.setDayOfJourney(days);
					
					System.out.println("Enter the source: ");
					String source=scanner.next();
					bus.setSource(source);
					
					System.out.println("Enter the destination: ");
					String destination=scanner.next();
					bus.setDestination(destination);
					
					System.out.println("Enter the cost of the seat: ");
					double cost=scanner.nextDouble();
					bus.setCost(cost);
					
					System.out.println(adminService.addBus(bus));
					
					break;
					
				case 2:
					System.out.println("Enter the bus id to remove");
					busId=scanner.nextBigInteger();
					if(adminService.removeBus(busId)==0) {
						System.out.println("No bus with bus id " + busId + "is found");
					}
					else {
						System.out.println("Bus details with bus id "+ busId+ " is removed successfully");
					}
					break;
				case 3:
					System.out.println("Enter the bus id to update details: ");
					busId=scanner.nextBigInteger();
					bus=adminService.updateBus(busId);
					if(bus!=null) {
						System.out.println("No bus with id "+busId+" is found");
					}else {
						System.out.println(adminService.updateBus(busId));
					}
					break;
				case 4:
					System.out.println("Enter the bus id to search: ");
					busId=scanner.nextBigInteger();
					bus=adminService.searchBus(busId);
					if(bus==null) {
						System.out.println("No bus with id "+busId+ " is found");
					}else {
						System.out.println(bus);
					}
					break;
				case 5:
					System.out.println("List Of buses");
					for(Bus b:adminService.viewBuses()) {
						System.out.println("Bus Id: "+b.getBusId());
						System.out.println("Bus name: "+b.getBusName());
						System.out.println("Bus Type: "+b.getBusType());
						System.out.println("Bus Class: "+b.getBusClass());
						System.out.println("Number of seats: "+b.getNoOfSeats());
						System.out.println("Day Of Journey: "+b.getDayOfJourney());
						System.out.println("Source: "+b.getSource());
						System.out.println("Destination: "+b.getDestination());
						System.out.println("Cost: "+b.getCost());
						System.out.println("------------------------------------------------------------");
					}
					break;
				default:
					break;
				}
				System.out.println("Press 1 to continue, 0 to stop");
				n=scanner.nextInt();
			}
			
		}
		else if(choice==2) {
			n=1;
			while(n!=0) {
				printCustomerMenu();
				System.out.println("Enter your choice: ");
				int customer_choice=scanner.nextInt();
				switch(customer_choice) {
				case 1:
					Booking booking=null;
					customerService.bookTicket(booking);
					break;
				case 2:
					booking=null;
					customerService.cancelTicket(booking);
					break;
				case 3:
					customerService.viewTicketList();
					break;
				case 4:
					customerService.viewTicket(LocalDate.now());
					break;
				default:
					break;	
				}
				System.out.println("Press 1 to continue, 0 to stop");
				n=scanner.nextInt();
			}
			
			
		}
		else {
			System.out.println("Invalid user");
		}
		
		scanner.close();
		
	}

}
