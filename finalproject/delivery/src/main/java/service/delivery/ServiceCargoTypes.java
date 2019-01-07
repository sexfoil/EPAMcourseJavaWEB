package service.delivery;

import model.database.dao.mysql.delivery.CargoTypesDao;
import model.entity.CargoType;
import service.AbstractService;
import utility.DeliveryNames;

import java.util.List;

public class ServiceCargoTypes extends AbstractService {

    private CargoTypesDao dao;

    public ServiceCargoTypes() {
        super(DeliveryNames.CARGO_TYPES);
        dao = (CargoTypesDao) abstractDAO;
    }

    public List<CargoType> getAllCargoTypes() {
        return dao.getAll();
    }

}
