package utility;

public class Tools {

    public int[] getValidData(String[] data) {
        int[] validData = new int[2];
        if (data.length > 1) {
            try {
                validData[1] = Integer.parseInt(data[1]);
                validData[0] = 1;
            } catch (NumberFormatException e) {
                System.out.println("Not integer!!!");
            }
        }
        return validData;
    }
}
