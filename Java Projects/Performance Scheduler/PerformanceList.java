/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

import java.time.LocalDateTime;
/* This class creates a list of nodes (performances) in the way the user wants,l displays information from the peformances in the list, and changes the peformances
in the list.*/
public class PerformanceList {
    PerformanceNode head;
    PerformanceNode tail;
    PerformanceNode cursor;
    public PerformanceList() {
        head = null;
        tail = null;
        cursor = null;
    }
    /* Head, tail, and cursor are all set to null in the constructor. (Cursor is the current performance)*/
    public void addToEnd(PerformanceNode newPerformance) {
        if (head == null) {
            head = newPerformance;
            tail = head;
            cursor = head;
            newPerformance.prev = null;
            newPerformance.start_Time = 0;
        }
        else {
            newPerformance.start_Time = tail.start_Time + tail.duration;
            tail.setNext(newPerformance);
            newPerformance.setPrev(tail);
            tail = newPerformance;
            cursor = newPerformance;
        }
    }/* The precondition for this method is that there is at least one node in the list. If this is met, the else condition will set the links from the last node in the
    list to the new node (new performance) that will be at the end of list. (tail and cursor move to the new node) If precondition is not met, the m ethod will just
    add the new node to the list and set the head, tail, and cursor equal to the new node.*/
    
    public int size() {
        PerformanceNode node_Ptr = head;
        int counter = 0;
        while (node_Ptr != null) {
            counter++;
            node_Ptr = node_Ptr.getNext();
        }
        return counter;
    }
    /* This method returns the size of the list. (The number of nodes (performances) in the list) It does this by setting a node equal to the head and using a while loop 
    to loop through the list as long as the next node in the list is not equal to null. (Meaning the next node exists) Everytime the loop is circled, the counter inceases
    by 1. This method helps us in the jumpToPosition method. */
    public PerformanceNode ReturnCurrentNode(PerformanceNode newPerformance)
    {
        PerformanceNode node_Ptr = head;
        PerformanceNode currNode = null;
        double currMinutes = (LocalDateTime.now().getHour() * 60) + (LocalDateTime.now().getMinute());
        while (node_Ptr != null) {
            if (node_Ptr.getStartTime() <= currMinutes && node_Ptr.getStartTime() + node_Ptr.getDuration() > currMinutes) {
                return node_Ptr;
            }
            node_Ptr=node_Ptr.getNext();
            }
        return null;
    }/* This method returns the current node (current performance) by using the starttime and duration methods from the PerformanceNode class to determine whether or not the 
    next node in the while loop is the current node.*/
    public void addAfterCurrent(PerformanceNode newPerformance) {
        double per_Dur = newPerformance.duration;
        if (cursor != null && cursor != tail) {  
            newPerformance.setNext(cursor.getNext());
            cursor.getNext().setPrev(newPerformance);
            cursor.setNext(newPerformance);
            newPerformance.setPrev(cursor);
            newPerformance.start_Time = cursor.start_Time + cursor.duration;
            while (newPerformance.getNext() != null) {
                newPerformance.getNext().start_Time = newPerformance.getNext().start_Time + per_Dur;
                newPerformance = newPerformance.getNext();
            }
        }
        else {
            if (cursor != null) {
                newPerformance.start_Time = cursor.start_Time + cursor.duration;
            }
            this.addToEnd(newPerformance);            
        }
    }
    /* This method adds the new node to after the current node which is the cursor. The precondition is the cursor must not be equal to null. If this is met, the method will
    run through the first if condition and the if condition in the else condition. If cursor is equal to null, then the method will use the addToEnd method for adding the new
    performance. (New node)*/
    public boolean removeCurrentNode() {
       
        if (cursor != null) {
            if (cursor.getPrev() != null) {
                if (cursor.getNext() != null) {
                    double cur_Dur = cursor.duration;
                    PerformanceNode temp = cursor;
                    cursor=cursor.getNext();
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                    cursor.start_Time = cursor.start_Time - cur_Dur;
                    temp = cursor;
                    while (temp.getNext() != null) {
                        temp.getNext().start_Time = temp.getNext().start_Time - cur_Dur;
                        temp = cursor.getNext();
                    }
                    return true;
                }
                else {
                    cursor = cursor.getPrev();
                    cursor.setNext(null);
                    tail = cursor;
                    return true;
                }
            }
            else {
                if (cursor.getNext() == null) {
                    cursor=null;
                    head = cursor;
                    tail = cursor;
                    return true;
                }
                else {
                    cursor = cursor.getNext();
                    head = cursor;
                    cursor.getPrev().setNext(null);
                    cursor.setPrev(null);
                    return true;
                    
                }
            }
        }
        return false;
    }
    /* This method will return true if a node (performance) got removed from the list. It will return false if a node is not removed from the list. If there is a node in
    front of the cursor, then the method will move the cursor over to the next node and remove the node behind the new cursor. If there are no nodes in front of the cursor then the
    method will move the cursor backwards and remove the node in front of the new cursor. The method will return false if the precondition is not met. (Precondition is
    cursor is not equal to null) In this case, there is nothing to remove from the list.*/
    public void displayCurrentPerformance() {
        if (cursor != null) {
            System.out.print(cursor.toString());
        }
        else {
            System.out.print("No current performannce");
        }
    }
    /* This method displays the toString method of the cursor in the if condition if the precondition is met. (Precondition is cursor is not equal to null) If the precondition is not met,
    then the method will run through the else condition and print out the statement above.*/
    public boolean moveCursorForward() throws Exception {
        if (cursor == null) {
            throw new Exception("There is no current performance");
        }
        else {
            if (head != tail && cursor != tail) { 
                cursor = cursor.getNext();
                return true;
            }
        }
        return false;
    }
    /* This method returns true if the cursor gets moved forward. If there is no current node then the method throws an exception.*/
    public boolean moveCursorBackward() throws Exception {
        if (cursor == null) {
            throw new Exception("There is no current performance");
        }
        else {
            if (tail != head && cursor != head) { 
                cursor = cursor.getPrev();
                return true;
            }
        }
        return false;
    }
    /* This method returns true if the cursor gets moved backward. If there is no current node then the method throws an exception.*/
    public boolean jumpToPosition(int position) {
        int size = this.size();
        PerformanceNode node_Ptr = head;
        for (int i = 1; i < size + 1; i++) {
            if (i == position) {
                cursor = node_Ptr;
                return true;
            }
            if (node_Ptr.getNext() != null) {
                node_Ptr=node_Ptr.getNext();   
            }
        }
        return false;          
    }
    /* This method returns true if the cursor gets moved to the position given by the user. It returns false if there are no nodes in the list. It sets a node equal
    to the head and uses a for loop with i < size + 1. (size + 1 is the last node in the list) Once cursor is equal to the node in the position given by the user, the first
    if condition will return true and the loop will stop.*/
    public String toString() {
        PerformanceNode node_Ptr = head;
        int counter = 0;
        String display = "";
        while (node_Ptr != null) {
            counter = counter + 1;
            if (node_Ptr == cursor) {
                display +=" * ";
            }
            display += counter + "     " + node_Ptr.toString() + "\n";
            node_Ptr = node_Ptr.getNext();
        }
        return display;
    }/* This method returns a string that adds upon the rows created in the toString method created in the PerformanceNode class. It adds a * for the current performnce
    (cursor) and adds the position number for each node in the list. It also seperates each node into rows with all of their information.*/
}
        
    
   