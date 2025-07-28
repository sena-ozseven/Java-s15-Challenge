package Library;
import Library.Books.Book;
import Library.People.Author;
import Library.People.Librarian;
import Library.People.Reader;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Set<Book> books;
    private Set<Reader> readers;
    private Map<Reader, Set<Book>> mapOfOwnedBooks;
    private final double deposit = 3.3;
    private Librarian librarian;

    public Library(Set<Book> books) {
        this.books = books;
        this.readers = new HashSet<>();
        this.mapOfOwnedBooks = new HashMap<>();
    }

    public Book getBooksById(int bookId){
        for(Book book : books){
            if(book.getBookID() == bookId){
                return book;
            }
        }
        System.out.println("no record under the book id: " + bookId);
        return null;
    }

    public Book getBooksByName(String bookName){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(bookName)){
                return book;
            }
        }
        System.out.println("no record under the book name: " + bookName);
        return null;
    }

    public Book getBooksFromReadersList(String bookName){
        for(Map.Entry<Reader, Set<Book>> books : mapOfOwnedBooks.entrySet()){
            for(Book ownedBook : books.getValue()){
                if(ownedBook.getName().equalsIgnoreCase(bookName)){
                    return ownedBook;
                }
            }
        }
        System.out.println(bookName + " is not found among the readers list.");
        return null;
    }

    public Set<Book> getBooksByAuthor(Author author){
        Set<Book> authorBooks = new HashSet<>();
        for(Book book : books){
            if(book.getAuthor().equals(author)){
                authorBooks.add(book);
            }
        }
        if(!authorBooks.isEmpty()){
            return authorBooks;
        }else {
            System.out.println("the book is not found by the given author name: " + author);
            return null;
        }
    }

    public Set<Book> getBooksByCategory(String category){
        Set<Book> categoryBooks = new HashSet<>();
        for(Book item : books){
            if(item.getCategory().equals(category)){
                categoryBooks.add(item);
            }
        }
        if(!categoryBooks.isEmpty()){
            return categoryBooks;
        }else {
            System.out.println("the book is not found by the given category name: " + category);
            return null;
        }
    }

    public Reader getReaderByBookName(String bookName){
        for(Map.Entry<Reader, Set<Book>> item : mapOfOwnedBooks.entrySet()){
            for(Book book : item.getValue()){
                if(book.getTitle().equalsIgnoreCase(bookName)){
                    return item.getKey();
                }
            }
        }
        System.out.println("the reader is not found by the given book name: " + bookName);
        return null;
    }

    public Reader getReaderByName(String name) {
        for (Reader reader : readers) {
            if(reader.getName().equalsIgnoreCase(name)) {
                return reader;
            }
        }
        System.out.println("no matches are found under the given name: " + name);
        return null;
    }

    public void newBook(Set<Book> book) {
        book.add((Book) book);
    }

    public void lendBook(Book book, Reader reader, LocalDate date) {
        librarian.issueBook(book, reader, date);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }
}
