package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employees;
import com.util.HibernateUtil;

public class States {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		// Transient State 
		// There is no relation between the object and the sessions
		transientState();
		
		// Persistent State
		// When we link the object with the session then the object moves to the persistent state
		persistentState(session);
		
		// detached State
		// after closing the connection then we are detaching which means detaching the link between the session and the object 
		detachedState(session);
		
	}
	
	private static void detachedState(Session session) {
		Employees emp = new Employees(3,"balu",29000);
		session.beginTransaction();
		session.persist(emp);
		session.getTransaction().commit();
		session.close();
		emp.setSalary(40000);
		// unable to link
		// session.persist(emp);
	}

	private static void persistentState(Session session) {
		Employees emp = new Employees(2,"sai",29000);
		session.beginTransaction();
		session.persist(emp);
		session.getTransaction().commit();
		session.close();
	}

	private static void transientState() {
		Employees emp = new Employees();
	}
}
