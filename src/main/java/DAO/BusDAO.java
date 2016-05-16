package DAO;

import model.Bus;
import model.Driver;
import model.Route;

import java.util.Collection;
import java.sql.SQLException;

public interface BusDAO {
	public void addBus(Bus bus) throws SQLException;

	public void updateBus(Long bus_id, Bus bus) throws SQLException;

	public Bus getBusById(Long bus_id) throws SQLException;

	public Collection<Bus> getAllBusses() throws SQLException;

	public void deleteBus(Bus bus) throws SQLException;

	public Collection<Bus> getBussesByDriver(Driver driver) throws SQLException;

	public Collection<Bus> getBussesByRoute(Route route) throws SQLException;

}
