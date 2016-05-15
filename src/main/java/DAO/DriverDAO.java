package DAO;

import java.sql.SQLException;
import java.util.Collection;

import logic.Bus;

public interface DriverDAO {
	Collection getDriversByBus(Bus bus) throws SQLException;
}
