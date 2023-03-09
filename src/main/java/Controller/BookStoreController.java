package Controller;

import Model.Author;
import Model.Book;
import Service.AuthorService;
import Service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
public class BookStoreController {
    BookService bookService;
    AuthorService authorService;

    public BookStoreController(){
        this.bookService = new BookService();
        this.authorService = new AuthorService();
    }



    public void startAPI(){
        Javalin app = Javalin.create();

        app.get("/books", this::getAllBooksHandler);
        app.post("/books", this::postBookHandler);
        app.get("/authors", this::getAllAuthorsHandler);
        app.post("/authors", this::postAuthorHandler);
        app.get("/books/available", this::getAvailableBooksHandler);

        app.get("/{title}/purchase", this::purchaseBookHandler);

        app.start(8080);
    }


    private void postAuthorHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Author author = mapper.readValue(ctx.body(), Author.class);
        Author addedAuthor = authorService.addAuthor(author);
        if(addedAuthor!=null){
            ctx.json(mapper.writeValueAsString(addedAuthor));
        }else{
            ctx.status(400);
        }
    }

    private void getAllAuthorsHandler(Context ctx) {
        List<Author> authors = authorService.getAllAuthors();
        ctx.json(authors);
    }

    private void postBookHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(ctx.body(), Book.class);
        Book addedBook = bookService.addBook(book);
        if(addedBook!=null){
            ctx.json(mapper.writeValueAsString(addedBook));
        }else{
            ctx.status(400);
        }
    }

    public void getAllBooksHandler(Context ctx){
        List<Book> books = bookService.getAllBooks();
        ctx.json(books);
    }

    private void getAvailableBooksHandler(Context context) {
        context.json(bookService.getAllAvailableBooks());
    }

    private void purchaseBookHandler(Context ctx) throws JsonProcessingException{
        //TODO write purchasing handler
        context.json(bookService.purchaseBook());
    }

}
