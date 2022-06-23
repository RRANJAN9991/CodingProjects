/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

public class Card {
    
    int suit, value;
    boolean isFaceUp;
    String values[] = {" ","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    char suits[]    = {' ', '\u2666', '\u2663','\u2665', '\u2660'};  

    public Card(){
    }
    
    public int getSuit() {
        return suit;
    }
    public char getSuitV() {
        return suits[this.getSuit()];
    }
    
    public void setSuit(int suit) {
        this.suit = suit;
    }
    
    public int getValue() {
        return value;
    }
    
      public String getValueV() {
        return values[this.getValue()];
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public boolean isFaceUp() {
        return isFaceUp;
    }
    
    public void setFaceUp(boolean isFaceUp) {
        this.isFaceUp = isFaceUp;
    }
    
    public boolean isRed() {
        if (value % 2 == 0) {
            return true;
        }
        return false;
    }
    
    public String toString1() {
        return "[" + values[value] + suits[suit] + "]";
    }
}
    

