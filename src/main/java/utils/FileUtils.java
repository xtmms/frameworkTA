package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {

    // Crea una directory se non esiste
    public static void createDirectoryIfNotExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    // Cancella un file o una directory
    public static void deleteFileOrDirectory(String path) {
        File fileOrDir = new File(path);
        if (fileOrDir.isDirectory()) {
            for (File file : fileOrDir.listFiles()) {
                deleteFileOrDirectory(file.getPath());
            }
        }
        fileOrDir.delete();
    }

    // Copia un file
    public static void copyFile(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath());
    }
}

