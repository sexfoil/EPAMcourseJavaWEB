package p02reflection2;

public class UnaryArithmeticOperation {

    private double value;

    public UnaryArithmeticOperation() {
        this(99.99);
    }

    public UnaryArithmeticOperation(double value) {
        this.value = value;
    }

    public void incrementValue() {
        ++value;
    }

    public void decrementValue() {
        --value;
    }

    public void viceVersaValue() {
        value = - value;
    }

    @Override
    public String toString() {
        return "UnaryArithmeticOperation{value=" + value +'}';
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
