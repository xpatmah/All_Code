package com.org.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.sql.domain.UserDetails;

/**
 * Hello world!
 *
 */
public class HibernateApp 
{
    public static void main( String[] args )
    {
        UserDetails details = new UserDetails();
        
        details.setId(6);
        details.setName("Hello World");
        details.setAddress("Addression "+details.getId());
        details.setDescription("Description "+details.getId());
        details.setJoiningDate(new Date());
    	
        UserDetails detail = new UserDetails();
        
        detail.setId(7);
        detail.setName("Hello World Again");
        details.setAddress("Addression "+detail.getId());
        details.setDescription("Description "+detail.getId());
        detail.setJoiningDate(new Date());
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(details);
        session.save(detail);
        session.getTransaction().commit();
        session.close();
        
        // getting the user object
         session = factory.openSession();
         session.beginTransaction();
        UserDetails user  = session.get(UserDetails.class, 6);
        
        System.out.println(user.getAddress());
        session.close();
        
        factory.close();
        
        
        
    }
    
}
