package co.edu.upb.pdfconverter;

public class Threads {

    private final UrlMaking urlmaking;

    public Threads(UrlMaking urlmaking) {
        this.urlmaking = urlmaking;
    }

    public void start() {
        for (int i = 1; i < 17; i++) {
            long startTime = System.currentTimeMillis();

            UrlPDFConverter urlConverter = new UrlPDFConverter(urlmaking, i);
            urlConverter.iterateURL();

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Total execution time: " + totalTime + " ms. This was for " + i + " thread(s).");
        }
    }
}
