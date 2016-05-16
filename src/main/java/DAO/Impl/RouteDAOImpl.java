package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import model.Route;

import org.hibernate.Session;

import util.HibernateUtil;
import DAO.RouteDAO;

public class RouteDAOImpl implements RouteDAO {
	
	public Collection<Route> getAllRoutes() throws SQLException {
		Session session = null;
		List<Route> routes = new ArrayList<Route>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			routes = session.createCriteria(Route.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return routes;
	}


}
