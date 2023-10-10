package com.sarathchandraProjects.embeddedValueType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sarathchandraProjects.embeddedValueType.entities.Address;
import com.sarathchandraProjects.embeddedValueType.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Employee.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
		  Address address1 = new Address("Ongole", "AP", 523001, "Old Market Center","Sai Surya towers"); 
		  Address address2 = new Address("Ongole","AP", 523001, "Srinivasa hall back side", "Gopal nagar");
		  
		  Employee employee1 = new Employee("TCS", "General", address1); 
		  Employee employee2 = new Employee("Cognizant", "General", address2);
		  
		  Transaction transaction = session.beginTransaction();
		  
		  session.persist(employee1); 
		  session.persist(employee2);
		  
		  transaction.commit();
		 
        
    }
}
