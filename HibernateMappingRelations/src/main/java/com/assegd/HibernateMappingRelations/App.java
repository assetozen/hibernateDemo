package com.assegd.HibernateMappingRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Student student = new Student();
       Laptop laptop = new Laptop();
    
       laptop.setLid(101);
       laptop.setLname("HP");
       laptop.getStudent().add(student);
       
     
       student.setRollno(1);
       student.setName("Assegd");
       student.setMarks(100);
       student.getLaptop().add(laptop);
       
       
       Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
       SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.save(student);
       session.save(laptop);
       
       session.getTransaction().commit();
       }
}
