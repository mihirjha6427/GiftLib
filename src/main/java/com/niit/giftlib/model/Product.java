package com.niit.giftlib.model;

public class Product {
	private int CategoryId;
	private String name;
	private String description;
	
	
	
	
	
	
	public Product(int categoryId, String name, String description) {
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
	
	
	
	
	
}
