
public class ConverterModel {
    private String convertedNumber;

    public ConverterModel() {
    }

    public String getConvertedNumber() {
        return convertedNumber;
    }

    private void setConvertedNumber(String convertedNumber) {
        this.convertedNumber = convertedNumber;
    }

    public void convertNumber(int number, int notation) {

        String symbol = "0123456789abcdef";
        StringBuilder numSeq = new StringBuilder();
        int remainder;

        while (number > 0) {
            remainder = number % notation;
            numSeq.append(symbol.charAt(remainder));
            number /= notation;
        }

        setConvertedNumber(numSeq.reverse().toString());
    }

}
