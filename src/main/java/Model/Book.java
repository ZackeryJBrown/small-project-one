package Model;

import java.util.Objects;


public class Book {


    int isbn;
    String title;
    int copies;

    int author_id;

    public Book(){

    }
    public Book(int isbn,int author_id,String title,int copies){

        this.isbn = isbn;
        this.author_id = author_id;
        this.title = title;
        this.copies= copies;

    }



    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", author_id=" + author_id +
                ", title=" + title +
                ", copies=" + copies +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isbn == book.isbn && copies == book.copies && author_id == book.author_id   && Objects.equals(title, book.title) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( isbn, title, copies, author_id);
    }
}
