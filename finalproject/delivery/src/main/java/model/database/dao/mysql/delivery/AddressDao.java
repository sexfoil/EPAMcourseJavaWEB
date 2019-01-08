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


    public void updateAddress(Integer streetId, String build, String section, String apart, int userId) {
        executeUpdate(buildUpdateAddressQuery(streetId, build, section, apart, userId));
    }


    public void addAddress(Address address) {
        executeUpdate(buildInsertAddressQuery(address));
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


    private void executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            // TODO
            e.printStackTrace();
        }
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

    private String buildUpdateAddressQuery(Integer streetId, String build, String section, String apart, int userId) {

        StringBuilder query = new StringBuilder("update addresses set ");
        if (streetId != null) {
            query.append("street_id=").append(streetId);
            if (build != null || section != null || apart != null) {
                query.append(", ");
            }
        }
        if (build != null) {
            query.append("building='").append(build).append("'");
            if (section != null || apart != null) {
                query.append(", ");
            }
        }
        if (section != null) {
            query.append("section='").append(section).append("'");
            if (apart != null) {
                query.append(", ");
            }
        }
        if (apart != null) {
            query.append("apartment='").append(apart).append("'");
        }
        query.append(" where user_id=").append(userId).append(";");

        System.out.println(query.toString());
        return query.toString();
    }

}
