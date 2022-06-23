
package programs;

public class Passenger {

    int size;
    String destination;
    String start;
    int time_Arrived;
    routes route;
      
    enum routes {
        inRoute,
        outRoute
    }
    
    public Passenger() {}
    
    public void setRoute(routes route){
        this.route = route;
    }
    
    public routes getRoute() {
        return route;
    } 
    
    public void setStart(String start) {
        this.start = start;
    }
    
    public String getStart() {
        return start;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setTimeArrived(int time_Arrived) {
        this.time_Arrived = time_Arrived;
    }
    
    public int getTimeArrived() {
        return time_Arrived;
    }
}
