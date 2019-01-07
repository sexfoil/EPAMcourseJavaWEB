package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDao extends AbstractDAO {

    public StatusDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<String> getAll() {
        List<String> status = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("select status_name from delivery_status;");
            while(result.next()) {
                status.add(result.getString("status_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}
