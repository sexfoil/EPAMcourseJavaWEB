package utility.tools;

import java.util.Locale;
import java.util.ResourceBundle;

public enum LanguageManager {
    INSTANCE;
    private ResourceBundle resourceBundle;

    LanguageManager() {
        resourceBundle = ResourceBundle.getBundle("property.language.message",
                new Locale("en", "UK"));
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("property.language.message",
                locale);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
