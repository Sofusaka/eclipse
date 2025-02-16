package co.edu.upb.pdfconverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DocPDFConverter {

    
    private final String sofficePath = "C:\\Program Files\\LibreOffice\\program\\soffice.exe";
    
    private final int threadCount;
    private final String outputDir;
    private final String inputDir;
    private final List<String> pdfPaths = Collections.synchronizedList(new ArrayList<>());

    public DocPDFConverter(String inputDir, String outputDir, int threadCount) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.threadCount = threadCount;
    }

    // file to PDF 
    public void convertFileToPdf(String inputFilePath) {
        File inputFile = new File(inputFilePath);
        String fileName = inputFile.getName();
        // Se reemplaza la extensión original por .pdf
        String pdfName = fileName.contains(".") 
                ? fileName.substring(0, fileName.lastIndexOf('.')) + ".pdf" 
                : fileName + ".pdf";
        String outputPdfPath = outputDir + File.separator + pdfName;
        pdfPaths.add(outputPdfPath);

        //Se crean perfiles temporales para la concurrencia 
        String tmpDir = System.getProperty("java.io.tmpdir").replace("\\", "/");
        if (!tmpDir.startsWith("file:///")) {
            tmpDir = "file:///" + tmpDir;
        }
        String uniqueUserInstallation = tmpDir + "LOProfile_" + UUID.randomUUID().toString();

        
        ProcessBuilder processBuilder = new ProcessBuilder(
        	    sofficePath,
        	    "-env:UserInstallation=" + uniqueUserInstallation,
        	    "--convert-to",
        	    "pdf",
        	    "--outdir",
        	    outputDir,
        	    inputFilePath,
        	    "--headless"
        	);


        
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("Convertido: " + inputFilePath + " a " + outputPdfPath + " (exit code: " + exitCode + ")");
            if (exitCode != 0) {
                System.err.println("Error al convertir el archivo: " + inputFilePath);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    
    
    public void iterateFiles() {
        DocRepository docRepo = new DocRepository();
        List<String> filePaths = docRepo.collectFilePaths(inputDir);
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (String filePath : filePaths) {
            executor.submit(() -> convertFileToPdf(filePath));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                System.err.println("El executor no finalizó en el tiempo especificado.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executor.shutdownNow();
        }

        // Muestra la lista de PDFs generados
        System.out.println("Archivos PDF generados:");
        for (String path : pdfPaths) {
            System.out.println(path);
        }
    }
}
