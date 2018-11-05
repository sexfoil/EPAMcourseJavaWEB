package Controllers;

import Models.BooksSet;
import Models.Entity.Book;
import UI.UserInterface;
import Utility.Tools;
import Views.BooksView;

import javax.swing.text.View;

/**
 * This class is the Controller in MVC Pattern - controls the data flow into {@code BooksSet}
 * object and updates the {@code BooksView} whenever data changes.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class BooksController {

    /**
     * Books model
     */
    private BooksSet model;

    /**
     * Books view
     */
    private BooksView view;

    /**
     * Tools to controls the data flow
     */
    private Tools tools;


    /**
     * Sole constructor. Constructs and initialized controller to controls the data flow.
     */
    public BooksController () {
        init();
    }

    private void init() {
        model = new BooksSet();
        view = new BooksView();
        tools = new Tools(model, view);
    }

    /**
     * Starts work of controller.
     */
    public void run() {
        view.printMessage( "WELCOME!!!\n");

        tools.loadDataToModel();

        Book[] resultSet = null;

        application:
        while (true) {

            int command = UserInterface.inputCommand(view);
            String name;

            switch (command) {
                case 1:
                    name = UserInterface.getUserInputString(view, BooksView.INPUT_AUTHOR);
                    resultSet = tools.searchByAuthor(name);
                    if (resultSet.length > 0) {
                        view.printMessage(BooksView.START_INFO + BooksView.BY_AUTHOR + name);
                        view.printBooks(resultSet);
                    } else {
                        view.printMessage(BooksView.NO_RESULT);
                    }
                    break ;
                case 2:
                    name = UserInterface.getUserInputString(view, BooksView.INPUT_PUBLISHER);
                    resultSet = tools.searchByPublisher(name);
                    if (resultSet.length > 0) {
                        view.printMessage(BooksView.START_INFO + BooksView.BY_PUBLISHER + name);
                        view.printBooks(resultSet);
                    } else {
                        view.printMessage(BooksView.NO_RESULT);
                    }
                    break;
                case 3:
                    int year = UserInterface.inputYear(view);
                    resultSet = tools.searchByYear(year);
                    if (resultSet.length > 0) {
                        view.printMessage(BooksView.START_INFO + BooksView.FROM_YEAR + year);
                        view.printBooks(resultSet);
                    } else {
                        view.printMessage(BooksView.NO_RESULT);
                    }
                    break;
                case 4:
                    resultSet = tools.sortByPublisher();
                    view.printMessage(BooksView.START_INFO + BooksView.SORTED_BY_PUBLISHER);
                    view.printBooks(resultSet);
                    break;
                case 5:
                    view.printMessage(BooksView.START_INFO + ":");
                    view.printBooks(model.getBooks());
                    break;
                case 0:
                    if (resultSet != null && resultSet.length > 0) {
                        tools.saveDataToFile(resultSet);
                    }
                    break application;
            }
        }

        view.printMessage("\nSEE YOU AND HAVE A NICE DAY!!!");
    }

}
