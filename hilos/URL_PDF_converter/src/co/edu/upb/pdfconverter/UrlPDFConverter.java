package co.edu.upb.pdfconverter;

import java.io.IOException;
import java.util.ArrayList;

public class UrlPDFConverter {

    // Update this path if necessary; note the executable is chrome.exe.
    final String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
   
    
    public void convertUrlToPdf(String url, String outputPdfPath) {
        
    	//esto es para que la CLI agarre los comandos del headless chrome
        ProcessBuilder processBuilder = new ProcessBuilder(
                chromePath,
                "--headless",
                "--disable-gpu",
                "--print-to-pdf=" + outputPdfPath,
                url
        );

        //manejo de error
        processBuilder.redirectErrorStream(true);

        try {
            //inicializa los comandos para el CLI
            Process process = processBuilder.start();            
            int exitCode = process.waitFor();
            System.out.println("Process finished with exit code: " + exitCode);

            if (exitCode != 0) {
                System.err.println("There was an error generating the PDF.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

   
    public void iterateURL(){
    	
    	
    	 UrlMaking urlMaker = new UrlMaking();
         urlMaker.setUrls();
         ArrayList<UrlType> urls = urlMaker.getUrls();

        
         UrlPDFConverter converter = new UrlPDFConverter();

         
         for (UrlType urlType : urls) {
             
             String pdfPath = "C:\\hola\\" + urlType.getName().replaceAll("\\s+", "_") + ".pdf";
             System.out.println("Converting URL: " + urlType.getUrl() + " to PDF: " + pdfPath);
             converter.convertUrlToPdf(urlType.getUrl(), pdfPath);
    	
    }
    	 
       
    
    
    }

           
    
    
    
}
