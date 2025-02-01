package co.edu.upb.songs;

import java.io.Serializable;

public class SongServer implements Serializable{
	private static final long serialVersionUID = 1L;
    
    private String name;
    private String author;
    private int year;
    private String genre;
    public SongServer[] songs;
    
    public SongServer(String name, String author, int year, String genre) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public String getAuthor() {
        return author;
    }
    
   
    public int getYear() {
        return year;
    }
    
    
    public String getGenre() {
        return genre;
    }
    
    
    public String getSong() {
        return "Song: " + name + "\n" +
               "Author: " + author + "\n" +
               "Year: " + year + "\n" +
               "Genre: " + genre;
    }
    
    
    public SongServer[] setSongs() {
        SongServer song1 = new SongServer("West Coast", "Lana Del Rey", 2011, "Rock");
        SongServer song2 = new SongServer("Shades of Cool", "Lana Del Rey", 2011, "Rock");
        SongServer song3 = new SongServer("World Is Mine", "Miku", 2009, "Vocaloid");
        SongServer song4 = new SongServer("Flamboyant", "Dorian Electra", 2020, "Hyperpop");
        SongServer song5 = new SongServer("Juicy Couture", "Ayesha Erotica", 2019, "Hyperpop");
        SongServer song6 = new SongServer("Just Be Friends", "Miku", 2009, "Vocaloid");
        SongServer song7 = new SongServer("Bad Romance", "Lady Gaga", 2009, "Pop");
        SongServer song8 = new SongServer("Rolling in the Deep", "Adele", 2010, "Soul");
        SongServer song9 = new SongServer("Bohemian Rhapsody", "Queen", 1975, "Rock");
        SongServer song10 = new SongServer("Imagine", "John Lennon", 1971, "Soft Rock");

        return this.songs = new SongServer[] {
            song1, song2, song3, song4, song5,
            song6, song7, song8, song9, song10
        };
    }
    
    
    public SongServer[] getSongs() {
        return this.songs;
    }
    
    public void printSongs() {
        if (songs != null) {
            for (SongServer song : songs) {
                System.out.println(song.getSong());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No songs have been set.");
        }
    }
}



    
   
 

