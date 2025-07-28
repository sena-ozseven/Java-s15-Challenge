package Library.People;
import Library.Books.Book;
import java.util.Set;

public class Librarian{
    private Set<Book> books;
    private String name;
    private String password;
    private Set<Reader> readers;

    public Librarian(Set<Book> books, String name, String password, Set<Reader> readers) {
        this.books = books;
        this.name = name;
        this.password = password;
        this.readers = readers;
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

    public boolean searchBook(String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                System.out.println(targetTitle + " is found.");
                return true;
            }
        }
        return false;
    }

    public boolean verifyMember(String targetMember) {
        for (Reader reader : readers) {
            if (reader.getName().equalsIgnoreCase(targetMember)) {
                System.out.println(targetMember + "is a member.");
                return true;
            }
        }
        return false;
    }

    public void createBill(Author author, Reader reader, Book book) {
        System.out.println("==================== Library Receipt =========================");
        System.out.println("                                                              ");
        System.out.println("Book Details: " + book.getName()+", "+ book.getAuthor());
        System.out.println("Receiver: " + reader);
        System.out.println("Total: " + " ");
        System.out.println("==============================================================");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
