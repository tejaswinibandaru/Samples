package com.cg.springmvcdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcdemo.dto.Product;

@Repository("productdao")
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Product save(Product product) {
		entityManager.persist(product);
		return product;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("FROM Product");
		List<Product> products=query.getResultList();
		return products;
	}

	@Override
	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return entityManager.find(Product.class, productId);
	}

	@Override
	public void removeProduct(int productId) {
		Product product=entityManager.find(Product.class, productId);
		entityManager.remove(product);
	}

}
