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
* java.util.* was imported in order for this class to use GregorainCalendar timestamp and implement Comparator.
* java.io.* was imported in order for this program to implement Serializable.
*/

import java.util.*;
import java.io.*;

/**
* This class implements Comparator and Serializable and contains a method that will compare
* two Email objects to determine which came before the other.
*/

public class DateComparator implements Comparator, Serializable{
    
    /**
    * compare(Object o1, Object o2) is a method that compares two Email objects to determine which came before the other.
    * @param o1
    * An Object that will represent an Email object.
    * @param o2
    * An Object that will represent an Email object.
    * @return 
    * An int that will represent the result for this method.
    */
    
    public int compare(Object o1, Object o2) {
        Email e1 = (Email) o1;
            Email e2 = (Email) o2;
            if (e1.getTimeStamp().getTime() == e2.getTimeStamp().getTime()) {
                return 0;
            }
            else if (e1.getTimeStamp().getTime().before(e2.getTimeStamp().getTime())) {
                return 1;
            }
            else {
                return -1;
            }
    }
}

