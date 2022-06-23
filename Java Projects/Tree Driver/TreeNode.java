
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
* TreeNode class creates and holds a TreeNode object.
* It has setter and getter methods for its attributes along with 
* two other methods that will help with the next classes.
*/

public class TreeNode {
    
    /**
    * left is a TreeNode that represents the left TreeNode object of this TreeNode object.
    * middle is a TreeNode that represents the middle TreeNode object of this TreeNode object.
    * right is a TreeNode that represents the right TreeNode object of this TreeNode object.
    * label is a private String that represents the label of this TreeNode object. 
    * message is a private String that represents the message of this TreeNode object.
    * prompt is a private String that represents the prompt of this TreeNode object.
    */
    
    TreeNode left, middle, right;
    private String label;
    private String message;
    private String prompt;
    
    /**
    * TreeNode() is a constructor that creates a TreeNode object. 
    * There are no parameters or initializations.
    */
    
    public TreeNode() {}
    
    /**
    * setLeft(TreeNode node) is a method that sets the left of this TreeNode object.
    * @param node 
    * A TreeNode object that represents the left TreeNode object of this TreeNode object.
    * PostCondition : left gets set.
    */
    
    public void setLeft(TreeNode node) {
        left = node;
    }
    
    /**
    * setMiddle(TreeNode node) is a method that sets the middle of this TreeNode object.
    * @param node 
    * A TreeNode object that represents the middle TreeNode object of this TreeNode object.
    * PostCondition : middle gets set.
    */
    
    public void setMiddle(TreeNode node) {
        middle  = node;
    }
    
    /**
    * setRight(TreeNode node) is a method that sets the right of this TreeNode object.
    * @param node 
    * A TreeNode object that represents the right TreeNode object of this TreeNode object.
    * PostCondition : right gets set.
    */
    
    public void setRight(TreeNode node) {
        right = node;
    }
    
    /**
    * setLabel(String label) is a method that sets the label of this TreeNode object.
    * @param label
    * A String that represents the label of this TreeNode object.
    * PostCondition : label gets set.
    */
    
   
    public void setLabel(String label) {
        this.label = label;
    }
    
    /**
    * setMessage(String message) is a method that sets the message of this TreeNode object.
    * @param message
    * A String that represents the message of this TreeNode object.
    * PostCondition : message gets set.
    */
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
    * setPrompt(String prompt) is a method that sets the prompt of this TreeNode object.
    * @param prompt
    * A String that represents the prompt of this TreeNode object.
    * PostCondition : prompt gets set.
    */
    
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    /**
    * getLeft() is a method that gets the left TreeNode object of this TreeNode object.
    * @return 
    * A TreeNode object that represents the left TreeNode object of this TreeNode object.
    */
    
    public TreeNode getLeft() {
        return left;
    }
    
    /**
    * getMiddle() is a method that gets the middle TreeNode object of this TreeNode object.
    * @return 
    * A TreeNode object that represents the middle TreeNode object of this TreeNode object.
    */
    
    public TreeNode getMiddle() {
        return middle;
    }
    
    /**
    * getRight() is a method that gets the right TreeNode object of this TreeNode object.
    * @return 
    * A TreeNode object that represents the right TreeNode object of this TreeNode object.
    */
    
    public TreeNode getRight() {
        return right;
    }
    
    /**
    * getLabel() is a method that gets the label of this TreeNode object.
    * @return 
    * A String that represents the label of this TreeNode object.
    */
    
    public String getLabel() {
        return label;
    }
    
    /**
    * getMessage() is a method that gets the message of this TreeNode object.
    * @return 
    * A String that represents the message of this TreeNode object.
    */
    
    public String getMessage() {
        return message;
    }
    
    /**
    * getPrompt() is a method that gets the prompt of this TreeNode object.
    * @return 
    * A String that represents the prompt of this TreeNode object.
    */
    
    public String getPrompt() {
        return prompt;
    }
    
    /**
    * getNodeReference(String label) is a method that gets the first TreeNode object in the 
    * ternary tree with the label given in the parameter.
    * @param label
    * A String that represents the label of a certain TreeNode object.
    * @return 
    */
    
    public TreeNode getNodeReference(String label) {
        TreeNode cursor1 = new TreeNode();
        if (this.getLabel().equalsIgnoreCase(label)) {
            cursor1 = this;
            
            
        }
        else {
            if (left != null) {
                cursor1 = left.getNodeReference(label);
                if (cursor1.getLabel() != null) {
                    return cursor1;
                }
            }
            if (middle != null) {
                cursor1 = middle.getNodeReference(label);
                if (cursor1.getLabel() != null) {
                    return cursor1;
                }
            }
            if (right != null) {
                cursor1 = right.getNodeReference(label);
                if (cursor1.getLabel() != null) {
                    return cursor1;
                }   
            }
        }
        return cursor1;
    }
    
    /**
    * preorder() is a method that prints all of the String attributes for each 
    * TreeNode object in the ternary tree.
    * PreCondition : There are more than 0 TreeNode objects in the ternary tree.
    * PostCondition : String attributes get printed onto the screen.
    */
    
    public void preorder(TreeNode root) {
        System.out.println("Label: " + this.getLabel());
        if (this != root) {
            System.out.println("Prompt: " + this.getPrompt());
        }
        System.out.println("Message: " + this.getMessage());
        if (left != null) {
            left.preorder(root);
        }
        if (middle != null) {
            middle.preorder(root);
        }
        if (right != null) {
            right.preorder(root);
        }
    }
}
