package com.capgemini.lesson2;

public class Balance {
	private String custName ;
	private double balance;
	public Balance(String name, double d) {
		custName=name;
		balance=d;
	}

	public void show() {
		System.out.println(custName+" " +balance);
	}

}
