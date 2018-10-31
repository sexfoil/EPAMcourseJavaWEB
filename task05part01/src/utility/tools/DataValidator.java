package utility.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public static boolean isInputDataValid(String inputData, String format) {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(inputData);
        return matcher.find();
    }
}
