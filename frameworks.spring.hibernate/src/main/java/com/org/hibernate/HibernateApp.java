package com.org.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.sql.domain.Address;
import com.org.hibernate.sql.domain.Status;
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
        Address ad = new Address();
        ad.setStreat("Streat"+details.getId());
        ad.setPincode("122002");
        ad.setState("State "+details.getId());
        ad.setCity("Ciyt "+details.getId());
        details.setHomeAddress(ad);
        Address office = new Address();
        office.setStreat("Office_Streat"+details.getId());
        office.setPincode("office_122002");
        office.setState("office_State "+details.getId());
        office.setCity("office_Ciyt "+details.getId());
        details.setOfficeAddress(office);
        details.setDescription("Description "+details.getId());
        details.setJoiningDate(new Date());
        
        Status s1 = new Status();
    	s1.setStatus("ACTIVE");
        details.getStatus().add(s1);
    	s1 = new Status();
    	s1.setStatus("DEACTIVE");
    	details.getStatus().add(s1);
        UserDetails detail = new UserDetails();
        
        detail.setId(7);
        detail.setName("Hello World Again");
        ad = new Address();
        ad.setStreat("Streat"+detail.getId());
        ad.setPincode("122003");
        ad.setState("State "+detail.getId());
        ad.setCity("Ciyt "+detail.getId());
        detail.setHomeAddress(ad);
        office = new Address();
        office.setStreat("Office_Streat"+detail.getId());
        office.setPincode("office_122003");
        office.setState("office_State "+detail.getId());
        office.setCity("office_Ciyt "+detail.getId());
        detail.setOfficeAddress(office);
        detail.setDescription("Description "+detail.getId());
        detail.setJoiningDate(new Date());
        s1 = new Status();
    	s1.setStatus("ACTIVE");
        detail.getStatus().add(s1);
    	s1 = new Status();
    	s1.setStatus("DEACTIVE");
    	detail.getStatus().add(s1);
        
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
        
        System.out.println(user.getHomeAddress().getCity());
        session.close();
        
        factory.close();
        
        
        
    }
    
}
