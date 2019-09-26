package com.cg.springmvcdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.springmvcdemo.dto.Product;

@Repository("productdao")
public class ProductDaoImpl implements ProductDao {
	
	List<Product> products=new ArrayList<Product>();

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
		return product;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProduct(int productId) {
		// TODO Auto-generated method stub
		for (Product product : products) {
			if(product.getProductId()==productId) {
				products.remove(product);
				break;
			}
		}
		
	}

}
