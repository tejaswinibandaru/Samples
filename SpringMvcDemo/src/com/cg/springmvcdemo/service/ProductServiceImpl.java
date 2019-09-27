package com.cg.springmvcdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springmvcdemo.dao.ProductDao;
import com.cg.springmvcdemo.dto.Product;

@Service("productservice")
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productdao;
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productdao.save(product);
	}

	@Override
	public List<Product> showProducts() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	@Override
	public Product searchProduct(int productId) {
		// TODO Auto-generated method stub
		return productdao.findProductById(productId);
	}

	@Override
	public void removeProduct(int productId) {
		// TODO Auto-generated method stub
	productdao.removeProduct(productId);
		
	}

}
