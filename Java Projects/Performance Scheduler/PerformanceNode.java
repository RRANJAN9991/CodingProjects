/* Name : Rahul Ranjan ID# : 111448179*/
package programs;
/** This class creates a performance (node) by receiving data from the user. This data is inserted into the data fields name_Performance, name_Performer, num_Participants, and duration.*/
public class PerformanceNode {
    String name_Performance;
    String name_Performer;
    int num_Participants;
    double duration;
    double start_Time;
    PerformanceNode next;
    PerformanceNode prev;
    /* next is link to get the next node. Since we are working with a double link list, we will also use prev which is the link to get the previous node.*/
    public PerformanceNode() {
        next = null;
        prev = null;
    }
    /* Constructor justs sets the links for next and previous node equal to null.*/
    public String getPerformance() {
        return name_Performance;
    }
    
    public void setPerformance(String name_Performance) {
        this.name_Performance = name_Performance;
    }
    
    public String getPerformer() {
        return name_Performer;
    }
    
    public void setPerformer(String name_Performer) {
        this.name_Performer = name_Performer;
    }
    
    public int getParticipants() {
        return num_Participants;
    }
    
    public void setParticipants(int num_Participants) {
        this.num_Participants = num_Participants;
    }
    
    public double getDuration() {
        return duration;
    }
    
    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    public double getStartTime() {
        return start_Time;
    }
    
    public void setStartTime(double start_Time) {
        this.start_Time = start_Time;
    }
    /* All methods above are either get or set methods for each of the data fields. The set methods put the data from the user into variables and the get methods return
    data to the user if called.
    */
    
    public PerformanceNode getNext() {
        return next;
    }
    public void setNext(PerformanceNode node) {
        next = node;
    }
    
    public PerformanceNode getPrev() {
        return prev;
    }
    
    public void setPrev(PerformanceNode node) {
        prev = node;
    }
    /* Above methods set the link from one node to the next and to the previous.*/
    
    public String toString() {
        return "Performance: " + name_Performance + "            Lead Performer: " + name_Performer + "                Number of Participants: " + num_Participants + "                    Duration: "
                + duration + "                  Start Time: " + start_Time + "       ";
    }
}   /* toString() returns a string which contains all the data for each node in row format.*/

