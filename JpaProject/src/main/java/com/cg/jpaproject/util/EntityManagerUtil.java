package com.cg.jpaproject.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public EntityManagerUtil() {
		// TODO Auto-generated constructor stub
		entityManagerFactory=Persistence.createEntityManagerFactory("jpaproject");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	public EntityTransaction obtainTransaction() {
		entityTransaction=entityManager.getTransaction();
		return entityTransaction;
	}
	
	public void beginTransaction() {
		entityTransaction.begin();
	}
	
	public void commitTransaction() {
		entityTransaction.commit();
	}
	
	

}
