package Models;

import Models.Entity.Toy;

import java.util.ArrayList;

/**
 * This class is the Model in MVC Pattern - represents containing set of toys.
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
     * Max sum's value of all toy's prices.
     */
    private double toysBudget;


    /**
     * Constructs a PlayRoom instance.
     */
    public PlayRoom() {
        toys = new ArrayList<>();
    }


    /**
     * Returns the list of toys.
     *
     * @return the list of toys
     */
    public ArrayList<T> getToys() {
        return toys;
    }

    /**
     *Set list of toys to playroom
     *
     * @param toys list of toys
     */
    public void setToys(ArrayList<T> toys) {
        this.toys = toys;
    }

    /**
     * Returns the budget of playroom.
     *
     * @return the budget of playroom
     */
    public double getToysBudget() {
        return toysBudget;
    }

    /**
     * Set the value of budget to the playroom.
     *
     * @param toysBudget value of budget
     */
    public void setToysBudget(double toysBudget) {
        this.toysBudget = toysBudget;
    }
}
