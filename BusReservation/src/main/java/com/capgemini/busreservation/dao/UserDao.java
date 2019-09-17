package com.capgemini.busreservation.dao;

import java.math.BigInteger;
import java.util.List;

import com.capgemini.busreservation.dto.Bus;


public interface UserDao {

	public Bus addBusDetails(Bus bus);

	Integer removeBusDetails(BigInteger busId);

	public Bus saveBus(Bus bus);

	public Integer removeBus(BigInteger busId);

	Bus searchBus(BigInteger busId);

	public Bus findBusById(BigInteger busId);

	public List<Bus> viewBuses();

	public java.util.List<Bus> findAllBuses();

}
