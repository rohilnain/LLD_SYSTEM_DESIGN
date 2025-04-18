package Questions;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LMS {
    Location location;
    String Name;
    List<Customer> customerList;
    List<Librarian> librarianList;
    List<Book>bookList;

    void RegistarCustomer(Customer customer){
        //will be handled by service class
    }
    void registarLibrarian(Librarian librarian){
        //will be handled by service class
    }
    void senNotifications(){
        //will be handled by service class
        //can utilise observer pattern for sending notifcation
    }
    Boolean ReadingBarcode(){
        //will be handled by service class
    }
}
class Location{
    int pin;//zip code
    String city;
    String state;
    String country;
}

class Book{
    String barCode;
    UUID bookId;
    RackNumber rackNumber;
    Date publicationDate;
    List<BookItem>bookItems;
    List<Author>authorList;
    BookCategory bookCategory;
    BookSubject bookSubject;
}
class RackNumber{
    int floor;
    String section;
    int bookFloorSectionSerialNumber;
}
class BookItem{
    Integer bookNumber;
    String pressName;
    Boolean isAuthorSigned;
    Integer copyNumber;
}
enum BookCategory{
    FICTION,NON_FICTION
}
enum BookSubject{
    SCIENCE,HiSTORY,GEOGRAPHY,ROMANCE,PHILOSOPHY
}
class Person{
    String name;
    String phone;
    String Email;
}
class Author extends Person{
    String authorPenName;
    List<Book> books;
}

class Member extends Person{
    String userName;
    String password;
    Integer MemberId;
}
class Customer extends Member{
    SearchBook searchBookObj;
    List<Book>wishList;
    List<BookIssued>bookIssuedList;
    void addUnavailableBookToWishlist(Book){

    }
    List<Book>SearchBooks(String Title, Author author, BookSubject bookSubject, BookCategory bookCategory, Date publicationDate){
        //we will utilise search book obj for this
    }
}
class BookIssued{
    Date bookIssuedDate;
    BookItem bookItem;
}
class Librarian{
    SearchBook searchBookObj;
    String barCode;
    void addBook(Book book){

    }
    void editBook(Book book){

    }
    void deleteBook(Book book){

    }
    List<Book>searchBooks(){
        //will utilise search Book Obj for this
    }
    BookIssued CheckoutBook(Book book){
        //checking if book Item present or not and then issuing it
    }
}

class SearchBook{
    List<Book>SearchBooks(String Title, Author author, BookSubject bookSubject, BookCategory bookCategory, Date publicationDate){
        //we will utilise search book obj for this
    }
}
