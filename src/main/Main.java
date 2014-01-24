package main;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

//import org.apache.log4j.PropertyConfigurator;

import util.HibernateUtil;
import logic.*;

public class Main {
	public static void main(String[] args) throws SQLException {
		try {
			// PropertyConfigurator.configure("src/log4j.properties"); //
			// работает !
			// System.setProperty("log4j.configuration",
			// "E:\\Programming\\Examples 9 java\\swt\\Hibernate_MySQL\\log4j.properties");
			// System.out.println(System.getProperties().getProperty("java.class.path"));

			Collection routes = Factory.getInstance().getRouteDAO()
					.getAllRoutes();
			Iterator iterator = routes.iterator();
			System.out.println("========Все маршруты=========");
			while (iterator.hasNext()) {
				Route route = (Route) iterator.next();
				System.out.println("Маршрут : " + route.getName()
						+ "  Номер маршрута : " + route.getNumber());
				Collection busses = Factory.getInstance().getBusDAO()
						.getBussesByRoute(route);
				Iterator iterator2 = busses.iterator();
				while (iterator2.hasNext()) {
					Bus bus = (Bus) iterator2.next();
					System.out.println("\tАвтобус № " + bus.getNumber());

				}
			}

			Collection busses = Factory.getInstance().getBusDAO()
					.getAllBusses();
			iterator = busses.iterator();
			System.out.println("========Все автобусы=========");
			while (iterator.hasNext()) {
				Bus bus = (Bus) iterator.next();
				Collection drivers = Factory.getInstance().getDriverDAO()
						.getDriversByBus(bus);
				Iterator iterator2 = drivers.iterator();
				System.out.println("Автобус № " + bus.getNumber());
				while (iterator2.hasNext()) {
					Driver driver = (Driver) iterator2.next();
					System.out.println("\tИмя : " + driver.getName()
							+ "   Фамилия: " + driver.getSurname());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("========Выход========");
			HibernateUtil.getSessionFactory().close();
		}
	}
}