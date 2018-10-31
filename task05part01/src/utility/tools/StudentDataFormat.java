package utility.tools;

public enum StudentDataFormat {
    NAME("^[A-Z]([a-z]){1,9}$"),
    DATE("^((0[1-9]|[1-2][0-9]|3[01])\\.)((0[1-9]|1[0-2])\\.)((19|20)\\d{2})$"),
    PHONE("^\\+[1-9]\\d{2} \\(\\d{2}\\) \\d{3}(-\\d{2}){2}$"),
    ADDRESS("^[A-Z]([a-z])+ b\\.[1-9]\\d*, ap\\.[1-9]\\d*$");

    private String format;


    StudentDataFormat(String format) {
        this.format = format;
    }


    public String getFormat() {
        return format;
    }
}
