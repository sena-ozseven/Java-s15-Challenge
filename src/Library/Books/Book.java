package Library.Books;
import Library.People.Author;
import Library.enums.Status;

import java.time.LocalDate;
import java.util.Objects;


public abstract class Book {
    private int bookID;
    private Author author;
    private String name;
    private Status status;
    private int edition;
    private LocalDate date_of_purchase;
    private double price;
    private String category;

    public Book(int book_ID, Author author, String name, Status status, int edition, LocalDate date_of_purchase, double price, String category) {
        this.bookID = book_ID;
        this.author = author;
        this.name = name;
        this.status = status;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return name;
    };

    public abstract void getAuthor();
    public abstract void changeOwner();
    public abstract void getOwner();
    public abstract void display();
    public abstract void updateStatus();

    public int getBook_ID() {
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

    public void setBook_ID(int book_ID) {
        this.bookID = book_ID;
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


}
