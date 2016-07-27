package com.niit.giftlib.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.giftlib.model.Category;
@Repository("categoryDao")//So that spring picks up this class as an autowired implementation of categoryDao
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public CategoryDaoImpl() {
		super();
	}


	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> findAll() {
		Session session= sessionFactory.openSession();
		//Get all categories with hibernate criteria
		List<Category> categories= session.createCriteria(Category.class).list();
		session.close();
		
		return categories;
	}

	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Category category) {
	  Session session = sessionFactory.openSession();
	  session.beginTransaction();
	  session.save(category);
	  session.getTransaction().commit();
	  session.close();
	  
		
	}

	public void delete(Category category) {
		// TODO Auto-generated method stub
		
	}

}
