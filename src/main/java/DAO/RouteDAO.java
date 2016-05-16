package DAO;

import model.Route;

import java.sql.SQLException;
import java.util.Collection;

public interface RouteDAO {
	Collection<Route> getAllRoutes() throws SQLException;
}
