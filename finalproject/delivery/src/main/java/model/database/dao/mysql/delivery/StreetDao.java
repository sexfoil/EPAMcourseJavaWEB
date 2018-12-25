package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;

import java.sql.Connection;
import java.util.List;

public class StreetDao extends AbstractDAO {

    public StreetDao(Connection connection) {
        super(connection);
    }

    @Override
    public List[] getAll() {
        return new List[0];
    }
}
