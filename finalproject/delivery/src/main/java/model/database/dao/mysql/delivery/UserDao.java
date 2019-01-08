package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.user.User;
import model.entity.user.UserData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDAO {

    public UserDao(Connection connection) {
        super(connection);
    }


    public User getUserByString(String value, String field) {
        String query = "select * from users where " + field + " = ?;";
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            user = getUser(resultSet);
            System.out.println("GET USER=" + user);
        } catch (SQLException e) {
            // TODO
            e.printStackTrace();
        }
        return user;
    }

    public boolean addUser(User user) {
        String query = buildInsertUserQuery(user);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("CREATE USER=" + user.getLogin());
        } catch (SQLException e) {
            // TODO
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private User getUser(ResultSet result) throws SQLException {
        User user = null;
        if(result.next()) {
             user = new User(
                    result.getInt("id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("login"),
                    result.getString("password"),
                    result.getString("email"),
                    result.getString("sex"),
                    result.getInt("age")

            );
        }
        return user;
    }


    @Override
    public List getAll() {
        return null;
    }



    private String buildInsertUserQuery(User user) {

        StringBuilder query = new StringBuilder("insert into users ");
        query.append("(first_name, last_name, login, password, email, age, sex) values ('");
        query.append(user.getFirstName()).append("', '");
        query.append(user.getLastName()).append("', '");
        query.append(user.getLogin()).append("', '");
        query.append(user.getPassword()).append("', '");
        query.append(user.getEmail()).append("', ");
        query.append(user.getAge()).append(", '");
        query.append(user.getSex()).append("');");

        System.out.println(query.toString());
        return query.toString();
    }
}
