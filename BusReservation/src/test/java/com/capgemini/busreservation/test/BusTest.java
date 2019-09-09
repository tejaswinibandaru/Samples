package com.capgemini.busreservation.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.busreservation.dto.Bus;
import com.capgemini.busreservation.service.AdminService;
import com.capgemini.busreservation.service.AdminServiceImpl;

public class BusTest {
	
	Bus bus1=null;
	Set<DayOfWeek> days=new HashSet<>(Arrays.asList(DayOfWeek.of(1),DayOfWeek.of(2)));
	Bus bus2=new Bus(new BigInteger("101"), "Volvo(2+1)", "Sleeper", "AC", 30, days, "Mumbai", "Pune", 1000.0);
	
	AdminService as;
	
	@BeforeEach
	public void beforeTest() {
		as=new AdminServiceImpl();
	}
	
	@Test
	public void test() {
		assertEquals(bus1, as.addBus(null));
		assertEquals(bus2.getBusName(), as.addBus(bus2).getBusName());
	}
	
	@AfterEach
	public void afterTest() {
		as=null;
	}

}
