/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

import java.io.*;

public class Book implements Serializable{

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    
    public Book() {}
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String toStringBook() {
        return "Isbn  -  " + isbn + "   :           Title  -  " + title + "         Author  -  " + author + "         Publisher  -  " + publisher + " ";
    }
}
       
