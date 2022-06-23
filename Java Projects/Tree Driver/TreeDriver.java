
/**
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
*/

/**
* A package containing all homework programs for CSE 214.
*/

package programs;

/*
* The first three import statements are used to get the absolute path to find the directory given 
* the text file name and then read through the file line by line.
* The last import statemet is used in order for the program to ask the user for input.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
* This class is used to ask the user for input to add TreeNode objects to the ternary tree,
* then begin a help session or show the preorder traversal of the ternary tree. 
*/

public class TreeDriver {
    
    public static void main (String [] arguments) throws Exception{
        Tree tree = new Tree();
        Scanner input = new Scanner(System.in);
        char selection = ' ';
        while (selection != 'Q') {
            System.out.println("L : Load a Tree. ");
            System.out.println("H - Begin a Help Session. ");
            System.out.println("T - Traverse the Tree in preorder. "); 
            System.out.println("Q - Quit");
            System.out.println("Select an option: ");
            selection = input.next().charAt(0);
            if (selection == 'L') {
                String fileName = "";
                String fullPath = "";
                try {
                    System.out.println("Enter the filename. ");
                    fileName = input.next();
                    tree.setTreeTextFile(fileName);
                    final String dir = System.getProperty("user.dir");
                    fullPath = dir;
                    fullPath += "\\" + fileName;
                }
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
                
                
                try {
                    FileInputStream fis = new FileInputStream(fullPath);
                    InputStreamReader inStream = new InputStreamReader(fis);
                    BufferedReader reader = new BufferedReader(inStream);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.trim();
                        if (line.equalsIgnoreCase("root")) {
                            reader.readLine();
                            String rootMessage = reader.readLine().trim();
                            tree.addNode("root", "Root Node", rootMessage, "");
                            String children = reader.readLine().trim();
                            if (children.contains("1")) {
                                String label1 = reader.readLine().trim();
                                String childPrompt = reader.readLine().trim();
                                String childMessage = reader.readLine().trim();
                                tree.addNode(label1, childPrompt, childMessage, "root");
                            }
                            else if (children.contains("2")) {
                                String label1 = reader.readLine().trim();
                                String childPrompt = reader.readLine().trim();
                                String childMessage = reader.readLine().trim();
                                tree.addNode(label1, childPrompt, childMessage, "root");
                                String label2 = reader.readLine().trim();
                                String childPrompt2 = reader.readLine().trim();
                                String childMessage2 = reader.readLine().trim();
                                tree.addNode(label2, childPrompt2, childMessage2, "root");
                            }
                            else if (children.contains("3")) {
                                String label1 = reader.readLine().trim();
                                String childPrompt1 = reader.readLine().trim();
                                String childMessage1 = reader.readLine().trim();
                                tree.addNode(label1, childPrompt1, childMessage1, "root");
                                String label2 = reader.readLine().trim();
                                String childPrompt2 = reader.readLine().trim();
                                String childMessage2 = reader.readLine().trim();
                                tree.addNode(label2, childPrompt2, childMessage2, "root");
                                String label3 = reader.readLine().trim();
                                String childPrompt3 = reader.readLine().trim();
                                String childMessage3 = reader.readLine().trim();
                                tree.addNode(label3, childPrompt3, childMessage3, "root");
                            }   
                            
                        }
                        else {
                            if (!(line.contains("-"))) {
                                char numChildren = line.charAt(line.length() - 1);
                                String parentLabel = line.substring(0, line.length() - 2);
                                if (numChildren == '1') {
                                    String label = reader.readLine().trim();
                                    String childPrompt = reader.readLine().trim();
                                    String childMessage = reader.readLine().trim();
                                    tree.addNode(label, childPrompt, childMessage, parentLabel);
                                }
                                else if (numChildren == '2') {
                                    String label1 = reader.readLine().trim();
                                    String childPrompt1 = reader.readLine().trim();
                                    String childMessage1 = reader.readLine().trim();
                                    tree.addNode(label1, childPrompt1, childMessage1, parentLabel);
                                    String label2 = reader.readLine().trim();
                                    String childPrompt2 = reader.readLine().trim();
                                    String childMessage2 = reader.readLine().trim();
                                    tree.addNode(label2, childPrompt2, childMessage2, parentLabel);
                                }
                                else if (numChildren == '3') {
                                    String label1 = reader.readLine().trim();
                                    String childPrompt1 = reader.readLine().trim();
                                    String childMessage1 = reader.readLine().trim();
                                    tree.addNode(label1, childPrompt1, childMessage1, parentLabel);
                                    String label2 = reader.readLine().trim();
                                    String childPrompt2 = reader.readLine().trim();
                                    String childMessage2 = reader.readLine().trim();
                                    tree.addNode(label2 , childPrompt2, childMessage2, parentLabel);
                                    String label3 = reader.readLine().trim();
                                    String childPrompt3 = reader.readLine().trim();
                                    String childMessage3 = reader.readLine().trim();
                                    tree.addNode(label3, childPrompt3, childMessage3, parentLabel);
                                }   
                            }
                            else if (line.contains("-")) {
                                char numChildren = line.charAt(line.length() - 1);
                                String parentLabel = line.substring(0, line.length() - 2);
                                if (numChildren == '1') {
                                    String label = reader.readLine().trim();
                                    String childPrompt = reader.readLine().trim();
                                    String childMessage = reader.readLine().trim();
                                    tree.addNode(label, childPrompt, childMessage, parentLabel);
                                }
                                else if (numChildren == '2') {
                                    String label1 = reader.readLine().trim();
                                    String childPrompt1 = reader.readLine().trim();
                                    String childMessage1 = reader.readLine().trim();
                                    tree.addNode(label1, childPrompt1, childMessage1, parentLabel);
                                    String label2 = reader.readLine().trim();
                                    String childPrompt2 = reader.readLine().trim();
                                    String childMessage2 = reader.readLine().trim();
                                    tree.addNode(label2, childPrompt2, childMessage2, parentLabel);
                                }
                                else if (numChildren == '3') {
                                    String label1 = reader.readLine().trim();
                                    String childPrompt1 = reader.readLine().trim();
                                    String childMessage1 = reader.readLine().trim();
                                    tree.addNode(label1, childPrompt1, childMessage1, parentLabel);
                                    String label2 = reader.readLine().trim();
                                    String childPrompt2 = reader.readLine().trim();
                                    String childMessage2 = reader.readLine().trim();
                                    tree.addNode(label2 , childPrompt2, childMessage2, parentLabel);
                                    String label3 = reader.readLine().trim();
                                    String childPrompt3 = reader.readLine().trim();
                                    String childMessage3 = reader.readLine().trim();
                                    tree.addNode(label3, childPrompt3, childMessage3, parentLabel);
                                }   
                            }
                        }
                        
                    }

                } 
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
              
                
            }
            else if (selection == 'H') {
                System.out.println("Help Session Commencing... ");
                tree.beginSession();
            }
            else if (selection == 'T') {
                System.out.println("Traversing the tree in preorder... ");
                tree.preorder();
            }
        }
        System.out.println("Program terminating gracefully... ");
    }
}
