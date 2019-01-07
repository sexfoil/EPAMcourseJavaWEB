package service.delivery;

import model.database.dao.mysql.delivery.StreetDao;
import model.entity.Street;
import service.AbstractService;
import utility.DeliveryNames;

import java.util.List;

public class ServiceStreet extends AbstractService {

    private StreetDao dao;

    public ServiceStreet() {
        super(DeliveryNames.STREETS);
        dao = (StreetDao) abstractDAO;
    }

    public Street getStreetById(int id) {
        return dao.getStreetById(id);
    }

    public Street getStreetByName(String name) {
        return dao.getStreetByName(name);
    }

    public List<Street> getAllStreetNames() {
        return dao.getAll();
    }
}
