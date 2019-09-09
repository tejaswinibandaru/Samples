package com.capgemini.busreservation.dao;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.busreservation.dto.Bus;
import com.capgemini.busreservation.dto.Transaction;

public class AdminDaoImpl implements AdminDao{
	
	Set<Bus> busList=new HashSet<Bus>();
	Set<Transaction> transactionList=new HashSet<Transaction>();

	public Bus addBus(Bus b) {
		// TODO Auto-generated method stub
		busList.add(b);
		return b;
	}

	public Integer removeBus(BigInteger busId) {
		// TODO Auto-generated method stub
		for(Bus b:busList) {
			if(b.getBusId()==busId) {
				busList.remove(b);
				return 1;
			}
		}
		return 0;
	}

	public Bus updateBus(BigInteger busId) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		for(Bus b: busList) {
			if(b.getBusId()==busId) {
				System.out.println("1.Update day of journey");
				System.out.println("2.Update cost per seat");
				System.out.println("Enter your choice to update bus details: ");
				int choice= sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter the day to add: ");
					int day=sc.nextInt();
					b.getDayOfJourney().add(DayOfWeek.of(day));
					System.out.println("Data updated successfully");
					return b;
				case 2:
					System.out.println("Enter the cost: ");
					double cost=sc.nextDouble();
					b.setCost(cost);
					System.out.println("Data updated successfully");
					return b;
				default:
					System.out.println("Invalid option");
					return b;
				}
			}
		}
		return null;
	}

	public Bus searchBus(BigInteger busId) {
		// TODO Auto-generated method stub
		for(Bus b:busList) {
			if(b.getBusId()==busId) {
				return b;
			}
		}
		return null;
	}

	public Set<Bus> viewBuses() {
		// TODO Auto-generated method stub
		return busList;
	}

	public Set<Transaction> getTransactionByDate(LocalDate d) {
		// TODO Auto-generated method stub
		return null;
	}

}
