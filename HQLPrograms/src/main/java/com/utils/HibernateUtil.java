package com.utils;

import org.hibernate.*; 
import org.hibernate.cfg.Configuration;

import com.model.Student;


public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory  getSessionFactory() {
		
		if(sessionFactory == null) {
		Configuration config = new Configuration();
		config.configure ("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);
		sessionFactory = config.buildSessionFactory();
		return sessionFactory;
		}
		return sessionFactory;
		
	}
}
