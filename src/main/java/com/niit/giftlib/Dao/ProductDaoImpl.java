package com.niit.giftlib.Dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.giftlib.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;


	public ProductDaoImpl() {
	super();
}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Product> findAll() {
		Session session= sessionFactory.openSession();
		List<Product> products= session.createCriteria(Product.class).list();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByCategory(int Categoryid) {
		Session session= sessionFactory.openSession();
		List<Product> products= session.createCriteria(Product.class).list();
		List<Product> products1= new ArrayList<>();
		for(Product product : products){
			if(product.getCategoryId()== Categoryid){
				products1.add(product);
			}
		}
		session.close();
		return products1;
		
		
	}

	@Override
	public Product findById(int id) {
		Session session= sessionFactory.openSession();
		Product product= (Product) session.get(Product.class, id);
		session.close();
		
		return product;
	}

	@Override
	public void save(Product product) {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Product product) {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
		session.close();
		
	}

}
