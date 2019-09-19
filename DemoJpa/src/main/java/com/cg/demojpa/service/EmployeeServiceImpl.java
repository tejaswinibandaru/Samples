package com.cg.demojpa.service;

import java.util.List;

import com.cg.demojpa.dao.EmployeeDao;
import com.cg.demojpa.dao.EmployeeDaoImpl;
import com.cg.demojpa.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao employeeDao=new EmployeeDaoImpl();

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.save(emp);
	}

	@Override
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public void removeEmployee(Integer empId) {
		// TODO Auto-generated method stub
		employeeDao.remove(empId);

	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(empId);
	}

	@Override
	public List<Employee> getEmployeesBySalary(Double minimum, Double maximum) {
		// TODO Auto-generated method stub
		return employeeDao.findBySalary(minimum, maximum);
	}

}
