package com.girmiti.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product", type = "default")
public class Product {

	@Id
	int id;
	String productName;
	String price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Product(int id, String name, String price) {
		super();
		this.id = id;
		this.productName = name;
		this.price = price;
	}

	public Product() {
	}

}
