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

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        user = (User) session.getAttribute("user");

        if (user != null) {
            getServletContext().getRequestDispatcher(Pages.CABINET_JSP.getUrl()).forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }

    }

//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        System.out.println("MAIN POST");
//        session = req.getSession();
//        session.setAttribute("user", user);
//        redirect(req, resp, user);
//
//    }
//
//    private void setUserDataToSession(int userId) {
//        // TODO
//        Address userAddress =
//                ((ServiceAddress) DeliveryServiceFactory.getInstance().getService(DeliveryNames.ADDRESSES))
//                .getUserAddress(userId);
//
//        Street userStreet =
//                ((ServiceStreet) DeliveryServiceFactory.getInstance().getService(DeliveryNames.STREETS))
//                .getStreetById(userAddress.getStreetId());
//
//        UserData userData =
//                ((ServiceUserData) DeliveryServiceFactory.getInstance().getService(DeliveryNames.USERS_DATA))
//                .getUserData(userId);
//
//        session.setAttribute("userData", userData);
//        session.setAttribute("userAddress", userAddress);
//        session.setAttribute("userStreet", (userStreet == null ? "" : userStreet.getName()));
//
//    }

}
