//Rahul Ranjan ID# 111448179
package programs;
import java.util.*;
public class BaseballCard implements Cloneable { //This Class makes a Baseball card by setting attributes for the card. It also allows for the card's attributes
                            // to be updated by the use of the set methods. This class also allows the user to make a copy of a baseballcard and determine
                            // if a basebllcard has the same attributes of another baseball card.
    String name;
    String manufacturer;
    double year;            // These are all the stored variables
    double price;
    double[] size =  new double[2];
    double size_X;
    double size_Y;
    
    public BaseballCard() {}                //These get methods below output the atttributes of a card to the user while the set methods update attributes of a card or set
                                            // values of a new card.
    String getName() {  
        return name;
    }
    
    void setName(String name) { 
        this.name = name;
    }
    
    String getManufacturer() {
        return manufacturer;
    }
    
    void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    double getYear() {
        return year;
    }
    
    void setYear(Double year) {
        this.year = year;
    }
    
    double getPrice() {
        return price;
    }
    
    void setPrice(double price) throws Exception {
        this.price = price;
        if (price < 0.00) {
                throw new Exception("Price cannot be negative");
        }
    }
    double getSize_X() {
        return size_X;
    }
    void setSize_X(double size_X) {
        this.size_X = size_X;
    }
    double getSize_Y() {
        return size_Y;
    }
    void setSize_Y(double size_Y) {
        this.size_Y = size_Y;
    }

    
    double[] getImageSize() {
        return size;
    }
    
    void setImageSize() {
        size[0] = size_X;
        size[1] = size_Y;
    }
    
    public BaseballCard clone() throws CloneNotSupportedException {     //This method makes a copy of a baseballcard an throws an exception. 
        return (BaseballCard)super.clone();
    }
    
    public boolean equals(BaseballCard base) {      //this method determines if two baseballcards equal one another. It does this by setting all the get methods 
                                                    // equal to one another.
        System.out.println(this.getName());
        System.out.println(base.getName());
        return (base.getName().equalsIgnoreCase(this.getName())) &&
                base.getManufacturer().equalsIgnoreCase(this.getManufacturer())
                && base.getYear() == this.getYear() && 
                base.getPrice() == this.getPrice();
    }
    
    public String toString() {      //This method converts all the stored variabales to a String in order to output them all to the usesr.
        return "Name: " + name + "        " + "Manufacturer: " + manufacturer + "           " + "Year: " + year + "               " + "Price: " + price + "              "
                + "Size: " + size[0] + " x " + size[1];
    }
}

