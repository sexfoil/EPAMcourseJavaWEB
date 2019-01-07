package service.delivery;

import model.database.dao.mysql.delivery.UserDao;
import model.entity.user.User;
import service.AbstractService;
import utility.DeliveryNames;


public class ServiceUser extends AbstractService {

    private UserDao dao;

    public ServiceUser() {
        super(DeliveryNames.USERS);
        dao = (UserDao) abstractDAO;
    }

    public User getUser(String login) {
        return dao.getUserByString(login, "login");
    }

    public boolean addUser(String firstName, String lastName, String login, String password,
                           String email, String sex, int age) {
        User newUser = new User(0, firstName, lastName, login, password, email, sex, age);

        return dao.addUser(newUser);
    }
}
