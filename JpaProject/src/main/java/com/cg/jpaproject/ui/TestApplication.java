package com.cg.jpaproject.ui;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusDay;
import com.cg.jpaproject.dto.Passenger;
import com.cg.jpaproject.service.UserService;
import com.cg.jpaproject.service.UserServiceImpl;

public class TestApplication {
	public static void main(String[] args) {
		UserService service = new UserServiceImpl();

		Bus bus = new Bus();
		bus.setBusId(101);
		bus.setBusName("orange");
		bus.setBusType("SLEEPER");
		bus.setBusClass("AC");

		List<BusDay> days = new ArrayList<BusDay>();
		BusDay bd1 = new BusDay();
		bd1.setBusDayId(1);
		bd1.setDay("sunday".toUpperCase());
		days.add(bd1);
		BusDay bd2 = new BusDay();
		bd2.setBusDayId(2);
		bd2.setDay("monday".toUpperCase());
		days.add(bd2);
		bus.setDays(days);

		bus.setNoOfSeats(30);
		bus.setSource("mumbai");
		bus.setDestination("pune");
		bus.setCostPerSeat(1000.0);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String startTimeString = "06:30 AM";
		String endTimeString = "10:00 AM";
		LocalTime startTime = LocalTime.parse(startTimeString, formatter);
		LocalTime endTime = LocalTime.parse(endTimeString, formatter);

		bus.setStartTime(startTime);
		bus.setEndTime(endTime);
		bus.setDelete_flag(0);

		service.addBusDetails(bus);

		Passenger p1 = new Passenger();
		p1.setPassengerId(1001);
		p1.setPassengerName("teja");
		p1.setPassengerAge(22);
		p1.setPassengerGender('F');

		Passenger p2 = new Passenger();
		p2.setPassengerId(1002);
		p2.setPassengerName("hani");
		p2.setPassengerAge(19);
		p2.setPassengerGender('F');

		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(p1);
		passengers.add(p2);

		Booking booking = new Booking();
		booking.setBookingId(1);
		booking.setDateOfJourney(LocalDate.now());
		booking.setBus(bus);
		booking.setPassengers(passengers);
		booking.setModeOfPayment("DC");
		booking.setTotalCost(passengers.size()*bus.getCostPerSeat());
		
		System.out.println(service.createBooking(booking));

	}
}
