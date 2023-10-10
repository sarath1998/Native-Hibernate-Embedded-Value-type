package com.sarathchandraProjects.embeddedValueType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sarathchandraProjects.embeddedValueType.entities.Address;
import com.sarathchandraProjects.embeddedValueType.entities.Student;


/**
 * Hello world!
 *
 */
public class CreatApp 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Student.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address address1 = new Address();
        address1.setAddrLine1("Old Market Center");
        address1.setAddrLine2("Sai Surya towers");
        address1.setCity("Ongole");
        address1.setPincode(523001);
        address1.setState("AP");
        
        Address address2 = new Address("Ongole", "AP", 523001, "Srinivasa hall back side", "Goapl nagar"); 
        
        Student std1 = new Student("Sarath", 24, 903234L, address1);
        
        
        Student std2 = new Student();
        std2.setAge(24);
        std2.setMobileNo(123456L);
        std2.setName("Sasidhar");
        std2.setAddress(address2);
        
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(std1);
        session.persist(std2);
        
        transaction.commit();
        session.close();
    }
}
