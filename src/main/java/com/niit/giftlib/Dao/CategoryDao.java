package com.niit.giftlib.Dao;

import java.util.List;

import com.niit.giftlib.model.Category;

public interface CategoryDao {
	List<Category> findAll();
	Category findById(int id);
	void save(Category category);
	void delete(Category category);
	

}
