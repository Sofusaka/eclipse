package co.edu.upb.songs;

import java.util.Scanner;

public class Client {
    String opcion;
    JSocketClient sk;
    public Scanner scanner;

    public Client(String address, int port) {
        sk = new JSocketClient(address, port);
        scanner = new Scanner(System.in);
    }

    public void operation(String data) {
        this.sk.request(data);
    }

    public void message() {
        while (true) {
            System.out.println("\n[Cliente]: ESCOGE UNA OPCIÓN ");
            System.out.println("1. Enviar mensaje");
            System.out.println("2. Consultar canciones (por título, género o autor)");
            System.out.println("3. Cerrar conexión");
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Ingrese el mensaje a enviar: ");
                String mensaje = scanner.nextLine();
                sk.request(mensaje);
            } else if (opcion.equals("2")) {
                querySongs();
            } else if (opcion.equals("3")) {
                System.out.println("\n[Cliente]: Cerrando conexión...");
                sk.closeService();
                break;
            } else {
                System.out.println("[Cliente]: Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private void querySongs() {
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
                results = sk.getSongByTitle(searchTerm);
                break;
            case "2":
                System.out.print("Ingrese el género a buscar: ");
                searchTerm = scanner.nextLine();
                results = sk.getSongByGenre(searchTerm);
                break;
            case "3":
                System.out.print("Ingrese el autor a buscar: ");
                searchTerm = scanner.nextLine();
                results = sk.getSongByAuthor(searchTerm);
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
    }
}
