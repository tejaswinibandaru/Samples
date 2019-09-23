package com.cg.jpaproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpaproject.dao.UserDao;
import com.cg.jpaproject.dao.UserDaoImpl;
import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;

public class UserServiceImpl implements UserService {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpaproject");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	UserDao userDao=new UserDaoImpl(entityManager);
	public Bus addBusDetails(Bus bus) {
		return userDao.saveBus(bus);
	}

	public List<Bus> viewAllBuses() {
		// TODO Auto-generated method stub
		return userDao.findAllBuses();
	}

	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return userDao.saveBooking(booking);
	}

	public BusTransaction addTransaction(BusTransaction transaction) {
		// TODO Auto-generated method stub
		return userDao.saveTransaction(transaction);
	}

	public List<Booking> viewAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
