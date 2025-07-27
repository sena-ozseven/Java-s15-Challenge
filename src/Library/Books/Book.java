package Library.Books;
import Library.People.Author;
import Library.enums.Status;

// Author classını import etmediğim için kızmıyor?


public abstract class Book {
    private int book_ID;
    private Author author;
    private String name;
    private Status status;
    private int edition;
    private String date_of_purchase;

    public abstract void get_title();
    public abstract void get_author();
    public abstract void change_owner();
    public abstract void get_owner();
    public abstract void display();
    public abstract void update_status();

}
