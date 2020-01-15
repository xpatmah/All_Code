package com.org.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.sql.domain.FourWheelerVehicle;
import com.org.hibernate.sql.domain.TwoWheelerVehicle;
import com.org.hibernate.sql.domain.Vehicle;

public class HibernateInheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle v1 = new Vehicle();
		v1.setName("Vehicle");
		
		TwoWheelerVehicle v2 = new TwoWheelerVehicle();
		v2.setName("Two Wheeler");
		v2.setTwoWheelerHandle("Two Wheeler");
		
		FourWheelerVehicle v3 = new FourWheelerVehicle();
		
		v3.setName("Maruti");
		
		v3.setForWheelerHandle("FourWheeler Vehicle");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(v1);
		session.save(v2);
		session.save(v3);
		
		session.getTransaction().commit();
		
		session.close();
		
		factory.close();
		
		
	}

}
