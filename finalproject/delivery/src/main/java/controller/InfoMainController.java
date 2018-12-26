package controller;

import model.entity.user.User;
import model.entity.user.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "infoServlet", urlPatterns = "/info")
public class InfoMainController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        String lang = req.getParameter("lang");
        if (lang == null) {
            String page = req.getParameter("page");
            if (page != null) {
                session.setAttribute("infoPage", page.toUpperCase());
                //req.setAttribute("infoPage", );
            }
//            else {
//                resp.sendRedirect("/home");
//            }
        } else {
            session.setAttribute("lang", lang.toUpperCase());
        }

        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        user = (User) session.getAttribute("user");

        redirect(req, resp, user);

    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        if (user != null) {
            resp.sendRedirect("/cabinet");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/infopage.jsp");
            dispatcher.forward(req, resp);
        }

    }

}
