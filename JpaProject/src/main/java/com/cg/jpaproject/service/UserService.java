package com.cg.jpaproject.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.dto.User;

public interface UserService {
	public Bus addBusDetails(Bus bus);
	public Integer removeBus(Integer busId);
	public List<Bus> viewAllBuses();
	public Bus viewBusById(Integer busId);
	public List<Object[]> viewBusByRoutes(String source,String destination);
	
	
	public Booking createBooking(Booking booking);
	public Integer removeBooking(Integer bookingId);
	public List<Booking> viewAllBookings();
	
	public BusTransaction addTransaction(BusTransaction transaction);
	public List<BusTransaction> viewAllTransactions();
	public List<BusTransaction> viewTransactionsByDate(LocalDate date);
	public BusTransaction viewTransactionById(Integer busTransactionId);
	public BusTransaction updateTransaction(Integer busTransactionId);
	
	
	public User addUser(User user);
	public Integer removeUser(Integer userId);
	public List<User> viewAllUsers();
	public List<BusTransaction> findTransactionByDate(LocalDate date);
	
	
	
}
