package com.org.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.sql.domain.Course;
import com.org.hibernate.sql.domain.Instructor;
import com.org.hibernate.sql.domain.InstructorDetails;

public class HibernateAppTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Instructor ins = new Instructor();
		ins.setfirstName("John");
		ins.setLastName("Doe");
		InstructorDetails details = new InstructorDetails();
		details.setHobby("Cricket");
		details.setyouTubleChannel("Www.youtube.com");
		ins.setDetails(details);
		
		Course c1 = new Course();
		c1.setName("Physics");
		Course c2 = new Course();
		c2.setName("Mathmatics");
		
		ins.addCourses(c1);
		ins.addCourses(c2);
		
		session.save(ins);
		
		session.getTransaction().commit();
		
		//session.close();
		
		factory.close();
		
	}

}
