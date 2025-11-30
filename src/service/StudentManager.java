package service;

import java.util.HashMap;
import java.util.Map;
import model.Student;

public class StudentManager implements RecordActions {
    private Map<Integer, Student> studentMap;

    public StudentManager() {
        studentMap = new HashMap<>();
    }

    @Override
    public void addStudent(Student student) {
        // TODO: prevent duplicate roll numbers
    }

    @Override
    public void deleteStudent(int rollNo) {
        // TODO: remove by rollNo and show appropriate message
    }

    @Override
    public void updateStudent(Student student) {
        // TODO: replace existing student with same rollNo
    }

    @Override
    public Student searchStudent(int rollNo) {
        // TODO: return student or null if not found
        return null;
    }

    @Override
    public void viewAllStudents() {
        // TODO: loop and call displayInfo() on each student
    }
}
