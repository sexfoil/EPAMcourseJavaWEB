package utility.tools;

import model.TeacherBookModel;

public class TeacherBookTools {

    private TeacherBookModel model;
    private DataValidator validator;

    public TeacherBookTools(TeacherBookModel model) {
        this.model = model;
        validator = new DataValidator();
    }

    // some methods
}
