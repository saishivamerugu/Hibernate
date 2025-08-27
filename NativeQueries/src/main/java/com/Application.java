package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.MutationQuery;

import com.model.Student;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory = com.utils.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        retriveUsingNativeQueries(session);
        updateStudentMarks(session);
        deleteStudent(session);
        insertStudent(sessionFactory, session);
    }
    
    private static void updateStudentMarks(Session session) {
        session.beginTransaction();
        MutationQuery updateQuery = session.createNativeMutationQuery(
                "UPDATE student SET marks = ?1 WHERE studentId = ?2"
        );
        updateQuery.setParameter(1, 36);
        updateQuery.setParameter(2, 5);
        updateQuery.executeUpdate();
        session.getTransaction().commit();
    }

    private static void deleteStudent(Session session) {
        session.beginTransaction();
        MutationQuery deleteQuery = session.createNativeMutationQuery(
                "DELETE FROM student WHERE studentId = ?1"
        );
        deleteQuery.setParameter(1, 6);
        deleteQuery.executeUpdate();
        session.getTransaction().commit();
    }

	private static void insertStudent(SessionFactory sessionFactory, Session session) {
		MutationQuery query = session.createNativeMutationQuery("insert into student(name,marks) values (?1,?2)");
        query.setParameter(1, "kishore");
        query.setParameter(2, 45);
        
        session.beginTransaction();
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
	}

    private static void retriveUsingNativeQueries(Session session) {
        NativeQuery<Student> query = session.createNativeQuery(
            "SELECT studentId as studentId, name as name, marks as marks FROM student WHERE studentId = ?1", 
            Student.class);
        query.setParameter(1, 1);
        List<Student> list = query.list();
        System.out.println(list);
    }
 

}
