
package programs;

/**
* This class holds and creates a Request object which contains three attributes of this object 
* and set and get methods for these attributes..
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class Request {
    
    /**
    * sourceFloor is an int representing the floor where a request originated from.
    * destinationFloor is an int representing the floor where a passenger needs to be dropped off.
    * timeEntered is an int representing the time a request is entered in the queue.
    */
    
    int sourceFloor;
    int destinationFloor;
    int timeEntered;
    
    /**
    * Request(int numFloors) is a constructor that creates a Request object. This constructor takes numFloors
    * as its parameter which is used to generate a range of floors.
    * Then, two int values are chosen at random in this range and are set as the source and destination floor respectively.
    * @param numFloors 
    * An int representing the number of floors in a building.
    */
    
    public Request(int numFloors) {
        sourceFloor = (int)(Math.random() * numFloors) + 1;
        destinationFloor = (int)(Math.random() * numFloors) + 1;
    }
    
    /**
    * setSourceFloor(int sourceFloor) is a method that sets the source floor of a request.
    * @param sourceFloor 
    * An int that represents the floor where a request originated from.
    * PostCondition : sourceFloor gets set.
    */
    
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }
    
    /**
    * getSourceFloor() is a method that gets the source floor of a request.
    * @return 
    * An int that represents the floor where a request originated from.
    */
    
    public int getSourceFloor() {
        return sourceFloor;
    }
    
    /**
    * setDestinationFloor(int destinationFloor) is a method that sets the destination floor of a request.
    * @param destinationFloor 
    * An int that represents the floor where a passenger wants to be dropped off.
    * PostCondition : destinationFloor gets set.
    */
    
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
    
    /**
    * getDestinationFloor() is a method that gets the destination floor of a request.
    * @return 
    * An int that represents the floor where a passenger wants to be dropped off.
    */
    
    public int getDestinationFloor() {
        return destinationFloor;
    }
    
    /**
    * setTimeEntered(int timeEntered) is a method that sets the time entered of a request into the queue.
    * @param timeEntered 
    * An int that represents the time entered of a request into the queue.
    * PostCondition : timeEntered gets set.
    */
    
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
    
    /**
    * getTimeEntered() is a method that gets the time entered of a request into the queue.
    * @return 
    * An int that represents the time entered of a request into the queue.
    */
    
    public int getTimeEntered() {
        return timeEntered;
    }
}
