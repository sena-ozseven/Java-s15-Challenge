package Library.People;
import Library.enums.Status;
import Library.Books.Book;
import java.time.LocalDate;
import java.util.Set;

public class Librarian{
    private Set<Book> books;
    private String name;
    private String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean searchBook(Set<Book> books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                System.out.println(targetTitle + " is found.");
                return true;
            }
        }
        return false;
    }

    public boolean verifyMember(Reader reader, String targetMember) {
        if (!reader.getName().equalsIgnoreCase(targetMember)) {
            System.out.println(targetMember + "is not a member.");
            return false;
        } else {
            System.out.println(targetMember + "is a member.");
            return true;
        }
    }

    public void issueBook(Book book, Reader borrower, LocalDate date) {
        if (searchBook(books, book.getTitle())) {
            if (verifyMember(borrower, borrower.getName())) {
                if (book.getStatus() == Status.AVAILABLE) {
                    book.changeOwner();
                    book.updateStatus(Status.CHECKED_OUT);
                    book.setDate_of_purchase(date);
                }
            }
        }
    }

    public void returnBook(Book book) {
        if (book.getStatus() != Status.AVAILABLE) {
            book.updateStatus(Status.AVAILABLE);
        } else {
            System.out.println(book + " cannot be returned, it is already AVAILABLE.");
        }
    }

    public void calculateFine() {}
    public void createBill(Author author, Reader reader, Book book) {
        System.out.println("==================== Library Receipt =========================");
        System.out.println("                                                              ");
        System.out.println("Book Details: " + book.getName()+", "+ book.getAuthor(author));
        System.out.println("Receiver: " + reader);
        System.out.println("Total: " + " ");
        System.out.println("==============================================================");
    }

}
