package controller;

import model.entity.user.User;
import model.entity.user.UserData;
import service.ServiceUser;
import utility.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/registration")
public class RegisterController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        user = (User) session.getAttribute("user");
        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (Validator.isValid("user")){
            session = req.getSession();
            ServiceUser service = new ServiceUser();
            boolean successfulUserAdded = service.addUser(
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    req.getParameter("login"),
                    req.getParameter("password"),
                    req.getParameter("email"),
                    req.getParameter("sex"),
                    Integer.parseInt(req.getParameter("age"))
                    );
            if (successfulUserAdded) {
                user = service.getUser(req.getParameter("login"));
                session.setAttribute("user", user);
            }
        }

        redirect(req, resp, user);

    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        if (user != null) {
            resp.sendRedirect("/login");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/registerpage.jsp");
            dispatcher.forward(req, resp);
        }

    }

}
