package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.user.User;
import model.entity.user.UserData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao extends AbstractDAO {

    public UserDao(Connection connection) {
        super(connection);
    }

    public User getUserById(int id) {
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("select * from users where id='" + id + "';");
            result.next();
            //name = result.getString("first_name");
            //System.out.println("User = " + name);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    public User getUserByString(String value, String field) {
        String query = "select * from users where " + field + "='" + value + "'";
        User user = null;
        try (Statement statement = connection.createStatement()) {
            user = getUser(statement.executeQuery(query));
            System.out.println("GET USER=" + user);
        } catch (SQLException e) {
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
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List[] getAll() {
        return new List[0];
    }

    private ResultSet getResultSet(String queryString) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(queryString);
        }
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
                    result.getInt("age"),
                    (UserData) result.getObject("user_data")
            );
        }
        return user;
    }

    private String buildInsertUserQuery(User user) {
        StringBuilder query = new StringBuilder("insert into users ");
        query.append("(first_name, last_name, login, password, email, age, sex, user_data) ");
        query.append("values ('");
        query.append(user.getFirstName()).append("', '");
        query.append(user.getLastName()).append("', '");
        query.append(user.getLogin()).append("', '");
        query.append(user.getPassword()).append("', '");
        query.append(user.getEmail()).append("', ");
        query.append(user.getAge()).append(", '");
        query.append(user.getSex()).append("', NULL);");
        System.out.println(query.toString());
        return query.toString();
    }
}
