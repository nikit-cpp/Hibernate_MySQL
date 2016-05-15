package DAO;

import java.sql.SQLException;
import java.util.Collection;

public interface RouteDAO {
	Collection getAllRoutes() throws SQLException;
}
