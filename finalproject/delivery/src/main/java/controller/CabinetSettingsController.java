package controller;

import model.entity.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "cabinetSettingsServlet", urlPatterns = "/cabinetsettings")
public class CabinetSettingsController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SETTINGS GET");

        session = req.getSession();
        user = (User) session.getAttribute("user");
        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SETTINGS POST");

        session = req.getSession();
        session.setAttribute("user", user);
        redirect(req, resp, user);
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        if (user == null) {
            resp.sendRedirect("/login");
        } else {

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/cabsettingspage.jsp");
            dispatcher.forward(req, resp);
            System.out.println("forwarding.............");

        }

    }

}
