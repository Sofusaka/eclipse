package co.edu.upb.socketcliente;
import java.util.Scanner;

public class Client {
	String opcion;
	JSocketClient sk;
	 public Scanner scanner;
	
	public Client(String address, int port) {
		sk = new JSocketClient(address, port);	
		scanner = new Scanner(System.in);
	}
	
	public void opetation(String data) {
		this.sk.request(data);
	}
	
	public void message() {
		
		
		 while (true) {
	            System.out.println("\n[Cliente]: ESCOGE UNA OPCIÓN \n1. Enviar mensaje \n2. Cerrar conexión");
	            System.out.print("Ingrese opción: ");
	            opcion = scanner.nextLine(); 

	            if (opcion.equals("1")) {
	                System.out.print("Ingrese el mensaje a enviar: ");
	                String mensaje = scanner.nextLine();
	                sk.request(mensaje); 
	            } else if (opcion.equals("2")) {
	                System.out.println("\n[Cliente]: Cerrando conexión...");
	                sk.closeService(); 
	                break;
	            } else {
	                System.out.println("[Cliente]: Opción no válida. Intente de nuevo.");
	            }
	        }
	        scanner.close(); 
	    }
		
	}


