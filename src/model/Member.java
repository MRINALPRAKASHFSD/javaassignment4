package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private String email;
    private List<Integer> issuedBooks; 

    public Member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
    }

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Integer> getIssuedBooks() { return issuedBooks; }

    public void addIssuedBook(int bookId) {
        issuedBooks.add(bookId);
    }

    public void returnIssuedBook(int bookId) {
        issuedBooks.remove((Integer) bookId);
    }

    public void displayMemberDetails() {
        System.out.println("ID: " + memberId + " | Name: " + name + " | Email: " + email + 
                           " | Books Issued: " + issuedBooks);
    }

    // CSV Helpers
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        for (int id : issuedBooks) {
            sb.append(id).append(";");
        }
        String booksStr = sb.length() > 0 ? sb.toString() : "NONE";
        return memberId + "," + name + "," + email + "," + booksStr;
    }

    public static Member fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        Member m = new Member(Integer.parseInt(parts[0]), parts[1], parts[2]);
        
        if (!parts[3].equals("NONE")) {
            String[] bookIds = parts[3].split(";");
            for (String bid : bookIds) {
                if (!bid.isEmpty()) m.addIssuedBook(Integer.parseInt(bid));
            }
        }
        return m;
    }
}