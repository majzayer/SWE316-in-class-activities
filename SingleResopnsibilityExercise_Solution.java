//BookInventoryManager Class
import java.util.*;

public class BookInventoryManager {
    private List<Book> books;

    public BookInventoryManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    public boolean isBookAvailable(String isbn) {
        Book book = findBookByIsbn(isbn);
        return book != null && !book.isBorrowed();
    }

    public List<Book> getAllBooks() {
        return books;
    }
}

// 2. BorrowingService Class
import java.util.Map;

public class BorrowingService {
    private final BookInventoryManager bookInventory;
    private final MemberManager memberManager;

    public BorrowingService(BookInventoryManager bookInventory, MemberManager memberManager) {
        this.bookInventory = bookInventory;
        this.memberManager = memberManager;
    }

    public void borrowBook(String isbn, String memberId) {
        Book book = bookInventory.findBookByIsbn(isbn);
        if (book == null || book.isBorrowed()) {
            throw new IllegalStateException("Book is not available for borrowing.");
        }

        Member member = memberManager.getMemberById(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }

        book.setBorrowed(true);
        member.borrowBook(book);
    }

    public void returnBook(String isbn, String memberId) {
        Book book = bookInventory.findBookByIsbn(isbn);
        if (book == null || !book.isBorrowed()) {
            throw new IllegalStateException("Book was not borrowed.");
        }

        Member member = memberManager.getMemberById(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }

        book.setBorrowed(false);
        member.returnBook(book);
    }
}


//3. FineCalculator Class
import java.util.Date;

public class FineCalculator {
    private final MemberManager memberManager;

    public FineCalculator(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public double calculateFine(String memberId) {
        Member member = memberManager.getMemberById(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }

        double fine = 0.0;
        for (Book book : member.getBorrowedBooks()) {
            if (isOverdue(book)) {
                fine += 5.0; // Assume a fixed fine for simplicity
            }
        }
        return fine;
    }

    private boolean isOverdue(Book book) {
        // Dummy logic to check if a book is overdue
        return new Date().after(book.getDueDate());
    }
}

//5. ReportGenerator Class
import java.util.*;

public class ReportGenerator {
    private final MemberManager memberManager;

    public ReportGenerator(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public String generateOverdueReport() {
        StringBuilder report = new StringBuilder("Overdue Books Report:\n");
        for (Member member : memberManager.getAllMembers()) {
            for (Book book : member.getBorrowedBooks()) {
                if (isOverdue(book)) {
                    report.append("Member: ").append(member.getName())
                          .append(", Book: ").append(book.getTitle()).append("\n");
                }
            }
        }
        return report.toString();
    }

    private boolean isOverdue(Book book) {
        return new Date().after(book.getDueDate());
    }
}

//MemberManager Class
import java.util.*;

public class MemberManager {
    private Map<String, Member> members;

    public MemberManager() {
        this.members = new HashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    public Member getMemberById(String memberId) {
        return members.get(memberId);
    }

    public Collection<Member> getAllMembers() {
        return members.values();
    }
}
//7. LoggerService Class
import java.util.logging.*;

public class LoggerService {
    private static final Logger logger = Logger.getLogger(LoggerService.class.getName());

    public void logAction(String message) {
        logger.info(message);
    }
}
