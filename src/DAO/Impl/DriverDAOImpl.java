package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;
import logic.Bus;
import logic.Driver;
import DAO.DriverDAO;

public class DriverDAOImpl implements DriverDAO {
	
	public Collection getDriversByBus(Bus bus) throws SQLException {
		Session session = null;
		List drivers = new ArrayList<Driver>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Long bus_id = bus.getId();
			Query query = session.createQuery(
					" select d "
							+ " from Driver d INNER JOIN d.busses bus"
							+ " where bus.id = :busId ")
						.setLong("busId", bus_id);
			drivers = (List<Driver>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Ошибка 'getDriversByBus'", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return drivers;
	}

}
