/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

import java.util.*;

public class PerformanceScheduler {

    public static void main(String [] arguements) {
        Scanner input = new Scanner(System.in);
        char ch = ' ';
        PerformanceList node = new PerformanceList();
        while (ch != 'Q') {
            System.out.println();
            System.out.println("A) Add to end");
            System.out.println("B) Move current node backward");
            System.out.println("C) Display current node");
            System.out.println("D) Display all nodes");
            System.out.println("F) Move current node foward");
            System.out.println("I) INsert after current node");
            System.out.println("J) Jump to position");
            System.out.println("R) Remove current node");
            System.out.println("Q) Exit");
            System.out.print("Choose an operation");
            ch = input.next().charAt(0);
            /* While the key Q is not inputted by the user, the while loop will keep printing the menu and will ask the user to choose an operation*/
            if (ch == 'A') {
                PerformanceNode node_A = new PerformanceNode();
                System.out.print("Enter name of performance:");
                String x = input.nextLine();
                x = input.nextLine();
                System.out.print("Enter name of lead performer");
                String y = input.nextLine();
                System.out.print("Enter the total participants");
                int z = input.nextInt();
                System.out.print("Enter the duration of the performance");
                double a = input.nextDouble();
                node_A.setPerformance(x);
                node_A.setPerformer(y);
                node_A.setParticipants(z);
                node_A.setDuration(a);
                node.addToEnd(node_A);
                System.out.print("New performance " + x + " is added to the end of the list.");
            }
            if (ch == 'B') {
                try {
                    boolean b = node.moveCursorBackward();
                    if (b == true) {
                        System.out.print("Cursor has been moved backwards");
                    }
                    else {
                        System.out.print("The current performance is the first on the list.");
                    }
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                }
            }
            if (ch == 'C') {
                System.out.print("Current Node:");
                node.displayCurrentPerformance();
            }
            if (ch == 'D') {
                System.out.print("Schedule:");
                if (node != null) {
                    System.out.print(node.toString());
                }
                else {
                    System.out.print("There are no performances on the list.");
                }
            }
            if (ch == 'F') {
                 try {
                    boolean s = node.moveCursorForward();
                    if (s == true) {
                        System.out.print("Cursor has been moved fowards");
                    }
                    else {
                        System.out.print("The current performance is the last on the list.");
                    }
                }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                }
            }
            if (ch == 'I') {
                PerformanceNode node_P = new PerformanceNode();
                System.out.print("Enter name of performance:");
                String x = input.nextLine();
                x = input.nextLine();
                System.out.print("Enter name of lead performer");
                String y = input.nextLine();
                System.out.print("Enter the total participants");
                int z = input.nextInt();
                System.out.print("Enter the duration of the performance");
                double a = input.nextDouble();
                node_P.setPerformance(x);
                node_P.setPerformer(y);
                node_P.setParticipants(z);
                node_P.setDuration(a);
                node.addAfterCurrent(node_P);
                System.out.print("New performance" + x + " is added after current performance.");
            }
            if (ch == 'J') {
                System.out.print("Enter the position");
                int x = input.nextInt();                
                boolean jmp = node.jumpToPosition(x);
                if (jmp== true) {
                    System.out.print("Current performance has been moved to position " + x);
                }
                else {
                    System.out.print("The position does not exist in the list. ");
                }
            }
            if (ch == 'R') {
                if (node.removeCurrentNode() == true) {
                    System.out.print("The current performance has been removed.");
                }
                else {
                    System.out.print("There are no performances on the list.");
                }
            }
        }
    }
}
/* The methods that threw an exception in the PerformanceList class will need a try and catch block in order to execute the method and check for an esception 
 and print an exception message if the exception for the specific method is caught.*/