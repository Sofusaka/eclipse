package co.edu.upb.songs;

import java.net.MalformedURLException;

public class Principal {

	public static void main(String[] args) {
		
		
		SoapClient soapClient;
		 try {
		 soapClient = new SoapClient();
		 soapClient.request();
		 
		 
		 }catch (MalformedURLException e) {
		 e.printStackTrace();
		 }

	}

}
