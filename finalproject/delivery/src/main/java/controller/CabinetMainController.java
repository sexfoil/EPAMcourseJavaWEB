package controller;

import model.entity.Address;
import model.entity.Street;
import model.entity.user.User;
import model.entity.user.UserData;
import service.delivery.ServiceAddress;
import service.delivery.ServiceStreet;
import service.delivery.ServiceUserData;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "cabinetServlet", urlPatterns = "/cabinet")
public class CabinetMainController extends HttpServlet {

    //private HttpSession session = null;
    //private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //session = req.getSession();
        //user = (User) session.getAttribute("user");

        //if (user != null) {
        if (req.getSession().getAttribute("user") != null) {
            getServletContext().getRequestDispatcher(Pages.CABINET_JSP.getUrl()).forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }

    }

}
