package com.cg.jpaproject.service;

import java.util.List;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;

public interface UserService {
	public Bus addBusDetails(Bus bus);
	public List<Bus> viewAllBuses();
	
	public Booking createBooking(Booking booking);
	public List<Booking> viewAllBookings();
	public BusTransaction addTransaction(BusTransaction transaction);
}
