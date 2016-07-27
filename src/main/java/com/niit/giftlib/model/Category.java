package com.niit.giftlib.model;


import javax.persistence.Entity;
import javax.persistence.Id;


import org.springframework.stereotype.Component;

@Entity
@Component("category")
public class Category {
	@Id
	private int id;
	private String name;
	
	
	
    public Category(){}	
	
	
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	

}
