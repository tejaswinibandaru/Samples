package com.capgemini.busreservation.dto;

import java.math.BigInteger;
import java.util.Set;

public class Customer extends User {

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(BigInteger userId, String userName, String password, Character userType, String email,
			BigInteger phoneNumber, Set<Booking> bookingsList, Set<Bus> busList, Set<BusTransaction> transactionsList) {
		super(userId, userName, password, userType, email, phoneNumber, bookingsList, busList, transactionsList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [getUserId()=" + getUserId() + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getUserType()=" + getUserType() + ", getEmail()=" + getEmail()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getBookingsList()=" + getBookingsList()
				+ ", getBusList()=" + getBusList() + ", getTransactionsList()=" + getTransactionsList()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
	
	

}
