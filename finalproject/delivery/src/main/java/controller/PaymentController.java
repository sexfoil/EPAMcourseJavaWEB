package controller;

import model.entity.Cargo;
import model.entity.Invoice;
import model.entity.user.User;
import model.entity.user.UserData;
import service.delivery.ServiceCargo;
import service.delivery.ServiceInvoice;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "paymentServlet", urlPatterns = "/payment")
public class PaymentController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;
    private boolean isPaid;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        try {

            int invoiceId = Integer.valueOf(req.getParameter("invoice"));
            ServiceInvoice serviceInvoice = getService();
            Invoice invoice = serviceInvoice.getInvoiceById(invoiceId);
            HashMap<Long, Cargo> cargoes = getInvoicesCargoes(invoice);
            req.setAttribute("cargoes", cargoes);
            req.setAttribute("invoice", invoice);

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            // todo
        }
        session = req.getSession();
        redirect(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);

        try {

            int invoiceId = Integer.valueOf(req.getParameter("payment"));
            ServiceInvoice serviceInvoice = getService();
            serviceInvoice.updateStatus(invoiceId, 2);
            isPaid = true;
            updateUserDataInSession();
            session.setAttribute("updateInvoices", true);

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            // todo
        }

        redirect(req, resp);

    }

    private void initParameters(HttpServletRequest request) {
        session = request.getSession();
        user = (User) session.getAttribute("user");
        isPaid = false;
    }

    private void updateUserDataInSession() {
        int activeInvoices = (int) session.getAttribute("activeInvoiceAmount");
        session.setAttribute("activeInvoiceAmount", --activeInvoices);
    }

    private HashMap<Long, Cargo> getInvoicesCargoes(Invoice invoice) {
        ServiceCargo serviceCargo = getServiceCargo();
        HashMap<Long, Cargo> cargoes = new HashMap<>();

        cargoes.put(invoice.getCargoId(), serviceCargo.getCargoById(invoice.getCargoId()));

        return cargoes;
    }

    private ServiceCargo getServiceCargo() {
        return (ServiceCargo) DeliveryServiceFactory.getInstance().getService(DeliveryNames.CARGOES);
    }


    private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            if (isPaid) {
                resp.sendRedirect("/cabinet_history");
            } else {
                getServletContext().getRequestDispatcher(Pages.PAYMENT_JSP.getUrl()).forward(req, resp);
            }
        }

    }

    private ServiceInvoice getService() {
        return (ServiceInvoice) DeliveryServiceFactory.getInstance().getService(DeliveryNames.INVOICES);
    }
}
