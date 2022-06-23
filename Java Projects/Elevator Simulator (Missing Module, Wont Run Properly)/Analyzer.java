
package programs;

//import java.util.* is used to ask the user for input.

import java.util.*;

/**
* This class asks for input from the user to run the elevator simulation.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class Analyzer {
    
    /**
    * The static method below asks for input from the user to run an elevator simulation.
    * @param arguments
    * A String [] that contains all arguments for this method.
    */
    
    public static void main(String [] arguments) {
        Simulator sim = new Simulator();
        Scanner input = new Scanner(System.in);
        double probability = 0.0;
        int numFloors = 0;
        int numElevators = 0;
        int lengthSim = 0;
        System.out.println("Welcome to Elevator Simulator");
        
        int count = 0;
        while (true) {
            try {
                System.out.println("Enter the probability of arrival for Requests: ");
                probability = input.nextDouble();
                sim.setProbability(probability);
                break;
            }
            catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
        }
        
        while (true) {
            try {
                System.out.println("Enter the number of floors: ");
                numFloors = input.nextInt();
                sim.setNumFloors(numFloors);
                break;
            }
            catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
        }
        
        while (true) {
            try {
                System.out.println("Enter the number of elevators: ");
                numElevators = input.nextInt();
                sim.setNumElevators(numElevators);
                break;
            }
            catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
        }
        
        
        while (true) {
            try {
                System.out.println("Enter the length of the simulation (in time units): ");
                lengthSim = input.nextInt();
                sim.setLengthSim(lengthSim);
                break;
            }
            catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
        }
        sim.simulate(probability, numFloors, numElevators, lengthSim);
      
    }
}
