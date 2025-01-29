package co.edu.upb.socketcliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class JSocketClient {

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

	public void request(String data) {
		try {
			this.clientSk = new Socket(this.address, this.port);
			this.oos = new ObjectOutputStream(this.clientSk.getOutputStream());
			this.oos.flush();
			this.ois = new ObjectInputStream(this.clientSk.getInputStream());
			System.out.println("\n [Client]: Conexión exitosa.");
			send(data);
			while(true) {
				try {
					data = (String) this.ois.readObject();
					if (data == null) {
						closeService();
					} else {
						System.out.println("\n [Client]: el servidor dice:" + data);
					}
				} catch (Exception e) {
					System.out.println("\n [Client]: No se puede recibir la data.");
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}

	private void send(String data) {
		try {
			this.oos.writeObject("[Client]: " + data);
			this.oos.flush();
		} catch (Exception e) {
			System.out.println("\n [Client]: No se puede enviar la data.");
		}
	}
	
	private void closeService() {
		try {
			this.ois.close();
			this.oos.close();
			this.clientSk.close();
			System.out.println("\n [Client]: Conexión terminada.");
		} catch (Exception e) {
			System.out.println("\n [Client]: No se puede cerrar la conexión.");
		}
	}

}
