package com.cg.jpaproject.service;

import java.util.List;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.dto.User;

public interface UserService {
	public Bus addBusDetails(Bus bus);
	public Integer removeBus(Integer busId);
	public List<Bus> viewAllBuses();
	
	public Booking createBooking(Booking booking);
	public Integer removeBooking(Integer bookingId);
	public List<Booking> viewAllBookings();
	public BusTransaction addTransaction(BusTransaction transaction);
	
	
	public User addUser(User user);
	public Integer removeUser(Integer userId);
	public List<User> viewAllUsers();
	
	
	
}
