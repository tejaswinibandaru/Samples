package com.cg.jpaproject.service;

import java.util.List;

import com.cg.jpaproject.dao.BusDao;
import com.cg.jpaproject.dao.BusDaoImpl;
import com.cg.jpaproject.dto.Bus;

public class UserServiceImpl implements UserService {
	
	static BusDao busDao;
	
	static {
		busDao=new BusDaoImpl();
	}

	public Bus addBusDetails(Bus bus) {
		return busDao.saveBus(bus);
	}

	public List<Bus> viewAllBuses() {
		// TODO Auto-generated method stub
		return null;
	}

}
