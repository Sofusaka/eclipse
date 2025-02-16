package co.edu.upb.pdfconverter;

public class Threads {

    private final String inputDir;
    private final String outputDir;

    public Threads(String inputDir, String outputDir) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
    }

    public void start() {
        for (int i = 1; i < 17; i++) {
            long startTime = System.currentTimeMillis();

            DocPDFConverter converter = new DocPDFConverter(inputDir, outputDir, i);
            converter.iterateFiles();

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Tiempo total de ejecución: " + totalTime + " ms. Para " + i + " hilo(s).");
        }
    }
}
