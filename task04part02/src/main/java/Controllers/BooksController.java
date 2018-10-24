package Controllers;

import Models.BooksSet;
import Models.Entity.Book;
import UI.UserInterface;
import Utility.Tools;
import Views.BooksView;


public class BooksController {

    private BooksSet model;
    private BooksView view;
    private Tools tools;

    public BooksController () {
        init();
    }

    private void init() {
        model = new BooksSet();
        view = new BooksView();
        tools = new Tools(model);
    }

    public void run() {
        view.printMessage( "WELCOME!!!\n");

        application:
        while (true) {
            int command = UserInterface.inputCommand(view);
            String name;
            Book[] resultSet;
            switch (command) {
                case 1:
                    name = UserInterface.inputName(view, BooksView.INPUT_AUTHOR);
                    resultSet = tools.searchByAuthor(name);
                    if (resultSet.length > 0) {
                        view.printMessage(BooksView.START_INFO + BooksView.BY_AUTHOR + name);
                        view.printBooks(resultSet);
                    } else {
                        view.printMessage(BooksView.NO_RESULT);
                    }
                    break ;
                case 2:
                    name = UserInterface.inputName(view, BooksView.INPUT_PUBLISHER);
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
                    view.printMessage("\nSEE YOU AND HAVE A NICE DAY!!!");
                    break application;
            }
        }

    }
}
