package com.util;

import org.hibernate.*;  
import org.hibernate.cfg.Configuration;

import com.model.Car;
import com.model.Passport;
import com.model.Student;
import com.model.User;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory  getSessionFactory() {
		
		if(sessionFactory == null) {
		Configuration config = new Configuration();
		config.configure ("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(Car.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Passport.class);
		sessionFactory = config.buildSessionFactory();
		return sessionFactory;
		}
		return sessionFactory;	
	}
}
