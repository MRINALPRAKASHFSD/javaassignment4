package service;

import model.Book;
import model.Member;
import java.util.*;

public class LibraryManager {
    // Data Structures
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    
    // File Paths (Relative to project root)
    private final String BOOK_FILE = "data/books.txt";
    private final String MEMBER_FILE = "data/members.txt";

    public LibraryManager() {
        // Load data using FileUtil on startup
        FileUtil.loadBooks(BOOK_FILE, books);
        FileUtil.loadMembers(MEMBER_FILE, members);
    }

    // --- Core Operations ---

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
        FileUtil.saveBooks(BOOK_FILE, books.values());
        System.out.println("Book added successfully.");
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        FileUtil.saveMembers(MEMBER_FILE, members.values());
        System.out.println("Member added successfully.");
    }

    public void issueBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            System.out.println("Error: Invalid Book ID or Member ID.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Error: Book is already issued.");
            return;
        }

        book.markAsIssued();
        member.addIssuedBook(bookId);
        
        // Save both files as both records changed
        FileUtil.saveBooks(BOOK_FILE, books.values());
        FileUtil.saveMembers(MEMBER_FILE, members.values());
        System.out.println("Book issued successfully.");
    }

    public void returnBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book != null && member != null && member.getIssuedBooks().contains(bookId)) {
            book.markAsReturned();
            member.returnIssuedBook(bookId);
            
            FileUtil.saveBooks(BOOK_FILE, books.values());
            FileUtil.saveMembers(MEMBER_FILE, members.values());
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Error: Record mismatch or book not issued to this member.");
        }
    }

    // --- Search & Sort ---

    public void searchBooks(String query) {
        boolean found = false;
        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(query.toLowerCase()) || 
                b.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                b.getCategory().toLowerCase().contains(query.toLowerCase())) {
                b.displayBookDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No books found.");
    }

    public void sortBooks(int criterion) {
        List<Book> bookList = new ArrayList<>(books.values());

        if (criterion == 1) {
            Collections.sort(bookList); // Sort by Title
            System.out.println("--- Books Sorted by Title ---");
        } else if (criterion == 2) {
            // Sort by Author using Comparator
            Collections.sort(bookList, new Comparator<Book>() {
                @Override
                public int compare(Book b1, Book b2) {
                    return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
                }
            });
            System.out.println("--- Books Sorted by Author ---");
        }

        for (Book b : bookList) {
            b.displayBookDetails();
        }
    }
}