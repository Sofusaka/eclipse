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



    
   
 

