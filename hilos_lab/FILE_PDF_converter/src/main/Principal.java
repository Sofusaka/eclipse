package main;

import co.edu.upb.pdfconverter.Threads;

public class Principal {

    public static void main(String[] args) {
        
        String inputDir = "C:\\FileToPDF";
        String outputDir = "C:\\FileToPDF\\PDF";

        
        Threads threads = new Threads(inputDir, outputDir);
        threads.start();

       
    }
}
