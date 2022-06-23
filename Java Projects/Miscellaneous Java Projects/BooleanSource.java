
package programs;

/**
* This class holds and creates a BooleanSource object which sets probability and determines if a request has arrived.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class BooleanSource {
    
    /**
    * probability is a double representing the probability that a request will arrive.
    */
    
    double probability;
    
    /**
    * BooleanSource(double probability) is a constructor that sets the probability. (That a request will arrive)
    * @param probability
    * A double that represents the probability. (That a request will arrive)
    * @throws IllegalArgumentException 
    * Indicates that the probability is less than 0.0 or greater than 1.0.
    * PreCondition : probability is greater than or equal to 0.0 or less than or equal to 1.0
    * PostCondition : the probability gets set.
    */
    
    public BooleanSource(double probability) throws IllegalArgumentException {
        if (probability < 0.0 || probability > 1.0) {
            throw new IllegalArgumentException("Probability must be greater than or equal to 0.0 or less than or equal to 1.0. ");
        }
        this.probability = probability;
    }
    
    /**
    * requestArrived() is a method that determines whether or not a request has arrived.
    * @return 
    * true if a random number generated between 0.0 and 1.0 is less than probability 
    * or false if a random number generated between 0.0 and 1.0 is greater than or equal to probability
    */
    
    public boolean requestArrived() {
        return (Math.random() < this.probability);
    }
}
