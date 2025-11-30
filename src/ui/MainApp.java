package ui;

import service.LibraryManager;
import model.Book;
import model.Member;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libManager = new LibraryManager();
        
        System.out.println("Welcome to City Library Digital Management System");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. Sort Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String cat = scanner.nextLine();
                    libManager.addBook(new Book(bId, title, author, cat, false));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int mId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    libManager.addMember(new Member(mId, name, email));
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int issueBId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Member ID: ");
                    int issueMId = Integer.parseInt(scanner.nextLine());
                    libManager.issueBook(issueBId, issueMId);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int retBId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Member ID: ");
                    int retMId = Integer.parseInt(scanner.nextLine());
                    libManager.returnBook(retBId, retMId);
                    break;

                case 5:
                    System.out.print("Enter search keyword: ");
                    String query = scanner.nextLine();
                    libManager.searchBooks(query);
                    break;

                case 6:
                    System.out.println("Sort by: 1. Title  2. Author");
                    int sortChoice = Integer.parseInt(scanner.nextLine());
                    libManager.sortBooks(sortChoice);
                    break;

                case 7:
                    System.out.println("Exiting System...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}