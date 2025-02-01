package co.edu.upb.songs;

public interface InterfaceSong {
	
	SongServer[] getSongByTitle(String title);
	SongServer[] getSongByGenre(String genre);
	SongServer[] getSongByAuthor(String author);

}
