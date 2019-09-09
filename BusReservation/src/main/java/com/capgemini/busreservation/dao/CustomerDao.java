package com.capgemini.busreservation.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.capgemini.busreservation.dto.Booking;
import com.capgemini.busreservation.dto.Passenger;

public interface CustomerDao {
	
	public Integer bookTicket(Booking booking);
	public List<Booking> viewTicket(LocalDate date);
	public Integer cancelTicket(Booking b);
	public List<Booking> viewTicketList();
	public Set<Passenger> addPassenger(Passenger passenger);
	public Set<Passenger> viewPassengers();
	public Double calculateCost();

}
