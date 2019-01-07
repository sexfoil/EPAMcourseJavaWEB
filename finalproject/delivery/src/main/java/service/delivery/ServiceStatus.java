package service.delivery;

import model.database.dao.mysql.delivery.StatusDao;
import service.AbstractService;
import utility.DeliveryNames;

import java.util.List;

public class ServiceStatus extends AbstractService {

    private StatusDao dao;

    public ServiceStatus() {
        super(DeliveryNames.STATUS);
        dao = (StatusDao) abstractDAO;
    }

    public List<String> getAllStatuses() {
        return dao.getAll();
    }

}
