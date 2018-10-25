package Utility;

import Models.Entity.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ToysCreator<T extends Toy> {

    private static final String[] colors = new String[] {"black", "white", "red", "green", "blue", "yellow", "brawn"};
    private static final String[] buildings = new String[] {"bridge", "house", "garage", "castle", "stadium"};
    private static final String[] themes = new String[] {"StarWars", "AngryBirds", "Ninja", "Weekend", "Picnic"};
    private static Random random = new Random();


    public T createToy() {
        T toy = null;
//        for (int i = 0; i < 20; i++) {
//            Toy item = null;
//            int num = r.nextInt(100);
//            String color = colors[num % 3];
//            switch (r.nextInt(8)) {
//                case 0:
//                    item = new Barbie("black", "plastic", "USA", num*10.0, num/5.0, "female", true, "City");
//                    break;
//                case 1:
//                    item = new Bear("white", "plush", "FR", num*5.0, num/4.0, "male", 10, "Polar");
//                    break;
//                case 2:
//                    item = new Bunny(color, "plush", "UA", num*3.0, num/6.0, "female", 25);
//                    break;
//                case 3:
//                    item = new Igroteco(color, "wood", "RUS", 12.35, num*2, num*10, (3+num%5), (8+num%5), buildings[num%3]);
//                    break;
//                case 4:
//                    item = new Ivan("white", "wood", "RUS", num*2.0, num/5.0, "male", false, "Ural");
//                    break;
//                case 5:
//                    item = new Lego(color, "plastic", "USA", 102.50, num*3, num*14, (2+num%5), (6+num%5), buildings[num%3]);
//                    break;
//                case 6:
//                    item = new McLaren(color, "steel", "USA", num*100_000, num*100, 1, true, "F1");
//                    break;
//                case 7:
//                    item = new Tavria(color, "steel", "UA", num*500, num*50, 1, true, "Slavuta");
//                    break;
//            }
//            toys.add((T) item);
//        }
        return toy;
    }


}
