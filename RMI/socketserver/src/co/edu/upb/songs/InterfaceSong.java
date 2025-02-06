package co.edu.upb.songs;
import java.rmi.Remote;
import java.rmi.RemoteException;



public interface InterfaceSong extends Remote{
	
	SongServer[] getSongByTitle(String title) throws RemoteException;
	SongServer[] getSongByGenre(String genre) throws RemoteException;
	SongServer[] getSongByAuthor(String author)throws RemoteException;

}


