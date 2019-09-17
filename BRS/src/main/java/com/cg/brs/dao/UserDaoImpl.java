package com.cg.brs.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.brs.model.Booking;
import com.cg.brs.model.Bus;
import com.cg.brs.model.BusTransaction;
import com.cg.brs.model.Passenger;
import com.cg.brs.util.DBUtil;


public class UserDaoImpl implements UserDao{
	
	private static Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private static Logger logger;
	
	static {
		Properties properties=System.getProperties();
		String userDir= properties.getProperty("user.dir")+"\\src\\main\\resources\\";
		System.out.println("Current working directory: "+userDir);
		PropertyConfigurator.configure(userDir+"log4j.properties");
		logger=Logger.getLogger("UserDaoImpl.class");
	}
	static {
		try {
			connection=DBUtil.getConnection();
			logger.info("Connection established!!! ");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("Connection unable to estalish: "+e.getMessage());
		}
	}
	

	@Override
	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeBooking(BigInteger bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingById(BigInteger bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger savePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> findAllPassengers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger findPassengerByName(String pname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		String sql="insert into bus(bus_name,bus_type,bus_class,no_of_seats,source,destination,cost_per_seat) values (?,?,?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bus.getBusName());
			preparedStatement.setString(2, bus.getBusType());
			preparedStatement.setString(3, bus.getBusClass());
			preparedStatement.setInt(4, bus.getNoOfSeats());
			preparedStatement.setString(5, bus.getSource());
			preparedStatement.setString(6, bus.getDestination());
			preparedStatement.setDouble(7, bus.getCost());
			
			int recordsCount=preparedStatement.executeUpdate();
			logger.info(recordsCount+" records inserted");
			
			Set<DayOfWeek> days=bus.getDayOfJourney();
			sql="insert into bus_day values(?,?)";
			for(int i=0;i<days.size();i++) {
				
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setLong(1, bus.getBusId().longValue());
				preparedStatement.setInt(2,DayOfWeek.);
			}
			
			BigInteger generatedId=BigInteger.valueOf(1000L);
			resultSet=preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()) {
				generatedId=BigInteger.valueOf(resultSet.getLong(1001));
				logger.info("Auto generated id: "+generatedId);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("Error generated at saveBus method in UserDaoImpl: "+e.getMessage());
		}
		return bus;
	}

	@Override
	public Integer removeBus(BigInteger busId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus findBusById(BigInteger busId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusTransaction saveTransaction(BusTransaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeTransaction(Bus bus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BusTransaction> findTransactionsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BusTransaction> getTransactionList() {
		// TODO Auto-generated method stub
		return null;
	}

}
