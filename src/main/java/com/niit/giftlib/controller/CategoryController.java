package com.niit.giftlib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.giftlib.model.Category;
import com.niit.giftlib.model.Product;
import com.niit.giftlib.repository.CategoryRepository;
import com.niit.giftlib.repository.ProductRepository;


@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRespository;
	@Autowired
	private ProductRepository productRepository;
	
	
	
	@RequestMapping("/")
	public String ListCategories(ModelMap modelMap){
		List<Category>categories=categoryRespository.getAllCategory();
		modelMap.put("categories", categories);
		return "home";
	}
	
	
	
	@RequestMapping("/category/{id}")
	public String Category(@PathVariable int id, ModelMap modelMap){
		Category category= categoryRespository.findById(id);
		modelMap.put("category", category);
		List<Product> products= productRepository.findByCategoryId(id);
		modelMap.put("products", products);
		
		return "category-details";
		
		
	}

}
