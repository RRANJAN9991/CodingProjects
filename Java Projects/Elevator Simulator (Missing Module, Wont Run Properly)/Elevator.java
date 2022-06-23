
package programs;

/**
* This class holds and creates an Elevator object which has setter and getter methods for its attributes.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class Elevator {
    
    /**
    * currentFloor is an int that represents the current floor of an elevator.
    * elevatorState is an int that represents the state that an elevator is in.
    * IDLE is a final int that represents elevators that are idle.
    * TO_SOURCE is a final int that represents elevators that are moving to the source floor of a request.
    * TO_DESTINATION is a final int that represents elevators that are moving to the destination floor of a request.
    * request is a Request object that represents a request for a single elevator.
    */
    
    int currentFloor;
    int elevatorState;
    final int IDLE = 1;
    final int TO_SOURCE = 2;
    final int TO_DESTINATION = 3;
    Request request;
    
    /**
    * Elevator() is a constructor that creates an Elevator object.
    * This constructor contains no parameters but it initializes request to null, elevatorState to IDLE, and currentFloor to 1.
    */
    
    public Elevator() {
        request = null;
        elevatorState = IDLE;
        currentFloor = 1;
    }
    
    /**
    * setRequest(Request request) sets the request for a single elevator.
    * @param request 
    * A Request object that represents the request for a single elevator.
    * PostCondition : request gets set.
    */
    
    public void setRequest(Request request) {
        this.request = request;
    }
    
    /**
    * getRequest() gets the request for a single elevator.
    * @return 
    * A Request object that represents the request for a single elevator.
    */
    
    public Request getRequest() {
        return request;
    }
    
    /**
    * setCurrentFloor(int currentFloor) sets the current floor for a single elevator.
    * @param currentFloor 
    * An int that represents the current floor for a single elevator.
    * PostCondition : currentFloor gets set.
    */
    
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    
    /**
    * getCurrentFloor() gets the current floor for a single elevator.
    * @return 
    * An int that represents the current floor for a single elevator.
    */
    
    public int getCurrentFloor() {
        return currentFloor;
    }
    
    /**
    * setElevatorState(int elevatorState) sets the elevator state for a single elevator.
    * @param elevatorState 
    * An int that represents the state an elevator is.
    * PostCondition : elevatorState gets set.
    */
    
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }
    
    /**
    * getElevatorState() gets the elevator state for a single elevator.
    * @return 
    * An int that represents the elevator state for a single elevator.
    */
    
    public int getElevatorState() {
        return elevatorState;
    }

}
