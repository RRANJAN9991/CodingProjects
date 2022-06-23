package programs;

import java.util.*; 

public class LargerNum {
    public static void main(String [] args) {
        double x, y;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter first number. ");
        x = s.nextDouble();
        System.out.print("Enter second number. ");
        y = s.nextDouble();
        if (x > y) {
            System.out.print(x + " is larger number. ");
        }
        else if (x == y) {
            System.out.print("Both " + x + " and " + y + " are equal. ");
        }
        else {
            System.out.print(y + " is the larger number. ");
        }
    }
}
 