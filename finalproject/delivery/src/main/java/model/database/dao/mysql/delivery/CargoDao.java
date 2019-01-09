package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.Cargo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CargoDao extends AbstractDAO {

    public CargoDao(Connection connection) {
        super(connection);
    }

    public Cargo getCargoById(long id) {
        String query = "select * from cargoes where id=" + id + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return new Cargo(
                        resultSet.getInt("type_id"),
                        null,
                        resultSet.getInt("weight")
                );
            }

        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }

        return null;

    }

    public void addCargo(Cargo cargo) {
        String query = buildInsertInvoiceQuery(cargo);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            // TODO
            e.printStackTrace();
        }

    }


    private String buildInsertInvoiceQuery(Cargo cargo) {

        StringBuilder query = new StringBuilder("insert into cargoes ");
        query.append("(id, type_id, weight) values (");
        query.append(cargo.getId()).append(", ");
        query.append(cargo.getType().getId()).append(", ");
        query.append(cargo.getWeight()).append(");");

        System.out.println(query.toString());
        return query.toString();
    }


    @Override
    public List getAll() {
        return null;
    }
}
