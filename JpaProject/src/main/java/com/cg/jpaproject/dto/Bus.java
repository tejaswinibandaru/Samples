package com.cg.jpaproject.dto;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bus")
public class Bus {
	@Id
	private BigInteger busId;
	@Column(name="bus_name")
	private String busName;
	public enum busClassList{AC,NON_AC}
	public enum busTypeList {SLEEPER,SEMI_SLEEPER}
	@Column(name="bus_type")
	private busTypeList busType;
	@Column(name="bus_class")
	private busClassList busClass;
	@OneToMany(mappedBy="bus")
	private List<DayOfWeek> days;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="no_of_seats")
	private Integer noOfSeats;
	@Column(name="delete_flag")
	private Integer deleteFlag=0;
	@Column(name="start_time")
	private LocalDateTime startTime;
	@Column(name="end_time")
	private LocalDateTime endTime;
	@Column(name="cost_per_seat")
	private Double costPerSeat;

	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public Bus(BigInteger busId, String busName, String busType, String busClass, List<DayOfWeek> days, String source,
			String destination, Integer noOfSeats, Integer delete_flag, LocalDateTime startTime, LocalDateTime endTime,
			Double costPerSeat) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busType = busTypeList.valueOf(busType);
		this.busClass = busClassList.valueOf(busClass);
		this.days = days;
		this.source = source;
		this.destination = destination;
		this.noOfSeats = noOfSeats;
		this.deleteFlag = delete_flag;
		this.startTime = startTime;
		this.endTime = endTime;
		this.costPerSeat = costPerSeat;
	}

	public BigInteger getBusId() {
		return busId;
	}

	public void setBusId(BigInteger busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType.toString();
	}

	public void setBusType(String busType) {
		this.busType = busTypeList.valueOf(busType);
	}

	public String getBusClass() {
		return busClass.toString();
	}

	public void setBusClass(String busClass) {
		this.busClass = busClassList.valueOf(busClass);
	}

	public List<DayOfWeek> getDays() {
		return days;
	}

	public void setDays(List<DayOfWeek> days) {
		this.days = days;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDelete_flag(Integer delete_flag) {
		this.deleteFlag = delete_flag;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Double getCostPerSeat() {
		return costPerSeat;
	}

	public void setCostPerSeat(Double costPerSeat) {
		this.costPerSeat = costPerSeat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busId == null) ? 0 : busId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (busId == null) {
			if (other.busId != null)
				return false;
		} else if (!busId.equals(other.busId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busType=" + busType + ", busClass=" + busClass
				+ ", days=" + days + ", source=" + source + ", destination=" + destination + ", noOfSeats=" + noOfSeats
				+ ", deleteFlag=" + deleteFlag + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", costPerSeat=" + costPerSeat + "]";
	}
	
	
}
