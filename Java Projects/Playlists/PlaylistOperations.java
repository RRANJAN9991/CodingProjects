/**
* This class implements Cloneable 
* This class is for manipulating multiple playlists. (Playlist objects)
*
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
**/
package programs;

import java.util.*;


public class PlaylistOperations implements Cloneable {
    
    public static void main(String [] arguments) {
        final int MAX_PLAYLISTS = 50;
        Playlist playlists[] = new Playlist[MAX_PLAYLISTS];
        for (int i = 0; i < playlists.length; i++) {
            playlists[i] = new Playlist();
        }
        Scanner input = new Scanner(System.in);
        char selection = ' ';
        int positionN = 0;
        System.out.println("What is the name of the first playlist? ");
        String playlistName = input.nextLine();
        playlists[positionN].setPlaylistName(playlistName);
        while (selection != 'Q') {
            System.out.println("Menu: ");
            System.out.println("A) Add Song");
            System.out.println("B) Print Songs by Artist");
            System.out.println("G) Get Song");
            System.out.println("R) Remove Song");
            System.out.println("P) Print All Songs");
            System.out.println("S) Size");
            System.out.println("Q) Quit");
            System.out.println("N) Create a new playlist and set as current playlist. ");
            System.out.println("V) Change current playlist. ");
            System.out.println("C) Copy the current playlist's songs into a new playlist. ");
            System.out.println("E) Compare the songs in the current playlist with the given playlist. ");
            System.out.println("D) Display all playlist names. ");
            System.out.println("Select a menu option: ");
            selection = input.next().charAt(0);
            if (selection == 'A') {
                SongRecord newSong = new SongRecord();
                System.out.println("Enter the song title: ");
                String title = input.nextLine();
                title = input.nextLine();
                newSong.setTitle(title);
                System.out.println("Enter the song artist: ");
                String artist = input.nextLine();
                newSong.setArtist(artist);
                System.out.println("Enter the song length (minutes): ");
                int minutes = input.nextInt();
                try {
                    newSong.setLengthMin(minutes);
                }
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
                System.out.println("Enter the song length (seconds): ");
                int seconds = input.nextInt();
                try {
                    newSong.setLengthSec(seconds);
                }
                catch(Exception exp) {
                    System.out.println(exp.getMessage());
                }
                System.out.println("Enter the position: ");
                int position = input.nextInt();
                try {
                    playlists[positionN].addSong(newSong, position);
                    System.out.println("This song has been added to the current playlist. ");
                }
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
            }
            if (selection == 'B') {
                System.out.println("Enter the artist: ");
                String artist = input.nextLine();
                artist = input.nextLine();
                Playlist newPlayList = playlists[positionN].getSongsByArtist(playlists[positionN], artist);
                newPlayList.printAllSongs();
            }
            if (selection == 'G') {
                System.out.println("Enter the position: ");
                int position = input.nextInt();
                SongRecord song = playlists[positionN].getSong(position);
                System.out.println("Song Number: " + position + " " + song.toString());
            }
            if (selection == 'R') {
                System.out.println("Enter the position: ");
                int position = input.nextInt();
                try {
                    playlists[positionN].removeSong(position);
                    System.out.println("This song has been removed from the current playlist. ");
                }
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
            }
            if (selection == 'P') {
                playlists[positionN].printAllSongs();
            }
            if (selection == 'S') {
                System.out.println("There are " + playlists[positionN].size() + " song(s) in the current playlist. ");
            }
            if (selection == 'N') {
                int sum = 0;
                int k = 0;
                System.out.println("Enter the name of the new playlist: ");
                String newPlaylist = input.nextLine();
                newPlaylist = input.nextLine();
                while (!(playlists[k].getPlaylistName().equalsIgnoreCase(""))) {
                    sum = sum + 1;
                    k = k + 1;
                    positionN = sum;
                }
               
                playlists[positionN].setPlaylistName(newPlaylist);
                System.out.println(newPlaylist + " is the new current playlist. ");
            }
            if (selection == 'V') {
                System.out.println("Enter the name of the playlist to go to: ");
                String nameOfPlaylist = input.nextLine();
                nameOfPlaylist = input.nextLine();
                for (int i = 0; i < playlists.length; i++) {
                    if (playlists[i].getPlaylistName().equalsIgnoreCase(nameOfPlaylist)) {
                        positionN = i;
                        System.out.println("The new current playlist is: " + playlists[positionN].getPlaylistName());
                        break;
                    }
                    if (i == playlists.length - 1) {
                        System.out.println("Playlist does not exist. ");
                    }
                }
            }
            if (selection == 'C') {
                int total = 0;
                int j = 0;
                System.out.println("Enter the name of the new playlist to copy songs to: ");
                String newPlaylistName = input.nextLine();
                newPlaylistName = input.nextLine();
                while (!(playlists[j].getPlaylistName().equalsIgnoreCase(""))) {
                    total = total + 1;
                    j = j + 1;
                }
                try {
                    playlists[j] = (Playlist)playlists[positionN].clone();
                    playlists[j].setPlaylistName(newPlaylistName);
                    System.out.println("The current playlist has been copied. ");
                }
                catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
            }
            if (selection == 'E') {
                System.out.println("Enter the name of the playlist to compare to the current playlist: ");
                String comparePlaylist = input.nextLine();
                comparePlaylist = input.nextLine();
                int target = 0;
                for (int i = 0; i < playlists.length; i++) {
                    if (playlists[i].getPlaylistName().equalsIgnoreCase(comparePlaylist)) {
                        target = i;
                        break;
                    }
                    if (i == playlists.length - 1) {
                        System.out.println("Playlist does not exist. ");
                    }
                }
                boolean same = playlists[positionN].equals(playlists[target]);
                if (same == true) {
                    System.out.println("Current playlist and given playlist are the same. ");
                }
                else {
                    System.out.println("Current playlist and given playlist are not the same. ");
                }
            }
            if (selection == 'D') {
                int p = 0;
                while (!(playlists[p].getPlaylistName().equalsIgnoreCase(""))){
                    System.out.println("Playlist " + (p + 1) + " : " + playlists[p].getPlaylistName());
                    p = p + 1;
                }
            }
        }
        System.out.println("Program terminating gracefully... ");
    }
}

