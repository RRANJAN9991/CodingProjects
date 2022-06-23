/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

import java.util.*;
import java.io.*;

public class DatabaseDriver {
    
  //  static HashedLibrary myHashedLibrary;
   // HashedLibrary myHashLibObject;
    public static void saveHashTable(Hashtable hashtable) {
        try {
            FileOutputStream file = new FileOutputStream("myHashedLibrary.obj");
            ObjectOutputStream fout = new ObjectOutputStream(file);
           // Hashtable<String, Book> hashtable = new Hashtable<String, Book>();
           // hashtable = myLibrary.getHash();
            fout.writeObject(hashtable); 
            file.close();
            fout.close();
        } 
        catch (IOException exp){
            System.out.println(exp.toString());
        }
    }
    
    public static Hashtable retrieveHashTable() throws Exception{
        Hashtable<String, Book> hash = new Hashtable<String, Book>();
        try {
            
            FileInputStream file = new FileInputStream("myHashedLibrary.obj");
            ObjectInputStream fin  = new ObjectInputStream(file);
            hash = (Hashtable) fin.readObject(); //readObject() returns Object, so must typecast to HashedLibrary
            System.out.println("Successfully loaded contents of sigma_air. ");
            file.close();
            fin.close();
        } 
        catch(IOException exp){
            System.out.println(exp.getMessage() + " Using a new HashedLibrary. ");
        }
        return hash;
    }
    
    public static void main(String [] arguements) {
        
        HashedLibrary hash = new HashedLibrary();
        try {
            Hashtable<String, Book> hashtable = new Hashtable<String, Book>();
            hashtable = retrieveHashTable();
            hash.setHash(hashtable);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
       
        Scanner input = new Scanner(System.in);
        char selection = ' ';
        while (selection != 'Q') {
            System.out.println("Menu:");
            System.out.println("(D) Displays Books");
            System.out.println("(G) Get Book");
            System.out.println("(L) Load File");
            System.out.println("(R) Record Book");
            System.out.println("(Q) Quit");
            System.out.print("Enter a selection. ");
            selection = input.next().charAt(0);
            if (selection == 'D') {
                hash.printCatalog();
            }
            else if (selection == 'G') {
                System.out.print("Enter the isbn of the book you want to get. ");
                String isbn = input.next();
                Book getBook = new Book();
                getBook = hash.getBookByisbn(isbn);
                System.out.println(getBook.toStringBook());
            }
            else if (selection == 'L') {
                System.out.print("Enter a text file with xml file names on seperate lines. ");
                String textFile = input.next();
                try {                    
                    hash.addAllBookInfo(textFile);
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                }
            }
            else if (selection == 'R') {
                System.out.print("Enter the title: ");
                String title = input.nextLine();
                title = input.nextLine();
                System.out.print("Enter the author: ");
                String author = input.nextLine();
                System.out.print("Enter the publisher: ");
                String publisher = input.nextLine();
                System.out.print("Enter the isbn: ");
                String isbn = input.nextLine();
                try {
                    hash.addBook(title, author, publisher, isbn);
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                }
            }
            System.out.println();
        }
        saveHashTable(hash.getHash());
        System.out.println("HashedLibrary is saved into file library.obj. ");
        System.out.print("Program terminating gracefully. ");
    }
}
