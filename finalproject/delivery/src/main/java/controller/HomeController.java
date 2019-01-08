package controller;

import model.entity.user.User;
import utility.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "homeServlet", urlPatterns = "/home")
public class HomeController extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                session.setAttribute("user", null);
                session.setAttribute("userData", null);
                session.setAttribute("userAddress", null);
                session.setAttribute("userStreet", null);
                session.setAttribute("activeInvoiceAmount", 0);

                ((HashSet<String>) getServletContext().getAttribute("usersPool")).remove(user.getLogin());
            }
        }

        getServletContext().getRequestDispatcher(Pages.INDEX.getUrl()).forward(req, resp);

    }


}
