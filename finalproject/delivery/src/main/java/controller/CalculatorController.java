package controller;

import model.entity.Cargo;
import model.entity.CargoType;
import model.entity.Street;
import model.entity.user.User;
import service.delivery.ServiceCargoTypes;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "calculatorServlet", urlPatterns = "/calculator")
public class CalculatorController extends HttpServlet {

    HttpSession session = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("lang") == null) {
            session = req.getSession();

            session.setAttribute("weightError", null);
            session.setAttribute("calculatedCargo", null);
            session.setAttribute("calculatedCost", null);
            session.setAttribute("oldWeight", null);
            session.setAttribute("oldStreet", null);
        }

        getServletContext().getRequestDispatcher(Pages.CALCULATOR_JSP.getUrl()).forward(req, resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();

        int weight = Integer.parseInt(req.getParameter("weight"));
        List<CargoType> cargoTypes = (List<CargoType>) session.getAttribute("cargoTypes");
        CargoType cargoType = getCargoType(cargoTypes, weight);

        String streetName = req.getParameter("street");
        List<Street> streets = (List<Street>) session.getAttribute("streetsList");
        Street street = getStreet(streets, streetName);

        if (cargoType == null) {
            session.setAttribute("weightError", "TOO MUCH!!!");
        }
        if (street == null) {
            session.setAttribute("streetError", "WRONG STREET!!!");
        }

        if (cargoType != null && street != null) {
            double cost = getCalculatedCost(cargoType, street);
            session.setAttribute("calculatedCargo", cargoType.getType());
            session.setAttribute("calculatedCost", cost);
        }

        session.setAttribute("oldWeight", weight);
        session.setAttribute("oldStreet", street);

        getServletContext().getRequestDispatcher(Pages.CALCULATOR_JSP.getUrl()).forward(req, resp);

    }


    private double getCalculatedCost(CargoType cargoType, Street street) {
        int typeRate = cargoType.getRate();
        int distance = street.getDistance();
        double currentPriceRate = (double) session.getAttribute("currentPriceRate");

        return typeRate * distance * currentPriceRate;
    }


    private CargoType getCargoType(List<CargoType> cargoTypes, int weight) {

        Optional<CargoType> matchingType = cargoTypes.stream()
                .filter(cargo -> weight > cargo.getMinWeight() && weight <= cargo.getMaxWeight()).findFirst();

        return matchingType.orElse(null);
    }


    private Street getStreet(List<Street> streets, String name) {

        Optional<Street> matchingStreet = streets.stream().filter(n -> name.equals(n.getName())).findFirst();

        return matchingStreet.orElse(null);

    }

}
