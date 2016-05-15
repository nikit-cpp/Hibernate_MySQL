package util;

import javax.swing.JOptionPane;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;

/**
 * Теперь создадим класс, который будет хавать наш конфиг-файл и возвращать нам
 * объект типа SessionFactory, который отвечает за создание hibernate-сессии.
 * 
 * @author Ник
 * 
 */

public class HibernateUtil {
	/**
	 * The SessionFactory is heavyweight object so usually it is created during application start up and kept for later use
	 */
	private static final SessionFactory sessionFactory;

	private static final ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure(); // loads hibernate.cfg.xml from classpath
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			final String text = "Ошибка при создании сессии";
			JOptionPane.showMessageDialog(null, text+": "+ex.getMessage(), text, JOptionPane.OK_OPTION);
			System.err.println(text+".\n" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeServiceRegistry() {
		StandardServiceRegistryBuilder.destroy(serviceRegistry);
	}
}
