package Library.People;
import Library.enums.Status;
//librarian da bir person degil midirr?  - extends people, Book dersek

import Library.Books.Book;

import java.time.LocalDate;
import java.util.Set;

public class Librarian{
    private String name;
    private String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean searchBook(Set<Book> books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                System.out.println(targetTitle + " is found.");
                return true;
            }
        }
        return false;
    }

    public boolean verifyMember(Person reader, String targetMember) {
        if (!reader.getName().equalsIgnoreCase(targetMember)) {
            System.out.println(targetMember + "is not a member.");
            return false;
        } else {
            System.out.println(targetMember + "is a member.");
            return true;
        }
    }

    public void issueBook(Book book, Person borrower, LocalDate date) {
        if (searchBook(Set < book >, book.getTitle())) {
            if (verifyMember(borrower, borrower.getName())) {
                if (book.getStatus() == Status.AVAILABLE) {
                    book.changeOwner();
                    book.updateStatus();
                    book.setDate_of_purchase(date);

                }
            }
        }
    }


}
