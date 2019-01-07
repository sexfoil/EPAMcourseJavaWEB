package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.CargoType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CargoTypesDao extends AbstractDAO {

    public CargoTypesDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<CargoType> getAll() {
        List<CargoType> cargoTypes = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("select * from cargo_types order by rate;");
            while(result.next()) {
                cargoTypes.add(
                        new CargoType(
                                result.getInt("id"),
                                result.getString("type"),
                                result.getInt("min_weight"),
                                result.getInt("max_weight"),
                                result.getInt("rate")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cargoTypes;
    }
}
