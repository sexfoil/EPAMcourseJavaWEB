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

    public Cargo getCargoById(long id) {
        return dao.getCargoById(id);
    }

    public void addCargo(Cargo cargo) {
        dao.addCargo(cargo);
    }
}
