package com.cg.jpaproject.dto;

import java.time.DayOfWeek;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class BusDay {
	@Id
	private Integer busDayId;
	@Enumerated(EnumType.STRING)
	private Days day;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="busId")
	private Bus bus;

	public BusDay() {
		// TODO Auto-generated constructor stub
	}

	public BusDay(Integer busDayId, String day) {
		super();
		this.busDayId = busDayId;
		this.day = Days.valueOf(day);
	}

	public Integer getBusDayId() {
		return busDayId;
	}

	public void setBusDayId(Integer busDayId) {
		this.busDayId = busDayId;
	}

	public Days getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = Days.valueOf(day);
	}


	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "BusDay [busDayId=" + busDayId + ", day=" + day + "]";
	}
	
	
	
	
}
