package controller;

import model.entity.user.User;
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

        // TODO

        session = req.getSession();

        // MOVE TO INIT FILTER THEN
        if (session.getAttribute("streetsList") == null) {

            List<String> list = new ArrayList<>();
            for (int i = 10; i < 100; i++) {
                list.add("_" + i + "th_Street");
            }

            session.setAttribute("streetsList", list);
            session.setAttribute("streetsListSize", list.size());

        }

        String pageParam = req.getParameter("page");
        int pageNum = pageParam == null ? 1 : Integer.parseInt(pageParam); // TRY CATCH !!!
        int pageStep = (int) session.getAttribute("rowOnPage");

        List<String> listAll = (List<String>) session.getAttribute("streetsList");
        int listSize = listAll.size();
        int lastPage = listSize / pageStep + (listSize % pageStep == 0 ? 0 : 1);

        int from = (pageNum - 1) * pageStep;
        int to = (from + pageStep) < listSize ? (from + pageStep) : listSize;
        List<String> listPage = new ArrayList<>(listAll.subList(from, to));
//        for (int i = 0; i < pageStep; i++) {
//            int index = (pageNum - 1) * pageStep + i;
//            listPage.add(listAll.get(index));
//        }
        req.setAttribute("streetsListPage", listPage);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("lastPage", lastPage);
        //session.setAttribute("infoPage", "SESSION INFO ATTRIBUTE DIRECTIONS");
        req.setAttribute("directionsPage", true);

        getServletContext().getRequestDispatcher(Pages.INFO_JSP.getUrl()).forward(req, resp);

    }

}

