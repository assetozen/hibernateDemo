package com.assegd.HibernateFetchEagerLazy;

import java.util.Collection;

import javax.swing.plaf.synth.SynthSeparatorUI;

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

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(reg);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// TODO inserted by a.asfaw [13.12.2018, 10:07:53] /*Put Any Logic Here*/
		Alien a1 = (Alien)session.get(Alien.class, 1);
		System.out.println(a1.getAname());
		
//		Collection<Laptop> laps = a1.getLaps();
//		 
//		System.out.println("The list of laptops for "+ a1.getAname() + " are: ");
//		for (Laptop laptop : laps) {
//			System.out.println(laptop);
//		}

		System.out.println("hi");
		session.getTransaction().commit();
	}
}
