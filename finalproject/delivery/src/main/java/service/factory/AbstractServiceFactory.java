package service.factory;

import service.AbstractService;
import utility.DeliveryNames;


public abstract class AbstractServiceFactory {

    protected static AbstractServiceFactory serviceFactory;

    public abstract AbstractService getService(DeliveryNames name);

    public static AbstractServiceFactory getInstance() {
        if( serviceFactory == null ){
            synchronized (AbstractServiceFactory.class){
                if(serviceFactory == null){
                    serviceFactory = new DeliveryServiceFactory();
                }
            }
        }
        return serviceFactory;
    }

}
