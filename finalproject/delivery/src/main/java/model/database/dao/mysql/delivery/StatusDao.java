package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.Status;

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
    public List<Status> getAll() {
        List<Status> status = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("select * from delivery_status;");
            while(result.next()) {
                status.add(new Status(
                        result.getInt("id"),
                        result.getString("status_name")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}
