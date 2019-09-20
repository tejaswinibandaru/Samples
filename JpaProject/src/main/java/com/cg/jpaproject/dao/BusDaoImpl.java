package com.cg.jpaproject.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.util.PersistenceUtil;

public class BusDaoImpl implements BusDao {

	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		EntityTransaction entityTransaction=PersistenceUtil.getEntityTransaction();
		entityTransaction.begin();
		PersistenceUtil.getEntityManager().persist(bus);
		entityTransaction.commit();
		return bus;
	}

	public Integer removebus(Bus bus) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bus searchBus(Bus bus) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bus> findBusByDay(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bus> findBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bus findBusById(Integer busId) {
		// TODO Auto-generated method stub
		return null;
	}

}
