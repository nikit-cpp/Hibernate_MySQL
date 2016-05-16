package DAO;

import dto.CustomBus;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import util.HibernateUtil;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nik on 16.05.16.
 */
public class CustomBusDAO {
    public Collection<CustomBus> getAllCustomBusses() throws SQLException {
        Session session = null;
        List<CustomBus> busses = new ArrayList<CustomBus>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query sqlQuery = session.createSQLQuery("select bus.id as myCustomId, bus.number as myCustomNumber from bus;").setResultTransformer(Transformers.aliasToBean(CustomBus.class));
            busses = sqlQuery.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return busses;
    }
}
