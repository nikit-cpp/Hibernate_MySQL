package launcher;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

//import org.apache.log4j.PropertyConfigurator;

import DAO.CustomBusDAO;
import DAO.CustomRouteDAO;
import dto.CustomBus;
import dto.CustomRoute;
import factory.Factory;
import util.HibernateUtil;
import model.*;

public class Main {
	public static void main(String[] args) throws SQLException {

		Collection<Route> routes = Factory.getInstance().getRouteDAO().getAllRoutes();
		Iterator<Route> routeIterator = routes.iterator();
		System.out.println("========Все маршруты=========");
		while (routeIterator.hasNext()) {
			Route route = routeIterator.next();
			System.out.println("Маршрут : " + route.getName() + "  Номер маршрута : " + route.getNumber());
			Collection<Bus> busses = Factory.getInstance().getBusDAO().getBussesByRoute(route);
			Iterator<Bus> iterator2 = busses.iterator();
			while (iterator2.hasNext()) {
				Bus bus = iterator2.next();
				System.out.println("\tАвтобус № " + bus.getNumber());
			}
		}

		Collection<Bus> busses = Factory.getInstance().getBusDAO().getAllBusses();
		Iterator<Bus> busIterator = busses.iterator();
		System.out.println("========Все автобусы=========");
		while (busIterator.hasNext()) {
			Bus bus = busIterator.next();
			Collection<Driver> drivers = Factory.getInstance().getDriverDAO().getDriversByBus(bus);
			Iterator<Driver> iterator2 = drivers.iterator();
			System.out.println("Автобус № " + bus.getNumber());
			while (iterator2.hasNext()) {
				Driver driver = iterator2.next();
				System.out.println("\tИмя : " + driver.getName() + "   Фамилия: " + driver.getSurname());
			}
		}

		System.out.println("========CustomBusses=========");
		Collection<CustomBus> customBuses = new CustomBusDAO().getAllCustomBusses();
		Iterator<CustomBus> customBusesIterator = customBuses.iterator();
		while (customBusesIterator.hasNext()) {
			CustomBus bus = customBusesIterator.next();
			System.out.println("CustomBus: id=" + bus.getMyCustomId() + ", number=" + bus.getMyCustomNumber());
		}

		System.out.println("========CustomRoutes=========");
		Collection<CustomRoute> customRoutes = new CustomRouteDAO().getAllCustomRoutes();
		Iterator<CustomRoute> customRoutesIterator = customRoutes.iterator();
		while (customRoutesIterator.hasNext()) {
			CustomRoute route = customRoutesIterator.next();
			System.out.println("CustomRoute: id=" + route.getId() + ", name=" + route.getRouteCustomName());
			Collection<CustomBus> customBuses2 = route.getCustomBusses();
			Iterator<CustomBus> customBusesIterator2 = customBuses2.iterator();
			while (customBusesIterator2.hasNext()) {
				CustomBus bus = customBusesIterator2.next();
				System.out.println("\tCustomBus: id=" + bus.getMyCustomId() + ", number=" + bus.getMyCustomNumber());
			}
		}

		System.out.println("========Выход========");
		HibernateUtil.getSessionFactory().close();
		HibernateUtil.closeServiceRegistry();
	}
}