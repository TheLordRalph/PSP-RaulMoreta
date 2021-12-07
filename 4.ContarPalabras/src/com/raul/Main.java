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

        try {
            DirectoryStream<Path> Path1 = Files.newDirectoryStream(path);
            for (Path file : Path1) {
                WordCounter wordCounter = new WordCounter(file);
                wordCounter.counter();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //path.get(System.getProperty("user.dir"));
        //List<File> libros;

    }
}
