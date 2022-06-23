
package programs;

import java.util.*;

/**
* This class holds a single ItemList object.
* This class acts a operations tester. (This class will take input from the user and alter the ItemList object based of these inputs)
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class DepartmentStore {
    
    public static void main(String [] arguments) {
        Scanner input = new Scanner(System.in);
        ItemList list = new ItemList();
        char selection = ' ';
        while (selection != 'Q') {
            System.out.println("I (Insert an item into the list)");
            System.out.println("M (Move an item in the store)");
            System.out.println("L (List by location)");
            System.out.println("P (Print all items in store)");
            System.out.println("O (Checkout)");
            System.out.println("C (Clean store)");
            System.out.println("U (Update inventory system)");
            System.out.println("R (Print by RFID tag number)");
            System.out.println("Q (Exit the program.)");
            System.out.println("Enter a capital letter representing the action of choice. ");
            selection = input.next().charAt(0);
            if (selection == 'I') {
                String rfid = " ";
                System.out.println("Enter the name: ");
                String productName = input.nextLine();
                productName = input.nextLine();
                System.out.println("Enter the RFID: ");
                rfid = input.nextLine();
                System.out.println("Enter the oringal location: ");
                String originalLocation = input.nextLine();
                System.out.println("Enter the price: ");
                double price = input.nextDouble();
                list.insertInfo(productName, rfid, price, originalLocation);
            }
            if (selection == 'M') {
                System.out.println("Enter the RFID: ");
                String rfid = input.nextLine();
                rfid = input.nextLine();
                System.out.println("Enter the original location: ");
                String originalLocation = input.nextLine();
                System.out.println("Enter the new location: ");
                String newLocation = input.nextLine();
                list.moveItem(rfid, originalLocation, newLocation);
            }
            if (selection == 'L') {
                System.out.println("Enter the location: ");
                String productLocation = input.nextLine();
                productLocation = input.nextLine();
                list.printByLocation(productLocation);
            }
            if (selection == 'P') {
                list.printAll();
            }
            
            if (selection == 'O') {
                System.out.println("Enter the cart number: ");
                String cartNumber = input.nextLine();
                cartNumber = input.nextLine();
                double productPrice = list.checkOut(cartNumber);
                System.out.println("The total coust for all merchandise in cart " + cartNumber + " was " + productPrice);
            }
            if (selection == 'C') {
                list.cleanStore();
                
            }
            if (selection == 'U') {
                list.removeAllPurchased();
            }
            if (selection == 'R') {
                System.out.println("Enter the RFID: ");
                String rfid = input.nextLine();
                rfid = input.nextLine();
                list.printByRfid(rfid);
            }
        }
        System.out.println("Program terminating gracefully. ");
    }
}
