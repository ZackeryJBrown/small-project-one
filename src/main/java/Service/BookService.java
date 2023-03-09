package Service;

import DAO.BookDAO;
import Model.Book;

import java.util.List;

public class BookService {
    public BookDAO bookDAO;

    public BookService(){
        bookDAO= new BookDAO();
    }
    public BookService(BookDAO bookDAO){
        this.bookDAO=bookDAO;
    }

    //Retrieve all books
     public List<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }

    public Book addBook(Book book) {
        int isbn= book.getIsbn();


        if((bookDAO.getBookByIsbn(isbn))!=null)
            return null;
        else
            return bookDAO.insertBook(book);

    }

    public List<Book> getAllAvailableBooks() {
        return bookDAO.getBooksWithBookCountOverZero();
    }
}
