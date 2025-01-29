
package co.edu.upb.mainserversocket;
import co.edu.upb.sockerserver.Server;

public class BankServer {
	
	public static void main(String[] args) {
		
		
		Server server= new Server(60);
		server.run();
	}

}
