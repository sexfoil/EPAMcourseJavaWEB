package model.database.dao.connection;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPoolMysqlDelivery {

    private static volatile DataSource dataSource;

    private static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolMysqlDelivery.class) {
                if (dataSource == null) {
                    BasicDataSource bds = new BasicDataSource();

                    ResourceBundle resource = ResourceBundle.getBundle("property.database.delivery_mysql");

                    bds.setDriverClassName(resource.getString("driver"));
                    bds.setUrl(resource.getString("url"));
                    bds.setUsername(resource.getString("user"));
                    bds.setPassword(resource.getString("password"));
                    bds.setConnectionProperties(resource.getString("characterEncoding") + ";useUnicode=yes;");
                    bds.setMaxActive(Integer.valueOf(resource.getString("maxActive")));
                    bds.setMinIdle(Integer.valueOf(resource.getString("minIdle")));
                    bds.setMaxIdle(Integer.valueOf(resource.getString("maxIdle")));
                    bds.setMaxOpenPreparedStatements(Integer.valueOf(resource.getString("statements")));

                    dataSource = bds;
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            System.out.println("CONNECTION...");
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
