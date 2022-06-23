//Rahul Ranjan ID# - 111448179
package programs;

import java.util.*;
import java.io.*;

public class SigmaAirDriver {
    public static void main(String[] arguements) throws Exception{
        Scanner input = new Scanner(System.in);
        String selection = "";
        SigmaAir sigmaAir = new SigmaAir();
        while (!(selection.equals("Q"))) {
            System.out.println("(A) Add City");
            System.out.println("(B) Add Connection");
            System.out.println("(C) Load all Cities");
            System.out.println("(D) Load all Connections");
            System.out.println("(E) Print all Cities");
            System.out.println("(F) Print all Connections");
            System.out.println("(G) Remove Connection");
            System.out.println("(H) Find Shortest Path");
            System.out.println("(Q) Quit");
            System.out.println();
            System.out.print("Enter a selection, ");
            selection = input.next();
            if (selection.equals("A")) {
                System.out.print("Enter the name of the city. ");
                String cityName = input.nextLine();
                cityName = input.nextLine();
                sigmaAir.addCity(cityName);
            }
            else if (selection.equals("B")) {
                System.out.print("Enter the source city: ");
                String sourceCity = input.nextLine();
                sourceCity = input.nextLine();
                System.out.print("Enter the destination city: ");
                String destCity = input.nextLine();
                sigmaAir.addConnection(sourceCity, destCity);
            }
            else if (selection.equals("C")) {
                System.out.print("Enter the file name. ");
                String fileName = input.next();
                sigmaAir.loadAllCities(fileName);
            }
            else if (selection.equals("D")) {
                System.out.print("Enter the file name. ");
                String fileName = input.next();
                sigmaAir.loadAllConnections(fileName);
            }
            else if (selection.equals("E")) {
                String selectionTwo = "";
                while (!(selectionTwo.equals("Q"))) {
                    System.out.println("(EA) Sort Cities by Name");
                    System.out.println("(EB) Sort Cities by Latitude");
                    System.out.println("(EC) Sort Cities by Longitude");
                    System.out.println("(Q) Quit");
                    System.out.print("enter a selection: ");
                    selectionTwo = input.next();
                    if (selectionTwo.equals("EA")) {
                        sigmaAir.printAllCities(selectionTwo);
                    }
                    else if (selectionTwo.equals("EB")) {
                        sigmaAir.printAllCities(selectionTwo);
                    }
                    else if (selectionTwo.equals("EC")) {
                        sigmaAir.printAllCities(selectionTwo);
                    }
                }
            }
            else if (selection.equals("F")) {
                ArrayList<String> cities = sigmaAir.getCities();
                for (int i = 0; i < cities.size(); i++) {
                    int comma = cities.get(i).indexOf(",");
                    String cityFrom = cities.get(i).substring(0, comma);
                    String cityTo = cities.get(i).substring(comma + 1, cities.get(i).length());
                    sigmaAir.printAllConnections(cityFrom, cityTo);
                }
            }
            else if (selection.equals("G")) {
                System.out.print("Enter the source city: ");
                String sourceCity = input.nextLine();
                sourceCity = input.nextLine();
                System.out.print("Enter the destination city: ");
                String destCity = input.nextLine();
                sigmaAir.removeConnection(sourceCity, destCity);
                
            }
                
                    
        }
        System.out.println("Program terminating gracefully. ");
        }
}
