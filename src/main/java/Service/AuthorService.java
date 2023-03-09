package Service;
import DAO.AuthorDAO;
import Model.Author;
import java.util.List;

public class AuthorService {

    private AuthorDAO authorDAO;

    public AuthorService(){
        authorDAO = new AuthorDAO();
    }

    public AuthorService(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }

    public List<Author> getAllAuthors() {

        return authorDAO.getAllAuthors();
    }

    public Author addAuthor(Author author) {

        return authorDAO.insertAuthor(author);
    }
}
