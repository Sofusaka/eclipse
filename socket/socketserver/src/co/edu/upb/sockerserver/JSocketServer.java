package co.edu.upb.sockerserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
			String data;
			System.out.println("\n [Server]: " + "Esperando.");
			this.clientSk = this.serverSk.accept();
			this.oos = new ObjectOutputStream(this.clientSk.getOutputStream());
			this.oos.flush();
			this.ois = new ObjectInputStream(this.clientSk.getInputStream());
			System.out.println("\n [Server]: " + "Conexión exitosa.");
			while(true) {
				try {
					data = (String) this.ois.readObject();
					if (data == null) {
						closeService();
					} else {
						send("Escuche esto: " + data); 
					}
				} catch (Exception e) {
					System.out.println("\n [Server]: No se puede recibir la data.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeService() {
		try {
			this.ois.close();
			this.oos.close();
			this.clientSk.close();
			this.serverSk.close();
			System.out.println("\n [Server]: Conexión terminada.");
		} catch (Exception e) {
			System.out.println("\n [Server]: No se puede cerrar la conexión.");
		}
	}
	
	private void send(String data) {
		try {
			this.oos.writeObject("[Server]: " + data);
			this.oos.flush();
		} catch (Exception e) {
			System.out.println("\n [Server]: No se puede enviar la data.");
		}
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}