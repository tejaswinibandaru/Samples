package com.cg.brs.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.cg.brs.model.Booking;
import com.cg.brs.model.Bus;
import com.cg.brs.model.BusTransaction;
import com.cg.brs.model.Passenger;


public interface UserDao {
	
	public Booking saveBooking(Booking booking);
	public Integer removeBooking(BigInteger bookingId);
	public List<Booking> findAllBookings();
	public Booking findBookingById(BigInteger bookingId);
	public Passenger savePassenger(Passenger passenger);
	public List<Passenger> findAllPassengers();
	public Passenger findPassengerByName(String pname);
	
	public Bus saveBus(Bus bus);
	public Integer removeBus(BigInteger busId);
	public List<Bus> findAllBuses();
	public Bus findBusById(BigInteger busId);
	
	public BusTransaction saveTransaction(BusTransaction transaction);
	public Integer removeTransaction(Bus bus);
	//public List<Transaction> findAllTransactions();
	public List<BusTransaction> findTransactionsByDate(LocalDate date);
	public List<BusTransaction> getTransactionList();

}
