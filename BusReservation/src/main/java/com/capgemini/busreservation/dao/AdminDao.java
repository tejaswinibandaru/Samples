package com.capgemini.busreservation.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Set;

import com.capgemini.busreservation.dto.Bus;
import com.capgemini.busreservation.dto.Transaction;

public interface AdminDao {
	
	public Bus addBus(Bus b);
	public Integer removeBus(BigInteger busId);
	public Bus updateBus(BigInteger busId);
	public Bus searchBus(BigInteger busId);
	public Set<Bus> viewBuses();
	public Set<Transaction> getTransactionByDate(LocalDate d);


}
