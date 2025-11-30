package model;

public class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student() {
        // TODO: initialize fields with default values
    }

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        // TODO: call a method to calculate grade
    }

    public void calculateGrade() {
        // TODO: set grade based on marks
    }

    @Override
    public void displayInfo() {
        // TODO: print roll no, name, email, course, marks, grade
    }

    // Overloaded method (polymorphism)
    public void displayInfo(String note) {
        // TODO: print normal info plus extra note
    }

    // Getters and setters as needed
    public int getRollNo() {
        return rollNo;
    }
}
