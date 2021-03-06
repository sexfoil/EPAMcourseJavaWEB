package controller;

import model.entity.user.User;
import service.delivery.ServiceUser;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.Pages;
import utility.tools.SecurityPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);

        if (user == null) {
            ServiceUser service = (ServiceUser) DeliveryServiceFactory.getInstance().getService(DeliveryNames.USERS);

            String login = req.getParameter("login");
            User userExist = login != null ? service.getUser(login) : null;

            if (userExist != null) {
                String inputPass = req.getParameter("password");
                if (SecurityPassword.checkPassword(inputPass, login, userExist.getPassword())) {
                    if (isUserLogIn(login)) {
                        user = userExist;
                        session.setAttribute("user", user);
                    } else {
                        req.setAttribute("logInError", true);
                    }
                }
            } else {
                req.setAttribute("authorizationError", true);
            }
            req.setAttribute("oldInput", login);
        }

        redirect(req, resp, user);

    }

    private void initParameters(HttpServletRequest request) {
        session = request.getSession();
        user = (User) session.getAttribute("user");
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        if (user != null) {
            session.setAttribute("updateInvoices", true);
            resp.sendRedirect("/cabinet");
        } else {
            getServletContext().getRequestDispatcher(Pages.LOGIN_JSP.getUrl()).forward(req, resp);
            System.out.println(getServletContext().getContextPath());
        }

    }

    private boolean isUserLogIn(String userLogin) {
        return ((HashSet<String>) getServletContext().getAttribute("usersPool")).add(userLogin);
    }

}
