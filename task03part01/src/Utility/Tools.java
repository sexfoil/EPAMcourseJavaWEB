package Utility;

import Models.Entity.Toy;
import Models.ToysSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tools<T extends Toy> {

    private ToysSet<T> model;

    public Tools(ToysSet model) {
        this.model = model;
    }

    public ArrayList<T> selectToys(String[] params) {
        ArrayList<T> result = new ArrayList<>();
        currentToy:
        for (T t : model.getToys()) {
            for (String pair : params) {
                String toy = t.toString();
                System.out.println(pair);

                if (!toy.contains(pair)) {
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
}
