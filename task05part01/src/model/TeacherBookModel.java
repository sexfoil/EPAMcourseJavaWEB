package model;

import model.entity.Student;

import java.util.ArrayList;

public class TeacherBookModel {

    private ArrayList<Student> students;

    public TeacherBookModel() {
        students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getLastName().equals(student.getLastName()) &&
                    s.getFirstName().equals(student.getFirstName()) &&
                    s.getDateOfBirth().equals(student.getDateOfBirth())) {
                return false;
            }
        }
        return students.add(student);
    }

//    public boolean removeStudent(Student student) {
//        return false;
//    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
