package co.edu.upb.songs;

public class Principal {

	public static void main(String[] args) {
		
		
		SongRepository songRepository = new SongRepository();
		Server SOAP = new Server(songRepository);
		SOAP.run();
		

	}

}
