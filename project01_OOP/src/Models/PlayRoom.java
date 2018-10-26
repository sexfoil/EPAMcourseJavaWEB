package Models;

import Models.Entity.Toy;

import java.util.ArrayList;

/**
 * Parametrized class {@code PlayRoom} is model (room with toys) in MVC application.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class PlayRoom<T extends Toy> {

    /**
     * List of toys in playroom.
     */
    private ArrayList<T> toys;

    /**
     * Budget of playroom is max value of sum of all toy's prices.
     */
    private double toysBudget;


    /**
     * Constructs a PlayRoom model.
     */
    public PlayRoom() {
        toys = new ArrayList<>();
    }

    public ArrayList<T> getToys() {
        return toys;
    }

    public void setToys(ArrayList<T> toys) {
        this.toys = toys;
    }

    public double getToysBudget() {
        return toysBudget;
    }

    public void setToysBudget(double toysBudget) {
        this.toysBudget = toysBudget;
    }
}
