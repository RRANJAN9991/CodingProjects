
package programs;

public class Bus {
    static int capacity;
    String inOutRoute;
    String nextStop;
    String currentStop;
    double timeNextStop;
    double timeToRest;
    int currentSize;
    
   PassengerQueue PassengerInBus=new PassengerQueue();
   
   public void addPassengerQueueBus(Passenger pass)
   {
       this.PassengerInBus.enqueue(pass);       
   }
   
   
    String inRoute[] = {"South P" , "West" , "SAC" , "Chapin"};
    String outRoute[] = {"South P" , "PathMart" , "Walmart" , "Target"};
    public int[] unload(String dest,double currTime)
    {
        int counter[] = new int[3];
        
        Node nod = PassengerInBus.front;
        while (nod != null) 
        {
            if (nod.getData().getDestination().equals(dest))
            {
                if (PassengerInBus.front != PassengerInBus.rear || nod != PassengerInBus.front)
                {
                    try
                    {
                        nod.getPrev().setNext(nod.getNext());
                        nod.getNext().setPrev(nod.getPrev());
                        nod.setNext(PassengerInBus.front);
                        PassengerInBus.front.setPrev(nod);
                        nod.setPrev(null);
                        PassengerInBus.front = nod;
                        counter[0] +=  1;
                        Passenger ps = new Passenger();
                        ps = PassengerInBus.dequeue(); 
                        counter[1] +=(currTime-ps.getTimeArrived());
                        counter[2] += ps.getSize();
                    }
                    catch (Exception exp) 
                    {
                        System.out.print(exp.getMessage());
                    }
                   
                }
                else
                {
                    try 
                    {
                        counter[0] +=  1;
                        Passenger ps = new Passenger();
                        ps = PassengerInBus.peek(); 
                        counter[1] +=(currTime-ps.getTimeArrived());
                        counter[2] += ps.getSize();
                        PassengerInBus.dequeue();
                    }
                    catch (Exception exp) 
                    {
                        System.out.print(exp.getMessage());
                    }
                }              
            }
            
            nod = nod.getNext();
        }
        return counter;
    }    
    
    
    public static void setCapacity(int capty) {
        capacity = capty;
    }
    
    public static int getCapacity() {
        return capacity;
    }
    
    public void setInOutRoute(String inOutRoute) {
        this.inOutRoute = inOutRoute;
    }
    
    public String getInOutRoute() {
        return inOutRoute;
    }
    
    public void setNextStop(String nextStop) {
        this.nextStop = nextStop;
    }
    
    public String getNextStop() {
        return nextStop;
    }
    
    public void setCurrentStop(String currrentStop) {
        this.currentStop = currentStop;
    }
    
    public String getCurrentStop() {
        return currentStop;
    }
    
    public int getCurrentSize() {
        return currentSize;
    }
    
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
    
    public void setTimeNextStop(double timeNextStop) {
        this.timeNextStop = timeNextStop;
    }
    
    public double getTimeNextStop() {
        return timeNextStop;
    }
    
    public void setTimeToRest(double timeToRest) {
        this.timeToRest = timeToRest;
    }
    
    public double getTimeToRest() {
        return timeToRest;
    }
}
  
            
         
    
    

