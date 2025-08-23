package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Employees;

public class Application {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Employees.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory(); 
		Session session = sessionFactory.openSession(); 
		
		Employees emp = new Employees(1,"akash",50000);
		
		session.beginTransaction();
		session.persist(emp); 
		System.out.println("data was inserted..");
		session.getTransaction().commit();
	}
}


