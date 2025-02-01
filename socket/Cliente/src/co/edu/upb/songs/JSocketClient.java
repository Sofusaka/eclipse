package co.edu.upb.songs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class JSocketClient implements InterfaceSong {

    private InetAddress address;
    private int port;
    private Socket clientSk;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public JSocketClient(String address, int port) {
        try {
            this.port = port;
            this.address = InetAddress.getByName(address);
            this.oos = null;
            this.ois = null;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Ensures that the socket connection and the associated streams are open.
     */
    private void initConnection() throws IOException {
        if (this.clientSk == null || this.clientSk.isClosed()) {
            this.clientSk = new Socket(this.address, this.port);
            this.oos = new ObjectOutputStream(this.clientSk.getOutputStream());
            this.oos.flush();
            this.ois = new ObjectInputStream(this.clientSk.getInputStream());
            System.out.println("\n[Client]: Conexión exitosa.");
        }
    }

    // Sends a simple message to the server.
    public void request(String data) {
        try {
            // Ensure connection is open
            initConnection();
            
            send(data); // Send message

            try {
                String response = (String) this.ois.readObject();
                if (response != null) {
                    System.out.println("\n[Client]: El servidor dice: " + response);
                } else {
                    System.out.println("\n[Client]: El servidor cerró la conexión.");
                    closeService();
                }
            } catch (Exception e) {
                System.out.println("\n[Client]: No se pudo recibir la data. " + e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(String data) {
        try {
            this.oos.writeObject("[Client]: " + data);
            this.oos.flush();
        } catch (Exception e) {
            System.out.println("\n[Client]: No se puede enviar la data.");
        }
    }
    
    public void closeService() {
        try {
            if (this.ois != null) this.ois.close();
            if (this.oos != null) this.oos.close();
            if (this.clientSk != null) this.clientSk.close();
            System.out.println("\n[Client]: Conexión terminada.");
        } catch (Exception e) {
            System.out.println("\n[Client]: No se puede cerrar la conexión.");
        }
    }
    
    
    public SongServer[] songQuery(String type, String value) {
        try {
            
            initConnection();
            
            
            this.oos.writeObject(type);
            this.oos.writeObject(value);
            this.oos.flush();
            
           
            Object obj = this.ois.readObject();
            System.out.println("Raw returned object: " + obj);
            System.out.println("Received object class: " + obj.getClass().getName());
            if (obj instanceof SongServer[]) {
                SongServer[] songs = (SongServer[]) obj;
                System.out.println("\n[Client]: Received songs:");
                for (SongServer song : songs) {
                    System.out.println(song.getSong());
                    System.out.println("---------------------");
                }
                return songs;
            }
        } catch (Exception e) {
            System.out.println("\n[Client]: No se puede enviar la data. " + e);
        }
        return null;
    }

    
    @Override
    public SongServer[] getSongByTitle(String title) {
        return songQuery("title", title);
    }

    @Override
    public SongServer[] getSongByGenre(String genre) {
        return songQuery("genre", genre);
    }

    @Override
    public SongServer[] getSongByAuthor(String author) {
        return songQuery("author", author);
    }
}
