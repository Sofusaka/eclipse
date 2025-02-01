package co.edu.upb.songs;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JSocketServer {
    private int port;
    private ServerSocket serverSk;
    private Socket clientSk;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public SongArray songs;  

    public JSocketServer(int port) {
        try {	
            this.port = port;
            this.serverSk = new ServerSocket(port, 100);
            this.oos = null;
            this.ois = null;
            
            this.songs = new SongArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void listening() {
        try {
            
            songs.setSongs();
            
            System.out.println("\n[Server]: Esperando conexión...");
            this.clientSk = this.serverSk.accept();
            this.oos = new ObjectOutputStream(this.clientSk.getOutputStream());
            this.oos.flush();
            this.ois = new ObjectInputStream(this.clientSk.getInputStream());
            System.out.println("\n[Server]: Conexión exitosa con el cliente.");

            while (true) {
                try {
                    Object receivedObj = this.ois.readObject();
                    if (receivedObj == null) {
                        System.out.println("\n[Server]: Cliente desconectado.");
                        closeService();
                        break;
                    }
                   
                    if (receivedObj instanceof String) {
                        String received = (String) receivedObj;
                        
                       
                        if (received.equalsIgnoreCase("title") ||
                            received.equalsIgnoreCase("genre") ||
                            received.equalsIgnoreCase("author")) {
                            
                            
                            Object searchObj = this.ois.readObject();
                            if (searchObj instanceof String) {
                                String searchTerm = (String) searchObj;
                                System.out.println("[Server]: Consulta recibida - Tipo: " 
                                        + received + ", Valor: " + searchTerm);
                                
                                // Determine which query to perform
                                SongServer[] result = null;
                                if (received.equalsIgnoreCase("title")) {
                                    result = this.songs.getSongByTitle(searchTerm);
                                } else if (received.equalsIgnoreCase("genre")) {
                                    result = this.songs.getSongByGenre(searchTerm);
                                } else if (received.equalsIgnoreCase("author")) {
                                    result = this.songs.getSongByAuthor(searchTerm);
                                }
                                
                                sendSongs(result);
                            } else {
                                System.out.println("[Server]: El objeto de búsqueda no es una cadena.");
                            }
                        } else {
                           
                            ZonedDateTime fechaHoraZona = ZonedDateTime.now(ZoneId.systemDefault());
                            System.out.println("[Server]: HE RECIBIDO " + received + " A LAS " + fechaHoraZona);
                            send("Escuche esto: " + received + " a las: " + fechaHoraZona);
                        }
                    }
                } catch (EOFException e) {
                    System.out.println("\n[Server]: El cliente cerró la conexión. ERROR EOFException.");
                    closeService();
                    break; 
                } catch (IOException e) {
                    System.out.println("\n[Server]: Error en la conexión con el cliente. ERROR IOException.");
                    closeService();
                    break; 
                } catch (ClassNotFoundException e) {
                    System.out.println("\n[Server]: Error al leer el objeto.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void closeService() {
        try {
            if (this.ois != null) this.ois.close();
            if (this.oos != null) this.oos.close();
            if (this.clientSk != null) this.clientSk.close();
            System.out.println("\n[Server]: Conexión cerrada correctamente.");
        } catch (IOException e) {
            System.out.println("\n[Server]: No se pudo cerrar la conexión correctamente.");
        }
    }
    
    private void send(String data) {
        try {
            this.oos.writeObject("[Server]: " + data);
            this.oos.flush();
        } catch (IOException e) {
            System.out.println("\n[Server]: No se puede enviar la data.");
        }
    }
    
    private void sendSongs(SongServer[] data) {
        try {
            System.out.println("enviando canciones....");
            this.oos.writeObject(data);
            this.oos.flush();
        } catch (IOException e) {
            System.out.println("\n[Server]: No se puede enviar las canciones.");
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
