
package programs;

// import java.util.* is used to extend the LinkedList class in order to implement RequestQueue. (queue)
import java.util.*;

/**
* This class holds and creates a RequestQueue object which contains Requests objects.
* This class also extends LinkedList to implement a queue.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class RequestQueue extends LinkedList{
    
    /**
    * RequestQueue() is a constructor that creates a RequestQueue object. (No parameters or initializations)
    */
    
    public RequestQueue(){}
    
    /**
    * isEmpty() is a method that checks if a queue is empty and returns true or false.
    * @return 
    * true if the size of the queue is 0 or false if the size of the queue is greater than 0. (boolean)
    */
    
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }
    
    /**
    * size() is a method that determines the size of the queue and returns the size (int) of the queue.
    * @return 
    * An int that represents the size of the queue.
    */
    
    public int size() {
        return super.size();
    }
    
    /**
    * enqueue(Request request) is a method that adds a request to the end of the queue. (Request object)
    * @param request 
    * A Request object that represents a request.
    * PostCondition : A Request object gets added to the queue.
    */

    public void enqueue(Request request){
        add(request);
    }
    
    /**
    * dequeue() is a method that removes a request from the beginning of the queue. (Request object)
    * @return 
    * A request object that represents a request.
    */
    
    public Request dequeue(){
       return (Request) remove();
    }
}
