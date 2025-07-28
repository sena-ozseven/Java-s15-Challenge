package Library.Books;

import Library.People.Author;
import Library.enums.Status;

import java.time.LocalDate;

public class StudyBooks extends Book{
    public StudyBooks(Author author, String name, int edition, LocalDate date_of_purchase, double price, String category) {
        super(author, name, edition, date_of_purchase, price, category);
    }

}
