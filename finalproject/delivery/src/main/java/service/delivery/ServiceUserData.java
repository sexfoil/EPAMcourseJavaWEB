package service.delivery;

import model.database.dao.mysql.delivery.UserDataDao;
import model.entity.user.UserData;
import service.AbstractService;
import utility.DeliveryNames;

public class ServiceUserData extends AbstractService {

    private UserDataDao dao;

    public ServiceUserData() {
        super(DeliveryNames.USERS_DATA);
        dao = (UserDataDao) abstractDAO;
    }


    public UserData getUserData(int id) {
        return dao.getUserData(id);
    }


    public void addUserData(int userId, String number) {
        UserData data = new UserData(userId, number);
        dao.addUserData(data);
    }
}
