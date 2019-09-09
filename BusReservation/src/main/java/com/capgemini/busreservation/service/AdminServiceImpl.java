package com.capgemini.busreservation.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Set;

import com.capgemini.busreservation.dao.AdminDao;
import com.capgemini.busreservation.dao.AdminDaoImpl;
import com.capgemini.busreservation.dto.Bus;
import com.capgemini.busreservation.dto.Transaction;

public class AdminServiceImpl implements AdminService{
	
	AdminDao adminDao=new AdminDaoImpl();

	public Bus addBus(Bus b) {
		// TODO Auto-generated method stub
		return adminDao.addBus(b);
	}

	public Integer removeBus(BigInteger busId) {
		// TODO Auto-generated method stub
		return adminDao.removeBus(busId);
	}

	public Bus updateBus(BigInteger busId) {
		// TODO Auto-generated method stub
		return adminDao.updateBus(busId);
	}

	public Bus searchBus(BigInteger busId) {
		// TODO Auto-generated method stub
		return adminDao.searchBus(busId);
	}

	public Set<Bus> viewBuses() {
		// TODO Auto-generated method stub
		return adminDao.viewBuses();
	}

	public Set<Transaction> getTransactionByDate(LocalDate d) {
		// TODO Auto-generated method stub
		return null;
	}

}
