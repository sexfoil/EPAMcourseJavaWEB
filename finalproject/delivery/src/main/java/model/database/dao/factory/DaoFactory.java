package model.database.dao.factory;

import model.database.dao.AbstractDAO;
import utility.DeliveryNames;

import java.sql.Connection;


public abstract class DaoFactory {

    protected static DaoFactory daoFactory;

    public abstract AbstractDAO getDao(DeliveryNames name, Connection connection);

    public static DaoFactory getInstance() {
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory == null){
                    daoFactory = new DeliveryMySQLDaoFactory();
                }
            }
        }
        return daoFactory;
    }

}
