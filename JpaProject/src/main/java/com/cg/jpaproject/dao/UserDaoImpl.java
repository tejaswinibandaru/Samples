package com.cg.jpaproject.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.dto.Passenger;
import com.cg.jpaproject.dto.User;

public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;

	public UserDaoImpl(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
		this.entityManager = entityManager;

	}

	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		bus.setBusId(bus.getBusId());
		entityManager.persist(bus);
		entityManager.flush();
		transaction.commit();
		return bus;
	}

	public Integer removeBus(Integer busId) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Bus busUpdate = entityManager.find(Bus.class, busId);
		if(busUpdate==null) {
			return 0;
		}
		busUpdate.setDelete_flag(1);
		entityManager.merge(busUpdate);

		transaction.commit();
		return 1;
	}

	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		TypedQuery<Bus> query = entityManager.createQuery("SELECT bus FROM Bus bus where bus.deleteFlag = 0",
				Bus.class);
		return query.getResultList();
	}

	public List<Object[]> findBusByRoutes(String source, String destination) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT bus.busId,bus.busName,bus.busType,bus.busClass,bus.costPerSeat FROM Bus bus WHERE bus.source=:source AND bus.destination=:destination");
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		List<Object[]> results=query.getResultList();
		return results;
	}

	public Bus findBusById(Integer busId) {
		// TODO Auto-generated method stub
		return entityManager.find(Bus.class, busId);
	}

	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Booking bookingObj = entityManager.merge(booking);
		// deleteFlag & bookingStatus
		bookingObj.setBookingId(booking.getBookingId());
		bookingObj.setBus(bookingObj.getBus());
		bookingObj.setPassengers(bookingObj.getPassengers());
		entityManager.persist(bookingObj);
		entityManager.flush();
		transaction.commit();

		return bookingObj;
	}

	public Integer removeBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Booking removeBooking = entityManager.find(Booking.class, bookingId);
		removeBooking.setBookingStatus("CANCELLED");
		entityManager.merge(removeBooking);

		transaction.commit();
		return 1;
	}

	public Booking findBookingById(Integer bookingId) {
		// TODO Auto-generated method stub
		return entityManager.find(Booking.class, bookingId);
	}

	public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		TypedQuery<Booking> query = entityManager.createQuery("SELECT booking FROM Booking booking ", Booking.class);
		return query.getResultList();
	}

	public List<Passenger> findAllPassengers(Integer bookingId) {
		// TODO Auto-generated method stub
		TypedQuery<Passenger> query = entityManager.createQuery("SELECT passenger FROM Passenger passenger", Passenger.class);
		return query.getResultList();
	}

	public BusTransaction saveTransaction(BusTransaction busTransaction) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		BusTransaction transactionObj = entityManager.merge(busTransaction);
		transactionObj.setBooking(transactionObj.getBooking());
		transactionObj.setBus(transactionObj.getBus());
		transactionObj.setDeleteFlag(0); // deleteFlag and transactionStatus
		transactionObj.setTransactionStatus("ACTIVE");
		entityManager.persist(transactionObj);
		entityManager.flush();
		transaction.commit();
		return transactionObj;
	}

	/*
	 * public BusTransaction insertBookingIntoTransaction(Booking booking,
	 * BusTransaction busTransaction) { // TODO Auto-generated method stub
	 * BusTransaction transactionUpdate = entityManager.merge(busTransaction);
	 * Booking bookingList = transactionUpdate.getBooking();
	 * bookingList.add(booking); transactionUpdate.setBookings(bookingList);
	 * entityManager.persist(transactionUpdate); return busTransaction; }
	 */

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		user.setBookingsList(user.getBookingsList());
		user.setDeleteFlag(0);
		User userSave = entityManager.merge(user);
		user.setUserId(user.getUserId());
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
		TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user where user.deleteFlag = 0",
				User.class);
		return query.getResultList();
	}

	@Override
	public List<BusTransaction> findAllTransactions() {
		// TODO Auto-generated method stub
		TypedQuery<BusTransaction> query=entityManager.createQuery("SELECT busTransaction FROM BusTransaction busTransaction", BusTransaction.class);
		return query.getResultList();
	}

	@Override
	public List<BusTransaction> findTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		TypedQuery<BusTransaction> query=entityManager.createQuery("SELECT busTransaction FROM BusTransaction busTransaction WHERE busTransaction.date=:date", BusTransaction.class);
		query.setParameter("date", date);
		return query.getResultList();
	}


	@Override
	public BusTransaction findTransactionById(Integer transactionId) {
		// TODO Auto-generated method stub
		return entityManager.find(BusTransaction.class, transactionId);
	}

	@Override
	public BusTransaction updateTransaction(Integer transactionId) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=entityManager.getTransaction();
		BusTransaction busTransaction=findTransactionById(transactionId);
		busTransaction=entityManager.merge(busTransaction);
		busTransaction.setBooking(busTransaction.getBooking());
		transaction.commit();
		return busTransaction;
	}

}
