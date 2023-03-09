package DAO;

import Model.Book;
import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> getAllBooks(){
        Connection connection = ConnectionSingleton.getConnection();
        List<Book> books = new ArrayList<>();
        try {

            String sql = "Select * from book";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies"));
                books.add(book);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }


    public Book getBookByIsbn(int isbn){
        Connection connection = ConnectionSingleton.getConnection();
        try {

            String sql = "Select * from book where isbn=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setInt(1,isbn);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies"));
                return book;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public Book insertBook(Book book){
        Connection connection = ConnectionSingleton.getConnection();
        try {

            String sql = "Insert into book( isbn,author_id,title,copies) values (?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,book.getIsbn());
            preparedStatement.setInt(2,book.getAuthor_id());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setInt(4,book.getCopies());




            preparedStatement.executeUpdate();
            return book;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Book> getBooksWithBookCountOverZero(){
        Connection connection = ConnectionSingleton.getConnection();
        List<Book> books = new ArrayList<>();
        try {

            String sql = "Select * from book where copies >0";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);



            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies"));
                books.add(book);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }
}