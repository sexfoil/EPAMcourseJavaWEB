package utility.tools;

import models.Model;

import java.util.regex.Pattern;


public class Translator {

    private Model model;

    public Translator(Model model) {
        this.model = model;
    }

    public String getTranslatedText(String text) {
        String[] words = getWordsArrayWithoutDoubleSpaces(text);
        //String translatedText = text;
        for (String word : words) {
            if (word.length() > 0) {
                String translation = getTranslation(word);
                if (!word.equals(translation)) {
                    text = text.replace(word, translation);
                }
            }
        }

        return text;
    }

    private String[] getWordsArrayWithoutDoubleSpaces(String text) {
        int originLength;
        do {
            originLength = text.length();
            text = text.replace("  ", " ");
        }while (text.length() < originLength);
        Pattern pattern = Pattern.compile("[.,!?:; ]");

        return pattern.split(text);
    }

    private String getTranslation(String word) {
        String translation;
        boolean isCapital = word.charAt(0) < 91;

        if (model.getDictionary().containsKey(word.toLowerCase())) {
            translation = model.getDictionary().get(word.toLowerCase());
            if (isCapital) {
                translation = translation.substring(0, 1).toUpperCase() + translation.substring(1);
            }

            return translation;
        }
        return word;
    }
}
