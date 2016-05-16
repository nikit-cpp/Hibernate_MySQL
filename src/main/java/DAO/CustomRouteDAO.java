package DAO;

import model.Route;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nik on 16.05.16.
 */
public class CustomRouteDAO {
    public Collection<Route> getAllCustomRoutes() throws SQLException {
        Session session = null;
        List<Route> routes = new ArrayList<Route>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query sqlQuery = session
                    .createSQLQuery("select {r.*}, {b.*} from bus b join route r on b.route_id = r.id;")
                    .addEntity("r", Route.class)
                    .addJoin("b", "r.busses")
                    .addEntity("r", Route.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            routes = sqlQuery.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Ошибка 'getAllCustomRoutes'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return routes;
    }
}
