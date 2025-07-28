package Library.Books;
import Library.People.Author;
import Library.People.Reader;
import Library.enums.Status;
import java.time.LocalDate;
import java.util.Objects;


public abstract class Book {
    public static int idCounter = 0;
    private int bookID;
    private Author author;
    private String name;
    private Status status;
    private int edition;
    private LocalDate date_of_purchase;
    private double price;
    private String category;

    public Book(int bookID, Author author, String name, Status status, int edition, LocalDate date_of_purchase, double price, String category) {
        this.bookID = idCounter++;
        this.author = author;
        this.name = name;
        this.status = status;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
        this.price = price;
        this.category = category;
    }

    public abstract void changeOwner();
    public abstract void display();

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    };

    public String getTitle() {
        return name;
    };

    public Author getAuthor() {
        return author;
    };

    public Reader getOwner(Reader reader) {
        return reader;
    };

    public int getBookID() {
        return bookID;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public LocalDate getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setDate_of_purchase(LocalDate date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID && edition == book.edition && Objects.equals(author, book.author) && Objects.equals(name, book.name) && status == book.status && Objects.equals(date_of_purchase, book.date_of_purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, author, name, status, edition, date_of_purchase);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", edition=" + edition +
                ", date_of_purchase=" + date_of_purchase +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
