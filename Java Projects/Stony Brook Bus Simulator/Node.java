
package programs;

public class Node {
    
    Passenger data;
    Node next;
    Node prev;
    
    public Node(Passenger data) {
        this.data = data;
        next = null;
        prev = null;
    }
    
    public Passenger getData() {
        return data;
    }
    
    public void setData(Passenger newData) {
        data = newData;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node newLink) {
        next = newLink;
    }
    
    public Node getPrev() {
        return prev;
    }
    
    public void setPrev(Node node) {
        prev = node;
    }
}
