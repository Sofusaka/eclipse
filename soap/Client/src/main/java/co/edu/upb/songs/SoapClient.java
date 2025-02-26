package co.edu.upb.songs;

import java.util.Scanner;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class SoapClient {
    
    
    private final Scanner scanner;
    
    //se declara la interfaz x fuera para que pueda ser usada en los metodos de la clase!!
    private InterfaceSong service;

    public SoapClient() throws MalformedURLException {
        this.scanner = new Scanner(System.in);
        this.setup();
    }
    
    // Configuración del cliente SOAP
    public void setup() throws MalformedURLException {
        
       
		URL wsdlURL = new URL("http://localhost:80/song?wsdl");
        
        
        QName servQName = new QName("http://songs.upb.edu.co/", "SongService");
        QName portQName = new QName("http://songs.upb.edu.co/", "SongPort");
        
        
        Service soapService = Service.create(wsdlURL, servQName);
        service = soapService.getPort(portQName, InterfaceSong.class);
    }
    
    
    public void request() {
        System.out.println("\n[Cliente]: Consulta de canciones");
        System.out.println("Seleccione el tipo de consulta:");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por género");
        System.out.println("3. Buscar por autor");
        System.out.print("Ingrese opción: ");
        String choice = scanner.nextLine();

        String searchTerm;
        Song[] results = null;
        
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
            for (Song song : results) {
                System.out.println(song.getSong());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("\n[Cliente]: No se encontraron canciones con el criterio especificado.");
        }
    }
    
    
}
