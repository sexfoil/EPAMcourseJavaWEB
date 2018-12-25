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

@WebServlet(name = "homeServlet", urlPatterns = "/home")
public class HomeController extends HttpServlet {


    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("Is START? - " + session.getAttribute("startApp"));
        if (user != null) {

            session.setAttribute("user", null);


        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);


//        try {
//            resp.setContentType("text/html");
//            List<String> u = new MySQLDataBaseWorker<Object>().connectDB();
//            PrintWriter out = resp.getWriter();
//            for (String user : u) {
//                out.println(user + "</br>");
//                System.out.println(user);
//            }
//        } catch (
//                SQLException e) {
//            e.printStackTrace();
//        }
    }


}
