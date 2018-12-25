package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "orderServlet", urlPatterns = "/order")
public class OrderController extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\nORDER SERVLET WORKING...\n");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/orderpage.jsp");
        dispatcher.forward(req, resp);
    }
}
