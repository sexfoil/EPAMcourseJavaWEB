package DataBaseUtility;

import DataBaseUtility.Entity.AbstractDAO;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorMySQL extends AbstractDAO {

    private String driverName;

    public ConnectorMySQL() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        driverName = resource.getString("driver");
        try {
            Class.forName(driverName);
            createConnection(resource);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
