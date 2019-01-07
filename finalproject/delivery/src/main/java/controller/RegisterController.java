package controller;

import model.entity.user.User;
import model.entity.user.UserData;
import service.delivery.ServiceAddress;
import service.delivery.ServiceStreet;
import service.delivery.ServiceUser;
import service.delivery.ServiceUserData;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.Pages;
import utility.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "registerServlet", urlPatterns = "/registration")
public class RegisterController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("/login");
        } else {
            getServletContext().getRequestDispatcher(Pages.REGISTER_JSP.getUrl()).forward(req, resp);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> formParams = getFormParams(req);
        saveUserInput(req);

        if (formParams.contains("")) {
            req.setAttribute("registerError", "EMPTY FIELDS");
        } else {
            if (validateFormParams(formParams)) {

                String login = req.getParameter("login");
                User user = registerNewUser(formParams, login);

                if (user != null) {
                    req.getSession().setAttribute("user", user);
                }
            }
        }

        doGet(req, resp);

    }

    private boolean validateFormParams(List<String> params) {
        boolean isOk = true;

        return isOk;
    }

    private void saveUserInput(HttpServletRequest req) {
        req.setAttribute("prevFirstName", req.getParameter("firstName"));
        req.setAttribute("prevLastName", req.getParameter("lastName"));
        req.setAttribute("prevLogin", req.getParameter("login"));
        req.setAttribute("prevEmail", req.getParameter("email"));
    }

    private List<String> getFormParams(HttpServletRequest req) {
        List<String> params = new ArrayList<>();
        params.add(req.getParameter("firstName"));
        params.add(req.getParameter("lastName"));
        params.add(req.getParameter("login"));
        params.add(req.getParameter("password"));
        params.add(req.getParameter("password2"));
        params.add(req.getParameter("email"));
        params.add(req.getParameter("sex"));
        params.add(req.getParameter("age"));
        return params;
    }

    private User registerNewUser(List<String> params, String login) {
        ServiceUser service = (ServiceUser) DeliveryServiceFactory.getInstance()
                .getService(DeliveryNames.USERS);
        params.remove(4);
        boolean successfulUserAdded = service.addUser(
                params.remove(0),
                params.remove(0),
                params.remove(0),
                params.remove(0),
                params.remove(0),
                params.remove(0),
                Integer.parseInt(params.remove(0))
        );

        if (successfulUserAdded) {
            User user = service.getUser(login);

            ((ServiceAddress) DeliveryServiceFactory.getInstance().getService(DeliveryNames.ADDRESSES))
                            .addAddress(user.getId(), 22, "-", "-", "-");


            ((ServiceUserData) DeliveryServiceFactory.getInstance().getService(DeliveryNames.USERS_DATA))
                            .addUserData(user.getId(), "-");


            return user;
        } else {
            // TODO
        }

        return null;
    }

}
