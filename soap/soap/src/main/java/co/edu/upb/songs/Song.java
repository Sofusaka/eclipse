package co.edu.upb.songs;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement(name = "song")
@XmlType(propOrder = {"name", "genre", "author", "year", "songs"}) 
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String author;
    private int year;
    private String genre;
    
    
    private Song[] songs;  
    
    public Song() {
    }
    
    public Song(String name, String author, int year, String genre) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }
    
    @XmlElement
    public String getName() {
        return name;
    }
    
    @XmlElement
    public String getAuthor() {
        return author;
    }
    
    @XmlElement
    public int getYear() {
        return year;
    }
    
    @XmlElement
    public String getGenre() {
        return genre;
    }
    
    
    public String getSong() {
        return "Song: " + name + "\n" +
               "Author: " + author + "\n" +
               "Year: " + year + "\n" +
               "Genre: " + genre;
    }
    
    @XmlElement
    public Song[] getSongs() {
        return this.songs;
    }
    
    
    public void printSongs() {
        if (songs != null) {
            for (Song song : songs) {
                System.out.println(song.getSong());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No songs have been set.");
        }
    }
    
    
    public void setSongs(Song[] songs) {
        this.songs = songs;
    }
}

