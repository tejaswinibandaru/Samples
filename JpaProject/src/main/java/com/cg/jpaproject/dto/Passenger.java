package com.cg.jpaproject.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Passenger {
	
	@Id
	private Integer passengerId;
	private String passengerName;
	private Integer passengerAge;
	private Character passengerGender;
	
	static int passsengerStaticId=1;
	
	public Passenger() {
		// TODO Auto-generated constructor stub
		passengerId = passsengerStaticId++;
	}

	public Passenger(Integer passengerId, String passengerName, Integer passengerAge, Character passengerGender) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public Character getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(Character passengerGender) {
		this.passengerGender = passengerGender;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerGender=" + passengerGender + "]";
	}
	
}
