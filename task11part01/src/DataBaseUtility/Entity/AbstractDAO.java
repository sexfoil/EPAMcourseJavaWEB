package DataBaseUtility.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public abstract class AbstractDAO {

    protected Connection connection;

    public AbstractDAO() {
        //connection =
    }

    public void createConnection(ResourceBundle resource) throws SQLException {
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        connection = DriverManager.getConnection(url, user, pass);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    public void closeStatement(Statement statement) throws SQLException {
        if (statement != null) statement.close();
    }
}
