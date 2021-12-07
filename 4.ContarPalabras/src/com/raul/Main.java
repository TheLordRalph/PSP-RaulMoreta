package com.raul;

import javax.tools.JavaCompiler;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var path = Paths.get(System.getProperty("user.dir"), "Files");
        // "path" almacena la ruta donde se encuntran los archivos que queremos contar las palabras
        // en este caso yo los tengo en una carpeta Files.

        try {
            DirectoryStream<Path> Path1 = Files.newDirectoryStream(path);
            // Con el siguiente foreach guardo en "pathOfFile" la ruta de los fichero que estan dentro de Files
            for (Path pathOfFile : Path1) {
                // Se crea una clase "WordCounte" a la que le pasamos el path del primer archivo y contamos sus palabras.
                WordCounter wordCounter = new WordCounter(pathOfFile);
                wordCounter.counter();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
