package controller;

import model.entity.user.User;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "calculatorServlet", urlPatterns = "/calculator")
public class CalculatorController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    // TODO

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> list = new ArrayList<>();
        for (int i=10; i <100; i++) {
            list.add("_" + i + "th_Street");
        }

        req.setAttribute("streetsList", list);

        initParameters(req);
        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);

        double weight = Double.parseDouble(req.getParameter("weight"));
        String type = req.getParameter("cargoType");
        String street = req.getParameter("street");
        String date = req.getParameter("date");
        System.out.println("Date: " + date);

        req.setAttribute("type", (type.equals("") ? "(crap)" : type));
        req.setAttribute("direction", (street.equals("") ? "(empty)" : street));
        req.setAttribute("distance", (street.equals("") ? "(DB data)" : 1234));
        req.setAttribute("date", (date == null ? "(no date)" : date));
        req.setAttribute("cost", (100 * weight));


        redirect(req, resp, user);

    }

    private void initParameters(HttpServletRequest request) {
        session = request.getSession();
        user = (User) session.getAttribute("user");
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        getServletContext().getRequestDispatcher(Pages.CALCULATOR_JSP.getUrl()).forward(req, resp);

    }

}
