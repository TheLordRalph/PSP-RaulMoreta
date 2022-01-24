package com.raul;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String classPath = System.getProperty("user.dir") + File.separator + "out" + File.separator;
        String className = WordCounter.class.getName();
        Path path = Paths.get(System.getProperty("user.dir"), "Files");

        List<String> command = new ArrayList<>();
        command.add("java");
        command.add("-cp");
        command.add(classPath);
        command.add(className);

        try {
            DirectoryStream<Path> Path1 = Files.newDirectoryStream(path);
            for (Path pathOfFile : Path1) {
                ProcessBuilder processBuilder = (new ProcessBuilder(command + pathOfFile.toString()).inheritIO());
                Process process = processBuilder.start();
                process.waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
