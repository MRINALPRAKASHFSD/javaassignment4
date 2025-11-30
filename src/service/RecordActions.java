package service;

import model.Student;

public interface RecordActions {
    void addStudent(Student student);
    void deleteStudent(int rollNo);
    void updateStudent(Student student);
    Student searchStudent(int rollNo);
    void viewAllStudents();
}

