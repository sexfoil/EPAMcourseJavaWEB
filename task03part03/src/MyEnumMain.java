import java.util.Arrays;

public class MyEnumMain{

    public static void main(String[] args) {
        System.out.println("---------------------------\n" +
                            "Rainbow colors enumeration:\n" +
                            "---------------------------");

        System.out.println("\ninvoke 'Enumeration.values()'");
        System.out.println(Arrays.toString(Enumeration.values()));

        System.out.println("\ninvoke 'Enumeration.RED'");
        System.out.println(Enumeration.RED);

        System.out.println("\ninvoke 'Enumeration.valueOf(\"ORANGE\")'");
        System.out.println(Enumeration.valueOf("ORANGE"));

        System.out.println("\ninvoke 'Enumeration.valueOf(\"BLACK\")'");
        System.out.println(Enumeration.valueOf("BLACK"));

        System.out.println("\ninvoke 'Enumeration.GREEN.name()'");
        System.out.println(Enumeration.GREEN.name());

        System.out.println("\ninvoke 'Enumeration.BLUE.ordinal()'");
        System.out.println(Enumeration.BLUE.ordinal());

        System.out.println("\ninvoke 'Enumeration.YELLOW.compareTo(Enumeration.INDIGO)'");
        System.out.println(Enumeration.YELLOW.compareTo(Enumeration.INDIGO));

        System.out.println("\ninvoke 'Enumeration.VIOLET'");
        System.out.println(Enumeration.VIOLET);

        System.out.println("\ninvoke 'Enumeration.VIOLET.equals(Enumeration.RED)'");
        System.out.println(Enumeration.VIOLET.equals(Enumeration.RED));

        System.out.println("\ninvoke 'Enumeration.VIOLET.equals(Enumeration.VIOLET)'");
        System.out.println(Enumeration.VIOLET.equals(Enumeration.VIOLET));

    }

}