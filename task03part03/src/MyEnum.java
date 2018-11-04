public class MyEnum implements Comparable {

    private final String name;

    public final String name() {
        return name;
    }

    private final int ordinal;

    public final int ordinal() {
        return ordinal;
    }


    public MyEnum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyEnum myEnum = (MyEnum) o;

        if (ordinal != myEnum.ordinal) return false;
        return name != null ? name.equals(myEnum.name) : myEnum.name == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + ordinal;
        return result;
    }

    @Override
    public int compareTo(Object obj) {
        MyEnum other = (MyEnum) obj;
        return this.ordinal - other.ordinal;
    }
}
