package com.cg.demojpa.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.demojpa.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa");

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(emp);
		entityManager.flush();
		entityTransaction.commit();

		return emp;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("FROM Employee");
		
		return query.getResultList();
	}

	@Override
	public void remove(Integer emp) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = entityManager.find(Employee.class, emp);
		if (emp != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);

			entityTransaction.commit();
		}

	}

	@Override
	public Employee findById(Integer empId) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, empId);
		return employee;
	}

	@Override
	public List<Employee> findBySalary(Double min,Double max) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("FROM Employee WHERE empSalary BETWEEN :first AND :second");
		query.setParameter("first", min);
		query.setParameter("second", max);
		
		List<Employee> empList=query.getResultList();
		return empList;
	}

}
