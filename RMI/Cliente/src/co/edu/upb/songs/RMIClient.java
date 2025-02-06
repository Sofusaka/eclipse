package co.edu.upb.songs;


import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class RMIClient {

		 private final String addressName;
		 private final Scanner scanner;
		 public RMIClient(String address, int port) {
		 this.scanner = new Scanner(System.in);
		 this.addressName = "rmi://127.0.0.1:1802/song";
		 }
    

    
    public void request() {
        try {
            
        	
        	//con esto se invoca al server!!
        	InterfaceSong service = (InterfaceSong) Naming.lookup(this.addressName);
        	
        	System.out.println("\n[Cliente]: Consulta de canciones");
            System.out.println("Seleccione el tipo de consulta:");
            System.out.println("1. Buscar por título");
            System.out.println("2. Buscar por género");
            System.out.println("3. Buscar por autor");
            System.out.print("Ingrese opción: ");
            String choice = scanner.nextLine();

            String searchTerm = "";
            SongServer[] results = null;

            switch (choice) {
                case "1":
                    System.out.print("Ingrese el título a buscar: ");
                    searchTerm = scanner.nextLine();
                    results = service.getSongByTitle(searchTerm);
                    break;
                case "2":
                    System.out.print("Ingrese el género a buscar: ");
                    searchTerm = scanner.nextLine();
                    results = service.getSongByGenre(searchTerm);
                    break;
                case "3":
                    System.out.print("Ingrese el autor a buscar: ");
                    searchTerm = scanner.nextLine();
                    results = service.getSongByAuthor(searchTerm);
                    break;
                default:
                    System.out.println("[Cliente]: Opción no válida.");
                    return;
            }

            if (results != null && results.length > 0) {
                System.out.println("\n[Cliente]: Se encontraron las siguientes canciones:");
                for (SongServer song : results) {
                    System.out.println(song.getSong());
                    System.out.println("---------------------");
                }
            } else {
                System.out.println("\n[Cliente]: No se encontraron canciones con el criterio especificado.");
            }
        }catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }

    
   
}
