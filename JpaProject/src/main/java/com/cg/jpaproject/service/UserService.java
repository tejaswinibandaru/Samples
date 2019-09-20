package com.cg.jpaproject.service;

import java.util.List;

import com.cg.jpaproject.dto.Bus;

public interface UserService {
	public Bus addBusDetails(Bus bus);
	public List<Bus> viewAllBuses();
}
