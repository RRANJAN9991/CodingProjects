/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

import java.util.*;

public class Stackotaire {
    int dCardCnt=52;
    CardStack [] tab = new CardStack[7];
    CardStack [] fou = new CardStack[4];
    CardStack was = new CardStack('w');
    CardStack stk = new CardStack('s');
    int capactiy = 10;
    CardStack deck = new CardStack('d');
    final int suit = 4;
    final int value = 13;
    public Stackotaire() {    
        for (int i = 1; i <= suit; i++) {
            for (int j = 1; j <= value; j++) {
                Card card = new Card();
                card.setSuit(i);
                card.setValue(j);
                card.setFaceUp(false);
                try {
                    deck.push(card);
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                }
            }
        }
        for (int count=0; count < dCardCnt; count++) {
            int r = count + (int)(Math.random() * (dCardCnt - count));
            Card crd = deck.data[r];
            deck.data[r] = deck.data[count];
            deck.data[count] = crd;
        }
        
        
       /* for (int count=0; count < dCardCnt; count++) {
            Card card = new Card();
            card.setSuit((count / 13) +1);
            card.setValue((count % 13)+1);
            card.setFaceUp(false);
            try {
                deck.push(card);
            }
            catch (Exception exp) {
                System.out.print(exp.getMessage());
            }
        }
        for (int i = 1; i <= suit; i++) {
            System.out.println();
            for (int j = 1; j <= value; j++) {
            System.out.print(deck.peek().getValueV() + deck.peek().getSuitV());
            deck.pop();
            }
        }*/
    }
    public void shuffleDeck() {
        
        Card card;
        for (int i = tab.length-1; i >= 0; i--) {
            tab[i] = new CardStack('t');
            for (int j = 0; j <= i; j++) {
                try {
                   
                    if (dCardCnt > 0) {
                        card = deck.pop(); 
                        // System.out.println(card.getValue());
                        //System.out.print(card);
                        dCardCnt -= 1;
                        if (j == i) {
                            card.setFaceUp(true);
                        }
                        tab[i].push(card);
                       // tab[i - 1].printStack('t');
                    }
                }
                catch (Exception exp) {
                    System.out.print(i + " " + j + " "+ exp.getMessage());
                }
            }
        }
        for (int i = 0; i < fou.length; i++) {
            fou[i] = new CardStack('f');
        }
        for (int i = 0; i < dCardCnt; i++) {
            try {
                stk.push(deck.pop());
            }
            catch (Exception exp) {
                System.out.print(exp.getMessage());
            }
        }
    }
    public void displayGameBoard() {
        
         /*  System.out.println("test = " + stk.top + " --" + deck.top);
            for (int j = 0; j < 23; j++) {
            
            Card c = stk.pop();
            System.out.println(j + " --" + c.getValue() + c.getSuit());
        */

              
        //System.out.println(dCardCnt);
        fou[0].printStack('f',1);
        fou[1].printStack('f',2);
        fou[2].printStack('f',3);
        fou[3].printStack('f',4);
        was.printStack('w',0);
        stk.printStack('s',0);
        System.out.print(dCardCnt);
        //System.out.println("[F1][F2][F3][F4]     W1 [  ]    [XX] " + dCardCnt);
        System.out.println();
        System.out.print("T7 " );
        tab[6].printStack('t',0);
        System.out.println();
        System.out.print("T6 " );
        tab[5].printStack('t',0);
        System.out.println();
        System.out.print("T5 " );
        tab[4].printStack('t',0);
        System.out.println();
        System.out.print("T4 " );
        tab[3].printStack('t',0);
        System.out.println();
        System.out.print("T3 " );
        tab[2].printStack('t',0);
        System.out.println();
        System.out.print("T2 " );
        tab[1].printStack('t',0);
        System.out.println();
        System.out.print("T1 " );
        tab[0].printStack('t',0);
        System.out.println();
    }  
    
