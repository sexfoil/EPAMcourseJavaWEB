package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.Street;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StreetDao extends AbstractDAO {

    public StreetDao(Connection connection) {
        super(connection);
    }



    public Street getStreetById(int id) {
        String query = "select * from streets where id=" + id + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);

            return getStreet(result);

        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return null;
    }


    public Street getStreetByName(String name) {
        String query = "select * from streets where name='" + name + "';";
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);

            return getStreet(result);

        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Street> getAll() {
        List<Street> streets = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("select * from streets;");
            while(result.next()) {
                streets.add(
                        new Street(result.getInt("id"),
                                result.getString("name"),
                                result.getInt("distance"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return streets;
    }


    private Street getStreet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            Street street = new Street(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("distance")
            );
            return street;
        }
        return null;
    }
}
