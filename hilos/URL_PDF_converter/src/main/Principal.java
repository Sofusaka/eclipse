package main;

import co.edu.upb.pdfconverter.UrlPDFConverter;

public class Principal {

	public static void main(String[] args) {
		
		String url = "https://www.google.com/";
        String outputPdf = "C:\\hola\\output1.pdf";

        // Convert the URL to a PDF.
        UrlPDFConverter converter= new UrlPDFConverter();
        
        converter.convertUrlToPdf(url, outputPdf);
	}

}
