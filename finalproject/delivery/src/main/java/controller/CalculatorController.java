package controller;

import model.entity.CargoType;
import model.entity.Street;
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
import java.util.List;

@WebServlet(name = "calculatorServlet", urlPatterns = "/calculator")
public class CalculatorController extends HttpServlet {

    HttpSession session = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher(Pages.CALCULATOR_JSP.getUrl()).forward(req, resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();

        int weight = Integer.parseInt(req.getParameter("weight"));
        List<CargoType> cargoTypes = (List<CargoType>) session.getAttribute("cargoTypes");
        CargoType cargoType = Validator.isCargoTypeValid(cargoTypes, weight);

        String streetName = req.getParameter("street");
        List<Street> streets = (List<Street>) session.getAttribute("streetsList");
        Street street = Validator.isStreetValid(streets, streetName);

        if (cargoType == null) {
            req.setAttribute("weightError", "TOO MUCH!!!");
        }
        if (street == null) {
            req.setAttribute("streetError", "WRONG STREET!!!");
        }

        if (cargoType != null && street != null) {
            double currentPriceRate = (double) session.getAttribute("currentPriceRate");
            double cost = Calculator.calculateCost(cargoType, street, currentPriceRate);
            req.setAttribute("calculatedCargo", cargoType.getType());
            req.setAttribute("calculatedCost", cost);
        }

        req.setAttribute("oldWeight", weight);
        req.setAttribute("oldStreet", street);

        getServletContext().getRequestDispatcher(Pages.CALCULATOR_JSP.getUrl()).forward(req, resp);

    }


//    private double getCalculatedCost(CargoType cargoType, Street street) {
//        int typeRate = cargoType.getRate();
//        int distance = street.getDistance();
//        double currentPriceRate = (double) session.getAttribute("currentPriceRate");
//
//        return typeRate * distance * currentPriceRate;
//    }
//

//    private CargoType getCargoType(List<CargoType> cargoTypes, int weight) {
//
//        Optional<CargoType> matchingType = cargoTypes.stream()
//                .filter(cargo -> weight > cargo.getMinWeight() && weight <= cargo.getMaxWeight()).findFirst();
//
//        return matchingType.orElse(null);
//    }
//

//    private Street getStreet(List<Street> streets, String name) {
//
//        Optional<Street> matchingStreet = streets.stream().filter(n -> name.equals(n.getName())).findFirst();
//
//        return matchingStreet.orElse(null);
//
//    }

}
