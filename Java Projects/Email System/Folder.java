/**
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
*/

/**
* A package containing all homework programs for CSE 214.
*/

package programs;

/**
* java.util.* was imported in order for this program to use ArrayLists.
* java.io.* was imported in order for this class to implement Serializable.
*/

import java.util.*;
import java.io.*;

/**
* This class implements Serializable and has methods to 
* manipulate the attributes in this class. 
*/

public class Folder implements Serializable {
    
    /**
    * emails is an ArrayList<Email> object that contains and represents all the emails in this folder.
    * name is a String that represents the name of this folder.
    * currentSortingMethod is a String that represents the current sorting method of this folder.
    */
    
    private ArrayList<Email> emails; 
    private String name;
    private String currentSortingMethod;
    
    /**
    * Folder() is a constructor that creates a Folder object.
    * It has no parameters but it does initialize the ArrayList<Email> named emails.
    */
    
    public Folder() {
        emails = new ArrayList<Email>();
    }
    
    /**
    * setEmails(ArrayList<Email> emails) is a method that sets emails.
    * @param emails 
    * An ArrayList<Email> object that represents all the emails in this folder.
    * PostCondition : emails gets set.
    */
    
    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
    
    /**
    * setFolderName(String name) is a method that sets name. 
    * @param name 
    * A String that represents the name of this folder.
    * PostCondition : name gets set.
    */
    
    public void setFolderName(String name) {
        this.name = name;
    }
    
    /**
    * setCurrentSortingMethod(String currentSortingMethod) is a method that sets currentSortingMethod.
    * @param currentSortingMethod 
    * A String that represents the current sorting method of this folder.
    * PostConditition : currentSortingMethod gets set.
    */
    
    public void setCurrentSortingMethod(String currentSortingMethod) {
        this.currentSortingMethod = currentSortingMethod;
    }
    
    /**
    * getEmails() is a method that gets emails.
    * @return 
    * An ArrayList<Email> object that represents all the emails in this folder.
    */
    
    public ArrayList<Email> getEmails() {
        return emails;
    }
    
    /**
    * getFolderName() is a method that gets name.
    * @return 
    * A String that represents the name of this folder.
    */
    
    public String getFolderName() {
        return name;
    }
    
    /**
    * getCurrentSortingMethod() is a method that gets currentSortingMethod.
    * @return 
    * A String that represents the current sorting method of this folder.
    */
    
    public String getCurrentSortingMethod() {
        return currentSortingMethod;
    }
    
    /**
    * addEmail(Email email) is a method that adds an Email object to ArrayList<Email> named emails.
    * @param email
    * An Email object that represents an email.
    * PostCondition : email gets added to this folder.
    */
    
    public void addEmail(Email email) {
        if (emails.isEmpty()) {
            emails.add(email);
        }
        else {
            emails.add(email);
            Collections.sort(emails, new DateComparator());
        }
    }
    
    /**
    * removeEmail(int index) is a method that removes an email from ArrayList<Email> based of the index given.
    * @param index
    * An int that represents the index of the Email object to remove from ArrayList<Email>.
    * @return
    * An Email object that has been removed from the given index.
    * @throws Exception 
    * Indicates that the index is either less than 0 or greater than or equal to the size of ArrayList<Email> emails.
    * PreCondition : the index given is greater than or equal to 0 and is less than the size of ArrayList<Email> emails.
    */
    
    public Email removeEmail(int index) throws Exception {
        if (index < 0 || index >= emails.size()) {
            throw new Exception("Index is out of range. ");
        }
        Email emailRemoved = new Email();
        for (int i = 0; i < emails.size(); i++) {
            if (i == index) {
                emailRemoved = emails.remove(index);
                break;
            }
        }
        return emailRemoved;
    }
    
    /**
    * sortBySubjectAscending() is a method that sorts ArrayList<Email> emails by subject ascending order.
    * PostCondition : ArrayList<Email> emails gets sorted by subject ascending order.
    */
    
    public void sortBySubjectAscending() {
        Collections.sort(emails, new SubjectComparator2());
    }
    
    /**
    * sortBySubjectDescending() is a method that sorts ArrayList<Email> emails by subject descending order.
    * PostCondition : ArrayList<Email> emails gets sorted by subject descending order.
    */
    
    public void sortBySubjectDescending() {
        Collections.sort(emails, new SubjectComparator());
    }
    
    /**
    * sortByDateAscending() is a method that sorts ArrayList<Email> emails by date ascending order.
    * PostCondition : ArrayList<Email> emails gets sorted by date ascending order.
    */
    
    public void sortByDateAscending() {
        Collections.sort(emails, new DateComparator2());
    }
    
    /**
    * sortByDateDescending() is a method that sorts ArrayList<Email> emails by date descending order.
    * PostCondition : ArrayList<Email> emails gets sorted by date descending order.
    */
    
    public void sortByDateDescending() {
        Collections.sort(emails, new DateComparator());
    }
}