    public void checkWinningBoard() {
        boolean y = true;
        
        //if (x==false)
           // return;
        for (int i = tab.length-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (tab[i].data[j].isFaceUp() == true) {
                }
                else {
                    y = false;
                    break ;
                }
            }
        }
        
        if (y != false) {
            System.out.println("You have won");
        }
    }
    public static void main(String [] arguements) {
        String str = "";
        int counter = 0;
        Stackotaire s = new Stackotaire();
        s.shuffleDeck();
        
         //Stackotaire g;
        while (!(str.equals("quit"))) {           
            s.displayGameBoard();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a command: ");
            str = input.nextLine();    
            if (str.equals("quit")) {
                System.out.print("You lose");
                break;
            }
            else if (str.equals("draw")) {
                Card tmpcard;
                try {
                    tmpcard = s.stk.pop();
                    s.dCardCnt -=1;
                    tmpcard.setFaceUp(true);
                    s.was.push(tmpcard);                    
                }
                catch (Exception exp) {
                    System.out.print("test" + exp.getMessage());
                }
               // s.was.data[counter].setFaceUp(true);
               // counter = counter + 1;
            }
           //System.out.print("1");
            else if (str.charAt(3) == 'e' && str.charAt(4) == ' ') {   
              
                if (str.charAt(5) == 'W') {
                   
                    if (str.charAt(8) == 'T') {
                        int x = Character.getNumericValue(str.charAt(9));
                        try {
                            s.tab[x-1].push(s.was.pop());
                        }
                        catch (Exception exp) {
                            System.out.print(exp.getMessage());
                        }
                    }
                    if (str.charAt(8) == 'F') {
                        int x = Character.getNumericValue(str.charAt(9));
                        try {
                            s.fou[x-1].push(s.was.pop());
                        }
                        catch (Exception exp) {
                            System.out.print(exp.getMessage());
                        }
                    }
                }
                if (str.charAt(5) == 'F') {
                    int y = Character.getNumericValue(str.charAt(6));
                    int z = Character.getNumericValue(str.charAt(9));
                    try {
                        s.tab[z-1].push(s.fou[y-1].pop());
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                    }
                }
                if (str.charAt(5) == 'T') {
                    int t = Character.getNumericValue(str.charAt(6));
                    int u = Character.getNumericValue(str.charAt(9));
                    try {
                        if (s.tab[t-1].peek().isFaceUp() == true && s.tab[t-1].top != -1) {
                            s.fou[u-1].push(s.tab[t-1].pop());
                            if (s.tab[t-1].top != -1) {
                                if (s.tab[t-1].peek().isFaceUp() == false) {
                                    s.tab[t-1].peek().setFaceUp(true);
                                }
                            }
                        }
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                    }
                }
            }
            else if (str.charAt(4) == 'N') {
                int a = Character.getNumericValue(str.charAt(7));
                int b = Character.getNumericValue(str.charAt(10));
                int c = Character.getNumericValue(str.charAt(12));
                for (int i = 0; i < c; i++) {
                    try {
                        if (s.tab[a-1].top != -1) {
                            if (s.tab[a-1].peek().isFaceUp() == false) {
                                s.tab[a-1].peek().setFaceUp(true);
                            }
                            s.tab[b-1].push(s.tab[a-1].pop());
                        }
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                    }
                }
            }
            else if (str.equals("restart")) {
                
                System.out.print("Would you like to start a new game?");
                String e = input.nextLine();
                if (e.equals("yes")) {
                    counter = 0;
                    
                   // s=null;
                   // s.tab[1]=null;
                   // s.tab[2]=null;
                   // s.deck=null;
                    //s.suit=null;
                   
                    s = new Stackotaire();
                   
                    s.shuffleDeck();
                   // s.displayGameBoard();
                }
                else {
                    continue;
                }
            }
            s.checkWinningBoard();
            
        }
        
        
    }
}        
        
          
         
    
    

