package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.model.Car;
import com.model.CarId;
import com.model.Student;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = com.util.HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
//		insertMethod(session);	
//		carInsertion(session);
//		retriveDataUsingNamedQueries(session);
		
		NamedQueryMutationQuery(session);
		
		
	}

	private static void NamedQueryMutationQuery(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createNamedMutationQuery("updateStudent");
		query.setParameter(1, "Ashok Kumar");
		query.setParameter(2, 2);
		query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Updated Sucessfully");
	}

	private static void retriveDataUsingNamedQueries(Session session) {
		Query<Student> query = session.createNamedQuery("allStudents",Student.class);
		List<Student> list = query.list();
		System.out.println(list);
	}

	private static void carInsertion(Session session) {
		session.beginTransaction();

		Car car = new Car(new CarId(2,"xyz1234"),"Benz-Mercedes",6000000);
		session.persist(car);

		session.getTransaction().commit(); // Now you can commit.
		session.close(); // Always good to close the session
		System.out.println("Data Inserted Sucessfully...");
	}

	private static void insertMethod(Session session) {
		Student stu = new Student("akash",97);
		session.beginTransaction();
		session.persist(stu);
		session.getTransaction().commit();
		session.close();
		System.out.println("The data was inserted");
	}
}
