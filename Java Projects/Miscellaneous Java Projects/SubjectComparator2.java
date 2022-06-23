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
* java.util.* was imported in order for this class to implement Comparator.
* java.io.* was imported in order for this program to implement Serializable.
*/

import java.util.*;
import java.io.*;

/**
* This class implements Comparator and Serializable and contains a method that will compare
* two Email objects to determine which has a subject that has its letters come earlier in the alphabet.
*/

public class SubjectComparator2 implements Comparator, Serializable{
    
    /**
    * compare(Object a, Object b) is a method that compares two Email objects to determine 
    * which has a subject that has its letters come earlier in the alphabet.
    * @param a
    * An Object that will represent an Email object.
    * @param b
    * An Object that will represent an Email object.
    * @return 
    * An int that represents the result of this method.
    */
    
    public int compare(Object a, Object b) {
        Email e1 = (Email)a;
        Email e2 = (Email)b;
        return (e1.getSubject().compareTo(e2.getSubject()));
    }
}
