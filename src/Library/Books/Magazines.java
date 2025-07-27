package Library.Books;

import Library.People.Author;
import Library.enums.Status;

import java.time.LocalDate;

public class Magazines extends Book{
    public Magazines(int bookID, Author author, String name, Status status, int edition, LocalDate date_of_purchase, double price, String category) {
        super(bookID, author, name, status, edition, date_of_purchase, price, category);
    }

    @Override
    public void changeOwner() {

    }

    @Override
    public void display() {

    }
}
