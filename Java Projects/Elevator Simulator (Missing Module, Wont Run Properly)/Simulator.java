
package programs;

/**
* This class holds and creates a Simulator object which has setter and getter methods for its attributes 
* and a simulate method.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class Simulator {
    
    /**
    * requests is a RequestQueue object that represents a queue of requests.
    * probability is a double that represents the probability. (That a request has arrived)
    * numFloors is an int that represents the number of floors of a building.
    * numElevators is an int that represents the number of elevators of a building.
    * lengthSim is an int that represents the number of minutes a simulation will last.
    */
    
    RequestQueue requests;
    double probability;
    int numFloors;
    int numElevators;
    int lengthSim;
    
    /**
    * Simulator() is a constructor that creates a Simulator object. 
    * This constructor initializes requests. (Request object)
    */
    
    public Simulator() {
        requests = new RequestQueue();
    }
    
    /**
    * setProbability(double probability) sets the probability. (That a request has arrived)
    * @param probability
    * A double that represents the probability. (That a request has arrived)
    * @throws IllegalArgumentException 
    * Indicates that probability is less than 0.0 or greater than 1.0.
    * PreCondition : probability is greater than or equal to 0.0 or less than or equal to 1.0.
    * PostCondition  probability gets set.
    */
    
    public void setProbability(double probability) throws IllegalArgumentException {
        if (probability < 0.0 || probability > 1.0) {
            throw new IllegalArgumentException("Probability is not in range. ");
        }
        this.probability = probability;
    }
    
    /**
    * setNumFloors(int numFloors) sets the number of floors.
    * @param numFloors
    * An int that represents the number of floors of a building.
    * @throws IllegalArgumentException 
    * Indicates that numFloors is less than 2.
    * PreCondition : numFloors is greater than or equal to 2.
    * PostCondition  numFloors gets set.
    */
    
    public void setNumFloors(int numFloors) throws IllegalArgumentException {
        if (numFloors < 2) {
            throw new IllegalArgumentException("Number of floors is not in range. ");
        }
        this.numFloors = numFloors;
    }
    
    /**
    * setNumElevators(int numElevators) sets the number of elevators.
    * @param numElevators
    * An int that represents the number of elevators in a building.
    * @throws IllegalArgumentException 
    * Indicates that numElevators is less than 1.
    * PreCondition : numElevators is greater than or equal to 1.
    * PostCondition  numElevators gets set.
    */
    
    public void setNumElevators(int numElevators) throws IllegalArgumentException {
        if (numElevators < 1) {
            throw new IllegalArgumentException("Number of elevators is not in range. ");
        }
        this.numElevators = numElevators;
    }
    
    /**
    * setLengthSim(int lengthSim) is a method that sets the length of the simulation. 
    * @param lengthSim
    * An int that represents the length of the simulation. 
    * @throws IllegalArgumentException 
    * Indicates that lengthSim is less than 1.
    * PreCondition : lengthSim is greater than or equal to 1.
    * PostCondition : lengthSim gets set.
    */
    
    public void setLengthSim(int lengthSim) throws IllegalArgumentException {
        if (lengthSim < 1) {
            throw new IllegalArgumentException("Length of simulation is not in range. ");
        }
        this.lengthSim = lengthSim ;
    }
    
    /**
    * simulate(double probability) is a method that simulates using probability, number of floors, number of elevators, and length of simulation.
    * @param probability
    * A double that represents the probability that a request will arrive.
    * @param numFloors
    * An int that represents the number of floors in a building.
    * @param numElevators
    * An int that represents the number of elevators in a building.
    * @param lengthSim
    * An int that reprsents the length of the simulation.
    * PostCondition : The total wait time total number of requests, and the average wait time is printed at the end of the simulation.
    * 
    */
    
    public void simulate(double probability, int numFloors, int numElevators, int lengthSim) {
       
        BooleanSource source = new BooleanSource(probability);
        Elevator elevators [] = new Elevator [numElevators];
        int length = 1;
        double totalWaitTime = 0;
        int totalRequests = 0;
        double averageWaitTime = 0.0;
        for (int i = 0; i < elevators.length; i++) {
            elevators[i] = new Elevator();
        }
        while (length <= lengthSim) {
            Boolean arrived = source.requestArrived();
            if (arrived == true) {
                Request request = new Request(numFloors);
                totalRequests++;
                request.setTimeEntered(length);
                requests.enqueue(request);
                boolean full = true;
                int position = 0;
                for (int i = 0; i < elevators.length; i++) {
                    if (elevators[i].getElevatorState() == elevators[i].IDLE) {
                        full = false;
                        position = i;
                        break;
                    }
                }
                if (full == false) {
                    elevators[position].setRequest(request);
                    if (elevators[position].getCurrentFloor() != request.getSourceFloor()) {
                        elevators[position].setElevatorState(elevators[position].TO_SOURCE);
                    }
                    else {
                        elevators[position].setElevatorState(elevators[position].TO_DESTINATION);
                    }
                    requests.dequeue();
                }
            }        
            
            for (int i = 0; i < elevators.length; i++) {
                if (elevators[i].getElevatorState() == elevators[i].TO_SOURCE) {
                    if (elevators[i].getCurrentFloor() < elevators[i].getRequest().getSourceFloor()) {
                        elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() + 1);
                    }
                    else if (elevators[i].getCurrentFloor() < elevators[i].getRequest().getSourceFloor()) {
                        elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() - 1);
                    }
                    else {
                        totalWaitTime = totalWaitTime + (length - elevators[i].getRequest().getTimeEntered());
                        elevators[i].setElevatorState(elevators[i].TO_DESTINATION);
                    }
                }
                else if (elevators[i].getElevatorState() == elevators[i].TO_DESTINATION) {
                    if (elevators[i].getCurrentFloor() < elevators[i].getRequest().getDestinationFloor()) {
                        elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() + 1);
                    }
                    else if (elevators[i].getCurrentFloor() > elevators[i].getRequest().getDestinationFloor()) {
                        elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() - 1);
                    }
                    else {
                        elevators[i].setElevatorState(elevators[i].IDLE);
                        if (requests.isEmpty() == false) {
                            elevators[i].setRequest(requests.dequeue());
                        }
                    }
                }
            }
            
            length++;
        }
        System.out.println("Total Wait Time: " + totalWaitTime);
        System.out.println("Total Requests: " + totalRequests);
        averageWaitTime = Math.round(totalWaitTime / totalRequests * 100.0) / 100.0;
        System.out.println("Average Wait Time " + averageWaitTime);
    }
}
            
            
  
