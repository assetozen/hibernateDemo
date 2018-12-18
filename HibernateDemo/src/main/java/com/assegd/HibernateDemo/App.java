package com.assegd.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		AlienName alienName = new AlienName();
		alienName.setFname("Assegd");
		alienName.setMname("Assefa");
		alienName.setLname("Asfaw");
		
		Alien alien = new Alien();
		alien.setAid(101);
		alien.setColor("Blue");
		alien.setAname(alienName);
		

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sessionFactory = con.buildSessionFactory(reg);
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(alien);
		
		tx.commit();
		System.out.println(alien);
	}
}
