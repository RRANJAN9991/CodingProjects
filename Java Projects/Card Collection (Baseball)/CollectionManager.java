//Rahul Ranjan ID# 111448179

package programs;

import java.time.*;

import java.util.*;
    
public class CollectionManager {

    public static void main(String [] arguements) {
        char Ch = ' ';
        CardCollection A = new CardCollection();        //Two collections have been set. (Empty collections)
        CardCollection B = new CardCollection();
        while (Ch != 'Q') {
            System.out.println("Main Menu");    //While Q is not inputted, this menu will keep on outputting to the user.
            System.out.println();
            System.out.println("A) Add Card");
            System.out.println("C) Copy");
            System.out.println("E) Update Price");
            System.out.println("G) Get Card");
            System.out.println("L) Locate Card");
            System.out.println("N) Update Name");
            System.out.println("P) Print All Cards");
            System.out.println("R) REmove Card");
            System.out.println("S) Size");
            System.out.println("T) Trade");
            System.out.println("Q) Quit");
            System.out.print(LocalDateTime.now().getHour() * 60);
            System.out.print(LocalDateTime.now().getMinute());
            Scanner input = new Scanner(System.in);
            System.out.print("Select an operaton: ");
            Ch = input.next().charAt(0);
            if (Ch == 'A') {                                    //All if conditions on this level of indentation are used to check for which operation letter is inputted. 
                BaseballCard C = new BaseballCard();
                System.out.print("Enter name (Put a / between first and last name): ");     //I tried using input.nextLine() but when I ran the program, it would say 
                                                                                            // Enter name Enter Manufacturer. There is no space to enter input for Enter name
                                                                                            //. So I switched to input.next() in order to make the program output Enter name then on the 
                                                                                            // next line output Enter manufacturer after the user inputs name. the consequence of this 
                                                                                            // was that if there is a space between words (first and last name) then the program would
                                                                                            // output Enter manufacturerer and Enter Price on the same line leaving the user no space to enter
                                                                                            // manufacturer. So just enter a / sign between words (First and Last Name) for input.
                String s = input.next();
                C.setName(s);
                System.out.print("Enter manufacturer (Put a / between words): ");
                String st = input.next();
                C.setManufacturer(st);
                System.out.print("Enter year: ");
                double d = input.nextDouble();
                C.setYear(d);
                System.out.print("Enter x component for size: ");
                double ag = input.nextDouble();
                System.out.print("Enter y component for size: ");
                double al = input.nextDouble();
                C.setSize_X(ag);
                C.setSize_Y(al);
                C.setImageSize();
                System.out.print("Enter price: ");
                double dou = input.nextDouble();        //Since there is an exception being thrown for the setPrice method in class BaseballCard, we will have to use throw and
                                                        // catch here in order to catch the exception if price is negative.
                try {
                    C.setPrice(dou);
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                    continue;
                }
                System.out.print("Enter collection: ");
                Ch = input.next().charAt(0);
                if (Ch == 'A') {
                    System.out.print("Enter the position: ");
                    int i = input.nextInt();
                    try{
                        A.addCard(C, i);
                        System.out.print("Added all attributes. ");
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                        continue;
                    }
                }
                if (Ch == 'B') {
                    System.out.print("Enter the position: ");
                    int y = input.nextInt();
                    try {
                        B.addCard(C, y);
                        System.out.print("Added all attributes. ");
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                        continue;
                    }
                }
            }
            if (Ch == 'C') {
                System.out.print("Enter the collection to copy from: ");
                char t = input.next().charAt(0);
                if (t == 'A') {
                    BaseballCard dr = new BaseballCard();
                    System.out.print("Enter the position of the card to copy from: ");
                    int gh = input.nextInt();
                    System.out.print("Enter the collection to copy to: ");
                    char gf = input.next().charAt(0);                           //The getCard and addCard methods throws IllegalArguementException and clone method throws CloneNotSupportedException
                                                                                // so since we are using all these methods here, we must use try and catch to catch any exceptions from the other classes' methods.
                    if (gf == 'A') {                                            //This occurs for any other try and catch blocks down the line.
                        try {
                            dr = A.getCard(gh).clone();
                            A.addCard(A.getCard(gh));
                        }
                        catch (Exception exp) {
                            System.out.print(exp.getMessage());
                            continue;
                        }
                    }
                    else {
                        try {
                            dr = A.getCard(gh).clone();
                            B.addCard(A.getCard(gh));
                        }
                        catch (Exception exp) {
                            System.out.print(exp.getMessage());
                            continue;
                        }
                    }
                }
                if (t == 'B') {
                    BaseballCard D = new BaseballCard();
                    System.out.print("Enter the position of the card to copy from: ");
                    int uy = input.nextInt();
                    System.out.print("Enter the collection to copy to: ");
                    char tr = input.next().charAt(0);
                    if (tr == 'A') {
                        try {
                            D = B.getCard(uy).clone();
                            A.addCard(B.getCard(uy));
                        }
                        catch (Exception exp) {
                                System.out.print(exp.getMessage());
                        continue;
                        }
                    }
                    else {
                        try {
                            D = B.getCard(uy).clone();
                            B.addCard(B.getCard(uy));
                        }
                        catch (Exception exp) {
                                System.out.print(exp.getMessage());
                        continue;
                        }
                    }
                }
            }
            if (Ch == 'E') {
                System.out.print("Enter the collection: ");
                char x = input.next().charAt(0);
                if (x == 'A') {
                    System.out.print("Enter the position of the card that needs price updated: ");
                    int g = input.nextInt();
                    BaseballCard W = A.getCard(g);
                    System.out.print("Enter price: ");
                    double y = input.nextDouble();
                    try {
                        W.setPrice(y);
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                        continue;
                    }
                }
                if (x == 'B') {
                    System.out.print("Enter the position of the card that needs price updated: ");
                    int p = input.nextInt();
                    try{
                        BaseballCard W = B.getCard(p);
                        System.out.print("Enter price: ");
                        double y = input.nextDouble();
                        try {
                            W.setPrice(y);
                        }
                        catch (Exception exp) {
                            System.out.print(exp.getMessage());
                            continue;
                        }
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                        continue;
                    }
                }
            }
            if (Ch == 'G') {
                System.out.print("Enter the collection: ");
                char Cha = input.next().charAt(0);
                if (Cha == 'A') {
                    System.out.print("Enter the position: ");
                    int pos = input.nextInt();
                    try{
                        BaseballCard S = A.getCard(pos);
                        if (S == null) {
                            System.out.print("No card in this position. ");
                        }
                        else {
                            System.out.print(Integer.toString(pos) + S.toString());
                        }
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                        continue;
                    }
                }
                if (Cha == 'B') {
                    System.out.print("Enter the position: ");
                    int pos = input.nextInt();
                    try {
                        BaseballCard S = B.getCard(pos);
                        if (S == null) {
                            System.out.print("NULL");
                        }
                        else {
                            System.out.print(Integer.toString(pos) + S.toString());
                        }
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                        continue;
                    }
                }
            }
            if (Ch == 'L') {
                BaseballCard k = new BaseballCard();
                System.out.print("Enter name: ");
                String sr = input.next();
                k.setName(sr);
                System.out.print("Enter manufacturer: ");
                String str = input.next();
                k.setManufacturer(str);
                System.out.print("Enter year: ");
                double x = input.nextDouble();
                k.setYear(x);
                System.out.print("Enter x component for size: ");
                double ag = input.nextDouble();
                System.out.print("Enter y component for size: ");
                double al = input.nextDouble();
                k.setSize_X(ag);
                k.setSize_Y(al);
                k.setImageSize();
                System.out.print("Enter price: ");
                double doub = input.nextDouble();
                try {
                    k.setPrice(doub);
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                    continue;
                }
                for (int i = 1; i < A.cards.length; i++) {
                    if(A.cards[i] != null) {
                        if (k.equals(A.cards[i])) {
                            System.out.print("The card is in Collection A. ");
                            break;
                        }
                        else {
                            System.out.print("The card is not in Collection A." );
                        }
                    }
                }
                for (int i = 1; i < B.cards.length; i++) {
                    if(B.cards[i] != null){
                        if (B.cards[i].equals(k)) {
                            System.out.print("The card is in Collection B.");
                            break;
                        }
                        else {
                            System.out.print("The card is not in Collection B.");
                        }
                    }
                }
            }
            if (Ch == 'N') {
                System.out.print("Enter the collection: ");
                char sto = input.next().charAt(0);
                if (sto == 'A') {
                    System.out.print("Enter the position of the card that needs name updated: ");
                    int x = input.nextInt();
                    BaseballCard W = A.getCard(x);
                    System.out.print("Enter name: ");
                    String y = input.next();
                    W.setName(y);
                }
                if (sto == 'B') {
                    System.out.print("Enter the position of the card that needs name updated: ");
                    int z = input.nextInt();
                    BaseballCard E = B.getCard(z);
                    System.out.print("Enter name: ");
                    String o = input.next();
                    E.setName(o);
                }
            }
            if (Ch == 'P') {
                for (int i = 0; i < A.cards.length; i++) {
                    if (A.cards[i] != null) {
                        BaseballCard Q = A.cards[i];
                        System.out.println("Collection A: ");
                        System.out.println("# " + i + "       " + Q.toString());
                    }
                }
                for (int i = 0; i < B.cards.length; i++) {
                    if (B.cards[i] != null) {
                        BaseballCard Q = B.cards[i];
                        System.out.println("Collection B: ");
                        System.out.println("# " + i + "       " + Q.toString());
                    }
                }
            }
            if (Ch == 'R') {
                System.out.print("Enter the card collection to remove from: ");
                char w = input.next().charAt(0);
                System.out.print("Enter position to remove: ");
                int g = input.nextInt();
                if (w == 'A') {
                    try{
                        A.removeCard(g);
                    }
                    catch (Exception exp) {
                            System.out.print(exp.getMessage());
                            continue;
                    }
                }
                if (w == 'B') {
                    try{
                        B.removeCard(g);
                    }
                    catch (Exception exp) {
                        System.out.print(exp.getMessage());
                        continue;
                    }
                }
            }
            if (Ch == 'S') {
                System.out.print("Collection A has: " + A.size() + " cards " + " and " + "Collection B has: " + B.size() + " cards. ");
            }
            if (Ch == 'T') {
                System.out.print("Enter the position of the card to trade from collection A: ");
                int J = input.nextInt();
                System.out.print("Enter the position of the card to trade from collection B: ");
                int L = input.nextInt();
                try{
                    A.trade(B, J, L);
                    System.out.print("The trade has been completed. ");
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                    continue;
                }
            }
            if (Ch == 'V') {
                for (int i = 0; i < A.cards.length; i++) {
                    if (A.cards[i] != null) {
                        double total = 0.00;
                        BaseballCard X = A.cards[i];
                        total = total + X.getPrice();
                    }
                    else {
                    }
                }
                for (int i = 0; i < B.cards.length; i++) {
                    if (B.cards[i] != null) {
                        double total = 0.00;
                        BaseballCard X = B.cards[i];
                        total = total + X.getPrice();
                    }
                    else {
                    }
                }
            
            }
            
        }
    }
}
