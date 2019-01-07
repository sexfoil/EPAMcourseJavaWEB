package service.factory;

import service.AbstractService;
import service.delivery.*;
import utility.DeliveryNames;


public class DeliveryServiceFactory extends AbstractServiceFactory {

    @Override
    public AbstractService getService(DeliveryNames name) {
        switch (name) {
            case USERS: return new ServiceUser();
            case USERS_DATA: return new ServiceUserData();
            case ADDRESSES: return new ServiceAddress();
            case STREETS: return new ServiceStreet();
            case INVOICES: return new ServiceInvoice();
            case CARGOES: return new ServiceCargo();
            case CARGO_TYPES: return new ServiceCargoTypes();
            case STATUS: return new ServiceStatus();
            default:
                //TODO
                System.out.println("NOT IN CASE SERVICE FACTORY...");
        }
        return null;

    }
}
