package com.niit.giftlib.model;

import javax.persistence.Entity;
import javax.persistence.Id;


import org.springframework.stereotype.Component;

@Entity
@Component("product")
public class Product {
	@Id
	private int id;
	private int CategoryId;
	private String name;
	private String description;
	
	
	
	
	public Product(){}
	
	
	public Product(int id ,int categoryId, String name, String description) {
		super();
		CategoryId = categoryId;
		this.name = name;
		this.description = description;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
