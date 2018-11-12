package p01reflection1;

import utility.UserInterface;

import java.lang.reflect.Field;

public class Part01Runner {

    public void run() {

        try {

            String existingString = "white";
            String userString = UserInterface.getUserInputString();

            System.out.println("\nExisting string:");
            System.out.println(existingString);
            System.out.println("\nUser input string:");
            System.out.println(userString);

            Class<?> clazzE = existingString.getClass();
            Class<?> clazzU = userString.getClass();

            Field fieldE = clazzE.getDeclaredField("value");
            Field fieldU = clazzU.getDeclaredField("value");

            fieldE.setAccessible(true);
            fieldU.setAccessible(true);

            String anotherString = UserInterface.getUserInputString().trim();
            if (anotherString.length() == 0) {
                anotherString = "black";
            }

            System.out.println("\nNew string:");
            System.out.println(anotherString);


            fieldE.set(existingString, anotherString.toCharArray());
            fieldU.set(userString, anotherString.toCharArray());

            System.out.println("\nReflection...\n");
            System.out.println("\nExisting string:");
            System.out.println(existingString);
            System.out.println("\nUser input string:");
            System.out.println(userString);


            System.out.println("white=" + userString + " ? " + "white".equals(userString));

            System.out.println("\n**************************************************************************\n\n");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
