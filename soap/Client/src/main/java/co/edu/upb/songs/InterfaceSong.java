package co.edu.upb.songs;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(targetNamespace = "http://songs.upb.edu.co/", name = "InterfaceSong")

public interface InterfaceSong {
	@WebMethod
	Song[] getSongByTitle(String title);
	@WebMethod
	Song[] getSongByGenre(String genre);
	@WebMethod
	Song[] getSongByAuthor(String author);

}


