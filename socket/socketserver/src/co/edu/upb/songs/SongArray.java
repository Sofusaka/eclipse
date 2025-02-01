package co.edu.upb.songs;

import java.util.ArrayList;
import java.util.List;

public class SongArray implements InterfaceSong {
	
	
	
	public SongServer[] songs;
	
	
	
	
	 public SongServer[] setSongs() {
	        SongServer song1 = new SongServer("West Coast", "Lana Del Rey", 2011, "Rock");
	        SongServer song2 = new SongServer("Shades of Cool", "Lana Del Rey", 2011, "Rock");
	        SongServer song3 = new SongServer("World Is Mine", "Miku", 2009, "Vocaloid");
	        SongServer song4 = new SongServer("Flamboyant", "Dorian Electra", 2020, "Hyperpop");
	        SongServer song5 = new SongServer("Juicy Couture", "Ayesha Erotica", 2019, "Hyperpop");
	        SongServer song6 = new SongServer("Just Be Friends", "Miku", 2009, "Vocaloid");
	        SongServer song7 = new SongServer("Bad Romance", "Lady Gaga", 2009, "Pop");
	        SongServer song8 = new SongServer("Rolling in the Deep", "Adele", 2010, "Soul");
	        SongServer song9 = new SongServer("Life Eternal", "Ghost", 2019, "Rock");
	        SongServer song10 = new SongServer("Rosa Pastel", "Belanova", 2006, "Pop");

	        return this.songs = new SongServer[] {
	            song1, song2, song3, song4, song5,
	            song6, song7, song8, song9, song10
	        };
	    }

	
	
	@Override
	public SongServer[] getSongByTitle(String title) {
		
		return this.getSongsByMatch(title);
	}

	@Override
	public SongServer[] getSongByGenre(String genre) {
		
		
		return this.getSongsByMatch(genre);
	}

	@Override
	public SongServer[] getSongByAuthor(String author) {
		return this.getSongsByMatch(author);
	}
	
	
	//search song
	public SongServer[] getSongsByMatch(String match) {
		
		List<SongServer> matchedSongs = new ArrayList<>();

		
		 if (songs != null) {
			 for (SongServer song : songs) {
			        
			        if (song.getName().equalsIgnoreCase(match)) {
			            matchedSongs.add(song);
			        }
			    }
	        } else {
	            System.out.println("No songs have been set.");
	        }
		return matchedSongs.toArray(new SongServer[matchedSongs.size()]);
		
		
	}

}
