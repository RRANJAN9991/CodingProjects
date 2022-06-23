/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

import java.util.*;
import big.data.*;
import java.io.*;

public class HashedLibrary implements Serializable {
    
    private Hashtable<String, Book> hash = new Hashtable<String, Book>();

    public HashedLibrary(){}     
    
    public Hashtable<String, Book> getHash()
    {
        return hash;
    }
    
    public void setHash(Hashtable<String, Book> hash) {
        this.hash = hash;
    }

    public void addBook(String title, String author, String publisher, String isbn) throws Exception {
        Set<String> keys = hash.keySet();
        boolean sameKey = false;
        for(String key: keys) {
            if (key.equals(isbn)) {
                sameKey = true;
                break;
            }
            else {
                sameKey = false;
            }
        }
        if (sameKey == true) {
            throw new Exception(isbn + ": Book already recorded.  ");
        }
        else {
            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setAuthor(author);
            newBook.setPublisher(publisher);
            newBook.setIsbn(isbn);
            hash.put(isbn, newBook);
            System.out.println(newBook.getIsbn() + ": " + newBook.getTitle() + " by " + newBook.getAuthor() + " successfully recorded. ");
        }
    }
    
    public void addAllBookInfo(String fileName) throws Exception{
           
        final String dir = System.getProperty("user.dir");
        String fullPath = dir;
        //System.out.println(fullPath);
       // String relPath = directory.getAbsolutePath() ;
        //relPath="C:\\Users\\ranja\\Documents\\NetBeansProjects\\Programs\\BooksInfo";

       // if (fileName.toUpperCase().equals("book_list3.txt".toUpperCase()))
        //    fullPath += "\\" + "book_list3";
        
        fullPath += "\\" + fileName;
        FileInputStream fis = new FileInputStream(fullPath); 
        InputStreamReader inStream = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(inStream);
        String line;
        while ((line = reader.readLine()) != null) {
            String xmlFileName = line.trim();
            if (xmlFileName.equals("")) {
                continue;
            }
            DataSource ds = DataSource.connect("http://www3.cs.stonybrook.edu/~cse214/hw/hw6/" + xmlFileName + ".xml").load();
            DataSourceIterator iter = ds.iterator();
            String title = ds.fetchString("title");
            String author = ds.fetchString("author");
            String publisher = ds.fetchString("publisher");
            String isbn = ds.fetchString("isbn");
            try {
                this.addBook(title, author, publisher, isbn);
            }
            catch (Exception exp) {
                System.out.println(exp.getMessage());
                continue;
            }
        }
    }
    
    public Book getBookByisbn(String isbn) {
        Set<String> keys = hash.keySet();
        Book bookGet = new Book();
        for(String key: keys){
            if (key.equals(isbn)) {
                return hash.get(key);
            }
            else {
                continue;
            }
        }
        return null;
    }
    
    public void printCatalog() {
        Set<String> keys = hash.keySet();
        for(String key: keys){
            System.out.println(hash.get(key).toStringBook());
        }
    }
}
