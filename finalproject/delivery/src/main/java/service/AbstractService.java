package service;

import model.database.dao.AbstractDAO;
import model.database.dao.connection.ConnectionPoolMysqlDelivery;
import model.database.dao.factory.DeliveryMySQLDaoFactory;
import utility.DeliveryNames;

public abstract class AbstractService {

    protected AbstractDAO abstractDAO;

    public AbstractService(DeliveryNames name) {
        abstractDAO = DeliveryMySQLDaoFactory.getInstance()
                .getDao(name, ConnectionPoolMysqlDelivery.getConnection());
    }

}
