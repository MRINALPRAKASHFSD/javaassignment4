package service;

import model.Book;
import model.Member;
import java.io.*;
import java.util.Collection;
import java.util.Map;

public class FileUtil {

    // Helper to ensure data directory exists
    public static void checkFileExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs(); // Create "data" folder if missing
        }
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void saveBooks(String fileName, Collection<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Book b : books) {
                writer.write(b.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }

    public static void loadBooks(String fileName, Map<Integer, Book> bookMap) {
        try {
            checkFileExists(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Book b = Book.fromCSV(line);
                    bookMap.put(b.getBookId(), b);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
    }

    public static void saveMembers(String fileName, Collection<Member> members) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Member m : members) {
                writer.write(m.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving members: " + e.getMessage());
        }
    }

    public static void loadMembers(String fileName, Map<Integer, Member> memberMap) {
        try {
            checkFileExists(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Member m = Member.fromCSV(line);
                    memberMap.put(m.getMemberId(), m);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error loading members: " + e.getMessage());
        }
    }
}