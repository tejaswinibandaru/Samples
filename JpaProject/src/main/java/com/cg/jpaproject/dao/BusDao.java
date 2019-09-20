package com.cg.jpaproject.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.jpaproject.dto.Bus;

public interface BusDao {
	
	public Bus saveBus(Bus bus);
	public Integer removebus(Bus bus);
	public Bus searchBus(Bus bus);
	public List<Bus> findAllBuses();
	public List<Bus> findBusByDay(LocalDate date);
	public List<Bus> findBusByRoutes(String source, String destination);
	public Bus findBusById(Integer busId);
	
}
