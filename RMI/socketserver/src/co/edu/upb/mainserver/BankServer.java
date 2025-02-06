
package co.edu.upb.mainserver;
import co.edu.upb.songs.Server;
import java.rmi.RemoteException;

public class BankServer {
	
	public static void main(String[] args) throws RemoteException {
		
		
		Server server= new Server(60);
		server.run();
	}

}
