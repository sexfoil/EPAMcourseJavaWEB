package Utility;

import Models.Entity.Toy;
import Models.PlayRoom;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Service class to controls the data flow in model.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class Tools<T extends Toy> {

    /**
     * Playroom instance.
     */
    private PlayRoom<T> model;

    /**
     * Toy creator instance.
     */
    private ToysCreator toysCreator;


    /**
     * Constructs new tools to controls the data flow in model.
     *
     * @param model {@code PlayRoom}
     */
    public Tools(PlayRoom model) {
        this.model = model;
        toysCreator = new ToysCreator();
    }


    /**
     * Selects toys by provided parameters.
     *
     * @param params array of parameter to selecting toys
     *
     * @return list of selected toys
     */
    public ArrayList<T> selectToys(String[] params) {
        ArrayList<T> result = new ArrayList<>();
        currentToy:
        for (T t : model.getToys()) {
            boolean skip = true;
            for (String pair : params) {
                String toy = t.toString();
                if (pair.startsWith("price")) {
                    double userPrice = Double.parseDouble(pair.substring(6));
                    switch (pair.charAt(5)) {
                        case '>':
                            skip = t.getPrice() < userPrice;
                            break;
                        case '<':
                            skip = t.getPrice() > userPrice;
                            break;
                        case '=':
                            skip = t.getPrice() != userPrice;
                            break;
                    }
                } else {
                    skip = !toy.contains(pair);
                }
                if (skip) {
                    continue currentToy;
                }
            }
            result.add(t);
        }

        return result;
    }

    /**
     * Sorted toys in playroom by parameter provided.
     *
     * @param comparator {@code Comparator<Toy>} for parameter
     *
     * @return sorted list of toys
     */
    public ArrayList<T> sortToys(Comparator<Toy> comparator) {
        ArrayList<T> result = new ArrayList<>(model.getToys());
        result.sort(comparator);
        return result;
    }

    /**
     * Calculates total sum of playroom's prices.
     *
     * @return sum of playroom's prices
     */
    public double calculatePrices() {
        double sum = 0;
        for (T item : model.getToys()) {
            sum += item.getPrice();
        }
        return sum;
    }

    /**
     * Fill playroom with toys in accordance with budget provided.
     *
     * @param budget budget of playroom
     */
    public void setToysInPlayRoom(double budget) {
        double minPrice = ToysCreator.minPrice;
        do {
            Toy toy = toysCreator.createToy();
            if (budget > toy.getPrice()) {
                model.getToys().add((T) toy);
                budget -= toy.getPrice();
            }
        } while (budget > minPrice);
    }
}
