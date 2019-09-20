package com.cg.demojpa.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private Integer deptId;
	private String deptName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> empList;
	

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", empList=" + empList + "]";
	}


	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public List<Employee> getEmpList() {
		return empList;
	}


	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}


	public Department(Integer deptId, String deptName, List<Employee> empList) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.empList = empList;
	}


	public Department() {
		// TODO Auto-generated constructor stub
	}

}
