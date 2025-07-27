package Library;
import Library.Books.Book;
import Library.People.Reader;

import java.util.Map;
import java.util.Set;

public class Library {
    private Set<Book> books;
    private Set<Reader> readers;
    private Map<Reader, Set<Book>> mapOfOwnedBooks;
    private final double deposit = 3.3;

    public Library(Set<Book> books, Set<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void newBook(Set<Book> book) {

    }


}
