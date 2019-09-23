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
	private BusTransaction busTransaction;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private String bookingStatus;
	private Integer deleteFlag;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer bookingId, LocalDate dateOfJourney, Bus bus, List<Passenger> passengers,
			String modeOfPayment, Double totalCost, BusTransaction busTransaction, User user, String bookingStatus,
			Integer deleteFlag) {
		super();
		this.bookingId = bookingId;
		this.dateOfJourney = dateOfJourney;
		this.bus = bus;
		this.passengers = passengers;
		this.modeOfPayment = modeOfPayment;
		this.totalCost = totalCost;
		this.busTransaction = busTransaction;
		this.user = user;
		this.bookingStatus = bookingStatus;
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", dateOfJourney=" + dateOfJourney + ", bus=" + bus + ", passengers="
				+ passengers + ", modeOfPayment=" + modeOfPayment + ", totalCost=" + totalCost + ", busTransaction="
				+ busTransaction + ", user=" + user + ", bookingStatus=" + bookingStatus + ", deleteFlag=" + deleteFlag
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((bookingStatus == null) ? 0 : bookingStatus.hashCode());
		result = prime * result + ((bus == null) ? 0 : bus.hashCode());
		result = prime * result + ((dateOfJourney == null) ? 0 : dateOfJourney.hashCode());
		result = prime * result + ((deleteFlag == null) ? 0 : deleteFlag.hashCode());
		result = prime * result + ((modeOfPayment == null) ? 0 : modeOfPayment.hashCode());
		result = prime * result + ((passengers == null) ? 0 : passengers.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
		result = prime * result + ((busTransaction == null) ? 0 : busTransaction.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (bookingStatus == null) {
			if (other.bookingStatus != null)
				return false;
		} else if (!bookingStatus.equals(other.bookingStatus))
			return false;
		if (bus == null) {
			if (other.bus != null)
				return false;
		} else if (!bus.equals(other.bus))
			return false;
		if (dateOfJourney == null) {
			if (other.dateOfJourney != null)
				return false;
		} else if (!dateOfJourney.equals(other.dateOfJourney))
			return false;
		if (deleteFlag == null) {
			if (other.deleteFlag != null)
				return false;
		} else if (!deleteFlag.equals(other.deleteFlag))
			return false;
		if (modeOfPayment == null) {
			if (other.modeOfPayment != null)
				return false;
		} else if (!modeOfPayment.equals(other.modeOfPayment))
			return false;
		if (passengers == null) {
			if (other.passengers != null)
				return false;
		} else if (!passengers.equals(other.passengers))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		if (busTransaction == null) {
			if (other.busTransaction != null)
				return false;
		} else if (!busTransaction.equals(other.busTransaction))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
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
		return busTransaction;
	}

	public void setBusTransaction(BusTransaction busTransaction) {
		this.busTransaction = busTransaction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	
	
	
}
