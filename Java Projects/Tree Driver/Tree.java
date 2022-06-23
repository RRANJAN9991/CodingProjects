

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

/**
* import java.util.* is used to ask the user for input.
*/

import java.util.*;

/** 
* Tree class creates and holds a Tree object.
* It has methods for its attributes along with 
*/

public class Tree {
    
    /**
    * root is a TreeNode object that represents the root or first TreeNode object in the ternary tree.
    * fileName is a String representing the fileName that was used to create this Tree object. (Ternary tree)
    */
    
    
    TreeNode root;
    String fileName;
    
    /**
    * Tree() is a constructor that creates a Tree object.
    * It contains no parameters, but it initializes root to null.
    */
    
    public Tree() {
        root = null;
    }
    
    /**
    * isEmpty() is a method that determines if this Tree object is empty.
    * @return 
    * A boolean that equals true if this Tree object is empty or false if it is not empty.
    */
    
    public void setTreeTextFile(String fileName) throws Exception{
        if (fileName.length() > 20) {
            throw new Exception("File name is too long. ");
        }
        this.fileName = fileName;
    }
    
    public boolean isEmpty() {
        return (root == null);
    }
    
    /**
    * addNode(String label, String prompt, String message, String parentLabel) is a method that 
    * adds a TreeNode object along with its attributes as the given parameters to this Tree object. (Ternary tree)
    * @param label
    * A String that represents the label of a TreeNode object.
    * @param prompt
    * A String that represents the prompt of a TreeNode object.
    * @param message
    * A String that represents the message of a TreeNode object.
    * @param parentLabel
    * A string that represents the label of the parent TreeNode object of a TreeNode object.
    * @return 
    * A boolean that equals true if a TreeNode object has been added or false if it has not been added.
    * PostCondition : TreeNode object gets added to Tree object. (Ternary tree)
    */
    
    public boolean addNode(String label, String prompt, String message, String parentLabel) {
        TreeNode newNode = new TreeNode();
        TreeNode cursor = new TreeNode();
        try {
            newNode.setLabel(label);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        try {
            newNode.setMessage(message);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        try {
            newNode.setPrompt(prompt);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        if (this.isEmpty()) {
            root = newNode;
            return true;
        }
        else {
            cursor = root;
            cursor = cursor.getNodeReference(parentLabel);
            if (cursor.getLeft() == null) {
                cursor.setLeft(newNode);
                return true;
            }
            else if (cursor.getMiddle() == null) {
                cursor.setMiddle(newNode);
                return true;
            }
            else if (cursor.getRight() == null){
                cursor.setRight(newNode);
                return true;
            }
            else {
                return false;
            }
        }
    }   
    
    /**
    * preorder() is a method that determines the preorder traversal
    * of a ternary tree starting with the root.
    * PreCondition : There are more than 0 TreeNode objects in the ternary tree.
    * PostCondition : String attributes get printed onto the screen.
    */
    
    public void preorder() {
        if (root != null) {
            root.preorder(root);
        }
        else {
            System.out.println("There are no TreeNode objects in the ternary tree. ");
        } 
    }
    
    /**
    * beginSession() is a method that asks for input from the user and 
    * based off the input, traverses the ternary tree (Tree object) in a certain
    * way and displays the String attributes of the TreeNode objects that it
    * traverses in the ternary tree (Tree object) (Except for root prompt)
    * PreCondition : root is not equal to null. (There are more than 0 TreeNode objects in the tree object (Ternary tree))
    * PostCondition : String attributes for all TreeNode objects that have been traverse are printed. (Except for root prompt)
    */
    
    public void beginSession() {
        TreeNode cursor = root;
        Scanner input = new Scanner(System.in);
        String selection = "";
        if (root == null) {
            System.out.println("There are no TreeNode objects in the ternary tree. ");
        }
        else {
            while (cursor != null) {
                System.out.println(cursor.getMessage());
                if (cursor.getLeft() != null) {
                    System.out.println("Option 1 " + cursor.getLeft().getPrompt());
                }
                if (cursor.getMiddle() != null) {
                    System.out.println("Option 2 " + cursor.getMiddle().getPrompt());
                }
                if (cursor.getRight() != null) {
                    System.out.println("Option 3 " + cursor.getRight().getPrompt());
                }
                if (cursor.getLeft() == null && cursor.getMiddle() == null && cursor.getRight() == null) {
                    break;
                }
                System.out.println("Option 0 Quit");
                selection = input.next();
                if (selection.equals("1")) {
                    cursor = cursor.getLeft();
                }
                else if (selection.equals("2")) {
                    cursor = cursor.getMiddle();
                }
                else if (selection.equals("3")) {
                    cursor = cursor.getRight();
                }
                else if (selection.equals("0")) {
                    break;
                }
            }
            System.out.println("Heading back to Menu. ");
        }
    }
}
   
    
    
