package Utility.Tools;

import Models.TextToolsModel;
import Views.TextToolsView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tools {

    private TextToolsView view;
    private TextToolsModel model;

    public Tools(TextToolsView view, TextToolsModel model) {
        this.view = view;
        this.model = model;
    }

    public boolean loadTextFromFile(String userInput) {
        Path path = Paths.get("src/main/resources/" + userInput);
        if (Files.exists(path)) {
            try {
                model.setTextLines(Files.readAllLines(path));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERROR!!!\n" + e.getMessage());
            }
        } else {
            System.out.println("NOT EXISTS...");
        }
        return false;
    }

    public String findLongestPalindrome() {
        String longestPalendrome = "";

        currentLine:
        for (String str : model.getTextLines()) {
            CharSequence seq = getValidString(str);
            //System.out.println(seq);
            if (seq.length() > longestPalendrome.length()) {
                int size = seq.length();
                //System.out.println("Len=" + size);
                for (int i = 0; i < size / 2; i++) {
                    //System.out.println("chars: " + seq.charAt(i) + "=" + seq.charAt(size - 1 - i));

                    if (seq.charAt(i) != seq.charAt(size - 1 - i)) {
                        continue currentLine;
                    }
                }
                longestPalendrome = (String) seq;
            }
        }

        return longestPalendrome;
    }

    private CharSequence getValidString(String str) {
        str = str.replace("\n", "");
        int len = str.length();
        while (true) {
            str = str.replace("  ", " ");
            if (str.length() == len) {
                break;
            }
            len = str.length();
        }
        return str.trim();
    }
}
