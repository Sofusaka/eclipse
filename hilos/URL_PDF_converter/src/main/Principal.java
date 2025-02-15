package main;

import co.edu.upb.pdfconverter.Threads;
import co.edu.upb.pdfconverter.UrlMaking;


public class Principal {

	public static void main(String[] args) {
		
		UrlMaking urlmaking= new UrlMaking();
        Threads converter= new Threads(urlmaking);
        
        converter.start();
	}

}



