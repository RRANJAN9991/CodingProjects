/**
* The  class implements Cloneable.
* This class holds and creates a Playlist object which contains an array of SongRecord objects.
*
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
**/
package programs;
import java.lang.*;
public class Playlist implements Cloneable {

    SongRecord[] songs;
    String name;
    final int MAX_SONGS = 50;
    
    /**
    * SongRecord[] songs contains array of SongRecord objects.
    * String name represents the name of the playlist.
    * final int MAX_SONGS is equal to 50 and represents the size of the SongRecord array.
    */
    
    /**
    * Returns an instance of Playlist 
    * Initializes array called songs.
    */
    public Playlist() {
        songs = new SongRecord[MAX_SONGS+1];
        name = "";
    }
    
    /**
    * Sets the name of the playlist.
    * @param name 
    * A string representing the name of the playlist.
    * PostCondition : name gets set.
    */
    public void setPlaylistName(String name) {
        this.name = name;
    }
    
    /**
    * Gets the name of the playlist.
    * @return 
    * A string representing the name of the playlist.
    */
    public String getPlaylistName() {
        return name;
    }
    
    /** 
    * Creates a copy of the current Playlist object.
    * @return
    * A Playlist object which is the copy of the current Playlist object.
    * @throws CloneNotSupportedException 
    * Indicates that cloning is not supported.
    * PreCondition : All songs by specific artist in one playlist is added to newly created playlist.
    */
    @Override
    protected Object clone() throws CloneNotSupportedException {     
        Playlist playlist = (Playlist)super.clone();
        for (int i = 1; i < songs.length; i++) {
            playlist.songs = (SongRecord[])songs.clone();
        }
        return (Playlist)playlist;
    }
    
    /**
    * Determines whether or not the current Playlist object is equal to the Playlist object in the parameter. (Same attributes)
    * @param obj
    * A Playlist object that will be used in a comparison with the current Playlist object.
    * @return 
    * True if both Playlist objects are equal. False if both Playlist objects are not equal.
    */
    public boolean equals(Playlist obj) {
        boolean same = false;
        int i = 1;
        while (songs[i] != null) {
            if (obj.songs[i].getArtist().equalsIgnoreCase(this.songs[i].getArtist()) && obj.songs[i].getTitle().equalsIgnoreCase(this.songs[i].getTitle()) &&
            obj.songs[i].getLengthMin() == this.songs[i].getLengthMin() && obj.songs[i].getLengthSec() == this.songs[i].getLengthSec()) {
                same = true;
            }
            else {
                same = false;
                break;
            }
            i = i + 1;
        }
        return same;
    }
    
    /**
    * Determines the number of songs in the playlist. 
    * @return 
    * An int sum that represents the number of songs in the playlist.
    */
    public int size() {
        int sum = 0;
        for (int i = 1; i < songs.length; i++) {
            if (songs[i] != null) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    
    /**
     * Adds a SongRecord object to a specific position in the playlist.
     * @param song
     * A SongRecord object with attributes to be added to the playlist.
     * @param position
     * An int that determines where the SongRecord object will be placed in the playlist.
     * @throws IllegalArgumentException
     * Indicates position is less than 0 or greater than or equal to the total number of songs in the playlist + 1.
     * @throws FullPlaylistException 
     * Indicates the playlist is full. (>=50)
     * PreConditions : position is greater than 0 and less than total number of songs in playlist + 1.
     * PostCondition : Song is recorded into proper position and other songs after this song are shifted up the array by 1.
     */
    public void addSong(SongRecord song, int position) throws IllegalArgumentException, FullPlaylistException{
        int newPosition = 0;
        if (this.size() < 50) {
            if (position > 0 & position < this.size() + 1) {
                if (songs[position] != null) {
                    for (int i = position; i < songs.length; i++) {     
                        if (songs[i] == null) {
                            newPosition = i;
                            break;
                        }
                    }
                    for (int i = newPosition; i > position; i--) {
                        songs[i] = songs[i-1];
                        songs[i-1] = null;
                        
                    } 
                    songs[position] = song;
                }
                else {
                    songs[position] = song;
                }
            }
            else if (position == this.size() + 1) {
                songs[position] = song;
            }
            else {        
                throw new IllegalArgumentException("Position is not within the valid range. ");
            }
        }
        else {
            throw new FullPlaylistException("There is no more room inside playlist to add songs. ");    
        }
    }
    
    /**
    * Removes a SongRecord object from the playlist. 
    * @param position
    * An int that determines the SongRecord to be removed. (Based off position)
    * @throws IllegalArgumentException 
    * Indicates position is less than 0 or greater than equal to total number of SongRecord objects in playlist + 1.
    * PreCondition : Position is greater than 0 and less than the total number of songs in the playlist  + 1.
    * PostCondition : The song in the given position is removed from the playlist and all songs after this song are moved
    * down one in the array.
    */
    public void removeSong(int position) throws IllegalArgumentException {
        if (this.size() < 50)
        if (position > 0 & position < this.size() + 1) {   
            if (songs[position] == null) {
                System.out.println("No song at position " + position + " to remove. ");
            }
            else {
                songs[position] = null;
            }
            for (int i = position; i < songs.length - 1; i++) {
                songs[i] = songs[i+1];
                songs[i+1] = null;
            }
        }
        else {
            throw new IllegalArgumentException("Position is not within the valid range. ");
        }
    }
    
    /**
    * Gets a SongRecord in the position given. 
    * @param position
    * An int that determines which SongRecord object to get from the playlist. (Based off position)
    * @return
    * A SongRecord object in the position given.
    * @throws IllegalArgumentException 
    * Indicates position is less than 0 or position is greater than or equal to 51.
    * PreCondition : position is greater than 0 and less than 51.
    */
    public SongRecord getSong(int position) throws IllegalArgumentException {     
   
        if (position > 0 & position < 51) {
            return songs[position];
        }
        else {
            throw new IllegalArgumentException("Position is not within the valid range. ");
        }
    }
    /**
    * Prints the attributes of all SongRecord objects in the array. 
    * PostCondition : all songs' attributes are printed.
    */
    public void printAllSongs() {
        for (int i = 1; i < songs.length; i++) {
            if (songs[i] != null) {
                System.out.println("Song Number: " + i +  " " + songs[i].toString());
            }
            if (songs[1] == null) {
                System.out.println("No songs exist in this playlist. ");
                break;
            }
        }
    }
    
    /**
    * Inserts all SongRecord objects with the given attribute (String artist) and 
    * inserts them into a new Playlist.
    * @param originalList
    * A Playlist object that contains SongRecord objects.
    * @param artist
    * A String that represents the artist of a song.
    * @return 
    * A Playlist object that contains the SongRecord objects with the same attribute. (String artist)
    */
    public static Playlist getSongsByArtist(Playlist originalList, String artist) {
        Playlist newPlaylist = new Playlist();
        int position = 0;
        for (int i = 1; i < originalList.size() + 1; i++) {
            if (originalList.songs[i].getArtist().equalsIgnoreCase(artist)) {
                position = position + 1;
                try {
                    newPlaylist.addSong(originalList.songs[i], position);
                }
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
            }
        }
        return newPlaylist;
    }
}
