package main;

import co.edu.upb.songs.Client;

public class ATM {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Client client = new Client("127.0.0.1", 60);
		client.operation();
	}

}
