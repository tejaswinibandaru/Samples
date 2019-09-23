package com.cg.jpaproject.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.dto.Passenger;

public class UserDaoImpl implements UserDao {
	
	private EntityManager entityManager;
	
	public UserDaoImpl(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
		this.entityManager=entityManager;
		
	}

	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		Bus busDays=entityManager.merge(bus);
		busDays.setDays(busDays.getDays());
		entityManager.persist(busDays);
		entityManager.flush();
		transaction.commit();
		return busDays;
	}

	public Integer removebus(Bus bus) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		TypedQuery<Bus> query=entityManager.createQuery("SELECT bus FROM Bus bus", Bus.class);
		return query.getResultList();
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

	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		Booking bookingObj=entityManager.merge(booking);
		bookingObj.setBus(bookingObj.getBus());
		bookingObj.setPassengers(bookingObj.getPassengers());
		bookingObj.setTransaction(bookingObj.getTransaction());
		entityManager.persist(bookingObj);
		entityManager.flush();
		transaction.commit();
		
		return bookingObj;
	}

	public Integer removeBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	public Booking findBookingById(Integer booking) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		TypedQuery<Booking> query=entityManager.createQuery("SELECT booking FROM Booking booking", Booking.class);
		return query.getResultList();
	}

	public List<Passenger> findAllPassengers(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	public BusTransaction saveTransaction(BusTransaction busTransaction) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		BusTransaction transactionObj=entityManager.merge(busTransaction);
		transactionObj.setBookings(transactionObj.getBookings());
		transactionObj.setBus(transactionObj.getBus());
		entityManager.persist(transactionObj);
		entityManager.flush();
		transaction.commit();
		return transactionObj;
	}

}
