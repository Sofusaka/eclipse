package co.edu.upb.pdfconverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UrlPDFConverter {
	
	final String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
	private int threadCount;
	
	private final UrlMaking urlmaking;
   
	
	//constructor
	 public UrlPDFConverter(UrlMaking urlmaking, int threadCount) {
	        
			this.urlmaking = urlmaking;
	        this.threadCount = threadCount;

	      
	    }
	
    
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

   
    public void iterateURL() {
        ExecutorService executor = Executors.newFixedThreadPool(this.threadCount);
        UrlMaking urlMaker = new UrlMaking();
        urlMaker.setUrls();
        ArrayList<UrlType> urls = urlMaker.getUrls();

        for (UrlType urlType : urls) {
            executor.submit(() -> {
                String pdfPath = "C:\\hola\\" + urlType.getName().replaceAll("\\s+", "_") + ".pdf";
                System.out.println("Converting URL: " + urlType.getUrl() + " to PDF: " + pdfPath);
                convertUrlToPdf(urlType.getUrl(), pdfPath);
            });
        }
        
        // Indica que no se enviarán más tareas y espera a que finalicen las actuales
        executor.shutdown();
        try {
            // Espera hasta 1 hora (ajusta el tiempo si es necesario)
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                System.err.println("Executor did not terminate in the specified time.");
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            executor.shutdownNow();
        }
    }
           
    
    
    
}
