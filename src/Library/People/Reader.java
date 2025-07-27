package Library.People;

import Library.Books.Book;

import java.util.Objects;
import java.util.Set;

public class Reader extends Person{
    private Set<Book> books;

    public Reader(String name) {
        super(name);
    }

    public Reader(String name, Set<Book> books) {
        super(name);
        this.books = books;
    }

    public void purchase_book(Book book) {
        books.add(book);
        System.out.println(book + "has been purchased.");
    }

    public void borrow_book(Book book) {
        books.add(book);
        System.out.println(book + "has been borrowed.");
    }

    public void return_book(Book book) {
        books.remove(book);
        System.out.println(book + "has been returned to the library and removed from your book list.");
    }

    public void show_book() {
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
    public String toString() {
        return "Reader{" +
                "books=" + books +
                '}';
    }

    @Override
    public void whoyouare() {}
}
