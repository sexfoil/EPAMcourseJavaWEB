package Controllers;

import Models.TextToolsModel;
import Utility.Tools.Tools;
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
        view.printMessage("Controller ran...");
    }
}
