package controller;

import model.entity.Address;
import model.entity.Street;
import model.entity.user.User;
import model.entity.user.UserData;
import service.delivery.ServiceAddress;
import service.delivery.ServiceStreet;
import service.delivery.ServiceUserData;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.Pages;
import utility.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "cabinetSettingsServlet", urlPatterns = "/cabinet_settings")
public class CabinetSettingsController extends HttpServlet {

    private HttpSession session = null;
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);
        redirect(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initParameters(req);

        List<String> formParams = getFormParams(req);
        saveChanges(formParams);

        redirect(req, resp);
    }


    private void saveChanges(List<String> params) {

        String cell = params.remove(0);
        if (Validator.isPhoneNumber(cell)) {
            ServiceUserData serviceUserDada = (ServiceUserData) DeliveryServiceFactory.getInstance()
                    .getService(DeliveryNames.USERS_DATA);
            serviceUserDada.updateUserData(cell, user.getId());
            System.out.println("Update PHONE");
        }

        String streetName = (params.remove(0)).trim();
        String build = params.remove(0);
        String secti = params.remove(0);
        String apart = params.remove(0);

        List<Street> streets = (List<Street>) session.getAttribute("streetsList");
        Street street = streets.stream().filter(s -> streetName.equals(s.getName())).findFirst().orElse(null);
        Integer streetId = street != null ? street.getId() :null;
        String building = Validator.isAddressNumber(build) ? build : null;
        String section = Validator.isAddressNumber(secti) ? secti : null;
        String apartment = Validator.isAddressNumber(apart) ? apart : null;

        if (streetId != null || building != null || section != null || apartment != null) {
            ServiceAddress serviceAddress = (ServiceAddress) DeliveryServiceFactory.getInstance()
                    .getService(DeliveryNames.ADDRESSES);

            serviceAddress.updateAddress(streetId, building, section, apartment, user.getId());
        }

    }


    private List<String> getFormParams(HttpServletRequest req) {
        List<String> params = new ArrayList<>();
        params.add(req.getParameter("cell"));
        params.add(req.getParameter("street"));
        params.add(req.getParameter("building"));
        params.add(req.getParameter("section"));
        params.add(req.getParameter("apartment"));
        return params;
    }


    private boolean validateFormParams(List<String> params) {
        boolean isOk = true;

        return isOk;
    }


    private void initParameters(HttpServletRequest request) {
        session = request.getSession();
        user = (User) session.getAttribute("user");
    }



    private void updateUserDataInSession(int userId) {

        Address userAddress =
                ((ServiceAddress) DeliveryServiceFactory.getInstance().getService(DeliveryNames.ADDRESSES))
                        .getUserAddress(userId);

        Street userStreet =
                ((ServiceStreet) DeliveryServiceFactory.getInstance().getService(DeliveryNames.STREETS))
                        .getStreetById(userAddress.getStreetId());

        UserData userData =
                ((ServiceUserData) DeliveryServiceFactory.getInstance().getService(DeliveryNames.USERS_DATA))
                        .getUserData(userId);

        session.setAttribute("userData", userData);
        session.setAttribute("userAddress", userAddress);
        session.setAttribute("userStreet", userStreet.getName());
        //session.setAttribute("userStreet", (userStreet == null ? "" : userStreet.getName()));

    }


    private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            updateUserDataInSession(user.getId());
            getServletContext().getRequestDispatcher(Pages.CABINET_SETTINGS_JSP.getUrl()).forward(req, resp);
        }

    }

}
