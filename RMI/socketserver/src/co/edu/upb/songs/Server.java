package co.edu.upb.songs;
import java.rmi.RemoteException;

public class Server {
	
	private RMIServer sk;
	
	
	public Server(int port) throws RemoteException{
		this.sk = new RMIServer(port,new SongArray());		
	}
	

	public void run() {
		sk.listening();
	}

}
