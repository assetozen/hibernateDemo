package com.assegd.HibernateObjectStatesANDGetVsLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	
		Laptop laptop = (Laptop) session.load(Laptop.class, 6);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(laptop);
	
	
		
		session.getTransaction().commit();
	

	}
}
