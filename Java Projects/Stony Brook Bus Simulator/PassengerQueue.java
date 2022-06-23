
package programs;

public class PassengerQueue {

    Node front;
    Node rear;
    
    public PassengerQueue() {
        front = null;
        rear = null;
    }
    
    public void enqueue(Passenger p) {
        Node newPassenger = new Node(p);
        if (front == null) {
            front = newPassenger;
            rear = front;
        }
        else {
            rear.setNext(newPassenger);
            rear = newPassenger;
        }
    }
    
    public Passenger dequeue() throws Exception {
        Passenger answer = null;
        if (front == null) {
            throw new Exception("Empty Queue");
        }
        answer = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return answer;
    }
    
        
    public Passenger peek() throws Exception {
        Passenger answer = null;
        if (front == null) {
            throw new Exception("Empty Queue");
        }
        answer = front.getData();
        return answer;
    }
    
    public int size() {
        int counter = 0;
        Node group = this.front;
        while (group != null) {
            counter = counter + group.getData().getSize();
            group = group.getNext();
        }
        return counter;
    }
    
    public int groupNumber() {
        int counter = 0;
        Node group = this.front;
        while (group != null) {
            counter = counter + 1;
            group = group.getNext();
        }
        return counter;
    }
    
    public boolean isEmpty() {
        return (front == null);
    }
}
