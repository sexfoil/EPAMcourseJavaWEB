package controller;

import model.entity.user.User;
import utility.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "homeServlet", urlPatterns = "/home")
public class HomeController extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("logout") != null) {
            User user = (User) req.getSession().getAttribute("user");
            if (user != null) {
                ((HashSet<String>) getServletContext().getAttribute("usersPool")).remove(user.getLogin());
                req.getSession().setAttribute("user", null);
            }
        }

        getServletContext().getRequestDispatcher(Pages.INDEX.getUrl()).forward(req, resp);

    }


}
