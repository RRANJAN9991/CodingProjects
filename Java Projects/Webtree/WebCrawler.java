//Rahul Ranjan ID# - 111448179
package programs;

import java.util.*;

public class WebCrawler {

    
    public static void main(String [] arguements) {
        Scanner input = new Scanner(System.in);
        char selection = ' ';
        WebTree webtree = new WebTree();
        System.out.println("[L] : Load HTML file");
        System.out.println("[P] : Print tree");
        System.out.println("[D] : Print dead links");
        System.out.println("[S] : Search for a page with a title within the tree");
        System.out.println("[R] : Reset tree structure");
        System.out.println("[Q] : Quit");
        while (selection != 'Q') {
            System.out.print("Enter a selection: ");
            selection = input.next().charAt(0); 
          
            if (selection == 'P') {
                try {
                    webtree.PrintTree();
                    }
                catch (Exception exp) {
                    System.out.print(exp.getMessage());
                }
            }
            else if (selection == 'L') {
                System.out.print("Enter a HTML file: ");
                String file = input.next();                    
                webtree.setTotalLink(file.substring(0, file.toUpperCase().indexOf(".HTML")));
                webtree.CreateRootNode();
                try {
                    webtree.crawlHTML(file);
                    System.out.println("Active Links: " + webtree.getActiveLink()); 
                    System.out.println("Circular Links: " + webtree.getCrossLink()); 
                    System.out.println("Dead Links    : " + webtree.getDeadLink());
                    System.out.println("Total Links   : " + webtree.getTotalLink());                   
                }
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
            }

            else if (selection == 'R') {
                webtree = new WebTree();
                System.out.println("Information Reset: ");
            }
                
            }
        System.out.println("Program Terminated gracefully. ");

        }
}
