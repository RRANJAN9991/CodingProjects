package programs;

import java.util.*;

public class EvenOdd {
    public static void main(String [] args) {
        int x;
        String z = "Hello Guy";
        System.out.print(z.indexOf("q"));
        int [] array = new int [3];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = count;
            count++;
        }
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number :");
        System.out.print((int)(Math.random()*10));
        x = s.nextInt();
        if (x % 2 == 0) {
            System.out.print(x + " is an even number. ");
        }
        else {
            System.out.print(x + " is an odd number. ");
        }
    }
    
}
