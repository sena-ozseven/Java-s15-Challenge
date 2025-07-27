package Library.Books;

import Library.People.Author;
import Library.enums.Status;

import java.time.LocalDate;

public class Journals extends Book{


    public Journals(int book_ID, Author author, String name, Status status, int edition, LocalDate date_of_purchase, double price, String category) {
        super(book_ID, author, name, status, edition, date_of_purchase, price, category);
    }

    @Override
    public void getAuthor() {


    }

    @Override
    public void changeOwner() {

    }

    @Override
    public void getOwner() {

    }

    @Override
    public void display() {

    }

    @Override
    public void updateStatus() {

    }

    //TOSTRING METHODU EKSİK --OVERRIDE EDİLMELİ (BOOK ABSTRACT CLASSINDA YOK SİMDİLİK)
}
