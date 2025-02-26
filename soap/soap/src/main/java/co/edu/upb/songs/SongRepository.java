package co.edu.upb.songs;

import java.util.ArrayList;
import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;




@WebService(
        endpointInterface = "co.edu.upb.songs.InterfaceSong",
        serviceName = "SongService",
        portName = "SongPort",
        targetNamespace = "http://songs.upb.edu.co/"
)
public class SongRepository  implements InterfaceSong {
	
	
	 

	public Song[] songs;
	
	
	public SongRepository() {
       
        this.setSongs();
    }
	
	
	 public Song[] setSongs() {
	        Song song1 = new Song("West Coast", "Lana Del Rey", 2011, "Rock");
	        Song song2 = new Song("Shades of Cool", "Lana Del Rey", 2011, "Rock");
	        Song song3 = new Song("World Is Mine", "Miku", 2009, "Vocaloid");
	        Song song4 = new Song("Flamboyant", "Dorian Electra", 2020, "Hyperpop");
	        Song song5 = new Song("Juicy Couture", "Ayesha Erotica", 2019, "Hyperpop");
	        Song song6 = new Song("Just Be Friends", "Miku", 2009, "Vocaloid");
	        Song song7 = new Song("Bad Romance", "Lady Gaga", 2009, "Pop");
	        Song song8 = new Song("Rolling in the Deep", "Adele", 2010, "Soul");
	        Song song9 = new Song("Life Eternal", "Ghost", 2019, "Rock");
	        Song song10 = new Song("Rosa Pastel", "Belanova", 2006, "Pop");

	        return this.songs = new Song[] {
	            song1, song2, song3, song4, song5,
	            song6, song7, song8, song9, song10
	        };
	    }

	
	@WebMethod
	@Override
	public Song[] getSongByTitle(String name) {
		
		return this.getSongsByMatch(name, "name");
	}
	
	@WebMethod
	@Override
	public Song[] getSongByGenre(String genre) {
		
		
		return this.getSongsByMatch(genre, "genre");
	}

	@WebMethod
	@Override
	public Song[] getSongByAuthor(String author) {
		return this.getSongsByMatch(author, "author");
	}
	
	
	//search song
	public Song[] getSongsByMatch(String match, String field) {
	    List<Song> matchedSongs = new ArrayList<>();
	    
	    if (songs != null) {
	        for (Song song : songs) {
	            switch(field.toLowerCase()) {
	                case "name":
	                    if (song.getName().equalsIgnoreCase(match)) {
	                        matchedSongs.add(song);
	                    }
	                    break;
	                case "genre":
	                    if (song.getGenre().equalsIgnoreCase(match)) {
	                        matchedSongs.add(song);
	                    }
	                    break;
	                case "author":
	                    if (song.getAuthor().equalsIgnoreCase(match)) {
	                        matchedSongs.add(song);
	                    }
	                    break;
	                default:
	                   
	                    break;
	            }
	        }
	    } else {
	        System.out.println("No songs have been set.");
	    }
	    return matchedSongs.toArray(new Song[matchedSongs.size()]);
	}


}
