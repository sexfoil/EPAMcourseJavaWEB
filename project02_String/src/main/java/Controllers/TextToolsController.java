package Controllers;

import Models.TextToolsModel;
import Utility.Tools.Tools;
import Utility.UI.UserInterface;
import Views.TextToolsView;

public class TextToolsController {

    private TextToolsView view;
    private TextToolsModel model;
    private Tools tools;

    public TextToolsController() {
        view = new TextToolsView();
        model = new TextToolsModel();
        tools = new Tools(view, model);
    }

    public void run() {

        while (true) {
            view.printMessage(TextToolsView.INPUT_PATH);
            String input = UserInterface.getUserInputString(view,"");
            if (input.toLowerCase().trim().equals("exit")) {
                view.printMessage("\nHAVE A NICE DAY!!!\n");
                break;
            }

            if(tools.loadTextFromFile(input)) {
                String result = tools.findLongestPalindrome();
                //view.printMessage(model.getTextLines().toString());
                view.printMessage(result);
            } else {
                view.printMessage(TextToolsView.WRONG_INPUT);
            }
        }
    }
}
