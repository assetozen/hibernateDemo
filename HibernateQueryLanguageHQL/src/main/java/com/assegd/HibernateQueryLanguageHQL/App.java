package com.assegd.HibernateQueryLanguageHQL;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		SQLQuery query = session.createSQLQuery("select name,marks from student where marks>60");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List students = query.list();
		
		for (Object student : students) {
			Map map = (Map)student;
			System.out.println(map.get("name") + " : " + map.get("marks"));
		}

		session.getTransaction().commit();
	}
}
