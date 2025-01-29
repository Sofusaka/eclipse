package co.edu.upb.sockerserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.io.EOFException;

public class JSocketServer {
    private int port;
    private ServerSocket serverSk;
    private Socket clientSk;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public JSocketServer(int port) {
        try {
            this.port = port;
            this.serverSk = new ServerSocket(port, 100);
            this.oos = null;
            this.ois = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listening() {
        try {
            System.out.println("\n[Server]: Esperando conexión...");
            this.clientSk = this.serverSk.accept();
            this.oos = new ObjectOutputStream(this.clientSk.getOutputStream());
            this.oos.flush();
            this.ois = new ObjectInputStream(this.clientSk.getInputStream());
            System.out.println("\n[Server]: Conexión exitosa con el cliente.");

            while (true) {
                try {
                    String data = (String) this.ois.readObject();
                    
                    if (data == null) {
                        System.out.println("\n[Server]: Cliente desconectado.");
                        closeService();
                        break; 
                    } else {
                        
                        ZonedDateTime fechaHoraZona = ZonedDateTime.now(ZoneId.systemDefault());
                        System.out.println("[Server]: HE RECIBIDO " + data + " A LAS " + fechaHoraZona);
                        send("Escuche esto: " + data + " a las: " + fechaHoraZona);
                    }
                } catch (EOFException e) {
                	
                	// El cliente cierra la conexion de manera esperada pero el server intenta leer mas datos
                    System.out.println("\n[Server]: El cliente cerró la conexión. ERROR EOFException. Se intentaron leer mas datos despues de desconexion del cliente.");
                    closeService();
                    break; 
                } catch (IOException e) {
                	
                	//El cliente cierra la conexion abrupta.
                    System.out.println("\n[Server]: Error en la conexión con el cliente. ERROR IOException. Desconexion del cliente abrupta.");
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
