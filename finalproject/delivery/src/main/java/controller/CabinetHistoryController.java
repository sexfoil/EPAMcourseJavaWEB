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

@WebServlet(name = "cabinetHistoryServlet", urlPatterns = "/cabinet_history")
public class CabinetHistoryController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        req.setAttribute("ordersPage", true);
        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        redirect(req, resp, user);

    }

    private void initParameters(HttpServletRequest request) {
        session = request.getSession();
        user = (User) session.getAttribute("user");
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            getServletContext().getRequestDispatcher(Pages.CABINET_HISTORY_JSP.getUrl()).forward(req, resp);
        }

    }

}
