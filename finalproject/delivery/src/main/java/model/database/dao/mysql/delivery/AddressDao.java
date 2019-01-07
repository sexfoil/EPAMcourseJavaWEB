package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AddressDao extends AbstractDAO {

    public AddressDao(Connection connection) {
        super(connection);
    }


    public void addAddress(Address address) {
        String query = buildInsertAddressQuery(address);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            // TODO
            e.printStackTrace();
        }

    }


    public Address getUserAddress(int userId) {
        String query = "select * from addresses where user_id=" + userId + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Address address = new Address(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("street_id"),
                        resultSet.getString("building"),
                        resultSet.getString("section"),
                        resultSet.getString("apartment")
                );
                return address;
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


    private String buildInsertAddressQuery(Address address) {

        StringBuilder query = new StringBuilder("insert into addresses ");
        query.append("(user_id, street_id, building, section, apartment) values (");
        query.append(address.getUserId()).append(", ");
        query.append(address.getStreetId()).append(", '");
        query.append(address.getBuilding()).append("', '");
        query.append(address.getSection()).append("', '");
        query.append(address.getApartment()).append("');");

        System.out.println(query.toString());
        return query.toString();
    }

}
