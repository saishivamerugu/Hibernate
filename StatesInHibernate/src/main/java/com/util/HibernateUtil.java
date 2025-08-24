package com.util;

import org.hibernate.*; 
import org.hibernate.cfg.Configuration;

import com.model.Employees;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory  getSessionFactory() {
		
		if(sessionFactory == null) {
		Configuration config = new Configuration();
		config.configure ("hibernate.cfg.xml");
		config.addAnnotatedClass(Employees.class);
		sessionFactory = config.buildSessionFactory();
		return sessionFactory;
		}
		return sessionFactory;
		
	}
}
