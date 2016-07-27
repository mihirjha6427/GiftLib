package com.niit.giftlib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.niit.giftlib.Dao.CategoryDao;
import com.niit.giftlib.model.Category;
import com.niit.giftlib.model.Product;
import com.niit.giftlib.repository.CategoryRepository;
import com.niit.giftlib.repository.ProductRepository;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/")
	public String home(){
		return "cart";
	}
	
	@RequestMapping("/product/")
	public String ListCategories(ModelMap modelMap){
		List<Category> categories=categoryDao.findAll();
		modelMap.put("categories", categories);
		return "home";
	}
	
	
	
	@RequestMapping("/category/{id}")
	public String Category(@PathVariable int id, ModelMap modelMap){
		Category category= categoryRepository.findById(id);
		modelMap.put("category", category);
		List<Product> products= productRepository.findByCategoryId(id);
		modelMap.put("products", products);
		
		return "category-details";
		
		
	}
      @RequestMapping("/add")
      public String add(){
    	  return "add";
      }
      @RequestMapping(value="/category/add", method= RequestMethod.POST)
      public String addCategory(Category category){
    	  categoryDao.save(category);
    	  return "redirect:/product/";
      }
}
