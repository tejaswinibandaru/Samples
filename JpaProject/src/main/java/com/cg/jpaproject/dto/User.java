package com.cg.jpaproject.dto;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	private Integer userId;
	private String username;
	private String pass;
	private Character userType;
	private String email;
	private Integer phoneNumber;
	@OneToMany
	private List<Booking> bookingsList;
	@OneToMany
	private List<BusTransaction> transactionsList;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String username, String pass, Character userType, String email, Integer phoneNumber,
			List<Booking> bookingsList, List<BusTransaction> transactionsList) {
		super();
		this.userId = userId;
		this.username = username;
		this.pass = pass;
		this.userType = userType;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bookingsList = bookingsList;
		this.transactionsList = transactionsList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Character getUserType() {
		return userType;
	}

	public void setUserType(Character userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Booking> getBookingsList() {
		return bookingsList;
	}

	public void setBookingsList(List<Booking> bookingsList) {
		this.bookingsList = bookingsList;
	}

	public List<BusTransaction> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(List<BusTransaction> transactionsList) {
		this.transactionsList = transactionsList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", pass=" + pass + ", userType=" + userType
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", bookingsList=" + bookingsList
				+ ", transactionsList=" + transactionsList + "]";
	}
	
	

}
