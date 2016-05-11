package util;

import javax.swing.JOptionPane;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Теперь создадим класс, который будет хавать наш конфиг-файл и возвращать нам
 * объект типа SessionFactory, который отвечает за создание hibernate-сессии.
 * 
 * @author Ник
 * 
 */

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			final String text = "Ошибка при создании сессии";
			JOptionPane.showMessageDialog(null, text+": "+ex.getMessage(),
					text, JOptionPane.OK_OPTION);
			System.err.println(text+".\n" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
