
package programs;

/**
* This class holds and creates an ItemList object which contains multiple items (ItemInfoNode Objects) where each item contains ItemInfo.
* This class creates a doubly linked list of ItemInfoNodes.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class ItemList {
    
    /**
    * head is an ItemInfoNode object that represents the head or beginning of the doubly link list.
    * tail is an ItemInfoNode object that represents the tail or end of the doubly link list.
    */
    
    ItemInfoNode head;
    ItemInfoNode tail;
    
    /**
    * ItemList() creates an ItemList object. 
    * This constructor initializes head and tail to equal null.
    */
    
    public ItemList() {
        head = null;
        tail = null;
    }
    
    /**
    * insertInfo() inserts an item into the list based off its RFID. 
    * @param name
    * A string that represents the name of a product/item.
    * @param rfidTag
    * A String that represents the RFID of a product/item.
    * @param price
    * A double that represents the price of a product/price.
    * @param initPosition 
    * A String that represents the original location of a product/price.
    * PreCondition : rfidTag and ititPosition are valid.
    * PostCondition : a new ItemInfoNode with all its attributes is inserted properly into the doubly linked list.
    * (Without destroying the list)
    * Worst Case Order of Complexity is 0(n). Best Case is 0(1).
    */
    
    public void insertInfo(String name, String rfidTag, double price, String initPosition) {
        ItemInfo newInfo = new ItemInfo();
        newInfo.setProductName(name);
        newInfo.setProductPrice(price);
        newInfo.setCurrentLocation(initPosition);
        newInfo.setOriginalLocation(initPosition);
        try {
            newInfo.setRfidTagNumber(rfidTag);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        ItemInfoNode newNode = new ItemInfoNode();
        newNode.setInfo(newInfo);
        if (head == null) {
            head = newNode;
            tail = head;
            newNode.prev = null;
        }
        else if (head.getNext() == null) {
            if (head.getInfo().hexToDec() > newNode.getInfo().hexToDec()) {
                head.setPrev(newNode);
                newNode.setNext(head);
                head = head.getPrev();
            }
            else {
                head.setNext(newNode);
                newNode.setPrev(head);
                newNode = tail;
            }
        }
        else {
            ItemInfoNode nodePtr = head;
            while (nodePtr != null) {
                if (nodePtr.getInfo().hexToDec() == newNode.getInfo().hexToDec()) {
                    nodePtr.getNext().setPrev(newNode);
                    newNode.setNext(nodePtr.getNext());
                    nodePtr.setNext(newNode);
                    newNode.setPrev(nodePtr);
                    break;
                }
                if (nodePtr.getInfo().hexToDec() > newNode.getInfo().hexToDec()) {
                    nodePtr.getPrev().setNext(newNode);
                    newNode.setPrev(nodePtr.getPrev());
                    newNode.setNext(nodePtr);
                    nodePtr.setPrev(newNode);
                    break;
                }
                if (nodePtr.getNext() == null) {
                    nodePtr.setNext(newNode);
                    newNode.setPrev(nodePtr);
                    tail = newNode;
                    break;
                }
                nodePtr = nodePtr.getNext();
                
            }
        }
    }
    
    /**
    * removeAllPurchased() removes all ItemInfoNode objects that have the attribute current location set as "out".
    * PreCondition : the head of the doubly link list is not equal to null.
    * PostCondition : All ItemInfoNode objects with ItemInfo that has the attribute currentLocation set to "out" hae been removed. 
    * (Without destroying the list)
    *  Worst Case Order of Complexity is 0(n). Best Case is 0(1).
    */
    
    public void removeAllPurchased() {
        if (head == null) {
            System.out.println("There are no items at all. ");
        }
        else if (head.getNext() == null) {
            if (head.getInfo().getCurrentLocation().equalsIgnoreCase("out")) {
                System.out.println("Items Removed:           Name: " + head.getInfo().getProductName() + "             RFID: " + head.getInfo().getRfidTagNumber() + "               Current Location: " + head.getInfo().getCurrentLocation()
                + "             Original Location: " + head.getInfo().getOriginalLocation() + "                   Price: " +  head.getInfo().getProductPrice());
                head = null;
                tail = null;
                
            }
        }
        else if (head.getNext().getNext() == null) {
            if (head.getInfo().getCurrentLocation().equalsIgnoreCase("out") && (!(head.getNext().getInfo().getCurrentLocation().equalsIgnoreCase("out")))) {
                System.out.println("Items Removed:           Name: " + head.getInfo().getProductName() + "             RFID: " + head.getInfo().getRfidTagNumber() + "               Current Location: " + head.getInfo().getCurrentLocation()
                + "             Original Location: " + head.getInfo().getOriginalLocation() + "                   Price: " +  head.getInfo().getProductPrice());
                head = head.getNext();
                tail = head;
                head.setPrev(null);
            }
            else if ((!(head.getInfo().getCurrentLocation().equalsIgnoreCase("out"))) && head.getNext().getInfo().getCurrentLocation().equalsIgnoreCase("out")) {
                System.out.println("Items Removed:           Name: " + head.getNext().getInfo().getProductName() + "             RFID: " + head.getNext().getInfo().getRfidTagNumber() + "               Current Location: " + head.getNext().getInfo().getCurrentLocation()
                + "             Original Location: " + head.getNext().getInfo().getOriginalLocation() + "                   Price: " +  head.getNext().getInfo().getProductPrice());
                tail = head;
                head.setNext(null);
                head.setPrev(null);
            }
            else if (head.getInfo().getCurrentLocation().equalsIgnoreCase("out") && head.getNext().getInfo().getCurrentLocation().equalsIgnoreCase("out")) {
               System.out.println("Items Removed:           Name: " + head.getInfo().getProductName() + "             RFID: " + head.getInfo().getRfidTagNumber() + "               Current Location: " + head.getInfo().getCurrentLocation()
                + "             Original Location: " + head.getInfo().getOriginalLocation() + "                   Price: " +  head.getInfo().getProductPrice());
                System.out.println("Items Removed:           Name: " + head.getNext().getInfo().getProductName() + "             RFID: " + head.getNext().getInfo().getRfidTagNumber() + "               Current Location: " + head.getNext().getInfo().getCurrentLocation()
                + "             Original Location: " + head.getNext().getInfo().getOriginalLocation() + "                   Price: " +  head.getNext().getInfo().getProductPrice());
                head.getNext().setPrev(null);
                head.setNext(null);
                head = null;
                tail = null;
            }
                
        }
        else {
            ItemInfoNode nodePtr = head;
            while (nodePtr != null) {
                if (nodePtr.getInfo().getCurrentLocation().equalsIgnoreCase("out")) {
                    if (nodePtr == head) {
                        if (nodePtr.getNext() == null) {
                            System.out.println("Items Removed:           Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                            nodePtr = null;
                            head = null;
                            tail = null;
                            break;
                        }
                        else {
                            System.out.println("Items Removed:           Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                            nodePtr = nodePtr.getNext();
                            nodePtr.setPrev(null);
                            head = nodePtr;
                        }
                    }
                    else if (nodePtr.getNext() == null) {
                        System.out.println("Items Removed:           Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                        tail = nodePtr.getPrev();
                        nodePtr.getPrev().setNext(null);
                        nodePtr = null;
                        break;
                        
                    }
                    else {
                        nodePtr.getPrev().setNext(nodePtr.getNext());
                        nodePtr.getNext().setPrev(nodePtr.getPrev());
                        System.out.println("Items Removed:           Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                        nodePtr = nodePtr.getNext();
                    }
                }
                else {
                    nodePtr = nodePtr.getNext();
                }
                
            }
        }
    }
    
    /**
    * moveItem() moves an Item from its original location to another location or from its current location to another location.
    * @param rfidTag
    * A String that represents the RFID of a product/item.
    * @param source
    * A String that represents the current location of a product/item.
    * @param dest
    * A String that represents the new location for the product/item to be moved to.
    * @return 
    * A boolean that indicates whether or not a product/item (ItemInfoNode) has been moved to the destination.
    * PreCondition : the head of the doubly linked list is not equal to null.
    * PostCondition : the ItemInfoNode has been moved to the destination and its currentLocation has been set to dest. 
    * (boolean value also has been updated)
    * Worst Case Order of Complexity is 0(n). Best Case is 0(1).
    */
    
    public boolean moveItem(String rfidTag, String source, String dest) {
        boolean exists = false;
        if (head == null) {
            System.out.println("There are no items in the list. ");
        }
        else {
            ItemInfoNode nodePtr = head;
            while (nodePtr != null) {
                if (nodePtr.getInfo().getRfidTagNumber().equalsIgnoreCase(rfidTag) && nodePtr.getInfo().getCurrentLocation().equalsIgnoreCase(source)) {
                    nodePtr.getInfo().setCurrentLocation(dest);
                    exists = true;
                    break;
                }
                nodePtr = nodePtr.getNext();
            }
        }
        return exists;
    }
    
    /**
    * printAll() prints all the ItemInfoNode's attributes within ItemInfo. (Name, price, original and current locations, and rfidTagNumber) 
    * PreCondition : the head of the doubly linked list is not equal to null.
    * Post Condition : All of the attributes for each ItemInfoNode has been printed.
    * Worst Case Order of Complexity is 0(n). Best Case is 0(1).
    */
    
    public void printAll() {
        if (head == null) {
            System.out.println("No items in the list. ");
        }
        else {
            ItemInfoNode nodePtr = head;
            while (nodePtr != null) {
                System.out.println("Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                nodePtr = nodePtr.getNext();
            }
        }
    }
    
    /**
    * printByLocation() prints the attributes of all ItemInfoNode objects found in a certain location.
    * @param location 
    * A String representing the current location of a product/item.
    * PreCondition : the head of the doubly linked list is not equal to null.
    * PostCondition : the attributes for all ItemInfoNode objects in a certain location has been printed.
    * Worst Case Order of Complexity is 0(n). Best Case is 0(1).
    */
    public void printByLocation(String location) {
        if (head == null) {
            System.out.println("No items in the list. ");
        }
        else {
            ItemInfoNode nodePtr = head;
            while (nodePtr != null) {
                if (nodePtr.getInfo().getCurrentLocation().equalsIgnoreCase(location)) {
                   System.out.println("Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                }
                nodePtr = nodePtr.getNext();
            }
        }
    }
    
    /**
    * cleanStore() moves all items/products that are not currently in their original location back to their original location.
    * PreCondition : The head in the doubly link list is not equal to null.
    * PostCondition : All ItemInfoObjects with ItemInfo that has the currentLocation not the same as originalLocation will be have their
    * currentLocation set as their originalLcoation.
    * Worst Case Order of Complexity is 0(n). Best Case is 0(1).
    */
    
    public void cleanStore() {
        if (head == null) {
            System.out.println("There are no items in the list. ");
        }
        else {
            ItemInfoNode nodePtr = head;
            while (nodePtr != null) {
                if (nodePtr.getInfo().getCurrentLocation().equalsIgnoreCase(nodePtr.getInfo().getOriginalLocation())) {

                }
                if (nodePtr.getInfo().getCurrentLocation().equalsIgnoreCase("out")) {

                }
                else {
                    System.out.println("Item moved back to original locaation:          Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                    nodePtr.getInfo().setCurrentLocation(nodePtr.getInfo().getOriginalLocation());
                }
                nodePtr = nodePtr.getNext();
            }
        }
    }
    
    /**
    * checkOut() sets the current locations of all products/items that are currently in carts as "out". 
    * This method also determines the price of all items that are to be checked out of the store.
    * @param cartNumber
    * A String that represents the current location of a product/item. (Taken off the shelf)
    * @return 
    * A double representing the total price of all items that will be checked out.
    * Worst Case Order of Complexity is 0(n). Best Case is 0(1).
    */
    
    public double checkOut(String cartNumber) {
        ItemInfoNode nodePtr = head;
        double totalPrice = 0.0;
        while (nodePtr != null) {
            if (nodePtr.getInfo().getCurrentLocation().equalsIgnoreCase(cartNumber)) {
                totalPrice = totalPrice + nodePtr.getInfo().getProductPrice();
                System.out.println("Checked Out:           Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                nodePtr.getInfo().setCurrentLocation("out");
            }
            nodePtr = nodePtr.getNext();
        }
        return totalPrice;
    }
    
    public void printByRfid(String rfid) {
        if (head == null) {
            System.out.println("No items in the list. ");
        }
        else {
            ItemInfoNode nodePtr = head;
            while (nodePtr != null) {
                if (nodePtr.getInfo().getRfidTagNumber().equalsIgnoreCase(rfid)) {
                   System.out.println("Name: " + nodePtr.getInfo().getProductName() + "             RFID: " + nodePtr.getInfo().getRfidTagNumber() + "               Current Location: " + nodePtr.getInfo().getCurrentLocation()
                            + "             Original Location: " + nodePtr.getInfo().getOriginalLocation() + "                   Price: " +  nodePtr.getInfo().getProductPrice());
                }
                nodePtr = nodePtr.getNext();
            }
        }
    }
}