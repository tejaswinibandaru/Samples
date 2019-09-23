package com.cg.jpaproject.service;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpaproject.dao.UserDao;
import com.cg.jpaproject.dao.UserDaoImpl;
import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.exception.BusException;

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

	public List<Bus> viewBusByDay(LocalDate date) {
		// TODO Auto-generated method stub
		return userDao.findBusByDay(date);
	}

	@Override
	public List<Object[]> viewBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		return userDao.findBusByRoutes(source, destination);
	}
	
	public static void validateTravel(String source, String destination) throws BusException{
		if(source.equals(destination)) {
			throw new BusException("source and destination cannot be same");
		}
	}
	public static int checkNumberInput() throws InputMismatchException{
		Scanner sc=new Scanner(System.in);
		try {
			return sc.nextInt();
		}catch (InputMismatchException e) {
			throw new InputMismatchException("Wrong input type");
		}

	}

}
