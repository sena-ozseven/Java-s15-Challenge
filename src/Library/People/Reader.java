package Library.People;

import Library.Books.Book;

import java.util.Objects;
import java.util.Set;

public class Reader extends Person{
    private Set<Book> books;
    private double balance;

    public Reader(String name, double balance) {
        super(name);
        this.balance = balance;
    }

    public Reader(String name, Set<Book> books, double balance) {
        super(name);
        this.books = books;
        this.balance = balance;
    }

    public void purchaseBook(Book book) {
        books.add(book);
        System.out.println(book + "has been purchased.");
    }

    public void borrowBook(Book book) {
        books.add(book);
        System.out.println(book + "has been borrowed.");
    }

    public void returnBook(Book book) {
        books.remove(book);
        System.out.println(book + "has been returned to the library and removed from your book list.");
    }

    public void showBook() {
        System.out.println(books);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return Objects.equals(getBooks(), reader.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBooks());
    }

    @Override
    public void whoyouare() {
        System.out.println("I am a reader.");
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
