package Library;
import Library.Books.Book;
import Library.Books.Journals;
import Library.Books.Magazines;
import Library.Books.StudyBooks;
import Library.People.Author;
import Library.People.Librarian;
import Library.People.Reader;
import Library.enums.Status;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private Set<Book> books;
    private Set<Reader> readers;
    private Map<Reader, Set<Book>> mapOfOwnedBooks;
    private Librarian librarian;
    private final double DEPOSIT = 3.3;

    public Library(Set<Book> books) {
        this.books = books;
        this.readers = new HashSet<>();
        this.mapOfOwnedBooks = new HashMap<>();
        librarian = new Librarian(books, "UCUBIK THE LIBRARIAN", "UCUBIK3333", readers);
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
        } else {
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
    //SHOUT OUT TO CETIN
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

    public void newBook(Book book) {
        books.add(book);
    }

    public void lendBook(Book book, Reader reader) {
        if (book == null) {
            System.out.println("no records under this book.");
            return;
        }
        if (!readers.contains(reader)) {
            readers.add(reader);
        }

        mapOfOwnedBooks.putIfAbsent(reader, new HashSet<>());

        if (mapOfOwnedBooks.get(reader).size() == 5) {
            System.out.println("you can borrow max of 5 books");
            return;
        }

        if (reader.getBalance() < DEPOSIT) {
            System.out.println("insufficient balance. should be 3.3 or higher");
            return;
        }

        if (book.getStatus().equals(Status.AVAILABLE)) {
            mapOfOwnedBooks.get(reader).add(book);
            double v = reader.getBalance() - DEPOSIT;
            reader.setBalance(v);
            book.updateStatus(Status.CHECKED_OUT);
            System.out.println(book.getName() + " has been lend to " + reader.getName());
        } else if(book.getStatus().equals(Status.CHECKED_OUT)){
            System.out.println("this book has already been checked out.");
        }
    }

    public void returnBooktoLibrary(Reader reader, Book book){
        mapOfOwnedBooks.get(reader).remove(book);

        double v = reader.getBalance() + DEPOSIT;
        reader.setBalance(v);
        book.updateStatus(Status.AVAILABLE);
        System.out.println(book.getName() + " has been returned to the library");
    }

    public void deleteBook(Book book){
        books.remove(book);
        System.out.println(book.getName() + " has been deleted successfully");
    }

    public void showBook(){
        Set<String> bookNames = new HashSet<>();
        for(Book book : books){
            bookNames.add(book.getName());
        }
        System.out.println(bookNames);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    Scanner scanner = new Scanner(System.in);
    public int getIntInput(){
        int input;
        while(true){
            try{
                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e){
                System.out.println("please pick a number 0 to 7");
                scanner.nextLine();
            }
        }
    }
    public void libraryConsoleSystem() {
        while (true) {
            System.out.println("please choose what you want to do: press...");
            System.out.println("0 -> stop the application");
            System.out.println("1 -> lend book");
            System.out.println("2 -> return book");
            System.out.println("3 -> show books on the library");
            System.out.println("4 -> search books");
            System.out.println("5 -> add-delete books");
            System.out.println("6 -> update book information");
            System.out.println("7 -> show matches of reader-book");
            int choosenNumber = getIntInput();
            switch (choosenNumber) {
                case 1:
                    System.out.println("Enter the member's name: ");
                    String reader = scanner.nextLine();

                    if (getReaderByName(reader) != null) {
                        System.out.println("Enter the book's name: ");
                        String book = scanner.nextLine();
                        lendBook(getBooksByName(book), getReaderByName(reader));
                    } else {
                        System.out.println("Enter the book's name: ");
                        String book = scanner.nextLine();
                        System.out.println("enter member's balance: ");
                        String balance = scanner.nextLine();
                        double balanceDouble = Double.parseDouble(balance);
                        lendBook(getBooksByName(book), new Reader(reader, balanceDouble));
                    }
                    break;

                case 2:
                    System.out.println("enter the name of the book you want to return: ");
                    String bookName = scanner.nextLine();
                    Reader reader2 = getReaderByBookName(bookName);
                    Book book2 = getBooksByName(bookName);
                    if (book2 == null || reader2 == null) {
                        System.out.println(bookName + " is already on the library");
                        break;
                    }
                    returnBooktoLibrary(reader2, book2);
                    break;

                case 3:
                    showBook();
                    break;

                case 4:
                    System.out.println("search books by...");
                    System.out.println("1 -> name");
                    System.out.println("2 -> id");
                    System.out.println("3 -> author");
                    System.out.println("4 -> category");
                    int num = getIntInput();

                    switch (num) {
                        case 1:
                            System.out.println("enter the name of the book you want to search: ");
                            String nameOftheBook = scanner.nextLine();
                            System.out.println(getBooksByName(nameOftheBook));
                            break;

                        case 2:
                            System.out.println("enter the id of the book you want to search: ");
                            int idOfTheBook = scanner.nextInt();
                            System.out.println(getBooksById(idOfTheBook));
                            break;

                        case 3:
                            System.out.println("enter the author's name of the book you want to search: ");
                            String authorName = scanner.nextLine();
                            Author author1 = new Author(authorName);
                            System.out.println(getBooksByAuthor(author1));
                            break;

                        case 4:
                            System.out.println("enter the category of the book you want to search: ");
                            System.out.println("journals, magazines, study books");
                            String category = scanner.nextLine();
                            System.out.println(getBooksByCategory(category));
                            break;

                        default:
                            System.out.println("invalid choice");

                    }
                    break;
                case 5:
                    System.out.println("choose: ");
                    System.out.println("1 -> add book");
                    System.out.println("2 -> delete book");
                    int number5 = getIntInput();

                    switch (number5) {
                        case 1:
                            System.out.println("enter the NAME of the book: ");
                            String bookname5 = scanner.nextLine();

                            System.out.println("enter the AUTHOR of the book: ");
                            String authorName5 = scanner.nextLine();
                            Author authorname5aut = new Author(authorName5);

                            System.out.println("enter the EDITION of the book: ");
                            int edition5 = getIntInput();

                            System.out.println("enter the PRICE of the book: ");
                            String price5 = scanner.nextLine();
                            double price5double = Double.parseDouble(price5);
                            System.out.println("enter the category of the book: ");
                            System.out.println("you can choose: journals, magazines, study books");
                            String category5 = scanner.nextLine();

                            switch (category5) {
                                case "journals":
                                    Book journal5 = new Journals(authorname5aut, bookname5, edition5, LocalDate.now(), price5double, category5);
                                    newBook(journal5);
                                    System.out.println(journal5 + "has been added to the library");
                                    break;
                                case "magazines":
                                    Book magazines5 = new Magazines(authorname5aut, bookname5, edition5, LocalDate.now(), price5double, category5);
                                    newBook(magazines5);
                                    System.out.println(magazines5 + "has been added to the library");
                                    break;
                                case "study books":
                                    Book studyBooks5 = new StudyBooks(authorname5aut, bookname5, edition5, LocalDate.now(), price5double, category5);
                                    newBook(studyBooks5);
                                    System.out.println(studyBooks5 + "has been added to the library");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("enter the NAME of book you want to delete");
                            showBook();
                            String deleteName = scanner.nextLine();
                            deleteBook(getBooksByName(deleteName));
                            break;
                        default:
                            System.out.println("please enter a valid number");

                    }
                    break;

                case 6:
                    System.out.println("choose the book you want to update: ");
                    showBook();
                    String bookname6 = scanner.nextLine();
                    Book bookToBeChanged = getBooksByName(bookname6);

                    System.out.println("choose what you want to update: ");
                    System.out.println("1 -> name of the book");
                    System.out.println("2 -> author of the book");
                    System.out.println("3 -> edition");
                    System.out.println("4 -> price");
                    int theChoice = getIntInput();

                    switch (theChoice) {
                        case 1:
                            System.out.println("enter the NAME you want to replace with the previous one");
                            String changeName = scanner.nextLine();
                            bookToBeChanged.setName(changeName);
                            System.out.println("name has been changed to " + changeName);
                            break;
                        case 2:
                            System.out.println("enter the AUTHOR you want to replace with the previous one");
                            String changeAuthor = scanner.nextLine();
                            Author changeAuthor1 = new Author(changeAuthor);
                            bookToBeChanged.setAuthor(changeAuthor1);
                            break;
                        case 3:
                            System.out.println("enter the EDITION you want to replace with the previous one");
                            int changeEdition = getIntInput();
                            bookToBeChanged.setBookID(changeEdition);
                            break;
                        case 4:
                            System.out.println("enter the PRICE you want to replace with the previous one");
                            String changePrice = scanner.nextLine();
                            double changePriceDouble = Double.parseDouble(changePrice);
                            bookToBeChanged.setPrice(changePriceDouble);
                            System.out.println("the price has been change to " + changePrice);
                            break;
                    }
                    break;

                case 7:
                    System.out.println(mapOfOwnedBooks);
                    break;

                case 0:
                    System.out.println("stopping the application...");
                    return;

                default:
                    System.out.println("invalid choice");
                    break;
            }
        }
    }
}
