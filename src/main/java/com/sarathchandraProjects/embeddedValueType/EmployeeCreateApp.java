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
public class EmployeeCreateApp 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Employee.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
		  Address homeAddress1 = new Address("Ongole", "AP", 523001, "Old Market Center","Sai Surya towers");
		  Address workLocationAddress1 = new Address("Chennai", "Tamil nadu", 603103, "Sipcot","Siruseri");
		  
		  Address homeAdress2 = new Address("Ongole","AP", 523001, "Srinivasa hall back side", "Gopal nagar");
		  Address workLocationAddress2 = new Address("Kalpakam", "Tamil nady", 603104, "Pudupattanam","1st street");
		  
		  
		  Employee employee1 = new Employee("TCS", "General", workLocationAddress1, homeAddress1); 
		  Employee employee2 = new Employee("Cognizant", "General", workLocationAddress2, homeAdress2);
		  
		  Transaction transaction = session.beginTransaction();
		  
		  session.persist(employee1); 
		  session.persist(employee2);
		  
		  transaction.commit();
		 
        
    }
}
