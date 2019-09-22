package com.cg.jpaproject.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.Passenger;

public interface UserDao {
	
	public Bus saveBus(Bus bus);
	public Integer removebus(Bus bus);
	public List<Bus> findAllBuses();
	public List<Bus> findBusByDay(LocalDate date);
	public List<Bus> findBusByRoutes(String source, String destination);
	public Bus findBusById(Integer busId);
	
	
	public Booking saveBooking(Booking booking);
	public Integer removeBooking (Booking booking);
	public Booking findBookingById(Integer booking);
	public List<Booking> findAllBookings();
	
	public List<Passenger> findAllPassengers(Integer bookingId);
	
}
