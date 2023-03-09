package DAO;

import Model.Author;
import Service.AuthorService;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    public List<Author> getAllAuthors(){
        Connection connection = ConnectionUtil.getConnection();
        List<Author> authors = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM author;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Author author = new Author(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
                authors.add(author);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return authors;
    }


    public Author insertAuthor(Author author){
        Connection connection = ConnectionUtil.getConnection();
        try {
//          Write SQL logic here. You should only be inserting with the name column, so that the database may
//          automatically generate a primary key.
            String sql = "INSERT INTO author (first_name, last_name) VALUES (?,?);" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());


            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_author_id = (int) pkeyResultSet.getLong(1);
                return new Author(generated_author_id, author.getFirstName(), author.getLastName());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
