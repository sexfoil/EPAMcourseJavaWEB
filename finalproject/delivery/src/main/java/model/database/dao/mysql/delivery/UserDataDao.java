package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.user.UserData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDataDao extends AbstractDAO {

    public UserDataDao(Connection connection) {
        super(connection);
    }


    public void addUserData(UserData data) {
        String query = buildInsertUserDataQuery(data);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            // TODO
            e.printStackTrace();
        }

    }


    public UserData getUserData(int userId) {
        String query = "select * from users_data where user_id=" + userId + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                UserData userData = new UserData(
                        resultSet.getInt("user_id"),
                        resultSet.getString("cell_number")
                );
                return userData;
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List getAll() {
        return null;
    }


    private String buildInsertUserDataQuery(UserData data) {

        StringBuilder query = new StringBuilder("insert into users_data ");
        query.append("(user_id, cell_number, address) values (");
        query.append(data.getUserId()).append(", '");
        query.append(data.getCellNumber()).append("', ");
        query.append(data.getUserId()).append(");");

        System.out.println(query.toString());
        return query.toString();
    }

}
