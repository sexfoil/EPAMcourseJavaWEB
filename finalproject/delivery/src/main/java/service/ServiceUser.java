package service;

import model.database.dao.connection.ConnectionPoolMysqlDelivery;
import model.database.dao.factory.DeliveryMySQLDaoFactory;
import model.database.dao.mysql.delivery.UserDao;
import model.entity.user.User;


public class ServiceUser {

    private UserDao dao;

    public ServiceUser() {

        dao = (UserDao) DeliveryMySQLDaoFactory.getInstance()
                .getDao("users", ConnectionPoolMysqlDelivery.getConnection());
    }

    public User getUser(String login) {
        return dao.getUserByString(login, "login");
    }

    public boolean addUser(String firstName, String lastName, String login, String password,
                           String email, String sex, int age) {
        User newUser = new User(0, firstName, lastName, login, password, email, sex, age, null);

        return dao.addUser(newUser);
    }
}
