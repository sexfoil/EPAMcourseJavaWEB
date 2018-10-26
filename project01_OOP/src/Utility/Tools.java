package Utility;

import Models.Entity.Toy;
import Models.PlayRoom;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Service class {@code Tools} to interact with model.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class Tools<T extends Toy> {

    private PlayRoom<T> model;
    private ToysCreator toysCreator;

    public Tools(PlayRoom model) {
        this.model = model;
        toysCreator = new ToysCreator();
    }

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

    public ArrayList<T> sortToys(Comparator<Toy> comparator) {
        ArrayList<T> result = new ArrayList<>(model.getToys());
        result.sort(comparator);
        return result;
    }

    public double calculatePrices() {
        double sum = 0;
        for (T item : model.getToys()) {
            sum += item.getPrice();
        }
        return sum;
    }

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
