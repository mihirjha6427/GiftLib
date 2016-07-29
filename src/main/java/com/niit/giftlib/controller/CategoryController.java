package com.niit.giftlib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.giftlib.FlashMessage;
import com.niit.giftlib.Dao.CategoryDao;
import com.niit.giftlib.Dao.ProductDao;
import com.niit.giftlib.model.Category;
import com.niit.giftlib.model.Product;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	
	
	
	
	@RequestMapping("/")
	public String home(){
		return "cart";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/product")
	public String ListCategories(ModelMap modelMap){
		List<Category> categories=categoryDao.findAll();
		modelMap.put("categories", categories);
		return "home";
	}
	
	
	
	@RequestMapping("/category/{id}")
	public String Category(@PathVariable int id, Model model){
		
		model.addAttribute("products", productDao.findByCategory(id));
		
		
		return "category-details";
		
		
	}
      @RequestMapping("/add")
      public String add(){
    	  return "add";
      }
      @RequestMapping(value="/category/add", method= RequestMethod.POST)
      public String addCategory(Category category){
    	  categoryDao.save(category);
    	  return "redirect:/product";
      }
      
      @RequestMapping("/add-Product")
      public String addProduct(){
    	  return "add-Product";
      }
      @RequestMapping(value="/category/addProduct", method= RequestMethod.POST)
      public String addProducts(Product product,RedirectAttributes redirectAttributes){
    	  productDao.save(product);
    	  redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category successfully added!", FlashMessage.Status.SUCCESS));

    	  return "redirect:/product";
    	  
      }
      
      
      @RequestMapping("/delete")
      public String deletechoice(ModelMap modelMap){
    	  List<Category> categories=categoryDao.findAll();
  		modelMap.put("categories", categories);
  		return "delete";
    	  
      }
      @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
      public String Delete(@PathVariable int id, RedirectAttributes redirectAttributes){
    	 Category category =categoryDao.findById(id);
    	 categoryDao.delete(category);
    	
    	 redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category successfully DELETED!", FlashMessage.Status.SUCCESS));

    	  
    	  return "redirect:/product";
    	  
      }
}
