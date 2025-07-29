package Library.People;
import Library.Books.Book;
import java.util.Objects;
import java.util.Set;

public class Author extends Person {
    private Set<Book> books;

    public Author(String name) {
        super(name);
    }

    public Author(String name, Set<Book> books) {
        super(name);
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void new_book(Book newBook) {
        books.add(newBook);
    }

    public void show_book() {
        System.out.println(books);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(getBooks(), author.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBooks());
    }

    @Override
    public void whoyouare() {
        System.out.println("I am an author");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
