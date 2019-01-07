package controller;

import model.entity.Street;
import utility.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "infoDirectionsServlet", urlPatterns = "/info_directions")
public class InfoDirectionsController extends HttpServlet {

    private HttpSession session = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        setCurrentPageStreets(req);

        req.setAttribute("directionsPage", true);

        getServletContext().getRequestDispatcher(Pages.INFO_JSP.getUrl()).forward(req, resp);

    }

    private void setCurrentPageStreets(HttpServletRequest request) {
        String pageParam = request.getParameter("page");
        int pageNum = 1;
        try {
            pageNum = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            // TODO
            System.out.println("NULL or 1: \n" + e);
        }

        if (request.getParameter("lang") != null) {
            pageNum = (int) session.getAttribute("paginationNumber");
        }

        int pageStep = (int) session.getAttribute("rowOnPage");

        List<Street> listAll = (List<Street>) session.getAttribute("streetsList");
        int listSize = (int) session.getAttribute("streetsListSize");

        int lastPage = listSize / pageStep + (listSize % pageStep == 0 ? 0 : 1);

        int from = (pageNum - 1) * pageStep;
        int to = (from + pageStep) < listSize ? (from + pageStep) : listSize;

        List<Street> pageList = new ArrayList<>(listAll.subList(from, to));

        request.setAttribute("streetsListPage", pageList);
        request.setAttribute("pageNum", pageNum);
        session.setAttribute("paginationNumber", pageNum);
        request.setAttribute("lastPage", lastPage);

    }

}

