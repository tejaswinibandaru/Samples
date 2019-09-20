package com.cg.demojpa.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String city;
	private String state;
	private Integer pinCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String state, Integer pinCode) {
		super();
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	
	

}
