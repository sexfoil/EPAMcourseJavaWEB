package controller;

import utility.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "infoPricesServlet", urlPatterns = "/info_prices")
public class InfoPricesController extends HttpServlet {

    private HttpSession session = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();

        req.setAttribute("pricesPage", true);

        getServletContext().getRequestDispatcher(Pages.INFO_JSP.getUrl()).forward(req, resp);

    }

}

