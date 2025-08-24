package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employees;
import com.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
		Session session = sessionFactory.openSession(); 
		
		// Inserting the data
//		 insertData(session);
		
		// Getting the data
//		 Select Operation
//		 getData(session);
		
		// Updating the employees
		// updateData(session);
		
		 // Delete data 
//		deleteData(session);
		 
		 // Dirty Checking in the hibernate 
		 dirtyChecking(session);
		 getData(session);
		 
	}
	
	private static void dirtyChecking(Session session) {
		
		Employees employee = session.find(Employees.class, 1);
		employee.setName("Akash k");
		session.beginTransaction();
		System.out.println("data was updated..");
		session.getTransaction().commit();
	}

	private static void deleteData(Session session) {
		Employees emp = new Employees(1,"",0);
		session.beginTransaction();
		session.remove(emp);
		session.getTransaction().commit();
		
	}

	private static void updateData(Session session) {
		
		Employees employees = session.find(Employees.class, 1);
		employees.setName("Akash K");
		session.beginTransaction();
		session.persist(employees); 
		System.out.println("data was updated..");
		session.getTransaction().commit();
		
		// or
		// -------------------------------- update the values ... 
		// this wont work 
		// 1. get the data
		// 2. update what is required 
		// 3. persist the data again or merge the data again
		Employees emp = new Employees();
		emp.setId(1);
		emp.setSalary(50000);
		session.beginTransaction();
		session.merge(emp);
		session.getTransaction().commit();
		// --------------------------------
		// The above don't work 
		// we can do 
		Employees employee = session.find(Employees.class, 1);
		employee.setName("Akash K");
		session.beginTransaction();
		session.merge(employee); 
		System.out.println("data was updated..");
		session.getTransaction().commit();
	}

	public static void getData(Session session) {
		
		Employees employees = session.find(Employees.class, 1);
		System.out.println(employees);
	}

	public static void insertData(Session session) {
		
		Employees emp = new Employees(1 ,"akash",50000);
		session.beginTransaction();
		session.persist(emp); 
		System.out.println("data was inserted..");
		session.getTransaction().commit();
	}
}


