package controller;

import model.entity.user.User;
import model.entity.user.UserData;
import service.ServiceUser;
import utility.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

@WebServlet (name = "loginServlet", urlPatterns = "/login")
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
            ServiceUser service = new ServiceUser();

            String login = req.getParameter("login");
            User userExist = login != null ? service.getUser(login) : null;

            if (userExist != null && req.getParameter("password").equals(userExist.getPassword())) {
                if (isUserLogIn(login)) {
                    user = userExist;
                    session.setAttribute("user", user);
                } else {
                    req.setAttribute("logInError", true);
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
            resp.sendRedirect("/cabinet");
        } else {
            getServletContext().getRequestDispatcher(Pages.LOGIN_JSP.getUrl()).forward(req, resp);
        }

    }

    private boolean isUserLogIn(String userLogin) {
        //HashSet<String> users = (HashSet<String>) getServletContext().getAttribute("usersPool");
        return ((HashSet<String>) getServletContext().getAttribute("usersPool")).add(userLogin);
    }

}
