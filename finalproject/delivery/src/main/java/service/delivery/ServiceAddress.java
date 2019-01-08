package service.delivery;

import model.database.dao.mysql.delivery.AddressDao;
import model.entity.Address;
import service.AbstractService;
import utility.DeliveryNames;

public class ServiceAddress extends AbstractService {

    private AddressDao dao;

    public ServiceAddress() {
        super(DeliveryNames.ADDRESSES);
        dao = (AddressDao) abstractDAO;
    }

    public Address getUserAddress(int id) {
        return dao.getUserAddress(id);
    }


    public void addAddress(int userId, int streetId, String build, String section, String apart) {
        Address address = new Address(userId, streetId, build, section, apart);
        dao.addAddress(address);
    }

    public void updateAddress(Integer streetId, String build, String section, String apart, int userId) {
        dao.updateAddress(streetId, build, section, apart, userId);
    }

}
