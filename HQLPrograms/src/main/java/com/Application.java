package com;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.model.Student;

public class Application {
    public static void main(String[] args) {
        SessionFactory sessionFactory = com.utils.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
//            insertStudent(session);
//            retriveData(session);
//        	  retriveRandom(session);
//        	  insertUsingMutationQuery(session);
//        	  updateMutationQuery(session);
//        	  deleteUsingMutationQuery(session);
        	
        	} finally {
            session.close();  
        } 
    }

	private static void deleteUsingMutationQuery(Session session) {
		MutationQuery query = session.createMutationQuery("Delete from Student where studentId=?1");
		query.setParameter(1, 4);
		session.beginTransaction();
		query.executeUpdate();
		session.getTransaction().commit();
	}

	private static void updateMutationQuery(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createMutationQuery("Update Student set marks=?1 where studentId=?2");
		query.setParameter(1, 36);
		query.setParameter(2, 5);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	private static void insertUsingMutationQuery(Session session) {
		MutationQuery query = session.createMutationQuery("Insert into Student(name,marks) values(?1,?2)");
//        	query.setParameter(1, q)
		query.setParameter(1, "akash");
		query.setParameter(2, 32);
		session.beginTransaction();
		query.executeUpdate();
		session.getTransaction().commit();
	}

	private static void retriveRandom(Session session) {
		SelectionQuery<Student> query = session.createSelectionQuery("From Student where studentId=?1",Student.class);
		query.setParameter(1, 1);
		// I can also use the studentId and id here if i use id then i has to change the name in the mysql and i has to anotate @Column and then change it ....
		// it is taking automatically using the @coulumn (name= id)
		List<Student> list = query.list();
		System.out.println(list);
	}

    private static void retriveData(Session session) {
        SelectionQuery<Student> query = session.createSelectionQuery("Select s from Student s", Student.class);
        // we can also write the query as "From Student";
        List<Student> list = query.list();
        System.out.println(list);
    }

    private static void insertStudent(Session session) {
        Student student = new Student("mahendar", 37);
        Student student1 = new Student("balu", 32);
        session.beginTransaction();
        session.persist(student);
        session.persist(student1);
        session.getTransaction().commit();
    }
}
