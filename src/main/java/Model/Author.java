package Model;
import java.util.Objects;


public class Author {

    int id;
    String firstName;
    String lastName;

    public Author(){

    }

    public Author(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Author(int id, String firstName, String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(){
        this.firstName=firstName;
    }

    public void setLastName(){
        this.lastName=lastName;
    }

}
