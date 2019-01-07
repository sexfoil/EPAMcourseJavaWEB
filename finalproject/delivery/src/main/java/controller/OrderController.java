package controller;

import utility.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "orderServlet", urlPatterns = "/order")
public class OrderController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String order = req.getParameter("create");
        if (order != null) {
            List<String> orders = new ArrayList();
            orders.add(order);
            req.getSession().setAttribute("activeInvoice", orders);
            req.getSession().setAttribute("activeInvoiceAmount", orders.size());
        }

        getServletContext().getRequestDispatcher(Pages.ORDER_JSP.getUrl()).forward(req, resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        StringBuilder info = new StringBuilder();
//        int weight = Integer.parseInt(req.getParameter("weight"));
//        String type = req.getParameter("cargoType");
//        String street = req.getParameter("street");
//        String date = req.getParameter("date");
//        LocalDateTime dateTime = LocalDateTime.parse(date);
//        LocalDateTime now = LocalDateTime.now();
//
//        System.out.println("Date: " + date);
//        System.out.println("DateNOW: " + now);
//
//        info.append("[Weight=" + weight).append(", Type=" + type).append(", Address=" + street);
//        info.append(", Date=" + date).append("]");
//
//        double price = weight * 10.0;
//
//        req.setAttribute("calculatedInfo", info);
//        req.setAttribute("calculatedPrice", price);


        getServletContext().getRequestDispatcher(Pages.ORDER_JSP.getUrl()).forward(req, resp);

    }
}
