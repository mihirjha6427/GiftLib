package com.niit.giftlib.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;


import com.niit.giftlib.model.Product;
@Component
public class ProductRepository {
	private static final List<Product> ALL_PRODUCTS= Arrays.asList(
			new Product(1,"shopping","women shopping"),
			new Product(2, "perfume", "women perfume"),
			new Product(3,"purse","women purse"),
			new Product(4,"jeans","women-jeans"),
			new Product(3,"purse-chanel","chanel purse"),
			new Product(3,"purse-gucci","chanel purse"),
			new Product(3,"purse-louisVuitton","LouisVuitton purse"),
			new Product(3,"purse-product","product purse"),
            new Product(2,"perfume-chloe","perfume"),
			new Product(2,"perfume-ck","perfume"),
			new Product(2,"perfume-gucci","perfume"));
	
	public List<Product> getAllProducts(){
		return ALL_PRODUCTS;
	}
	public Product findByName(String name){
		for(Product product:ALL_PRODUCTS){
			if(product.getName().equals(name)){
				return product;
			}
		}
		return null;
	}
	
	public   List<Product> findByCategoryId(int id){
		List<Product> products= new ArrayList<Product>();
		for(Product product : ALL_PRODUCTS){
			if(product.getCategoryId()==id){
				products.add(product);
			}
		}
		return products;
		
	}
}
