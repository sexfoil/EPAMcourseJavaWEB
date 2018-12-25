package model.database.dao;

import java.sql.Connection;

public abstract class AbstractDAO implements Dao {

    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

}
