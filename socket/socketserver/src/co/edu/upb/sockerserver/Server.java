package co.edu.upb.sockerserver;

public class Server {
	
	private JSocketServer sk;
	
	
	public Server(int port) {
		this.sk = new JSocketServer(port);		
	}
	

	public void run() {
		sk.listening();
	}

}
