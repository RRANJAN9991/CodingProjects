
package programs;
 
public class NewClass {
public class IntNode { private int data; private IntNode link; // IntNode methods }

Constructor public IntNode(int initialData) { data = initialData; link = null; }

Accessor Methods public int getData() { return data; } public IntNode getLink() { return link; }

Mutator Methods public void setData(int newData) { data = newData; } public void setLink(IntNode newLink) { link = newLink; }

Defining a Linked List public class IntList { private IntNode head; private IntNode tail; private IntNode cursor; // IntList methods }

Constructor public IntList() { head = null; tail = null; cursor = null; }

Add a new head of list public void addNewHead(int element) { IntNode newNode = new IntNode(element); newNode.setLink(head); head = newNode; if (tail == null) tail = head; cursor = head; }

Add integer after cursor public void addIntAfter(int element) { IntNode newNode = new IntNode(element); if (cursor == null) { head = newNode; tail = newNode; cursor = newNode; }

Add integer after cursor (cont’d) else { newNode.setLink (cursor.getLink()); cursor.setLink(newNode); cursor = newNode;//advance cursor if (cursor.getLink() == null) tail = cursor; } }

   
}
