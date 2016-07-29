package com.niit.giftlib.Dao;

import java.util.List;

import com.niit.giftlib.model.Product;

public interface ProductDao {

	List<Product> findAll();
	List<Product> findByCategory(int Categoryid);
	Product findById(int id);
	void save(Product product);
	void delete(Product product);
	
}
