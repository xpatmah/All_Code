package com.org.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.sql.domain.Address;
import com.org.hibernate.sql.domain.Description;
import com.org.hibernate.sql.domain.Job;
import com.org.hibernate.sql.domain.Status;
import com.org.hibernate.sql.domain.UserDetails;
import com.org.hibernate.sql.domain.Vehicle;

/**
 * Hello world!
 *
 */
public class HibernateApp 
{
    public static void main( String[] args )
    {
        UserDetails user1 = new UserDetails();
        
        user1.setId(6);
        user1.setName("Hello World");
        Address ad = new Address();
        ad.setStreat("Streat"+user1.getId());
        ad.setPincode("122002");
        ad.setState("State "+user1.getId());
        ad.setCity("Ciyt "+user1.getId());
       
        Address office = new Address();
        office.setStreat("Office_Streat"+user1.getId());
        office.setPincode("office_122002");
        office.setState("office_State "+user1.getId());
        office.setCity("office_Ciyt "+user1.getId());
        
        user1.setHomeAddress(ad);
        user1.setOfficeAddress(office);
        
        Description d1 = new Description();
        d1.setName("This is for some one ");
        
        user1.setDescription(d1);
       
        
        user1.setJoiningDate(new Date());
        
        Vehicle v1= new Vehicle();
        v1.setName("car");
        
        Vehicle v2= new Vehicle();
        v2.setName("carPool");
        
        v1.setUser(user1);
        v2.setUser(user1);
        user1.getVehicle().add(v1);
        user1.getVehicle().add(v2);
        
        Status s1 = new Status();
    	s1.setStatus("ACTIVE");
       
    	Status s2 = new Status();
    	s2.setStatus("DEACTIVE");
    	
    	user1.getStatus().add(s1);
    	user1.getStatus().add(s2);
        
    	
    	user1.setPassportNo("ABX-YZ");
    	
    	// User Jobs
    	
    	Job j1 = new Job();
    	j1.setDescription("Work");
    	j1.setUserDetails(user1);
    	
    	Job j2 = new Job();
    	j2.setDescription("kitchen");
    	j2.setUserDetails(user1);
    	
    	user1.getJobs().add(j1);
    	user1.getJobs().add(j2);
    	
    	//=========================================================//
    	
    	UserDetails user2 = new UserDetails();
        
        user2.setId(7);
        user2.setName("Hello World Again");
       
        
        ad = new Address();
        ad.setStreat("Streat"+user2.getId());
        ad.setPincode("122003");
        ad.setState("State "+user2.getId());
        ad.setCity("Ciyt "+user2.getId());
       
        office = new Address();
        office.setStreat("Office_Streat"+user2.getId());
        office.setPincode("office_122003");
        office.setState("office_State "+user2.getId());
        office.setCity("office_Ciyt "+user2.getId());
        
        user2.setHomeAddress(ad);
        user2.setOfficeAddress(office);
        
        Description d2 = new Description();
        d2.setName("This is for me");
     
        user2.setDescription(d2);
        
        Vehicle v3= new Vehicle();
        v3.setName("Airplane");
        
        Vehicle v4 = new Vehicle();
        v4.setName("AirBus");
        
        v3.setUser(user2);
        v4.setUser(user2);
        
        user2.getVehicle().add(v3);
        user2.getVehicle().add(v4);
        
        user2.setJoiningDate(new Date());
        user2.setPassportNo("AWE-BER");
        
        s1 = new Status();
    	s1.setStatus("XACTIVE");
        
    	s2 = new Status();
    	s2.setStatus("CDEACTIVE");
    	
    	user2.getStatus().add(s1);
    	user2.getStatus().add(s2);
    	
    	Job j3 = new Job();
    	j3.setDescription("RTO");
    	j3.setUserDetails(user2);
    	
    	Job j4 = new Job();
    	j4.setDescription("KTO");
    	j4.setUserDetails(user2);
    	
    	user2.getJobs().add(j3);
    	user2.getJobs().add(j4);
    	
    	//==============================================================//
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(d1);
        session.save(d2);
        session.persist(user1);
        session.persist(user2);
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
