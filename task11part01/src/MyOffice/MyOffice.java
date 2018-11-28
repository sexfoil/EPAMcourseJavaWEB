package MyOffice;

import DataBaseUtility.ConnectorMySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyOffice {

    public void run() throws SQLException {

        ConnectorMySQL db = new ConnectorMySQL();
        Statement st = null;

        st = db.getStatement();
        String query = "select * from employees;";
        ResultSet rs = st.executeQuery(query);
        System.out.println("DATABASE");
        while (rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getString(3));

        }

        db.closeStatement(st);

        db.closeConnection();
    }
}
