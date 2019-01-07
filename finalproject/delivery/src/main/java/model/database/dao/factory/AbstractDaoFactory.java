package model.database.dao.factory;

import model.database.dao.AbstractDAO;
import utility.DeliveryNames;

import java.sql.Connection;


public abstract class AbstractDaoFactory {

    protected static AbstractDaoFactory daoFactory;

    public abstract AbstractDAO getDao(DeliveryNames name, Connection connection);

    public static AbstractDaoFactory getInstance() {
        if( daoFactory == null ){
            synchronized (AbstractDaoFactory.class){
                if(daoFactory == null){
                    daoFactory = new DeliveryMySQLDaoFactory();
                }
            }
        }
        return daoFactory;
    }

}
