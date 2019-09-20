package com.cg.jpaproject.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceUtil {
	public static EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpaproject");
		return entityManagerFactory;
	}
	
	public static EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
	
	public static EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction();
	}
}
