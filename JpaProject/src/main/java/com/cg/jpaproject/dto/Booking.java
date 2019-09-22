package com.cg.jpaproject.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	private LocalDate dateOfJourney;
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	@OneToMany(cascade = CascadeType.MERGE,mappedBy = "booking")
	private List<Passenger> passengers;
	private String modeOfPayment;
	private Double totalCost;
	@ManyToOne
	@JoinColumn
	private BusTransaction transaction;
	

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer bookingId, LocalDate dateOfJourney, Bus bus, List<Passenger> passengers,
			String modeOfPayment, Double totalCost) {
		super();
		this.bookingId = bookingId;
		this.dateOfJourney = dateOfJourney;
		this.bus = bus;
		this.passengers = passengers;
		this.modeOfPayment = modeOfPayment;
		this.totalCost = totalCost;
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
	

	public BusTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(BusTransaction transaction) {
		this.transaction = transaction;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", dateOfJourney=" + dateOfJourney + ", bus=" + bus + ", passengers="
				+ passengers + ", modeOfPayment=" + modeOfPayment + ", totalCost=" + totalCost + "]";
	}
	
	
}
