package com.cg.jpaproject.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;

public interface UserService {
	public Bus addBusDetails(Bus bus);
	public List<Bus> viewAllBuses();
	public List<Bus> viewBusByDay(LocalDate date);
	public List<Object[]> viewBusByRoutes(String source,String destination);
	
	public Booking createBooking(Booking booking);
	public List<Booking> viewAllBookings();
	public BusTransaction addTransaction(BusTransaction transaction);
}
