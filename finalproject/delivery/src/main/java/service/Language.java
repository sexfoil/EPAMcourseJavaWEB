package service;

import java.util.Locale;

public enum Language {
    ENG(new Locale("en", "UK")),
    UKR(new Locale("uk", "UA")),
    RUS(new Locale("ru", "RU"));

    private Locale locale;

    Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}
