package com.cg.jpaproject.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	private Integer bookingId;
	@Column
	private LocalDate dateOfJourney;
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	@OneToMany(cascade = CascadeType.MERGE,mappedBy = "booking")
	private List<Passenger> passengers;
	private String modeOfPayment;
	private Double totalCost;
	@ManyToOne(cascade =CascadeType.MERGE)
	@JoinColumn(name="transaction_fk")
	private BusTransaction transaction;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	

	public Booking() {
		// TODO Auto-generated constructor stub
	}


	public Booking(Integer bookingId, LocalDate dateOfJourney, Bus bus, List<Passenger> passengers,
			String modeOfPayment, Double totalCost, BusTransaction transaction, User user) {
		super();
		this.bookingId = bookingId;
		this.dateOfJourney = dateOfJourney;
		this.bus = bus;
		this.passengers = passengers;
		this.modeOfPayment = modeOfPayment;
		this.totalCost = totalCost;
		this.transaction = transaction;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", dateOfJourney=" + dateOfJourney + ", bus=" + bus + ", passengers="
				+ passengers + ", modeOfPayment=" + modeOfPayment + ", totalCost=" + totalCost + ", transaction="
				+ transaction + ", user=" + user + "]";
	}


	public Integer getBookingId() {
		return bookingId;
	}


	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}


	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}


	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}


	public List<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}


	public String getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	public Double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}


	public BusTransaction getBusTransaction() {
		return transaction;
	}


	public void setBusTransaction(BusTransaction transaction) {
		this.transaction = transaction;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	
}
