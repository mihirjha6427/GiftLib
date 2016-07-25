package com.niit.giftlib.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.giftlib.model.Category;


@Component
public class CategoryRepository {
	private static final List<Category>ALL_CATEGORY= Arrays.asList(
			new Category(1,"shopping"),
			new Category(2, "perfume"),
			new Category(3,"purse"),
			new Category(4,"jeans"));
			
			
public Category findByName(String name){
	for(Category category:ALL_CATEGORY){
		if(category.getName().equals(name)){
			return category;
		}
	}
	return null;
}
public List<Category> getAllCategory(){
	
	return ALL_CATEGORY;
}
public  Category findById(int id){
	for(Category category: ALL_CATEGORY){
		if(category.getId()==id){
			return category;
	}
}
	return null;

}

}
