
package programs;

/**
* This class holds and creates an ItemInfoNode object which contains an item that contains ItemInfo.
* This class sets previous and next links to other ItemInfoNode objects.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class ItemInfoNode {
    
    /**
    * next is an ItemInfoNode object that represents the ItemInfoNode that comes after the current ItemInfoNode.
    * prev is an ItemInfoNode object that represents the ItemInfoNode that comes before the current ItemInfoNode.
    * info is an ItemInfo object that represents the item info of the current ItemInfoNode.
    */
    
    ItemInfoNode next;
    ItemInfoNode prev;
    ItemInfo info;
    
    /**
    * ItemInfoNode() creates an ItemInfoNode object.
    * This constructor initializes next and prev to null.
    */
    
    public ItemInfoNode() {
        next = null;
        prev = null;
    }
    
    /**
    * setInfo() sets the information of an ItemInfoNode object.
    * @param info 
    * An ItemInfo object representing the information of an ItemInfoNode.
    * PostCondition : info gets set.
    */
    
    public void setInfo(ItemInfo info) {
        this.info = info;
    }
    
    /**
    * getInfo() gets the information of an ItemInfoNode object.
    * @return 
    * An ItemInfo object representing the information of an ItemInfoNode.
    */
    
    public ItemInfo getInfo() {
        return info;
    }
    
    /**
    * setNext() sets a link to the next ItemInfoNode object.
    * @param node 
    * An ItemInfoNode object representing the node after the current ItemInfoNode object. (This)
    * PostCondition :  next gets set.
    */
    
    public void setNext(ItemInfoNode node) {
        next = node;
    }
    
      
    /**
    * getNext() gets the next ItemInfoNode object in the doubly linked list.
    * @return 
    * An ItemInfoNode object representing the node after the current ItemInfoNode object. (This)
    */
    
    public ItemInfoNode getNext() {
        return next;
    }
    
    /**
    * setPrev() sets a link to the previous ItemInfoNode object.
    * @param node 
    * An ItemInfoNode object representing the node before the current ItemInfoNode object. (This)
    * PostCondition : prev gets set.
    */
    
    public void setPrev(ItemInfoNode node) {
        prev = node;
    }
    
    /**
    * getPrev() gets the previous ItemInfoNode object in the doubly linked list.
    * @return 
    * An ItemInfoNode object representing the node before the current ItemInfoNode object. (This)
    */
    
    public ItemInfoNode getPrev() {
        return prev;
    }
}
