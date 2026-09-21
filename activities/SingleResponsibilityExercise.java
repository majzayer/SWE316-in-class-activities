import java.util.*;
import java.util.logging.*;

public class BookManager {
    private List<Book> books;
    private Map<String, Member> members;
    private Logger logger = Logger.getLogger(BookManager.class.getName());

    // Constructor
    public BookManager() {
        this.books = new ArrayList<>();
        this.members = new HashMap<>();
    }


    public void addBook(Book book) {
        books.add(book);
        logAction("Added new book: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        logAction("Removed book with ISBN: " + isbn);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


    public void borrowBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null || book.isBorrowed()) {
            logAction("Attempted to borrow unavailable book: " + isbn);
            throw new IllegalStateException("Book is not available for borrowing.");
        }

        Member member = members.get(memberId);
        if (member == null) {
            logAction("Member not found: " + memberId);
            throw new IllegalArgumentException("Member not found.");
        }

        book.setBorrowed(true);
        member.borrowBook(book);
        logAction("Book borrowed: " + isbn + " by member: " + memberId);
    }

    public void returnBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null || !book.isBorrowed()) {
            logAction("Attempted to return a book that was not borrowed: " + isbn);
            throw new IllegalStateException("Book was not borrowed.");
        }

        Member member = members.get(memberId);
        if (member == null) {
            logAction("Member not found: " + memberId);
            throw new IllegalArgumentException("Member not found.");
        }

        book.setBorrowed(false);
        member.returnBook(book);
        logAction("Book returned: " + isbn + " by member: " + memberId);
    }


    public boolean isBookAvailable(String isbn) {
        Book book = findBookByIsbn(isbn);
        return book != null && !book.isBorrowed();
    }


    public double calculateFine(String memberId) {
        Member member = members.get(memberId);
        if (member == null) {
            logAction("Member not found for fine calculation: " + memberId);
            throw new IllegalArgumentException("Member not found.");
        }

        double fine = 0.0;
        for (Book book : member.getBorrowedBooks()) {
            if (isOverdue(book)) {
                fine += 5.0; // Assume a fixed fine for simplicity
            }
        }
        logAction("Calculated fine for member: " + memberId + " is $" + fine);
        return fine;
    }

    private boolean isOverdue(Book book) {
        // Dummy logic to check if a book is overdue
        return new Date().after(book.getDueDate());
    }


    public String generateOverdueReport() {
        StringBuilder report = new StringBuilder("Overdue Books Report:\n");
        for (Member member : members.values()) {
            for (Book book : member.getBorrowedBooks()) {
                if (isOverdue(book)) {
                    report.append("Member: ").append(member.getName()).append(", Book: ").append(book.getTitle()).append("\n");
                }
            }
        }
        logAction("Generated overdue report.");
        return report.toString();
    }


    private void logAction(String message) {
        logger.info(message);
    }


    public void addMember(Member member) {
        members.put(member.getId(), member);
        logAction("Added new member: " + member.getName());
    }

    public void removeMember(String memberId) {
        members.remove(memberId);
        logAction("Removed member: " + memberId);
    }
}
