package util;

import javax.swing.JOptionPane;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * ������ �������� �����, ������� ����� ������ ��� ������-���� � ���������� ���
 * ������ ���� SessionFactory, ������� �������� �� �������� hibernate-������.
 * 
 * @author ���
 * 
 */

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			final String text = "������ ��� �������� ������";
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
