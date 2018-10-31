package controller;

import model.TeacherBookModel;
import utility.tools.TeacherBookTools;
import utility.ui.UserInterface;
import view.TeacherBookView;


public class TeacherBookController {

    private TeacherBookView view;
    private TeacherBookModel model;
    private TeacherBookTools tools;

    public TeacherBookController() {
        view = new TeacherBookView();
        model = new TeacherBookModel();
        tools = new TeacherBookTools(model, view);
    }

    public void run() {
        view.printMessage("\nWELCOME TO TEACHER BOOK!\n");
        application:
        while (true) {
            int action = UserInterface.inputCommand(view);
            switch (action) {
                case 1:
                    view.printResultSet(model.getStudents());
                    break;
                case 2:
                    if (tools.addStudentToTeacherBook()) {
                        view.printMessage("\nStudent was successfully added.");
                    } else {
                        view.printMessage("\nThis student already exists.");
                    }
                    break;
                case 0:
                    view.printMessage("\nExiting from MAIN MENU...\n");
                    break application;
            }
        }
        view.printMessage("\nSEE YOU AND HAVE A NICE DAY!\n");

    }
}
