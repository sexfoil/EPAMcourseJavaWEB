package model.database;

import model.database.dao.AbstractDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MySQLDataBaseWorker {

    private String driverName;

    public MySQLDataBaseWorker() {
        ResourceBundle resource = ResourceBundle.getBundle("property/database/dbinfo");

        driverName = resource.getString("driver");

    }



    public List<String> connectDB() throws SQLException {
        //ConnectorMySQL db = new ConnectorMySQL();
        Statement st = null;

       // st = this.getStatement();
        String query = "select * from users;";
        ResultSet rs = st.executeQuery(query);
        System.out.println("DATABASE");
        List<String> users = new ArrayList<>();
        while (rs.next()) {
            users.add(rs.getString(2) + " " + rs.getString(3));

        }

        //closeStatement(st);

        //closeConnection();
        return users;
    }


}
