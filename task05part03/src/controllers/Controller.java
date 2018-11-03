package controllers;

import models.Model;
import utility.tools.Translator;
import utility.ui.UserInterface;
import views.View;

public class Controller {

    private Model model;
    private View view;
    private Translator translator;

    public Controller() {
        model = new Model();
        view = new View();
        translator = new Translator(model);
    }

    public void run() {
        view.printMessage("WELCOME TO TRANSLATOR!!!\n");

        while (true) {
            String text = UserInterface.inputText(view, View.INPUT_TEXT);

            if (text != null && text.length() > 0) {

                view.printMessage(View.SOURCE_TEXT_OUTPUT);
                view.printMessage(text);

                String translatedText = translator.getTranslatedText(text);

                view.printMessage(View.TRANSLATED_OUTPUT);
                view.printMessage(translatedText);
                view.printMessage("\n-----------------------------------------------\n");

            } else {
                break;
            }
        }

        view.printMessage("HAVE A NICE DAY!!!\n");

    }
}
