package com.capgemini.busreservation.dto;

import java.math.BigInteger;
import java.util.Set;

public class Admin extends User {

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(BigInteger userId, String userName, String password, Character userType, String email,
			BigInteger phoneNumber, Set<Booking> bookingsList, Set<Bus> busList, Set<Transaction> transactionsList) {
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
		return "Admin [getUserId()=" + getUserId() + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getUserType()=" + getUserType() + ", getEmail()=" + getEmail()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getBookingsList()=" + getBookingsList()
				+ ", getBusList()=" + getBusList() + ", getTransactionsList()=" + getTransactionsList()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ "]";
	}
	
	

}
