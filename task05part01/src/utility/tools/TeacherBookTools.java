package utility.tools;

import model.TeacherBookModel;
import model.entity.Student;
import utility.ui.UserInterface;
import view.TeacherBookView;


public class TeacherBookTools {

    private TeacherBookView view;
    private TeacherBookModel model;

    public TeacherBookTools(TeacherBookModel model, TeacherBookView view) {
        this.model = model;
        this.view = view;
    }

    public boolean addStudentToTeacherBook() {

        String fName = null;
        String lName = null;
        String bDate = null;
        String pNum = null;
        String address = null;

        while (true) {
            fName = UserInterface.inputData(view, TeacherBookView.FIRST_NAME_STR);
            if (DataValidator.isInputDataValid(fName, StudentDataFormat.NAME.getFormat())) {
                break;
            }
            view.printMessage(TeacherBookView.INVALID_INPUT);
        }

        while (true) {
            lName = UserInterface.inputData(view, TeacherBookView.LAST_NAME_STR);
            if (DataValidator.isInputDataValid(lName, StudentDataFormat.NAME.getFormat())) {
                break;
            }
            view.printMessage(TeacherBookView.INVALID_INPUT);
        }

        while (true) {
            bDate = UserInterface.inputData(view, TeacherBookView.DATE_STR);
            if (DataValidator.isInputDataValid(bDate, StudentDataFormat.DATE.getFormat()) && isCorrectDate(bDate)) {
                break;
            }
            view.printMessage(TeacherBookView.INVALID_INPUT);
        }

        while (true) {
            pNum = UserInterface.inputData(view, TeacherBookView.PHONE_STR);
            if (DataValidator.isInputDataValid(pNum, StudentDataFormat.PHONE.getFormat())) {
                break;
            }
            view.printMessage(TeacherBookView.INVALID_INPUT);
        }

        while (true) {
            address = UserInterface.inputData(view, TeacherBookView.ADDRESS_STR);
            if (DataValidator.isInputDataValid(address, StudentDataFormat.ADDRESS.getFormat())) {
                break;
            }
            view.printMessage(TeacherBookView.INVALID_INPUT);
        }

        Student student = new Student(fName, lName, bDate, pNum, address);

        return model.addStudent(student);
    }

    private boolean isCorrectDate(String date) {
        String[] dateArray = date.split("\\.");
        int d = Integer.parseInt(dateArray[0]);
        int m = Integer.parseInt(dateArray[1]);
        int y = Integer.parseInt(dateArray[2]);
        boolean notLeap = (y % 4 != 0) || (y % 100 == 0 && y % 400 != 0);
        switch (m) {
            case 2:
                return d < 29 + (notLeap ? 0 : 1);
            case 4: case 6: case 9: case 11:
                return d < 31;
        }
        return true;
    }
}
