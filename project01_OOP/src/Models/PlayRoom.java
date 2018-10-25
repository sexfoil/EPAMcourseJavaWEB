package Models;

import Models.Entity.Toy;
import Utility.ToysCreator;

import java.util.ArrayList;

public class PlayRoom<T extends Toy> {

    private ArrayList<T> toys;
    private double toysBudget;

    public PlayRoom() {
        init();
    }

    private void init() {
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
