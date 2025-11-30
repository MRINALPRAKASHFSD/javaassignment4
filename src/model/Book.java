package model;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isIssued;

    public Book(int bookId, String title, String author, String category, boolean isIssued) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = isIssued;
    }

    // Getters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isIssued() { return isIssued; }

    // Domain Methods
    public void markAsIssued() { this.isIssued = true; }
    public void markAsReturned() { this.isIssued = false; }

    public void displayBookDetails() {
        System.out.println("ID: " + bookId + " | Title: " + title + " | Author: " + author + 
                           " | Category: " + category + " | Status: " + (isIssued ? "Issued" : "Available"));
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    // CSV Helpers
    public String toCSV() {
        return bookId + "," + title + "," + author + "," + category + "," + isIssued;
    }

    public static Book fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Book(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Boolean.parseBoolean(parts[4]));
    }
}