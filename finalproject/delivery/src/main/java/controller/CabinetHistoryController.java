package controller;

import model.entity.Invoice;
import model.entity.user.User;
import service.delivery.ServiceInvoice;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
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

@WebServlet(name = "cabinetHistoryServlet", urlPatterns = "/cabinet_history")
public class CabinetHistoryController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        List<Invoice> invoices = getUserInvoices();
        //req.setAttribute("userInvoices", invoices);
        setCurrentPageInvoices(req, invoices);
        req.setAttribute("ordersPage", true);
        redirect(req, resp, user);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        redirect(req, resp, user);

    }

    private void initParameters(HttpServletRequest request) {
        session = request.getSession();
        user = (User) session.getAttribute("user");
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {

        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            getServletContext().getRequestDispatcher(Pages.CABINET_HISTORY_JSP.getUrl()).forward(req, resp);
        }

    }

    private List<Invoice> getUserInvoices() {
        ServiceInvoice serviceInvoice = (ServiceInvoice) DeliveryServiceFactory.getInstance()
                .getService(DeliveryNames.INVOICES);
        return serviceInvoice.getAllUserInvoices(user.getId());
    }

    private void setCurrentPageInvoices(HttpServletRequest request, List<Invoice> invoices) {
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

        int listSize = invoices.size();

        int lastPage = listSize / pageStep + (listSize % pageStep == 0 ? 0 : 1);

        int from = (pageNum - 1) * pageStep;
        int to = (from + pageStep) < listSize ? (from + pageStep) : listSize;

        List<Invoice> pageList = new ArrayList<>(invoices.subList(from, to));

        request.setAttribute("userInvoices", pageList);
        request.setAttribute("pageNum", pageNum);
        session.setAttribute("paginationNumber", pageNum);
        request.setAttribute("lastPage", lastPage);

    }


}
