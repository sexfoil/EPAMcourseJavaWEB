package service.delivery;

import model.database.dao.mysql.delivery.CargoDao;
import model.entity.Cargo;
import model.entity.CargoType;
import service.AbstractService;
import utility.DeliveryNames;

public class ServiceCargo extends AbstractService {

    private CargoDao dao;

    public ServiceCargo() {
        super(DeliveryNames.CARGOES);
        dao = (CargoDao) abstractDAO;
    }

    public void addCargo(Cargo cargo) {
        dao.addCargo(cargo);
    }
}
