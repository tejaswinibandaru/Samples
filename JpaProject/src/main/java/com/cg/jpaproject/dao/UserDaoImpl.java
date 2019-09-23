package com.cg.jpaproject.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusDay;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.dto.Days;
import com.cg.jpaproject.dto.Passenger;
import com.cg.jpaproject.dto.User;

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
		bus.setDelete_flag(0);
		Bus busDays=entityManager.merge(bus);
		busDays.setDays(busDays.getDays());
		entityManager.persist(busDays);
		entityManager.flush();
		transaction.commit();
		return busDays;
	}

	public Integer removeBus(Integer busId) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Bus busUpdate = entityManager.find(Bus.class, busId);
		busUpdate.setDelete_flag(1);
		entityManager.merge(busUpdate);
		
		transaction.commit();
		return 1;
	}

	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		TypedQuery<Bus> query=entityManager.createQuery("SELECT bus FROM Bus bus where bus.deleteFlag = 0", Bus.class);
		return query.getResultList();
	}

	public List<Bus> findBusByDay(LocalDate date) {
		// TODO Auto-generated method stub

		String dayString=date.getDayOfWeek().toString();
		Days day=Days.valueOf(dayString);
//		Query query=entityManager.createQuery("SELECT bus.busName,bus.busType,bus.busClass,bus.costPerSeat,bus.source,bus.destination FROM Bus bus INNER JOIN BusDay busDay ON bus.busId=busDay.busId WHERE busDay.day=:dayValue");
		Query query=entityManager.createQuery("SELECT busday.day FROM BusDay busday WHERE busday.day=:dayValue");
		query.setParameter("dayValue", day);
		BusDay busDay= (BusDay) query.getSingleResult();
		
		/*
		 * query.setParameter("source", source); query.setParameter("destination",
		 * destination);
		 */
		
		return busDay.getBuses();

		//TypedQuery<Bus> query=entityManager.createQuery("SELECT bus FROM Bus bus where bus.deleteFlag = 0", Bus.class);
	}

	public List<Object[]> findBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT bus.busName,bus.busType,bus.busClass,bus.costPerSeat FROM Bus bus WHERE bus.source=:source AND bus.destination=:destination");
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		List<Object[]> results=query.getResultList();
		return results;
	}

	public Bus findBusById(Integer busId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		BusTransaction busTransaction =booking.getBusTransaction();
		Booking bookingObj=entityManager.merge(booking);
																					//deleteFlag & bookingStatus
		//
		busTransaction =insertBookingIntoTransaction(bookingObj, busTransaction);
		bookingObj.setBus(bookingObj.getBus());										
		bookingObj.setPassengers(bookingObj.getPassengers());
		bookingObj.setBusTransaction(busTransaction);
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
		transactionObj.setDeleteFlag(0);																//deleteFlag and transactionStatus
		transactionObj.setTransactionStatus("ACTIVE");
		entityManager.persist(transactionObj);
		entityManager.flush();
		transaction.commit();
		return transactionObj;
	}

	public BusTransaction insertBookingIntoTransaction(Booking booking, BusTransaction busTransaction) {
		// TODO Auto-generated method stub
		BusTransaction transactionUpdate = entityManager.merge(busTransaction);
		List<Booking> bookingList= transactionUpdate.getBookings();
		bookingList.add(booking);
		transactionUpdate.setBookings(bookingList);
		entityManager.persist(transactionUpdate);
		return busTransaction;
	}

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		user.setDeleteFlag(0);
		User userSave=entityManager.merge(user);
		entityManager.persist(userSave);
		entityManager.flush();
		transaction.commit();
		return user;
	}

	public Integer removeUser(Integer userId) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		User userUpdate = entityManager.find(User.class, userId);
		userUpdate.setDeleteFlag(1);
		entityManager.merge(userUpdate);
		
		transaction.commit();
		return 1;
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		TypedQuery<User> query=entityManager.createQuery("SELECT user FROM User user where user.deleteFlag = 0", User.class);
		return query.getResultList();
	}
	
	

}
