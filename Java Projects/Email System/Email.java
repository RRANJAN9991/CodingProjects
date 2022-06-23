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
* java.util.* was imported in order for this program to use the Gregorian Calendar object.
* java.io.* was imported in order for this class to implement Serializable.
*/

import java.util.*;
import java.io.*;

/**
* This class implements Serializable and creates an Email object.
* It contains setter and getter methods for all its attributes.
* @author ranja
*/

public class Email implements Serializable {
    
    /**
    * to is a String that represents the "to" part of an email.
    * cc is a String that represents the "cc" part of an email.
    * bcc is a String that represents the "bcc" part of an email.
    * subject is a String that represents the "subject" part of an email.
    * body is a String that represents the "body" part of an email.
    * timestamp is a GregorianCalendar object that represents the "date" of an email.
    */
    
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private GregorianCalendar timestamp;
    
    /**
    * Email() is a constructor that creates an Email object.
    * It has no parameters and does not initialize any of the class attributes.
    */
    
    public Email() {}
    
    /**
    * setTo(String to) is a method that sets the to of this Email object.
    * @param to 
    * A String that represents the "to" part of an email.
    * PostCondition : to gets set.
    */
    
    public void setTo(String to) {
        this.to = to;
    }
    
    /**
    * setCc(String cc) is a method that sets the cc of this Email object.
    * @param cc 
    * A String that represents the "cc" part of an email.
    * PostCondition : cc gets set.
    */
    
    public void setCc(String cc) {
        this.cc = cc;
    }
    
    /**
    * setBcc(String bcc) is a method that sets the bcc of this Email object.
    * @param bcc 
    * A String that represents the "bcc" part of an email.
    * PostCondition : bcc gets set.
    */
    
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
    
    /**
    * setSubject(String subject) is a method that sets the subject of this Email object.
    * @param subject 
    * A String that represents the "subject" part of an email.
    * PostCondition : subject gets set.
    */
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    /**
    * setBody(String body) is a method that sets the body of this Email object.
    * @param body 
    * A String that represents the "body" part of an email.
    * PostCondition : body gets set.
    */
    
    public void setBody(String body) {
        this.body = body;
    }
    
    /**
    * setTimeStamp(GregorianCalendar timestamp) is a method that sets the timestamp of this Email object.
    * @param timestamp
    * A GregorianCalednar object that represents the "timestamp" part of an email.
    * PostCondition : timestamp gets set.
    */
    
    public void setTimeStamp(GregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
    * getTo() is a method that gets the to of this Email object.
    * @return 
    * A String that represents the "to" part of an email.
    */
    
    public String getTo() {
        return to;
    }
    
    /**
    * getCc() is a method that gets the cc of this Email object.
    * @return 
    * A String that represents the "cc" part of an email.
    */
    
    public String getCc() {
        return cc;
    }
    
    /**
    * getBcc() is a method that gets the bcc of this Email object.
    * @return 
    * A String that represents the "bcc" part of an email.
    */
    
    public String getBcc() {
        return bcc;
    }
    
    /**
    * getSubject() is a method that gets the subject of this Email object.
    * @return 
    * A String that represents the "subject" part of an email.
    */
    
    public String getSubject() {
        return subject;
    }
    
    /**
    * getBody() is a method that gets the body of this Email object.
    * @return 
    * A String that represents the "body" part of an email.
    */
    
    public String getBody() {
        return body;
    }
    
    /**
    * getTimeStamp() is a method that gets the timestamp of this Email object.
    * @return 
    * A GregorianCalendar object that represents the "timestamp" part of an email.
    */
    
    public GregorianCalendar getTimeStamp() {
        return timestamp;
    }
}
