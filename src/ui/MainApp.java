package ui;

import java.util.Scanner;
import model.Student;
import service.StudentManager;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;
        do {
            System.out.println("===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // TODO: read details, create Student, call addStudent()
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    // TODO: read roll, call searchStudent(), display results
                    break;
                case 4:
                    // TODO: read roll, call deleteStudent()
                    break;
                case 5:
                    // TODO: read updated data, call updateStudent()
                    break;
                case 6:
                    System.out.println("Exiting application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }
}
