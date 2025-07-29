import Library.Books.Book;
import Library.Books.Journals;
import Library.Books.Magazines;
import Library.Library;
import Library.People.Author;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Journals(new Author("ucubik"), "journal", 3, LocalDate.of(2020, 2, 3), 3.3, "journal");
        Book book2 = new Magazines(new Author("ucubik3"), "mag", 3, LocalDate.of(2023, 3, 3), 3.3, "magazines");

        Set<Book> bookset = new HashSet<>();
        bookset.add(book2);
        bookset.add(book1);

        Library library = new Library(bookset);
        library.libraryConsoleSystem();
    }
}