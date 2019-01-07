package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;

import java.sql.Connection;
import java.util.List;

public class CargoDao extends AbstractDAO {

    public CargoDao(Connection connection) {
        super(connection);
    }


    @Override
    public List getAll() {
        return null;
    }
}
