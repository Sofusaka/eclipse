package co.edu.upb.pdfconverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocRepository {
    public List<String> collectFilePaths(String directoryPath) {
        List<String> filePaths = new ArrayList<>();
        File directory = new File(directoryPath);

        // Verifica que el directorio exista y sea un directorio
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Agrega la ruta absoluta de cada archivo a la lista
                    if (file.isFile()) {
                        filePaths.add(file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.err.println("El directorio no existe o no es válido: " + directoryPath);
        }

        return filePaths;
    }
}
