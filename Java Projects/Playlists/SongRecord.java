/**
* The  class implements Cloneable.
* This class holds and creates a SongRecord object and contains accessor and mutator methods to 
* to change and return its attributes. 
*
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
**/
package programs;

public class SongRecord implements Cloneable{

    String title, artist;
    int lengthMin, lengthSec;
    
    /**
    * String title represents the title of a song.
    * String artist represents the the artist of a song.
    * int lengthMin represents the length in minutes of a song.
    * int lengthSec represents the length in seconds of a song.
     */
    
    /**
    * Returns an instance of SongRecord.
     */
    public SongRecord() {
        artist = "";
    }
    
    /**
    * Sets the title of the song.
    * @param title 
    * A string representing the title of the song.
    * PostCondition : title gets set.
    */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
    * Gets the title of the song.
    * @return 
    * A string representing the title of the song.
    */
    public String getTitle() {
        return title;
    }
    
    /**
    * Sets the artist of the song.
    * @param artist 
    * A string representing the artist of the song.
    * PostCondition : artist gets set.
    */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    /**
    * Gets the artist of the song.
    * @return 
    * A string representing the artist of the song.
    */
    public String getArtist() {
        return artist;
    }
    
    /**
    * Sets the length in minutes of the song.
    * @param lengthMin 
    * An int representing the length in minutes of the song.
    * @exception Exception
    * Indicates lengthMin is less than 0. (Negative)
    * PreCondition : lengthMin >= 0
    * PostCondition: lengthMin gets set.
    */
    public void setLengthMin(int lengthMin) throws Exception{
        if (lengthMin < 0) {
            throw new Exception("Length in minutes cannot be negative. ");
        }
        this.lengthMin = lengthMin;
    }
    
    /**
    * Gets the length in minutes of the song.
    * @return 
    * An int representing the length in minutes of the song.
    */
    public int getLengthMin() {
        return lengthMin;
    }
    
    /**
    * Sets the length in seconds of the song.
    * @param lengthSec 
    * An int representing the length in seconds of the song.
    * @exception Exception
    * Indicates lengthSec is less than 0 or greater than 59.
    * PreCondition : lengthSec is >= to 0 and <=59.
    * PostCondition : lengthSec gets set.
    */
    public void setLengthSec(int lengthSec) throws Exception{
        if (lengthSec < 0 || lengthSec > 59) {
            throw new Exception("Length in seconds must be between 0 and 60. ");
        }
        this.lengthSec = lengthSec;
    }
    
    /**
    * Gets the length in seconds of the song.
    * @return 
    * An int representing the length in seconds of the song.
    */
    public int getLengthSec() {
        return lengthSec;
    }
    
    /**
    * Gives the string representation of all the song's attributes.
    * @return 
    * A String representing all the attributes of a song.
    */
    public String toString() {
    return "Title: " + title + "     Artist: " + artist + "        Length: " + lengthMin + " : " + lengthSec;
    }
}
