/**
* The  class extends Exception.
* This class creates a FullPlaylistException for other classes to use when
* a playlist is full of SongRecord objects.
*
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
**/
package programs;

public class FullPlaylistException extends Exception{
    public FullPlaylistException(String message) {
        super(message);
    }
}
