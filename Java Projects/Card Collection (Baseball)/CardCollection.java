//Rahul Ranjan ID# 111448179
package programs;
import java.util.*;
import java.lang.*;

public class CardCollection  {      //This class makes an array of cards or a collection. It has different methods which allow the user to manipulate the array
                                    // and other methods which allow the user to determine if a card exists and to print all cards in a collection/array.

    BaseballCard[] cards;
    final int MAX_CARDS = 100;      
  
    public CardCollection() {
        cards = new BaseballCard[MAX_CARDS];       //We want position and index to be the same so we add one to Max_Cards.
    }
    
    public int size() {         //This method returns the number of cards in a collection. In order to prevent a spot in the collection where no card exists to be 
                                //counted, we use a simple if condition which checks if the card at a position is null or not null. If not null, we increment the counter.
    
        int counter = 0;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] != null) {
                counter++;
            }
        }
        return counter;
    }
    
    public void addCard(BaseballCard newCard, int position) throws IllegalArgumentException, Exception {       //This method allows the user to add a new card at a specific position. This method throws IllegalArgumentException
                                                                    // and FullCollectionException. The first exception preents any invalid input and the second one prevents the user from adding
                                                                    // cards when the size of the collection is passed the maximum.
    
        int poss = 0;
        if (this.size() <= 99) {
            if (position > 0 & position <= 100) {
                if (cards[position] != null) {
                    for (int i = position; i < cards.length; i++) {     //We use if and else conditions here to determine if a position inputed by the user leads to a null
                                                                    // in the collection. If there is a null, we simply just add the card at the position given. If there is not a null, 
                                                                    // we have to move each card in the position greater than or equal to the position given by one up.
                        if (cards[i] == null) {
                            poss = i;
                            break;
                        }
                    }
                    for (int i = poss; i > position; i--) {
                        cards[i] = cards[i-1];
                        cards[position] = newCard;
                    } 
                }
                else {
                    cards[position] = newCard;
                }
            }
            else {        //If position given is any value in the restrictino zone, the an IllegalARgumentException will be thrown. 
                throw new IllegalArgumentException("Position is not in range. ");
            }
        }
        else {
            throw new Exception("Card colletion is full. ");    //if size() is showing a counter value of greater than or equal to 100 cards, then throw card collection full exception.
        }
    }
    public void addCard(BaseballCard newCard) {     //This method adds a card to the end of the collection. So, we use Cards.length - 1 for the indices. Since this method
                                                    // involves us just using the method from above with the position being Cards.length - 1, we have to also catch the two exceptions
                                                    // being thrown in the above method.
        try {
            addCard(newCard, cards.length-1);
        }
        catch (Exception exp) {}
    }
    
    public void removeCard(int position) throws IllegalArgumentException{       //This method removes a card at a given position and throws IllegalArgumentException
                                                                                // when the position given is not in the valid range.
        if (position > 0 & position <= 100) {                                   // We start off by setting the card at the position given to null and then for every card above
                                                                                // the card that was set to null, the cards' positions will be subtracted by 1.
            cards[position] = null;
            for (int i = position; i < cards.length; i++) {
                cards[i] = cards[i+1];
                cards[i+1] = null;
            }
        }
        else {
            throw new IllegalArgumentException("Position is not in valid range. ");
        }
    }
    
    public BaseballCard getCard(int position) throws IllegalArgumentException {     //This method returns a card object given the position and throws an IllegalArgumentException as well.
   
        if (position > 0 & position <= 100) {
            return cards[position];
        }
        else {
            throw new IllegalArgumentException("Position is not in valid range. ");
        }
    }
    
    public void trade(CardCollection other, int myPosition, int theirPosition) throws IllegalArgumentException{        //This method trades cards at a given position from two different collections. It also throws the 
                                                                                        // IllegalArguementException if the positions are not in the valid range.
        if ((myPosition > 0 & myPosition <= 100) & (theirPosition > 0 & theirPosition <= 100)) {                                                                          
            BaseballCard temp = new BaseballCard();
            temp = cards[myPosition];                                       //We use a variable (Temp) here to store cards for a short period of time. This is done so cards do not
                                                                            // get removed or deleted by accident. We cannot simply just set arrays equal to one another.
            cards[myPosition] = other.cards[theirPosition];
            other.cards[theirPosition] = temp;
        }
        else {
            throw new IllegalArgumentException("Position is not in valid range. ");
        }
    }
    
    public boolean exists(BaseballCard card) {      //This method determines whether or not a baseball card exists at a given position. 
        for (int i = 0; i < cards.length; i++) {    //We use for loop to check each card in the collection.
            if (cards[i] == card) {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    public void printAllCards() {                  //This method prints all cards in the collection. However, it will not print out null or any position in the collection
                                                   // that has no card. So we do this by using if condition to check for null while looping through the collection.
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                System.out.print(i);
            }
            else {
            }
            System.out.println();
        }
    }
}
    

   
