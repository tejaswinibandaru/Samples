package com.cg.jpaproject.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusDay;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.dto.Passenger;
import com.cg.jpaproject.dto.User;

public interface UserDao {
	
	public Bus saveBus(Bus bus);
	public BusDay saveBusDay(BusDay day);
	public Integer removeBus(Integer busId);
	public List<Bus> findAllBuses();
	public List<Bus> findBusByDay(LocalDate date);
	public List<Object[]> findBusByRoutes(String source, String destination);
	public Bus findBusById(Integer busId);
	
	
	public Booking saveBooking(Booking booking);
	public Integer removeBooking (Integer booking);
	public Booking findBookingById(Integer booking);
	public List<Booking> findAllBookings();
	
	public List<Passenger> findAllPassengers(Integer bookingId);
	
	public BusTransaction saveTransaction(BusTransaction busTransaction);
	public List<BusTransaction> findAllTransactions();
	public BusTransaction findTransactionById(Integer transactionId);
	public BusTransaction updateTransaction(Integer transactionId);
	public List<BusTransaction> findTransactionsByDate(LocalDate date);
	
//	public BusTransaction insertBookingIntoTransaction(Booking booking, BusTransaction busTransaction);
	
	public User saveUser(User user);
	public Integer removeUser(Integer userId);
	public List<User> viewAllUsers();
	
}
