package utility.tools;

import model.entity.CargoType;
import model.entity.Street;

public class Calculator {

    public static double calculateCost(CargoType cargoType, Street street, double currentPriceRate) {
        int typeRate = cargoType.getRate();
        int distance = street.getDistance();
        //double currentPriceRate = (double) session.getAttribute("currentPriceRate");

        return typeRate * distance * currentPriceRate;
    }


}
