package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculatorController", urlPatterns = "/calculator")
public class CalculatorController extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\nCALCULATOR SERVLET WORKING...\n");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/calculpage.jsp");
        dispatcher.forward(req, resp);
    }
}
