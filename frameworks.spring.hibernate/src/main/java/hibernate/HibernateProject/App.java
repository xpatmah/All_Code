package hibernate.HibernateProject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.sql.domain.UserDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDetails details = new UserDetails();
        
        details.setId(6);
        details.setName("Hello World");
        details.setAddress("lkfdnskldgsklg");
        details.setDescription("dvnsdfjksdf");
        details.setJoiningDate(new Date());
    	
        UserDetails detail = new UserDetails();
        
        detail.setId(7);
        detail.setName("Hello World Again");
        detail.setAddress("lkfdnskldgsklg");
        detail.setDescription("dvnsdfjksdf");
        detail.setJoiningDate(new Date());
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(details);
        session.save(detail);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
    
}
