package com.cg.springmvcdemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="products")
public class Product {
	@Id
	@Column(name="product_id")
	@NotNull
	private Integer productId;
	@Column(name="product_name")
	@NotEmpty(message="Name can't be empty")
	@Size(min=3,max=10,message="Name should be between 3 to 10 characters")
	private String productName;
	@Column(name="product_price")
	@NotNull(message="Price can't be empty")
	private Double productPrice;
	@Column(name="product_features")
	private String features;
	@Column(name="product_type")
	private String productType;
	@Column(name="online")
	private String online;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	

	


	public Product(Integer productId, String productName, Double productPrice, String features, String productType,
			String online) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.features = features;
		this.productType = productType;
		this.online = online;
	}



	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", features=" + features + ", productType=" + productType + ", online=" + online + "]";
	}

}
