package DAO;

import java.sql.SQLException;
import java.util.Collection;

import model.Bus;
import model.Driver;

public interface DriverDAO {
	Collection<Driver> getDriversByBus(Bus bus) throws SQLException;
}
