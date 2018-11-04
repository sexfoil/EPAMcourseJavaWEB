public class Enumeration {

    public static final MyEnum RED = new MyEnum("RED", 0);
    public static final MyEnum ORANGE = new MyEnum("ORANGE", 1);
    public static final MyEnum YELLOW = new MyEnum("YELLOW", 2);
    public static final MyEnum GREEN = new MyEnum("GREEN", 3);
    public static final MyEnum BLUE = new MyEnum("BLUE", 4);
    public static final MyEnum INDIGO = new MyEnum("INDIGO", 5);
    public static final MyEnum VIOLET = new MyEnum("VIOLET", 6);


    private static MyEnum[] values = new MyEnum[] {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET};

    public static MyEnum[] values() {
        return values;
    }

    public static String valueOf(String name) {
        for (MyEnum value : values) {
            if (name.equals(value.name())) {
                return value.name();
            }
        }
        return "Exception in thread \"main\" java.lang.IllegalArgumentException: No enum constant Enumeration." + name;
    }

}
