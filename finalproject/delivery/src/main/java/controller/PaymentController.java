package controller;

import model.entity.user.User;
import model.entity.user.UserData;
import utility.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "paymentServlet", urlPatterns = "/payment")
public class PaymentController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        user = (User) session.getAttribute("user");

        redirect(req, resp, user);

    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            getServletContext().getRequestDispatcher(Pages.PAYMENT_JSP.getUrl()).forward(req, resp);
        }

    }

}
