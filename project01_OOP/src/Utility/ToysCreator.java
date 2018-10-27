package Utility;

import Models.Entity.*;

import java.util.Random;

/**
 * Service class to create random instance of toy.
 * Uses class {@code Random} to generate different properties of toy created.
 *
 * @author Slava Poliakov
 * @version 1.0
 * @see Random
 */
public class ToysCreator {

    /**
     * Set of colors.
     */
    private static final String[] colors = new String[]{"brown", "white", "black", "grey", "red", "green", "blue"};

    /**
     * Set of buildings.
     */
    private static final String[] buildings = new String[]{"bridge", "house", "garage", "castle", "stadium"};

    /**
     * Set of themes.
     */
    private static final String[] themes = new String[]{"StarWars", "Police", "Ninja", "Weekend", "Picnic"};

    /**
     * Set of sexes.
     */
    private static final String[] sex = new String[]{"male", "female"};

    /**
     * Generator of random values.
     */
    private static Random random = new Random();

    /**
     * Minimum value of toy's price
     */
    public static double minPrice = 9.99;


    /**
     * Returns instance of toy random generated.
     *
     * @return instance of toy
     */
    public Toy createToy() {
        Toy item = null;
        int num = random.nextInt(100);
        int index;
        String color;
        double price;
        int[] age;
        switch (random.nextInt(4)) {
            case 0:
                index = random.nextInt(3);
                color = colors[index + 4];
                price = minPrice + 41.01 + index * 3;
                age = new int[]{4, 9};
                if (index == 0) {
                    item = new Tavria(color, "steel", "UA", price, age, true, "sedan");
                } else if (index == 1) {
                    item = new Iveco(color, "steel", "EU", price, age, true, "truck");
                } else {
                    item = new McLaren(color, "steel", "USA", price, age, true, "sport", "F1");
                }
                break;
            case 1:
                index = random.nextInt(2);
                color = colors[index];
                price = minPrice + 25.01 + index * 10;
                age = new int[]{4, 10};
                if (random.nextBoolean()) {
                    String theme = themes[index + 3];
                    item = new Barbie(color, "plastic", "USA", price, age, "female", true, theme);
                } else {
                    item = new Ivan(color, "wood", "RUS", price, age, "male", false, "Ural");
                }
                break;
            case 2:
                index = random.nextInt(2);
                color = colors[index];
                price = minPrice + 40.01 + index * 20;
                age = new int[]{7, 14};
                if (index == 0) {
                    item = new Igroteco(color, "wood", "RUS", price, age, num, buildings[num % 5]);
                } else {
                    item = new Lego(color, "plastic", "USA", price, age, num * 10, themes[num % 3]);
                }
                break;
            case 3:
                index = random.nextInt(4);
                color = colors[index];
                price = minPrice + index * 2;
                age = new int[]{3, 15};
                if (num % 4 == 0) {
                    item = new Bear(color, "plush", "EU", price, age, sex[num % 2], true);
                } else if (num % 4 == 1) {
                    item = new Bunny(color, "plush", "UA", price, age, sex[num % 2], true);
                } else if (num % 4 == 2) {
                    item = new Cat(color, "plush", "UK", price, age, sex[num % 2], true);
                } else {
                    item = new Dog(color, "plush", "UK", price, age, sex[num % 2], true);
                }
                break;
        }

        return item;
    }
}
