package model;

import java.util.List;
import java.util.Set;

public class Model {

    private List<Integer> listOfElements;
    private Set<Integer> setOfElements;

    public Model() {
    }

    public List<Integer> getListOfElements() {
        return listOfElements;
    }

    public void setListOfElements(List<Integer> listOfElements) {
        this.listOfElements = listOfElements;
    }

    public Set<Integer> getSetOfElements() {
        return setOfElements;
    }

    public void setSetOfElements(Set<Integer> setOfElements) {
        this.setOfElements = setOfElements;
    }
}
