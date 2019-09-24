package com.cg.jpaproject.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BusTransaction {
	@Id
	private Integer transactionId;
	@Column
	private LocalDate date;
	private Integer availableSeats;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Booking booking;
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	private String transactionStatus;
	private Integer deleteFlag;
	
	public BusTransaction() {
		// TODO Auto-generated constructor stub
	}

	public BusTransaction(Integer transactionId, LocalDate date, Integer availableSeats, Booking booking,
			Bus bus, String transactionStatus, Integer deleteFlag) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.availableSeats = availableSeats;
		this.booking = booking;
		this.bus = bus;
		this.transactionStatus = transactionStatus;
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "BusTransaction [transactionId=" + transactionId + ", date=" + date + ", availableSeats="
				+ availableSeats + ", booking=" + booking + ", bus=" + bus + ", transactionStatus="
				+ transactionStatus + ", deleteFlag=" + deleteFlag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((bus == null) ? 0 : bus.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((deleteFlag == null) ? 0 : deleteFlag.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((transactionStatus == null) ? 0 : transactionStatus.hashCode());
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
		BusTransaction other = (BusTransaction) obj;
		if (availableSeats == null) {
			if (other.availableSeats != null)
				return false;
		} else if (!availableSeats.equals(other.availableSeats))
			return false;
		if (booking == null) {
			if (other.booking!= null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (bus == null) {
			if (other.bus != null)
				return false;
		} else if (!bus.equals(other.bus))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (deleteFlag == null) {
			if (other.deleteFlag != null)
				return false;
		} else if (!deleteFlag.equals(other.deleteFlag))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (transactionStatus == null) {
			if (other.transactionStatus != null)
				return false;
		} else if (!transactionStatus.equals(other.transactionStatus))
			return false;
		return true;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking bookings) {
		this.booking = bookings;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	

}
