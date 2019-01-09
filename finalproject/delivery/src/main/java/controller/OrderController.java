package controller;

import model.entity.Address;
import model.entity.Cargo;
import model.entity.CargoType;
import model.entity.Street;
import model.entity.user.User;
import model.entity.user.UserData;
import service.delivery.*;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.Pages;
import utility.tools.Calculator;
import utility.tools.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "orderServlet", urlPatterns = "/order")
public class OrderController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;
    private boolean isInvoiceCreated;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        initParameters(req);
        redirect(req, resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        List<String> formParams = getFormParams(req);
        boolean isInputValid = validateFormParams(formParams);

        if (isInputValid) {
            createInvoice(formParams, req);
            session.setAttribute("updateInvoices", true);
        }

        redirect(req, resp);

    }


    private void createInvoice(List<String> params, HttpServletRequest req) {


        int weight = Integer.parseInt(params.remove(0));
        List<CargoType> cargoTypes = (List<CargoType>) session.getAttribute("cargoTypes");
        CargoType cargoType = Validator.isCargoTypeValid(cargoTypes, weight);

        String streetName = params.remove(0);
        List<Street> streets = (List<Street>) session.getAttribute("streetsList");
        Street street = Validator.isStreetValid(streets, streetName);

        LocalDateTime dateTime = Validator.isDateValid(params.remove(0));

        if (cargoType == null) {
            req.setAttribute("weightError", "TOO MUCH!!!");
        }
        if (street == null) {
            req.setAttribute("streetError", "WRONG STREET!!!");
        }

        if (dateTime == null) {
            req.setAttribute("dateError", "WRONG DATE!!!");
        }

        if (cargoType != null && street != null && dateTime != null) {
            double currentPriceRate = (double) session.getAttribute("currentPriceRate");
            double cost = Calculator.calculateCost(cargoType, street, currentPriceRate);

            ServiceCargo serviceCargo = (ServiceCargo) DeliveryServiceFactory.getInstance()
                    .getService(DeliveryNames.CARGOES);
            long cargoId = System.currentTimeMillis();
            Cargo cargo = new Cargo(cargoId, cargoType, weight);
            serviceCargo.addCargo(cargo);

            ServiceInvoice serviceInvoice = (ServiceInvoice) DeliveryServiceFactory.getInstance()
                    .getService(DeliveryNames.INVOICES);

            serviceInvoice.saveInvoice(user.getId(), cargoId, (int) cost * 100, dateTime, 1);

            updateUserDataInSession();

            isInvoiceCreated = true;
        }

    }


    private List<String> getFormParams(HttpServletRequest req) {
        List<String> params = new ArrayList<>();

        params.add(req.getParameter("weight"));
        params.add(req.getParameter("street"));
        params.add(req.getParameter("date"));

        return params;
    }


    private boolean validateFormParams(List<String> params) {
        boolean isOk = true;
        // TODO
        return isOk;
    }


    private void initParameters(HttpServletRequest request) {
        session = request.getSession();
        user = (User) session.getAttribute("user");
        isInvoiceCreated = false;
    }



    private void updateUserDataInSession() {
        int activeInvoices = (int) session.getAttribute("activeInvoiceAmount");
        session.setAttribute("activeInvoiceAmount", ++activeInvoices);
    }


    private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            if (isInvoiceCreated) {
                resp.sendRedirect("/cabinet_history");
            } else {
                getServletContext().getRequestDispatcher(Pages.ORDER_JSP.getUrl()).forward(req, resp);
            }
        }

    }

}
