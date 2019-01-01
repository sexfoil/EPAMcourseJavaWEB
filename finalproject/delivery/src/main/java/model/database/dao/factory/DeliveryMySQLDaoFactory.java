package model.database.dao.factory;

import model.database.dao.AbstractDAO;
import model.database.dao.mysql.delivery.*;
import utility.DeliveryNames;

import java.sql.Connection;

public class DeliveryMySQLDaoFactory extends DaoFactory {
    @Override
    public AbstractDAO getDao(DeliveryNames name, Connection connection) {
        switch (name) {
            case USERS: return new UserDao(connection);
            case USERS_DATA: return new UserDataDao(connection);
            case ADDRESSES: return new AddressDao(connection);
            case STREETS: return new StreetDao(connection);
            case INVOICES: return new InvoiceDao(connection);
            case CARGOES: return new CargoDao(connection);
            default:
                System.out.println("NOT IN CASE DAO FACTORY...");
        }
        return null;
    }
}
