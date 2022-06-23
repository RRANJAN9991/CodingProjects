
package programs;

/**
* This class holds and creates an ItemInfo object which contains multiple attributes of an item.
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
**/

public class ItemInfo {
    
    /** 
    * productName is a String that represents the name of a product/item.
    * productPrice is a double that represents the price of a product/item.
    * rfidTagNumber is a String that represents the RFID of a product/item.
    * originalLocation is a String that represents the original location of a product/item.
    * currentLocation is a String that represents the current location of a product/item.
    */
    
    String productName;
    double productPrice;
    String rfidTagNumber;
    String originalLocation;
    String currentLocation;
    
    /**
    * ItemInfo() is a constructor that creates an ItemInfo object. (No Parameters or initializations)
    */
    
    public ItemInfo(){}
    
    /**
    * setProductName() sets the name of a product/item. 
    * @param productName 
    * A String representing the name of a product/item.
    * PostCondition : productName gets set.
    */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    /**
    * getProductName() gets the name of a product/item. 
    * @return 
    * A String representing the name of a product/item.
    */
   
    public String getProductName() {
        return productName;
    }
    
    /**
    * setProductPrice() sets the price of a product/item. 
    * @param productPrice 
    * A double representing the price of a product/item.
    * PostCondition : productPrice gets set.
    */
    
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    
    /**
    * getProductPrice() gets the price of a product/item. 
    * @return 
    * A double representing the price of a product/item.
    */
    
    public double getProductPrice() {
        return productPrice;
    }
    
    /**
    * setRfidTagNumber() sets the RFID of a product/item. 
    * @param rfidTagNumber 
    * A String representing the RFID of a product/item.
    * @throws NumberFormatException, Exception
    * Indicates rfidTgNumber parameter contains invalid characters (see PreCondition) or length of this string is not equal to 9.
    * PreCondition : rfidTagNumber contains exactly 9 characters of which are either between A and F (including A and F) or 
    * are between 0 and 9 (including 0 and 9).
    * PostCondition : rfidTagNumber gets set.
    */
    
    public void setRfidTagNumber(String rfidTagNumber) throws NumberFormatException, Exception{
        
        try {
            Long.parseLong(rfidTagNumber, 16);
            if (rfidTagNumber.length() != 9) {
                throw new Exception("The length of the RFID must be exactly 9 characters. ");
            }
            this.rfidTagNumber = rfidTagNumber;
        }
        catch (NumberFormatException exp) {
            System.out.print("Invalid input for RFID. ");
        }
        
    }
    
    /**
    * getRfidTagNumber() gets the RFID of a product/item. 
    * @return 
    * A String representing the RFID of a product/item.
    */
    
    public String getRfidTagNumber() {
        return rfidTagNumber;
    }
    
    /**
    * setOriginalLocation() sets the original location of a product/item. 
    * @param originalLocation
    * A String representing the original location of a product/item.
    * @throws Exception, Exception
    * Indicates originalLocation parameter contains invalid characters (see PreCondition) or length of this string is not equal to 6.
    * PreCondition : originalLocation contains exactly 6 characters of which the first character in this string is either S or s and the remaining 
    * 5 characters are digits between 0 and 9 (including 0 and 9).
    * PostCondition : originalLocation gets set.
    */
    
    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
    }
    
    /**
    * getOriginalLocation() gets the original location of a product/item. 
    * @return 
    * A String representing the original location of a product/item.
    */
    
    public String getOriginalLocation() {
        return originalLocation;
    }
    
     /**
    * setCurrentLocation() sets the current location of a product/item. 
    * @param currentLocation
    * A String representing the current location of a product/item.
    * @throws Exception, Exception
    * Indicates currentLocation parameter contains invalid characters. (see PreCondition)
    * PreCondition : currentLocation contains characters C, c, s, or S and the remaining 
    * characters are digits between 0 and 9 (including 0 and 9). Also, currentLocation could be "out".
    * PostCondition : currentLocation gets set.
    */
    
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    /**
    * getCurrentLocation() gets the current location of a product/item. 
    * @return 
    * A String representing the current location of a product/item.
    */
    
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    /**
    * hexToDec() determines the decimal value of the rfidTagNumber of a product/item. (RFID) 
    * @return 
    * A long representing the decimal value of the rfidTagNumber of a product/item. (RFID)
    */
    
    public long hexToDec() {
        return Long.parseLong(this.rfidTagNumber, 16);
    }
}