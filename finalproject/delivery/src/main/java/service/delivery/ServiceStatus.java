package service.delivery;

import model.database.dao.mysql.delivery.StatusDao;
import model.entity.Status;
import service.AbstractService;
import utility.DeliveryNames;

import java.util.List;

public class ServiceStatus extends AbstractService {

    private StatusDao dao;

    public ServiceStatus() {
        super(DeliveryNames.STATUS);
        dao = (StatusDao) abstractDAO;
    }

    public List<Status> getAllStatuses() {
        return dao.getAll();
    }

}
